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
}
