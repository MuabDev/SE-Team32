
public class Auto implements AutoIF
{
	private int parkplatz;
	private String ticket;
	
	public Auto()
	{
	}
	
	public Auto(int p, String t)
	{
		parkplatz = p;
		ticket = t;
	}
	
	public int getParkplatz()
	{
		return parkplatz;
	}
	
	public String getTicket()
	{
		return ticket;
	}
	
	public void setParkplatz(int p)
	{
		parkplatz = p;
	}
	
	public void setTicket(String t)
	{
		ticket = t;
	}
}
