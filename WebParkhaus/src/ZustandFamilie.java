
public class ZustandFamilie extends Zustand 
{
	
	ZustandFamilie(Kunde k)
	{
		super(k);
	}
	
	public void set() 
	{
		kunde.preis = 2;
		kunde.name = "Familie";
	}

}
