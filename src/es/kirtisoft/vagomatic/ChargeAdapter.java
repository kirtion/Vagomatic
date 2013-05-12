package es.kirtisoft.vagomatic;

public class ChargeAdapter 
{
	private String name, description;
	private int logo;
	
	public ChargeAdapter()
	{
		
	}
	
	public ChargeAdapter(String name, String description, int logo)
	{
		this.name = name;
		this.description = description;
		this.logo = logo;
	}
	
	//Getters
	public String getName()
	{
		return name;
	}
	
	public String getDesiption()
	{
		return description;
	}
	
	public int getLogo()
	{
		return logo;
	}
	
	//Setters
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public void setLogo(int logo)
	{
		this.logo = logo;
	}
}
