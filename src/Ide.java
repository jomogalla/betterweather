package model;

public class Ide
{
	private long id;
    private String os;
    private String os_version;
    private String notes;

    public String getOs()
    {
        return os;
    }

    public void setOs(String os)
    {
        this.os = os;
    }

    public String getOs_version()
    {
        return os_version;
    }

    public void setOs_version(String os_version)
    {
        this.os_version = os_version;
    }

    public String getNotes()
    {
        return notes;
    }

    public void setNotes(String notes)
    {
        this.notes = notes;
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
        return "OS: " + getOs() + " | OS VERSION: " + getOs_version() + 
        " | NOTES: " + getNotes();
    }
}
