import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BerechnungIFTest 
{	
	Berechnung b;
	SumView s;
	AvgView a;

	@BeforeEach
	void setUp() throws Exception 
	{
		b = new Berechnung();
		s = new SumView();
		a = new AvgView();
		s.subscribe(b);
		a.subscribe(b);
		
	}
	
	@Test
	@DisplayName("Kosten sollen in Liste aufgenommen werden")
	void testAddCost() 
	{
		assertEquals(0, b.getSize()); //keine Elemente in Liste
		b.addCost(100.0f);			 
		assertEquals(1, b.getSize()); //Liste hat ein Element nach add
	}

	@Test
	@DisplayName("Summe der Kosten soll angezeigt werden")
	void testGetSum() 
	{
		b.addCost(100.0f);
		b.addCost(200.0f);
		b.addCost(300.0f);
		assertEquals(6.0f, s.view()); //Summe der zuvor eingefügten Elemente (durch 100 wegen Kosten in Cent)
	}

	@Test
	@DisplayName("Durchschnitt der Kosten soll angezeigt werden")
	void testGetAvg() 
	{
		b.addCost(100.0f);
		b.addCost(200.0f);
		b.addCost(300.0f);
		assertEquals(2.0f, a.view()); //Durchschnitt der zuvor eingefügten Elemente 
										//(durch 100 wegen Kosten in Cent)
	}

}
