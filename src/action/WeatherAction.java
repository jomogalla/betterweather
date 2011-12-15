package action;

import org.hibernate.Session;
import model.HibernateUtil;
import model.Parameters;
import model.City;
import model.CenterGeo;
import java.util.List;
import com.opensymphony.xwork2.ActionSupport;

//added after the postgis tutorial
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.WKTReader;
import com.vividsolutions.jts.io.ParseException;
import org.hibernate.Criteria;
import org.hibernatespatial.criterion.SpatialRestrictions;

public class WeatherAction extends ActionSupport {
		
	private Parameters parametersBean;
	private List<City> cityBeans;	
	private CenterGeo centerLoc;
	private double minLat;
	private double maxLat;
	private double minLong;
	private double maxLong;

	@Override
	public String execute() throws Exception {		
        
        /*
		//query returns lat/longs from the zipcode
		//deprecated :(
		cityBeans = session.createSQLQuery("SELECT DISTINCT ON (dest.city) dest.city, dest.state, ST_Distance(orig.geoloc, dest.geoloc)*0.0006214 AS distance, dest.zip FROM zipcodes orig, zipcodes dest WHERE ST_DWithin(orig.geoloc,dest.geoloc, :distance) AND orig.zip = :zipcode AND dest.zip <> :zipcode ;")
		.addScalar("city")
		.addScalar("state")
		.addScalar("distance")
		.addScalar("zip")
		.setParameter("zipcode", zipcode)
		.setParameter("distance", radius)
		.list();
		*/
		
		//maybe instead of using the parameters bean i can use the message store functionality of struts2?
		findCities(parametersBean.getZipCode(), parametersBean.getRadius());
		
	
		

	
		return SUCCESS;		
	}

	//solved
	//null pointer exception thrown from validate, happens when ip:8080/betterweather/Insert.action is called
	//by entering the above url in a new window. 
	//My deduction: ideBean was never put on the new stack by insert.jsp when called this way,
	//if we just check to see if it is null the validate returns no errors. And passes a null
	// ideBean back to insert.jsp, so we just make one and pretend nothing ever happened ಠ_ಠ
	
	/*
	public void validate(){			//validation needs to be fixed
		//if (parametersBean.getZipCode() == 0 ){	 
		//	addFieldError( "parametersBean.zipCode", "zipcode is required." );
		//}				
		//if (parametersBean.getRadius() == 0 ){	
		//	addFieldError( "parametersBean.radius", "radius is required." );
		}	
	}
	*/
		
	public Parameters getParametersBean() {		
		return parametersBean;		
	}
	
	public void setParametersBean(Parameters parametersBean) {		
		this.parametersBean = parametersBean;		
	}
	
	public List<City> getCityBeans(){
		return cityBeans;
	}
	
	public CenterGeo getCenterLoc(){
		return centerLoc;
	}
	//for debugging
	public String getMinLat(){
		return String.valueOf(minLat);
	}
	
	private void findCities(int zipcode, int distance){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		//get the lat/long of the zipcode
		//need to fix bug, if the zipcode does not exist, do not, under any circumstances continue
		session.beginTransaction();
		centerLoc = (CenterGeo) session.createQuery("from CenterGeo where id = :zipcode")
		.setParameter("zipcode", zipcode)
		.uniqueResult();
	
		//BUG ALERT!! Null Pointer Exception :( happens below when the jerks put in a fake zip
	
		//determine the max/min lat/long values
		maxLat = centerLoc.getLatitude() + distance/69.09;
		minLat = centerLoc.getLatitude() - distance/69.09;
		maxLong = centerLoc.getLongitude() + distance/69.09;
		minLong = centerLoc.getLongitude() - distance/69.09;
		
		//get selection within the above parameters
		cityBeans = session.createQuery("from City where latitude < :maxLat and latitude > :minLat and longitude < :maxLong and longitude > :minLong") 
		.setParameter("maxLat", maxLat)
		.setParameter("minLat", minLat)
		.setParameter("maxLong", maxLong)
		.setParameter("minLong", minLong)
		.list();	
		session.getTransaction().commit();
		
		//BUG ALERT!!! Putting in certain radius/zip combos spits out 0 distance
		//specific example: zip=97401 and radius=70 spits out a ton of 0s
		//the above example no longer holds true when radius=200??? who knows!
		
		//trim the list down to the actual radius
		for(int i = 0; i < cityBeans.size(); i++)
		{
			cityBeans.get(i).setDistance(calcDistance(centerLoc.getLatitude(), centerLoc.getLongitude(), cityBeans.get(i).getLatitude(), cityBeans.get(i).getLongitude()));
			if(cityBeans.get(i).getDistance() > distance){
				cityBeans.remove(i);
			}
		}
	}
	
	//algorithm provided by zips.sf.net. thanks guys!
	private double calcDistance(double latA, double longA, double latB, double longB)
	{
		double theDistance = (Math.sin(Math.toRadians(latA)) *
		Math.sin(Math.toRadians(latB)) +
		Math.cos(Math.toRadians(latA)) *
		Math.cos(Math.toRadians(latB)) *
		Math.cos(Math.toRadians(longA - longB)));
		return ((Math.toDegrees(Math.acos(theDistance))) * 69.09);
	}
	
}
