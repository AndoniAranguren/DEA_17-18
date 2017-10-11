package JUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import eginkizuna1.WebOrria;
import praktika1.Stopwatch;
import eginkizuna1.Hiztegia;
import eginkizuna1.WebOrriZerrenda;

import java.util.ArrayList;
import java.util.Random;

public class probaWebOrriZerrenda {
	
	private static WebOrriZerrenda weborrizerrenda= WebOrriZerrenda.getWebOrriZerrenda();
	
	private static WebOrria w1,w2, w3;
	private static String url1,url2, url3;
	private static int id1,id2,id3;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Hiztegia.getHiztegia().datuakKargatu("src\\JUnit\\hiztegiLuzea.txt");
		url1= "007waystomakemoney.com";
		id1 = 12345;
		url2= "009al3ab.com.es.de";
		id2 = 99999;
		url3= "oliverbenji.com";
		id3 = 10101;
		w1= new WebOrria(url1, id1);
		w2= new WebOrria(url2, id2);
		w3= new WebOrria(url3, id3);
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
	public void testEragiketaSinpleak(){
		System.out.println("\ntestEragiketaSinpleak========================================================");
		System.out.println(">Add (Weborria bat)");
		weborrizerrenda.add(w1);
		System.out.println(url1 +" orria gehitu al da? " + weborrizerrenda.contains(w1));
		
		System.out.println("\n>Remove (Weborria bat)\"");
		weborrizerrenda.remove(w1);
		System.out.println( url1 +" orria ezabatu al da? " + !weborrizerrenda.contains(w1));
		
		System.out.println("\n>Add (WebOrri lista bat)"); //?
		ArrayList<WebOrria> lista= new ArrayList<WebOrria>();
		lista.add(w1);
		lista.add(w2);
		weborrizerrenda.add(lista);
		System.out.println( url1 +" orria gehitu al da? " + (weborrizerrenda.contains(w1) && weborrizerrenda.contains(w2)));
		
		System.out.println("\n>Remove (WebOrri lista bat)");
		weborrizerrenda.remove(lista);
		System.out.println(url1 +" eta "+ url2+ " orriak ezabatu al dira? " + (!weborrizerrenda.contains(w1) && !weborrizerrenda.contains(w2)));	
		
		System.out.println("\n>Add (Weborria bat)");
		weborrizerrenda.add(w3);
		System.out.println(url3 +" orria gehitu al da? " + weborrizerrenda.contains(w3));
		
		System.out.println("\n>id2String (Id bat emanda, url eskatu)");
		System.out.println(weborrizerrenda.id2String(id3));
		
		System.out.println("\n>string2Id (Url bat emanda, id eskatu)");
		System.out.println(weborrizerrenda.string2Id(url3));
	}
	
	@Test
	public void webOrdenatuta() {
		
		System.out.println("\nwebOrdenatuta========================================================");
		String izena1,izena2;
		Random rnd = new Random();
		for(int i=0;i<25;i++) {
			izena1= "";
			for(int as=0; as<10; as++) {
				izena1=izena1.concat(""+(Character.toChars(
						rnd.nextInt(25)+97)[0]));
						//97-garren posizioan 'a' characterea dago
						//25 posizio aurrerago 'z' dago. 
						//Bitarteko balioa ateratzeko
			}
			weborrizerrenda.add(new WebOrria(izena1, i));
		}
		
		System.out.println("Ordenatutako lista osoa");
		ArrayList<String> lista=weborrizerrenda.webOrdenatua();
		System.out.println(lista);

		System.out.println("Listako balio bat, eta geroago dagoen beste bat hartuko da");
		int pos=rnd.nextInt(lista.size()-2);
		izena1=lista.get(pos);
		izena2=lista.get(rnd.nextInt(lista.size()-pos)+pos);
		
		System.out.println(izena1 + " " + izena2 +" baino txikiagoa da? " + (izena1.compareTo(izena2)<0));
		if(izena1.compareTo(izena2)>0) {
			fail("Lehenengoa bigarrena baino handiagoa da");
		}
	}
	@Test
	public void testEragiketaKonplex(){
		System.out.println("\ntestEragiketaKonplex========================================================");
		System.out.println("\n>Add (Weborria bat)");
		weborrizerrenda.add(w3);
		System.out.println(url3 +" orria gehitu al da? " + weborrizerrenda.contains(w3));
		System.out.println("\n>id2Web (Id bat emanda, weborria eskatu)");
		System.out.println(weborrizerrenda.id2Web(id3));
	}
	
	@Test
	public void testKargatu(){
		Stopwatch erloju= new Stopwatch();
		
		System.out.println("\ntestDatuakKargatu========================================================");
		System.out.println(">DatuakKargatu (Lista Hutsa)");
		
		
		System.out.println("\n>DatuakKargatu (Lista Laburra)");
		weborrizerrenda.datuakKargatu("src\\JUnit\\smallindex.txt");
		
		System.out.println("\n>DatuakKargatu (Lista Luzea)");
		
		System.out.println("Denbora: " + erloju.elapsedTime() + " segundu");
	}
}