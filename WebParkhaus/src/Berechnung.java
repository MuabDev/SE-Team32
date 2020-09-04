import java.util.ArrayList;
import java.util.List;

public class Berechnung implements BerechnungIF
{
	private static List<Float> costs = new ArrayList<>();
	
	public Berechnung()
	{
	}
	
	public void addCost(float cost)
	{
		costs.add(cost);
	}
	
	public int getSize()
	{
		return costs.size();
	}
	
	public float getSum()
	{
		float sum = costs.stream().reduce(0.0f, (x,y) -> x+y) / 100.0f;
		return Math.round(sum * 100.0) / 100.0f; //runde Summe auf zwei Nachkommastellen
	}
	
	public float getAvg()
	{
		float avg = getSum()/getSize();
		return Math.round(avg * 100.0) / 100.0f; //runde Summe auf zwei Nachkommastellen
	}
}
