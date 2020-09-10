
public class AvgView extends View 
{
	float avg;
	
	float view()
	{
		return avg;
	}
	
	public void update() 
	{
		avg = model.getCosts().stream().reduce(0.0f, (x,y) -> (x+y)) / 100.0f;
		avg /= model.getSize();
	}

}
