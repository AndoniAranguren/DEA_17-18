package eginkizuna1;

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
import java.util.HashMap;
import java.util.Random;
 
 public class WebOrriZerrendaTest {
 	
 	private static WebOrriZerrenda weborrizerrenda= WebOrriZerrenda.getWebOrriZerrenda();
 	
 	private static WebOrria w1,w2;
 	private static String url1,url2;
 	private static int id1,id2;
 	
 	
 	@BeforeClass
 	public static void setUpBeforeClass() throws Exception {
 		Hiztegia.getHiztegia().datuakKargatu("src\\eginkizuna1\\hiztegiLaburra.txt");
 		Hiztegia.getHiztegia().datuakKargatu("src\\eginkizuna1\\hiztegiLuzea.txt");
 		url1= "007waystomakemoney.com";
 		id1 = 12345;
 		url2= "009al3ab.com.es.de";
 		id2 = 99999;
 		w1= new WebOrria(url1, id1);
 		w2= new WebOrria(url2, id2);
 	}
 
 	@AfterClass
 	public static void tearDownAfterClass() throws Exception {
 	}
 	
 	@Before
 	public void setUp() throws Exception {
 	}
 
 	@After
 	public void tearDown() throws Exception {
 		weborrizerrenda.clear();
 	}
 
 	@Test
 	public void testEragiketaSinpleak(){
 		System.out.println("\ntestEragiketaSinpleak========================================================");
 		System.out.println(">Add (Weborria bat)");
 		weborrizerrenda.add(w1);
 		System.out.println(url1 +" orria gehitu al da? " + weborrizerrenda.contains(w1));
 		if(!weborrizerrenda.contains(w1))fail("Ez da "+w1+" gehitu");
 		
 		System.out.println("\n>Remove (Weborria bat)\"");
 		weborrizerrenda.remove(w1);
 		System.out.println( url1 +" orria ezabatu al da? " + !weborrizerrenda.contains(w1));
 		if(weborrizerrenda.contains(w1))fail("Ez da "+w1+" kendu");
 		
 		System.out.println("\n>Add (WebOrri lista bat)"); //?
 		ArrayList<WebOrria> lista= new ArrayList<WebOrria>();
 		lista.add(w1);
 		lista.add(w2);
 		weborrizerrenda.add(lista);
 		System.out.println( url1 +" orria gehitu al da? " + (weborrizerrenda.contains(w1) && weborrizerrenda.contains(w2)));
 		if(!(weborrizerrenda.contains(w1)&&weborrizerrenda.contains(w2)))fail("Ez da "+lista+" gehitu");
 		
 		System.out.println("\n>Remove (WebOrri lista bat)");
 		weborrizerrenda.remove(lista);
 		System.out.println(url1 +" eta "+ url2+ " orriak ezabatu al dira? " + (!weborrizerrenda.contains(w1) && !weborrizerrenda.contains(w2)));	
 		if(weborrizerrenda.contains(w1)&&weborrizerrenda.contains(w2))fail("Ez da "+lista+" kendu");
 	}
 	
 	@Test
 	public void testId2String() {
 		System.out.println("\n>id2String (Id bat emanda, url eskatu)=====================");
 		weborrizerrenda.add(w1);
 		System.out.println(weborrizerrenda.id2String(id1));
 		if(!weborrizerrenda.id2String(w1.getId())  .equals(w1.getUrl()))
 				fail("Ez da "+w1.getId()+" ondo lortu");
 	}
 	@Test
 	public void testString2Id() {
 		System.out.println("\n>string2Id (Url bat emanda, id eskatu)=====================");
 		weborrizerrenda.add(w1);
 		System.out.println(weborrizerrenda.string2Id(url1));
 		if(weborrizerrenda.string2Id(w1.getUrl())!=(w1.getId()))
 				fail("Ez da "+w1.getUrl()+" ondo lortu");
 	}
 
 	
 	@Test
 	public void testWebOrdenatuta() {
 		
 		System.out.println("\nwebOrdenatuta========================================================");
 		String izena1,izena2;
 		Random rnd = new Random();
 		for(int i=0;i<25;i++) {
 			izena1= "";
 			for(int as=0; as<10; as++) {
 				izena1=izena1.concat(""+(Character.toChars(
 						rnd.nextInt(25)+97)[0]));
 						//97garren posizioan 'a' characterea dago
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
 	public void testKargatu(){
 		
 		Stopwatch erloju= new Stopwatch();
 		System.out.println("\ntestDatuakKargatu========================================================");
 		System.out.println(">DatuakKargatu (Lista Hutsa)");
 		weborrizerrenda.datuakKargatu("src\\eginkizuna1\\fitxategiHutsa.txt");
 		System.out.println("Denbora: " + erloju.elapsedTime() + " segundu");
 
 		erloju= new Stopwatch();
 		System.out.println("\n>DatuakKargatu (Lista Laburra)");
 		weborrizerrenda.datuakKargatu("src\\eginkizuna1\\indexLaburra.txt");
 		weborrizerrenda.webOrrienDatuakKargatu("src\\eginkizuna1\\pdl-arcLaburra.txt");
 		System.out.println("Denbora: " + erloju.elapsedTime() + " segundu");
 
 		erloju= new Stopwatch();
 		System.out.println("\n>DatuakKargatu (Lista Luzea)");
 		weborrizerrenda.datuakKargatu("src\\eginkizuna1\\indexLuzea.txt");
 		weborrizerrenda.webOrrienDatuakKargatu("src\\eginkizuna1\\pdlarcLuzea.txt");
 		System.out.println("Denbora: " + erloju.elapsedTime() + " segundu");
 		
 		System.out.println(Hiztegia.getHiztegia().word2Webs("zombie"));
 		System.out.println(weborrizerrenda.irteerakoEstekak(Hiztegia.getHiztegia().word2Webs("zombie").get(0)));
 	}

 	@Test
 	public void testErlazionatutaPath() {
 		weborrizerrenda.datuakKargatu("src\\eginkizuna1\\indexLaburra.txt");
 		weborrizerrenda.webOrrienDatuakKargatu("src\\eginkizuna1\\pdl-arcLaburra.txt");
 		String a1="0-00.pl";
 		String a2="0-24.ro";
 		System.out.println(weborrizerrenda.erlazionatutaPath(a1, a2));
 	}
 	
 	@Test
 	public void testPageRank(){
 		Hiztegia.getHiztegia().clear();
 		Hiztegia.getHiztegia().datuakKargatu("src\\eginkizuna1\\hiztegiLaburra.txt");
 		
 		weborrizerrenda.datuakKargatu("src\\eginkizuna1\\indexLaburra.txt");
 		weborrizerrenda.webOrrienDatuakKargatu("src\\eginkizuna1\\pdl-arcLaburra.txt");
 		
 		java.util.Set<java.util.Map.Entry<String,Double>> list=weborrizerrenda.pageRank().entrySet();
 		
 		for(java.util.Map.Entry<String,Double> entry: list){
 			System.out.println("Url: "+entry.getKey()+"  PageRank: "+entry.getValue());
 		}
 	}
 	
 	@Test
 	public void testBilatzailea(){
 		Hiztegia.getHiztegia().clear();
 		Hiztegia.getHiztegia().datuakKargatu("src\\eginkizuna1\\hiztegiLaburra.txt");
 		
 		weborrizerrenda.datuakKargatu("src\\eginkizuna1\\indexLaburra.txt");
 		weborrizerrenda.webOrrienDatuakKargatu("src\\eginkizuna1\\pdl-arcLaburra.txt");
 		
 		ArrayList<String> list=weborrizerrenda.bilatzailea("e", "d", new java.util.HashMap<String,Double>());
 		
 		for(String s: list){
 			System.out.println("Url: "+s);
 		}
 	}
	@Test
 	public void testPageRankLuzea(){
 		Hiztegia.getHiztegia().clear();
 		Hiztegia.getHiztegia().datuakKargatu("src\\eginkizuna1\\hiztegiLuzea.txt");
 		
 		weborrizerrenda.datuakKargatu("src\\eginkizuna1\\indexLuzea.txt");
 		weborrizerrenda.webOrrienDatuakKargatu("src\\eginkizuna1\\pdl-pdl-arc.txt");
 		
 		HashMap<String, Double> list = weborrizerrenda.pageRank();
 		
 		System.out.println(list.size());
 		
 		ArrayList<String> listBilatu=weborrizerrenda.bilatzailea("e", "d", new java.util.HashMap<String,Double>());
 		
 		for(String s: listBilatu){
 			System.out.println("Url: "+s);
 		}
 	}
 } 