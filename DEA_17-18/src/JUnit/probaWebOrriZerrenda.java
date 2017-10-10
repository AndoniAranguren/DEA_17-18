package JUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import eginkizuna1.WebOrria;
import eginkizuna1.Hiztegia;
import eginkizuna1.WebOrriZerrenda;

import java.util.ArrayList;

public class probaWebOrriZerrenda {
	
	private static WebOrriZerrenda weborrizerrenda= WebOrriZerrenda.getWebOrriZerrenda();
	
	private static WebOrria w1,w2;
	private static String url1,url2;
	private static int id1,id2;
	private ArrayList<WebOrria> lista;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Hiztegia.getHiztegia().datuakKargatu("src\\JUnit\\hiztegiLuzea.txt");
		url1= "007waystomakemoney.com";
		id1 = 12345;
		url2= "009al3ab.com.es.de";
		id2 = 99999;
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Before
	public void setUp() throws Exception {
		w1= new WebOrria(url1, id1);
		w2= new WebOrria(url2, id2);
		lista= new ArrayList<WebOrria>();
	}

	@After
	public void tearDown() throws Exception {
		w1=null;
		w2=null;
		lista=null;
	}

	@Test
	public void testEragiketaSinpleak(){
		System.out.println("\ntestEragiketaSinpleak========================================================");
		System.out.println(">Add (Weborria bat)");
		weborrizerrenda.add(w1);
		System.out.println(url1 +" orria gehitu al da? " + weborrizerrenda.contains(w1));
		
		System.out.println("\n>Remove (Weborria bat)\"");
		weborrizerrenda.remove(w1);
		System.out.println( url1 +" orria ezabatu al da? " + !weborrizerrenda.contains(w1));
		
		System.out.println("\n>Add (WebOrri lista bat)"); //?
		lista.add(w1);
		lista.add(w2);
		weborrizerrenda.add(lista);
		System.out.println( url1 +" orria gehitu al da? " + (weborrizerrenda.contains(w1) && weborrizerrenda.contains(w2)));
		
		System.out.println("\n>Remove (WebOrri lista bat)");
		weborrizerrenda.remove(lista);
		System.out.println(url1 +" eta "+ url2+ " orriak ezabatu al dira? " + (!weborrizerrenda.contains(w1) && !weborrizerrenda.contains(w2)));
	
		weborrizerrenda.add(w1);
		System.out.println(weborrizerrenda.id2String(id1));
		System.out.println(weborrizerrenda.string2Id(url1));
	}
}