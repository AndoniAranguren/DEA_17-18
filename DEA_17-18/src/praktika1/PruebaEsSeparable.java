package praktika1;

public class PruebaEsSeparable {
	
	public static double timeTrial(int N){
		Integer[] a = ArrayCreator.createArray(N);
		
		Stopwatch timer = new Stopwatch();
		Separable sepa = new Separable();
		System.out.println("Erdiko puntua hau da:"+sepa.esSeparable(a));
		return timer.elapsedTime();
	}
	
	public static void main (String[] args){
		for(int N=250; true; N+=N){
			double time= timeTrial(N);
			System.out.println("Tamaina: "+N+" Denbora: "+time+"\n");
		}
	}
}
