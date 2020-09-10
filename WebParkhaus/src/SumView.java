
public class SumView extends View 
{
	float sum;
	
	float view()
	{
		return sum;
	}
	
	public void update() 
	{
		sum = model.getCosts().stream().reduce(0.0f, (x,y) -> (x+y)) / 100.0f;
	}

}
