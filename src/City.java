package model;

import com.vividsolutions.jts.geom.Point;

public class City
{
	private String id;
    private String city;
    private String state;
 //   private double longitude;   //not sure if this should be a geoloc or lat/long???
//	private double latitude;	//the lat/long is only needed for the weather data, and then
								//matching it up the city  and weather, so prolly should be a latlong :(
	private double distance;
	private Point geoLoc;

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public Point getGeoLoc()
    {
        return geoLoc;
    }

	public void setGeoLoc(Point geoLoc)
    {
        this.geoLoc = geoLoc;
    }
   
    public double getDistance()
    {
        return distance;
    }

    public void setDistance(double distance)
    {
        this.distance = distance;
    }
    
    public String getId()
    {
		return id;
	}
	
	public void setId(String id)
	{
		this.id = id;
	}

    public String toString()
    {
        return "City: " + getCity() + " | State: " + getState() + 
        " | Distance: " + getDistance();
    }
}
