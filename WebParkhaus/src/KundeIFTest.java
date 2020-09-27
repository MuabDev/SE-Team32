import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class KundeIFTest 
{
	KundeIF k = new Kunde();

	@Test
	@DisplayName("Zustand soll auf nächsten Zustand gesetzt werden und Name soll richtig angepasst werden")
	void testNextSetAndGetName() 
	{
		assertEquals("Kunde", k.getName());
		k.next();
		assertEquals("Familie", k.getName());
		k.next();
		assertEquals("Mitarbeiter", k.getName());
		k.next();
		assertEquals("Kunde", k.getName());
		
	}
	
	@Test
	@DisplayName("Preis soll nach Zustandsänderung angepasst werden")
	void testGetPreis() 
	{
		assertEquals(k.getPreis(), 1);
		k.next();
		assertEquals(k.getPreis(), 2);
		k.next();
		assertEquals(k.getPreis(), 0);
	}


}
