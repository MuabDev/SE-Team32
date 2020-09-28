package berechnung;
import java.util.ArrayList;
import java.util.List;

public class Berechnung extends AbstractPublisher implements BerechnungIF
{
	List<Float> costs = new ArrayList<>();
	
	public Berechnung()
	{
		super();
	}
	
	public void addCost(float cost)
	{
		costs.add(cost);
		update();       //alle Views aktualisieren nachdem Liste verändert wurde
	}
	
	public List<Float> getCosts()
	{
		return costs;
	}
	
	public int getSize()
	{
		return costs.size();
	}
}
