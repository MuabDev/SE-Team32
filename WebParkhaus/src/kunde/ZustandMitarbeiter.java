package kunde;

public class ZustandMitarbeiter extends Zustand
{
	
	ZustandMitarbeiter(Kunde k)
	{
		super(k);
	}

	public void set() 
	{
		kunde.preis = 0;
		kunde.name = "Mitarbeiter";
	}

}
