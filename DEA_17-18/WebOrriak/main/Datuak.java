package main;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Scanner;

public class Datuak {

	
	public void cargarLista(String pHelbidea){
    	try{
    		Scanner entrada=new Scanner(new FileReader(pHelbidea));
    		String linea;
//    		Aktorea aktorea;
//    		Pelikula peli;
    		String[] S1,S2;
    		while(entrada.hasNext()){
    			linea=entrada.nextLine();
    			
            	S1=linea.split("--->"); //pelikula
//        	    if(this.listaPelikula.elementuaBadago(S1[0])==null){    //Ez badago pelikula sortu eta gorde
//        	        peli= new Pelikula(S1[0]);
//        	    	this.listaPelikula.elementuaSartu(peli);}
//        	    else{
//        	        peli=this.listaPelikula.elementuaBadago(S1[0]);     //Baldin badago, pelikula hartu
//        	    }
            	    
            	S2=S1[1].split("&&&");  //aktoreak
//        	    for(int i=0;i<S2.length;i++){
//        	        if(this.listaAktore.elementuaBadago(S2[i])==null){  //Ez badago aktorea sortu eta gorde
//        	            aktorea=new Aktorea(S2[i]);
//        	        	this.listaAktore.elementuaSartu(aktorea);
//        	        }
//        	        else{
//        	            aktorea=this.listaAktore.elementuaBadago(S2[i]); //Baldin badago, aktorea hartu
//        	        }
//        	        peli.elementuaSartu(aktorea);                       //Sartu pelikulan
//        	        aktorea.elementuaSartu(peli);
//        	    }
            	    

    		}
    		entrada.close();
    	}
        catch(IOException e){e.printStackTrace();}
	
    }
//	public void fitxategiaSortu(String pIzena){
//    	FileWriter fitxategi = null;
//    	PrintWriter pw = null;
//    	try{
//    		fitxategi= new FileWriter(pIzena+".txt");///
//    		pw = new PrintWriter(fitxategi);
//    		Aktorea aktore;
//    		Iterator<Elementuak> iteradorea=this.listaAktore.iteradorea();
//    		
//    		while(iteradorea.hasNext()){
//    			aktore=(Aktorea)iteradorea.next();
//    			pw.print(aktore.izenaEman());
//    			pw.print("&&&");
//    		}
//    	}catch(Exception e){
//    		e.printStackTrace();
//    	}finally{
//    		try{
//    			if(null!=fitxategi){
//    				fitxategi.close();
//    			}
//    		}catch(Exception e2){
//    				e2.printStackTrace();
//    			}
//    		}
//    	}
//    
}
