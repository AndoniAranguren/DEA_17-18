package JUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import eginkizuna1.WebOrria;
import eginkizuna1.WebOrriZerrenda;

import java.util.ArrayList;

public class probaWebOrriZerrenda {
	
	private static WebOrriZerrenda weborrizerrenda;
	
	private WebOrria weborria0;
	private WebOrria weborria1;
	private ArrayList<WebOrria> lista;
	
	@Before
	public void setUp() throws Exception {
		weborria0= new WebOrria("willyrex.com",1);
		weborria1= new WebOrria("staxx.com",2);
		lista= new ArrayList<WebOrria>();
		
	}

	@After
	public void tearDown() throws Exception {
		weborria0=null;
		weborria1=null;
		lista=null;
	}

	@Test

	public void testEragiketaSinpleak(){
		
		System.out.println("\ntestEragiketaSinpleak========================================================");
		System.out.println(">Add (Weborria bat)");
		weborrizerrenda.add(weborria0);
		System.out.println("Gehitu egin den konprobatzeko contains erabliko dugu => ");
		System.out.println("\nwillyrex.com orria gehitu al da?" + weborrizerrenda.contains(weborria0));
		System.out.println("\nOrain sartu dugun weborria listatik ezabatuko dugu.");
		weborrizerrenda.remove(weborria0);
		System.out.println("\nwillyrex.com orria ezabatu al da?" + weborrizerrenda.contains(weborria0));
		
		System.out.println("\n>Add (WebOrri lista bat)"); //?
		lista.add(1, weborria0);
		lista.add(2, weborria1);
		weborrizerrenda.add(lista);
		System.out.println("Gehitu egin den konprobatzeko contains erabliko dugu => ");
		System.out.println("\nwillyrex.com orria gehitu al da?" + weborrizerrenda.contains(weborria0) + weborrizerrenda.contains(weborria1));
		System.out.println("\nOrain sartu dugun weborri lista ezabatuko dugu.");
		weborrizerrenda.remove(lista);
		System.out.println("\nwillyrex.com eta staxx.com orriak ezabatu al dira?" + weborrizerrenda.contains(weborria0) + weborrizerrenda.contains(weborria1));
	}
}
