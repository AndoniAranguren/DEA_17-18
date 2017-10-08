package praktika1;

public class Stopwatch {
	
	private final long start;
	
	public Stopwatch(){
		start= System.currentTimeMillis();
	}
	
	public double elapsedTime(){//segundutan bueltatzen du
		long now = System.currentTimeMillis();
		return (now-start)/1000.0;
	}
}
