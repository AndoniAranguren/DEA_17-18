package JUnit;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import eginkizuna1.Hiztegia;

public class probaHiztegia {

	private Hiztegia hiztegia= Hiztegia.getHiztegia();
	private ArrayList<String> lista= new ArrayList<String>();
	@Test
	public void testAdd() {
		System.out.println("hiztegia hutsik");
		System.out.println("Contains atea||izpilua?");
		System.out.println(hiztegia.contains("atea")||hiztegia.contains("izpilua"));
		lista= new ArrayList<String>(Arrays.asList("atea","izpilua"));
		hiztegia.add(lista);
		System.out.println("\nhiztegiak -atea- eta hizpilua- dauzka");
		System.out.println("contains atea?");
		System.out.println(hiztegia.contains("atea"));
		hiztegia.remove("atea");
		System.out.println("\nremove -atea-");
		System.out.println("contains atea?");
		System.out.println(hiztegia.contains("atea"));
		System.out.println("\nadd -atea-");
		System.out.println("contains atea?");
		hiztegia.add("atea");
		System.out.println(hiztegia.contains("atea")+"\n\n");
		testDatuakKargatu();
	}
	
	public void testDatuakKargatu(){
		System.out.println("holis");
		hiztegia.datuakKargatu("/Words2");
	}
	


}
