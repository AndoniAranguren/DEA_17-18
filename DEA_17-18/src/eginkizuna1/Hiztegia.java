package eginkizuna1;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

import WebOrria.Hitza;

public class Hiztegia {
	private HashSet<String> hitzak;
	
	public void add (java.util.ArrayList<String> pH){
		hitzak.addAll(pH);
	}
	public void add (String pH){
		hitzak.add(pH);
	}
	public void remove(String pH){
		hitzak.remove(pH);
	}
	public void datuakKargatu(String pHelbidea){
		try{
			Scanner entrada= new Scanner (new FileReader (pHelbidea));
			while(entrada.hasNext()){
				add(entrada.next());
			}
		}
		catch(IOException e){
			System.out.println("Sar ezazu beste helbide bat.");
			}
	}
}
