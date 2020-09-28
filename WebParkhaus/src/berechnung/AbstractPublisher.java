package berechnung;
import java.util.ArrayList;
import java.util.List;

public class AbstractPublisher //wie in Vorlesung zu Observer
{
	private List<View> views = new ArrayList<>();
	
	public void addView(View v)
	{
		views.add(v);
	}
	
	public void update() 
	{
		for(View v : views)
		{
			v.update();
		}
	}

}
