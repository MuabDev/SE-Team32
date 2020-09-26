
public class Zustand 
{
	Kunde kunde;
	Zustand next;
	
	Zustand(Kunde k)
	{
		kunde = k;
	}
	
	public void set() {};
	public void setNext(Zustand z)
	{
		next = z;
	}
}
