package eginkizuna3;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
		grafoa.clear();
		WebOrriZerrenda.getWebOrriZerrenda().clear();
	}
	
	@Test
	public void initLaburra() {
		double denbGrafo, denbWeb;
		
		Stopwatch watch= new Stopwatch();
		grafoa.init("src\\eginkizuna1\\smallindex.txt", "src\\eginkizuna1\\smallpld-arc.txt");
 		denbGrafo=watch.elapsedTime();

 		watch= new Stopwatch();
 		WebOrriZerrenda.getWebOrriZerrenda().datuakKargatu("src\\eginkizuna1\\smallindex.txt");
 		WebOrriZerrenda.getWebOrriZerrenda().webOrrienDatuakKargatu("src\\eginkizuna1\\smallpld-arc.txt");
		denbWeb=watch.elapsedTime();
		System.out.println("\nInit laburra (Laburra da, denbora analisia ez da oso ezanguratsua)"
				+ "\nGrafoa Denbora:"+denbGrafo+"s Ordena: O("+ denbGrafo/grafoa.getTotal() +"n)"
 				+ "\nWebOrriaren Denbora:"+denbWeb+"s Ordena: O("+denbWeb/grafoa.getTotal()+"n)"
 				+ "\nWebOrria initializatzea "+denbWeb/denbGrafo+" aldiz grafoarena inizialitzea behar du");
		
	}
	
	@Test
	public void initLuzea() {
		double denbGrafo, denbWeb;
		
		Stopwatch watch= new Stopwatch();
		grafoa.init("src\\eginkizuna1\\indexLuzea.txt", "src\\eginkizuna1\\pld-arc.txt");
 		denbGrafo=watch.elapsedTime();

 		watch= new Stopwatch();
 		WebOrriZerrenda.getWebOrriZerrenda().datuakKargatu("src\\eginkizuna1\\indexLuzea.txt");
 		WebOrriZerrenda.getWebOrriZerrenda().webOrrienDatuakKargatu("src\\eginkizuna1\\pld-arc.txt");
		denbWeb=watch.elapsedTime();
 		
		System.out.println("\nInit luzea"
				+ "\nGrafoa Denbora:"+denbGrafo+"s Ordena: O("+ denbGrafo/grafoa.getTotal() +"n)"
 				+ "\nWebOrriaren Denbora:"+denbWeb+"s Ordena: O("+denbWeb/grafoa.getTotal()+"n)"
 				+ "\nWebOrria initializatzea "+denbWeb/denbGrafo+" aldiz grafoarena inizialitzea behar du");
	}
	
	@Test
	public void testErlazionatutaPathLuzea() {
		ArrayList<String> listGrafo,listWeb;
		double denbGrafo, denbWeb;
		
 		String a1="0-00.pl";	//A web that links to a2
 		String a2="bestellipticalreviews.org"; //A web that links to a1
 		String a3="0-311.com";	//A web that doesn't link to anybody
 		
 		WebOrriZerrenda.getWebOrriZerrenda().datuakKargatu("src\\eginkizuna1\\indexLuzea.txt");
		WebOrriZerrenda.getWebOrriZerrenda().webOrrienDatuakKargatu("src\\eginkizuna1\\pld-arc.txt");		
		Stopwatch watch= new Stopwatch();
 		listWeb=WebOrriZerrenda.getWebOrriZerrenda().erlazionatutaPath(a1, a2);
 		denbWeb=watch.elapsedTime();
		
		grafoa.init("src\\eginkizuna1\\indexLuzea.txt", "src\\eginkizuna1\\pld-arc.txt");
		watch= new Stopwatch();
		listGrafo=grafoa.erlazionatutaPath(a1, a2);
 		denbGrafo=watch.elapsedTime();
 		System.out.println("\nErlazionatu luzea"
 				+ "\nGrafoa Denbora:"+denbGrafo+"s Ordena: O("+ denbGrafo/listGrafo.size() +"n)\n"+listGrafo
 				+ "\nWebOrriaren Denbora:"+denbWeb+"s Ordena: O("+denbWeb/listGrafo.size() +"n)\n"+listWeb
 				+ "\nWebOrriak erabiliz "+denbWeb/denbGrafo+" aldiz grafoarekin behar den denbora behar da");
		
 		Assert.assertNotNull(grafoa.erlazionatutaPath(a1, a2));	//Linkeatuta daukan web batera
 		Assert.assertNull(grafoa.erlazionatutaPath(a3, a1));	//Ez linkeatuta daukan web batera
 		Assert.assertEquals(grafoa.erlazionatutaPath(a1, a1).toString(),"["+a1+"]");	//Bere burura
	}
	
	@Test
	public void testErlazionatutaPathLaburra() {
		ArrayList<String> listGrafo,listWeb;
		double denbGrafo, denbWeb;
		
 		String a1="0086k.com";	//A web that links to a2
 		String a2="0100.cc";	//A web that is linked by a1
 		String a3="007bondgorka.bond";	//A web that doesn't link to anybody
 
 		WebOrriZerrenda.getWebOrriZerrenda().datuakKargatu("src\\eginkizuna1\\smallindex.txt");
		WebOrriZerrenda.getWebOrriZerrenda().webOrrienDatuakKargatu("src\\eginkizuna1\\smallpld-arc.txt");		
		Stopwatch watch= new Stopwatch();
 		listWeb=WebOrriZerrenda.getWebOrriZerrenda().erlazionatutaPath(a1, a2);
 		denbWeb=watch.elapsedTime();

		grafoa.init("src\\eginkizuna1\\smallindex.txt", "src\\eginkizuna1\\smallpld-arc.txt");
		watch= new Stopwatch();
		listGrafo=grafoa.erlazionatutaPath(a1, a2);
 		denbGrafo=watch.elapsedTime();
 		System.out.println("\nErlazionatu laburra (Laburra da, denbora analisia ez da oso ezanguratsua)"
 				+ "\nGrafoa Denbora:"+denbGrafo+"s Ordena: O("+ denbGrafo/listGrafo.size() +"n)\n"+listGrafo
 				+ "\nWebOrriaren Denbora:"+denbWeb+"s Ordena: O("+denbWeb/listGrafo.size() +"n)\n"+listWeb
 				+ "\nWebOrriak erabiliz "+denbWeb/denbGrafo+" aldiz grafoarekin behar den denbora behar da");
 		
		
 		Assert.assertNotNull(grafoa.erlazionatutaPath(a1, a2));	//Linkeatuta daukan web batera
 		Assert.assertNull(grafoa.erlazionatutaPath(a1, a3));	//Ez linkeatuta daukan web batera
 		Assert.assertEquals(grafoa.erlazionatutaPath(a1, a1).toString(),"["+a1+"]");	//Bere burura
	}
	
}