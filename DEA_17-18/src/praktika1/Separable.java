package praktika1;

public class Separable {
	public Separable(){}
	
	public int esSeparable(Integer[] pTabla){
		long left=0;
		long right=0;
		int indR=pTabla.length-1, indL=0;
		
		while(indL<=indR){
			if(left<=right){
				left+=pTabla[indL];
				indL++;
			}else{
				right+=pTabla[indR];
				indR--;
			}
		}
		return (left!=right ? 0 : indL); //(left ezberdin right)=true bada 0 bueltatzen du false bada indL bueltatzen du
	}
	public int esSeparable2(Integer[] tabla){
		int izq=0, der=0, i=0, k=0;
		boolean aurkituta=false;
		boolean amaitu=false;
		
		while (i<tabla.length-1){
			der=der+tabla[i];
			i++;
		}
		while (aurkituta==false && amaitu==false){
			izq=izq+tabla[k];
			der=der-tabla[k];
			if (izq>der || k>tabla.length){
				amaitu=true;
			}
			if (izq==der){
				aurkituta=true;
			}
			else 
				k++;
		}
		if(aurkituta) return k;
		else return 0;
	}
}
