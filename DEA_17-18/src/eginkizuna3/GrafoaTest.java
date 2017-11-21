package eginkizuna3;

import javax.swing.SingleSelectionModel;
import javax.swing.plaf.synth.SynthSeparatorUI;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
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
		grafoa.init("src\\eginkizuna1\\indexLaburra.txt", "src\\eginkizuna1\\pdl-arcLaburra.txt");
		
//		System.out.println(grafoa);
		
 		String a1="0-00.pl";	//A web that links to a2
 		String a2="0-24.ro";	//A web that is linked by a1
 		String a3="0-360.com";	//A web that doesn't link to anybody
 		
 		Assert.assertNotNull(grafoa.erlazionatutaPath(a1, a2));	//Linkeatuta daukan web batera
 		Assert.assertNull(grafoa.erlazionatutaPath(a3, a2));	//Ez linkeatuta daukan web batera
 		Assert.assertEquals(grafoa.erlazionatutaPath(a1, a1).toString(),"["+a1+"]");	//Bere burura
 		
	}

}
