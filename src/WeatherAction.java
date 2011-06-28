package action;

import org.hibernate.Session;
import model.HibernateUtil;
import model.Parameters;
import model.City;
import java.util.List;
import com.opensymphony.xwork2.ActionSupport;

public class WeatherAction extends ActionSupport {
		
	private Parameters parametersBean;
	private List<City> cityBeans;	
	private int zipcode;
	private int radius;

	@Override
	public String execute() throws Exception {		
		zipcode = parametersBean.getZipCode();
		radius = parametersBean.getRadius();	

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
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
		
		
		
		
		session.getTransaction().commit();
		

	
		return SUCCESS;		
	}

	//solved
	//null pointer exception thrown from validate, happens when ip:8080/betterweather/Insert.action is called
	//by entering the above url in a new window. 
	//My deduction: ideBean was never put on the new stack by insert.jsp when called this way,
	//if we just check to see if it is null the validate returns no errors. And passes a null
	// ideBean back to insert.jsp, so we just make one and pretend nothing ever happened ಠ_ಠ
	
	public void validate(){			//validation needs to be fixed
		if (parametersBean.getZipCode() == 0 ){	 
			addFieldError( "parametersBean.zipCode", "zipcode is required." );
		}				
		if (parametersBean.getRadius() == 0 ){	
			addFieldError( "parametersBean.radius", "radius is required." );
		}	
	}
		
	public Parameters getParametersBean() {		
		return parametersBean;		
	}
	
	public void setParametersBean(Parameters parametersBean) {		
		this.parametersBean = parametersBean;		
	}
	
	public List<City> getCityBeans(){
		return cityBeans;
	}
}
