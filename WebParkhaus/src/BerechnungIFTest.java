import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BerechnungIFTest 
{	
	BerechnungIF b;

	@BeforeEach
	void setUp() throws Exception 
	{
		b = new Berechnung();
		
	}
	
	@Test
	@DisplayName("Kosten sollen in Liste aufgenommen werden")
	void testAddCost() 
	{
		assertEquals(0, b.getSize()); //keine Elemente in Liste
		b.addCost(100.0f);			 //zwei Werte einfügen
		assertEquals(1, b.getSize()); 
	}
	
	@Test
	@DisplayName("Größe der Liste soll angezeigt werden")
	void testGetSize() 
	{
		assertEquals(1, b.getSize());
		b.addCost(100.0f);				//erst ein Element, nach Einfügen zwei
		assertEquals(2, b.getSize());
	}

	@Test
	@DisplayName("Summe der Kosten soll angezeigt werden")
	void testGetSum() 
	{
		assertEquals(2.0f, b.getSum()); //Summe der zuvor eingefügten Elemente (durch 100 wegen Kosten in Cent)
	}

	@Test
	@DisplayName("Durchschnitt der Kosten soll angezeigt werden")
	void testGetAvg() 
	{
		assertEquals(1.0f, b.getAvg()); //Durchschnitt der zuvor eingefügten Elemente 
										//(durch 100 wegen Kosten in Cent)
	}

}
