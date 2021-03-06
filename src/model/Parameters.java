package model;

import java.util.Date;

public class Parameters
{
	private long id;
    private int zipCode;
    private int radius;
//    private Date startDate;
//    private Date endDate;
    private double longitude;
	private double latitude;
	

    public int getRadius()
    {
        return radius;
    }

    public void setRadius(int radius)
    {
        this.radius = radius;
    }

    public int getZipCode()
    {
        return zipCode;
    }

    public void setZipCode(int zipCode)
    {
        this.zipCode = zipCode;
    }
 /*   
    public Date getStartDate()
    {
        return startDate;
    }

    public void setStartDate(Date startDate)
    {
        this.startDate = startDate;
    }
    
    public Date getEndDate()
    {
        return endDate;
    }

    public void setEndDate(Date endDate)
    {
        this.endDate = endDate;
    }
 */
    public long getId()
    {
		return id;
	}
	
	public void setId(long id)
	{
		this.id = id;
	}
	
	    public double getLongitude()
    {
		return longitude;
	}
	
	public void setLongitude(double longitude)
	{
		this.longitude = longitude;
	}
    public double getLatitude()
    {
		return latitude;
	}
	
	public void setLatitude(double latitude)
	{
		this.latitude = latitude;
	}
}
