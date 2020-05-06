import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class AbhaengigkeitenIFTest {

	static String[] seqFWD, seqBWD, seqEmpty, seqRepeat;
	static String[][] dependenciesNorm, dependenciesTrans, dependenciesEmpty, dependenciesNull;
	static AbhaengigkeitenIF vorsTest;
	
	@BeforeEach
	void setUp() throws Exception {
		seqFWD		= new String[]		{"A","B","C","D"};
		seqBWD		= new String[]		{"D","C","B","A"};
		seqEmpty	= new String[]		{};
		seqRepeat	= new String[]		{"A","A","B","C"};
		dependenciesNorm	= new String[][]	{{"A","B"},{"C","D"}};
		dependenciesTrans	= new String[][]	{{"A","C"},{"C","D"},{"B","C"}};
		dependenciesEmpty	= new String[][] 	{};
	}

	@DisplayName("Test ohne Transitivität")
	@Test
	void testIsWellSorted1() {
		vorsTest = new Abhaengigkeiten(dependenciesNorm);
		assertTrue(vorsTest.isWellSorted(seqFWD));			//Always passes
		assertFalse(vorsTest.isWellSorted(seqBWD));			//Doesn't work with dependencies
		assertTrue(vorsTest.isWellSorted(seqEmpty));		//Sequence = {} is always sorted
		assertFalse(vorsTest.isWellSorted(seqRepeat));		//Repetions of tasks are not allowed
	}
	
	@DisplayName("Test mit Transitivität")
	@Test
	void testIsWellSorted2() {
		vorsTest = new Abhaengigkeiten(dependenciesTrans);
		assertTrue(vorsTest.isWellSorted(seqFWD));
		assertFalse(vorsTest.isWellSorted(seqBWD));
		assertTrue(vorsTest.isWellSorted(seqEmpty));
		assertFalse(vorsTest.isWellSorted(seqRepeat));
	}
	
	@DisplayName("Test mit leerer Liste")
	@Test
	void testIsWellSorted3() {
		vorsTest = new Abhaengigkeiten(dependenciesEmpty);
		assertTrue(vorsTest.isWellSorted(seqFWD));
		assertTrue(vorsTest.isWellSorted(seqBWD));
		assertTrue(vorsTest.isWellSorted(seqEmpty));
		assertFalse(vorsTest.isWellSorted(seqRepeat));
	}
	
	@DisplayName("Test falls dependencies=null")
	@Test
	void testIsWellSorted4() {
		vorsTest = new Abhaengigkeiten(dependenciesNull);
		assertTrue(vorsTest.isWellSorted(seqFWD));
		assertTrue(vorsTest.isWellSorted(seqBWD));
		assertTrue(vorsTest.isWellSorted(seqEmpty));
		assertFalse(vorsTest.isWellSorted(seqRepeat));
	}

	@DisplayName("leere Sequenzen sind sortiert")
	@Test 
	public void testIsWellSortedNullSequence() {
		vorsTest = new Abhaengigkeiten(dependenciesNorm);
		assertTrue(vorsTest.isWellSorted(null));
		
	}
	
}