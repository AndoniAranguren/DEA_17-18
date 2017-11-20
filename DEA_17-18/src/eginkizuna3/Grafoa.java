package eginkizuna3;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Grafoa {
	private HashMap<String,Integer> th;
	private String[] keys;
	private ArrayList<Integer>[] adjList;
	private int totales;
	
	public Grafoa(){}
	
	public void init(String pWebOrriak, String pErlazioak) {		
		th= new HashMap<String,Integer>();
		totales= lineaTotalak(pWebOrriak);
		keys= new String[totales];
		adjList = new ArrayList[totales];
		datuakKargatu(pWebOrriak);
		webOrrienDatuakKargatu(pErlazioak);
	}
	private int lineaTotalak(String pHeblidea) {
		int lines = 0;
		try {
			java.io.File file = new java.io.File(pHeblidea);
			java.io.LineNumberReader lineNumberReader = new java.io.LineNumberReader(new FileReader(file));
			lineNumberReader.skip(Long.MAX_VALUE);
			lines = lineNumberReader.getLineNumber();
			lineNumberReader.close();
		}catch(IOException e){
			
		}
		return lines;
	}
	private void datuakKargatu(String pHelbidea){
		String linea;
		int kop=1,ehuneko=0;
		boolean loading= totales>1000000;

		System.out.println("WebOrriZerrendan datuak kargatzen...");
		try{
			Scanner entrada= new Scanner (new FileReader(pHelbidea)); //Scanner solo coge string, toda la linea
			if(loading) {
				System.out.print("[");
				for(int i =0; i<100;i++) System.out.print("-");
				System.out.println("]");
				System.out.print("[");
			}
			while(entrada.hasNext()){
				if(loading&&ehuneko!=(kop* 100)/totales) {
					ehuneko=(kop* 100)/totales;
					System.out.print("=");
				}
				linea=entrada.nextLine();
				
				String url=linea.split(" ")[0];
				int id=Integer.parseInt(linea.split(" ")[1]);
				th.put(url,id);
				keys[id]=url;
						
				kop++;
			}
			entrada.close();
			if(loading)System.out.println("]");
		}
		catch(IOException e){System.out.println("Beste helbide bat sar ezazu.");}

		System.out.println((kop-1)+ " weborri kargatu dira");
	}
	
	private void webOrrienDatuakKargatu(String pHelbidea){
		String linea;
		int nondik, nora;
		int totales= lineaTotalak(pHelbidea), kop=1,ehuneko=0;
		boolean loading= totales>1000000;
		try{
			Scanner entrada= new Scanner (new FileReader (pHelbidea));
			if(loading) {
				System.out.print("[");
				for(int i =0; i<100;i++) System.out.print("-");
				System.out.println("]");
				System.out.print("[");
			}
			while(entrada.hasNext()){
				if(loading&&ehuneko!=(kop* 100)/totales) {
					ehuneko=(kop* 100)/totales;
					System.out.print("=");
				}
				linea=entrada.nextLine();
				
				nondik=Integer.parseInt(linea.split(" ")[0]);
				nora=Integer.parseInt(linea.split(" ")[1]);
				if(adjList[nondik]==null)
					adjList[nondik]= new ArrayList<Integer>();
				adjList[nondik].add(nora);
				
				kop++;
			}
			entrada.close();
			if(loading)System.out.println("]");
		}
		catch(IOException e){
			System.out.println("Sar ezazu beste helbide bat.");
			}

		System.out.println((kop-1)+ " weborri estekatu dira");
	}
	
	public ArrayList<String> erlazionatutaPath(String a1, String a2){
		ArrayList<String> retArray= null;

		HashMap<String, String> path = new HashMap<String,String>();
		eginkizuna2.UnorderedDoubleLinkedList<Integer> nextWebs= 
				new eginkizuna2.UnorderedDoubleLinkedList<Integer>();
		
		int currentWeb=th.get(a1);
		int destiny= th.get(a2);
		boolean found=false;
		
		nextWebs.addToRear(currentWeb);
		path.put(keys[currentWeb], null);
		
		while(!found && !nextWebs.isEmpty()) {
			currentWeb=nextWebs.first();
			found= (currentWeb==destiny);
			if(!found) {
				nextWebs.removeFirst();
				for(int id:adjList[currentWeb]) {
					if(!path.containsKey(keys[id])){
						nextWebs.addToRear(id);
						path.put(keys[id], keys[currentWeb]);
					}
				}
			}
		}
		
		if(found) {//Create the array we have to return
			String current= a2;
			retArray= new ArrayList<String>();
			while(current!=null) {	//Inverted array. O(m) m being the amount of webs linked between a1 and a2
				retArray.add(current);
				current=path.get(current);
			}
			for (int i = 0; i < retArray.size() / 2; ++i) { // Invert it back. O(m/2) only goes for half the array size
			    String elem = retArray.get(i); 
			    retArray.set(i,retArray.get( (retArray.size()-1) -i )); // we set i-th element with i-th element from the back
			    retArray.set( (retArray.size()-1) -i, elem);
			  }
		}
		return retArray;
	}
}
