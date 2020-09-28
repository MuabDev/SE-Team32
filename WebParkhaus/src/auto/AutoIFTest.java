package auto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AutoIFTest 
{
	AutoIF a1 = new Auto(1, "ticket1");
	AutoIF a2 = new Auto(2, "ticket2");

	@Test
	void testGetParkplatz() 
	{
		assertEquals(1, a1.getParkplatz());
		assertEquals(2, a2.getParkplatz());
	}

	@Test
	void testGetTicket() 
	{
		assertEquals("ticket1", a1.getTicket());
		assertEquals("ticket2", a2.getTicket());
	}

	@Test
	void testSetParkplatz() 
	{
		assertEquals(1, a1.getParkplatz());
		a1.setParkplatz(3);
		assertEquals(3, a1.getParkplatz());
	}

	@Test
	void testSetTicket() 
	{
		assertEquals("ticket2", a2.getTicket());
		a2.setTicket("ticket3");
		assertEquals("ticket3", a2.getTicket());
	}

}
