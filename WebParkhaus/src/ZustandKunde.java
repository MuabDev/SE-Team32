
public class ZustandKunde extends Zustand
{
	
	ZustandKunde(Kunde k)
	{
		super(k);
	}

	public void set() 
	{
		kunde.preis = 1;
		kunde.name = "Kunde";
	}

}
