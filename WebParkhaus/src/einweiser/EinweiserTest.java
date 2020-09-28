package einweiser;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import auto.Auto;

class EinweiserTest 
{
	EinweiserIF e;
	Auto car, car2, car3;
	int in;

	@BeforeEach
	void setUe() throws Exception 
	{
		e = new Einweiser();
		car = new Auto(5, "55a5297432f8a6c7949cbfd7c0cf3531");
		car2 = new Auto(5, "e34ae43caf02cfb2fc53f6bb01123308");
		car3 = new Auto(2, "ticket3");
	}

	@Test
	@DisplayName("Auto soll in Parkhaus aufgenommen werden/Size soll sich ändern")
	void testEnterAndSize() 
	{
		assertEquals(0, e.getSize());
		
		in = e.enter(car);
		assertEquals(1, e.getSize());
		assertEquals(in, car.getParkplatz());
		
		in = e.enter(car2);
		assertEquals(2, e.getSize());
		assertEquals(in, car2.getParkplatz());
		
		in = e.enter(car3);
		assertEquals(3, e.getSize());
		assertEquals(in, car3.getParkplatz());
	}

	@Test
	@DisplayName("Auto soll Parkhaus verlassen")
	void testLeave() 
	{
		assertEquals(0, e.getSize());
		
		e.enter(car);
		assertEquals(1, e.getSize());
		
		e.enter(car2);
		assertEquals(2, e.getSize());
		
		Auto tmp = e.leave(car);
		assertEquals(1, e.getSize());
		assertSame(tmp, car);
	}

}
