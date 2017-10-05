package eginkizuna1;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class Hiztegia {
	//Atributuak
	private HashSet<String> hiztegia;
	private static Hiztegia nireBurua;
	
	//Eraikitzailea
	private Hiztegia(){
		hiztegia=new HashSet<String>();
	}
	public static Hiztegia getHiztegia(){
		if(nireBurua==null)
			nireBurua = new Hiztegia();
		return nireBurua;
	}
	
	//Metodoak
	public void add (java.util.ArrayList<String> pH){
		hiztegia.addAll(pH);
	}
	public void add (String pH){
		hiztegia.add(pH);
	}
	public void remove(String pH){
		hiztegia.remove(pH);
	}
	public boolean contains(String pH) {
		return hiztegia.contains(pH);
	}
	public void datuakKargatu(String pHelbidea){
		String hitza;
		try{
			Scanner entrada= new Scanner (new FileReader (pHelbidea));
			System.out.println("whilera sartuko da...");
			while(entrada.hasNext()){
				System.out.println(".");
				hitza=entrada.next();
				System.out.println(hitza+"\n");
				add(hitza);
			}
		}
		catch(IOException e){
			System.out.println("Sar ezazu beste helbide bat.");
			}
	}
}
