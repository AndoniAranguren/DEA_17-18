package JUnit;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import eginkizuna1.Hiztegia;
import praktika1.Stopwatch;


public class probaHiztegia {

	private Hiztegia hiztegia= Hiztegia.getHiztegia();
	private ArrayList<String> lista= new ArrayList<String>();
	
@Test
	public void testEragiketaSinpleak() {
		System.out.println("\ntestEragiketaSinpleak========================================================");
		System.out.println(">Add (Elementu bat)");
		System.out.println("Ondo gehitu da? => " + hiztegia.add("atea"));
		
		System.out.println("\n>Add (Iada daukan elementua)");
		System.out.println("Gehitu da? => " + hiztegia.add("atea"));
		
		System.out.println("\n>Add (ArrayList bat)");
		lista= new ArrayList<String>(Arrays.asList("aulkia","izpilua"));
		System.out.println("Guztiak ondo gehitu dira? => " + hiztegia.add(lista));
		
		System.out.println("\n>Contains (Elementua daukanean)");
		System.out.println("Elementua dauka? => " + hiztegia.contains("atea"));
		
		System.out.println("\n>Remove (Daukan elementua)");
		hiztegia.remove("atea");
		System.out.println("Kendutako elementua du? => "+ (hiztegia.contains("atea")));
		
		System.out.println("\n>Remove (Arraylist bat)");
		hiztegia.remove(lista);
		System.out.println("Kendutako elementuak ditu? => " 
				+ (hiztegia.contains("aulkia")&&hiztegia.contains("izpilua")));
		
		System.out.println("\n>Contains (Lista hutsa)");
		System.out.println("Lista hutsean elementu bat du? => " + hiztegia.contains("atea"));
	}

@Test
	public void testDatuakKargatu(){
		System.out.println("\ntestDatuakKargatu========================================================");
		System.out.println(">DatuakKargatu (Lista Hutsa)");
		hiztegia.datuakKargatu("src\\JUnit\\ListaHutsa.txt");
		
		System.out.println("\n>DatuakKargatu (Lista Laburra)");
		hiztegia.datuakKargatu("src\\JUnit\\ListaLaburra.txt");
		
		System.out.println("\n>DatuakKargatu (Lista guztiz errepikatuta)");
		hiztegia.datuakKargatu("src\\JUnit\\ListaLaburra.txt");
		
		System.out.println("\n>DatuakKargatu (Lista Luzea)");
		Stopwatch erloju= new Stopwatch();
		hiztegia.datuakKargatu("src\\JUnit\\ListaLuzea.txt");
		System.out.println("Denbora: " + erloju.elapsedTime() + " segundu");
	}

@Test
	public void testEragiketaGogorrenak() {
		System.out.println("\ntestEragiketaGogorrenak========================================================");
		hiztegia.clear();
		System.out.println(">DatuakKargatu (Lista Luzea)");
		Stopwatch erloju= new Stopwatch();
		hiztegia.datuakKargatu("src\\JUnit\\ListaLuzea.txt");
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
}
