package eginkizuna3;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GrafoaTest {

	private Grafoa grafoa= new Grafoa();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void init() {
		grafoa.init("src\\eginkizuna1\\indexLaburra.txt", "src\\eginkizuna1\\pdl-arcLaburra.txt");
	}
	@Test
	public void testErlazionatutaPath() {
 		String a1="0-00.pl";
 		String a2="0-24.ro";
 		System.out.println(grafoa.erlazionatutaPath(a1, a2));
	}

}
