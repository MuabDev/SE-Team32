
public class Kunde implements KundeIF
{
	Zustand zustand;
	int preis = 1;
	String name = "Kunde";
	
	Kunde()					//Aufbau und Konfiguration der Zustandobjekte
	{
		zustand = new ZustandKunde(this);
		zustand.setNext(new ZustandFamilie(this));
		zustand.next.setNext(new ZustandMitarbeiter(this));
		zustand.next.next.setNext(zustand);
	}
	
	public int getPreis()
	{
		return preis;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void next()
	{
		zustand = zustand.next;
		zustand.set();
	}
	
}
