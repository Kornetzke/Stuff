package ie;

public class Doubley {

	public static void main(String[] args){
		double x =1.0*Math.pow(10, 300);
		double newX = x;
		
		while(true){
			
			newX ++;
			
			if(x < newX){
				System.out.println("changed "+newX);
			}else{
				System.out.println("Not changed "+newX);
			}
		}
		
		
	}
	
	
}
