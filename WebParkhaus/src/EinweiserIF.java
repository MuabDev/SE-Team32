import java.util.List;

public interface EinweiserIF
{
	
	public int enter(Auto in);
	
	public Auto leave(Auto out);
	
	public void addCar(Auto in);
	
	public List<Auto> getCars();
	
	public int getSize();
	
	public int getMax();
	
	public void setMax(int m);
}
