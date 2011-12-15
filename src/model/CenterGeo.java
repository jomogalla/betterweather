package model;

public class CenterGeo{
	private int id;
	private double longitude;
	private double latitude;
	
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}
	public double getLongitude(){
		return longitude;
	}
	public void setLongitude(double longitude){
		this.longitude = longitude;
	}
	public double getLatitude(){
		return latitude;
	}
	public void setLatitude(double latitude){
		this.latitude = latitude;
	}
    public String toString()
    {
        return "zipcode: " + getId() + " | longitude: " + getLongitude() + 
        " | latitude: " + getLatitude();
    }
}