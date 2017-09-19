package praktika1;
import java.util.Random;

public class ArrayCreator {

	static int MAX=1000000;
	
	public static Integer[] createArray(int N, int range){
		Random randomGenerator = new Random();
		
		Integer[] a = new Integer[N];
		for (int i=0; i<N; i++){
			a[i] = Math.abs(randomGenerator.nextInt(range));
		}
		return a;
	}
	
	public static Integer[] createArray(int N){
		return createArray(N,MAX);
	}
}
