package eginkizuna3;

import javax.swing.SingleSelectionModel;
import javax.swing.plaf.synth.SynthSeparatorUI;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import eginkizuna1.Hiztegia;
import eginkizuna1.WebOrriZerrenda;
import praktika1.Stopwatch;

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

 		System.out.println("\n>DatuakKargatu Grafo");
		Stopwatch watch= new Stopwatch();
		grafoa.init("src\\eginkizuna1\\indexLaburra.txt", "src\\eginkizuna1\\pdl-arcLaburra.txt");
		System.out.println(watch.elapsedTime());

 		System.out.println("\n>DatuakKargatu WebOrriZerrenda");
 		watch= new Stopwatch();
 		WebOrriZerrenda.getWebOrriZerrenda().datuakKargatu("src\\eginkizuna1\\indexLaburra.txt");
 		WebOrriZerrenda.getWebOrriZerrenda().webOrrienDatuakKargatu("src\\eginkizuna1\\pdl-arcLaburra.txt");
 		System.out.println("Denbora: " + watch.elapsedTime() + " segundu");
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
 		
 		WebOrriZerrenda.getWebOrriZerrenda().clear();
 		WebOrriZerrenda.getWebOrriZerrenda().datuakKargatu("src\\eginkizuna1\\indexLaburra.txt");
 		WebOrriZerrenda.getWebOrriZerrenda().webOrrienDatuakKargatu("src\\eginkizuna1\\pdl-arcLaburra.txt");
 		

		Stopwatch watch= new Stopwatch();
 		WebOrriZerrenda.getWebOrriZerrenda().erlazionatuta(a1, a2);
		System.out.println("WebOrri: "+watch.elapsedTime()+" "+ WebOrriZerrenda.getWebOrriZerrenda().erlazionatutaPath(a1, a2).toString());
 		

		watch= new Stopwatch();
 		grafoa.erlazionatutaPath(a1, a2);
		System.out.println("Grafo: "+watch.elapsedTime()+" "+ grafoa.erlazionatutaPath(a1, a2).toString());
	}

}