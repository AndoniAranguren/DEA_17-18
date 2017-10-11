package JUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;

import eginkizuna1.Hiztegia;
import praktika1.Stopwatch;


public class probaHiztegia {
	private static Hiztegia hiztegia;
	private static ArrayList<String> lista;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		hiztegia= Hiztegia.getHiztegia();
		lista= new ArrayList<String>();
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}
	@Before
	public void setUp() throws Exception {
		hiztegia.clear();
	}
	@After
	public void tearDown() throws Exception {
		
	}
	
@Test
	public void testEragiketaSinpleak() {
		boolean denaOndo=true;
		
		System.out.println("\ntestEragiketaSinpleak========================================================");
		System.out.println(">Add (Elementu bat)");
		denaOndo=hiztegia.add("atea");
		System.out.println("Ondo gehitu da? => " + denaOndo);
		if(!denaOndo) fail("Add (Elementu bat)");
		
		System.out.println("\n>Add (Iada daukan elementua)");
		denaOndo=!hiztegia.add("atea");
		System.out.println("Gehitu da? => " + !denaOndo);
		if(!denaOndo) fail("Add (Iada daukan elementua)");
		
		System.out.println("\n>Add (ArrayList bat)");
		lista= new ArrayList<String>(Arrays.asList("aulkia","izpilua"));
		denaOndo=hiztegia.add(lista);
		System.out.println("Guztiak ondo gehitu dira? => " + denaOndo);
		if(!denaOndo) fail("Add (ArrayList bat)");
		
		System.out.println("\n>Contains (Elementua daukanean)");
		denaOndo=hiztegia.contains("atea");
		System.out.println("Elementua dauka? => " + denaOndo);
		if(!denaOndo) fail("Contains (Elementua daukanean)");
		
		System.out.println("\n>Remove (Daukan elementua)");
		denaOndo=hiztegia.remove("atea");
		System.out.println("Kendutako elementua du? => "+ denaOndo);
		if(!denaOndo) fail("Remove (Daukan elementua)");
		
		System.out.println("\n>Remove (Arraylist bat)");
		hiztegia.remove(lista);
		denaOndo=!(hiztegia.contains("aulkia")&&hiztegia.contains("izpilua"));
		System.out.println("Kendutako elementuak ditu? => " 
				+ denaOndo);
		if(!denaOndo) fail("Remove (Daukan elementua)");
		
		System.out.println("\n>Contains (Lista hutsa)");
		System.out.println("Lista hutsean elementu bat du? => " + hiztegia.contains("atea"));
	}
@Test
	public void testEragiketaGogorrenak() {
		System.out.println("\ntestEragiketaGogorrenak========================================================");
		System.out.println(">DatuakKargatu (Lista Luzea)");
		Stopwatch erloju= new Stopwatch();
		hiztegia.datuakKargatu("src\\JUnit\\hiztegiLuzea.txt");
		System.out.println("Denbora: " + erloju.elapsedTime() + " segundu");

		System.out.println("\n>Contains (Hasieran dagoen elementua)");
		erloju= new Stopwatch();
		System.out.println("Dago? " + hiztegia.contains("arthrosis"));
		System.out.println("Denbora: " + erloju.elapsedTime() + " segundu");
		
		System.out.println("\n>Contains (Erdian dagoen elementua)");
		erloju= new Stopwatch();
		System.out.println("Dago? " + hiztegia.contains("masterpiece"));
		System.out.println("Denbora: " + erloju.elapsedTime() + " segundu");
		
		System.out.println("\n>Contains (Amaieran dagoen elementua)");
		erloju= new Stopwatch();
		System.out.println("Dago? " + hiztegia.contains("zombie"));
		System.out.println("Denbora: " + erloju.elapsedTime() + " segundu");
		
		System.out.println("\n>Contains (Ez dagoen elementua)");
		erloju= new Stopwatch();
		System.out.println("Dago? " + hiztegia.contains("asdfasdfasdf"));
		System.out.println("Denbora: " + erloju.elapsedTime() + " segundu");
	}
@Test
	public void testDatuakKargatu(){
		System.out.println("\ntestDatuakKargatu========================================================");
		System.out.println(">DatuakKargatu (Lista Hutsa)");
		hiztegia.datuakKargatu("src\\JUnit\\fitxategiHutsa.txt");
		
		System.out.println("\n>DatuakKargatu (Lista Laburra)");
		hiztegia.datuakKargatu("src\\JUnit\\hiztegiLaburra.txt");
		
		System.out.println("\n>DatuakKargatu (Lista guztiz errepikatuta)");
		hiztegia.datuakKargatu("src\\JUnit\\hiztegiLaburra.txt");
		
		System.out.println("\n>DatuakKargatu (Lista Luzea)");
		Stopwatch erloju= new Stopwatch();
		hiztegia.datuakKargatu("src\\JUnit\\hiztegiLuzea.txt");
		System.out.println("Denbora: " + erloju.elapsedTime() + " segundu");
	}

}
