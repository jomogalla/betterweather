package model;

public class City
{
	private long id;
    private String city;
    private String state;
    private double longitude;
	private double latitude;
	private double distance;

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

    public double getLongitude()
    {
        return longitude;
    }

    public void setLongitude(double longitude)
    {
        this.longitude = longitude;
    }
    
    public double getDistance()
    {
        return distance;
    }

    public void setDistance(double distance)
    {
        this.distance = distance;
    }
    
    public double getLatitude()
    {
        return latitude;
    }

    public void setLatitude(double latitude)
    {
        this.latitude = latitude;
    }
 
    public long getId()
    {
		return id;
	}
	
	public void setId(long id)
	{
		this.id = id;
	}
	
    public String toString()
    {
        return "City: " + getCity() + " | State: " + getState() + 
        " | Distance: " + getDistance();
    }
}
