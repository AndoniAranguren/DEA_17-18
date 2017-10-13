package JUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import eginkizuna1.Hiztegia;
import eginkizuna1.WebOrria;

public class probaWebOrria {
	
	private static WebOrria w1,w2;
	private static String url1,url2;
	private static int id1,id2;
	
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
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testWebOrria() {
		System.out.println("\nEraikitzailea========================================================");
		
		System.out.println("\n1.Sartutako id-a: "+id1+" Emaitza: "+w1.getUrl());
		if(w1.getId()!=id1) fail("Id-a ezberdina");
		System.out.println("Sartutako url-a: "+url1+" Emaitza: "+w1.getUrl());
		if(w1.getUrl()!=url1) fail("Url-a ezberdina");
		System.out.println("Lortutako gakoak: "+ w1.getGakoa());
		

		System.out.println("\n2.Sartutako id-a: "+id2+" Emaitza: "+w2.getUrl());
		if(w2.getId()!=id2) fail("Id-a ezberdina");
		System.out.println("Sartutako url-a: "+url2+" Emaitza: "+w2.getUrl());
		if(w2.getUrl()!=url2) fail("Url-a ezberdina");
		System.out.println("Lortutako gakoak: "+ w2.getGakoa());
		
		
		
	}

	@Test
	public void testCompareTo() {
		if(w1.compareTo(w1)!=0)fail(w1.getUrl()+ " == " + w1.getUrl()+" izan beharko zen");
		if(w1.compareTo(w2)<0)fail(w1.getUrl()+ " < " + w2.getUrl()+" izan beharko zen");
		if(w2.compareTo(w1)>0)fail(w1.getUrl()+ " > " + w2.getUrl()+" izan beharko zen");
	}
}
