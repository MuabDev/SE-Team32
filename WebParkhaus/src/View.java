
public abstract class View 
{
	Berechnung model;
	
	public void subscribe(Berechnung m)  //View in die Berechnung hinzufügen
	{
		model = m;
		m.addView(this);
		update();
	}
	
	public abstract void update();
}
