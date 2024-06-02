package meta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Find all the solutions to a3 + b3 = c3 + d3 where a, b, c, d are ints between 1 and N.

public class DemoResue {
	
	public static class Pair {
		int a;
		int b;
		double sum; 
		
		public Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}
		@Override
		public String toString() {
			return  " a :: " + a + " b :: " + b ;
		}
	}

	public void bruteForce ( int[] a, int[] b, int[] c, int[] d) {
	
		for(int i =0; i< a.length; i++) {
			
			for(int j =0; j< b.length; j++) {
				
				for(int k =0; k< c.length; k++) {
					
					for(int l =0; l< d.length; l++) {
						
						double a3 =  Math.pow(a[i],3);;

						double b3 = Math.pow(b[j],3);

						double c3 = Math.pow(c[k],3);

						double d3 = Math.pow(d[l],3);
								
						if (  (a3 + b3) == ( c3 + d3 )  ) {
							System.out.println( (a3 + b3) +  " ===>  a " + a[i] + " b  " + b[j] + " c " + c[k] + " d  " + d[l]);
						} 
					}
				}
			} 
		} 
	}
	
	
	public void better ( int[] a, int[] b, int[] c, int[] d) {
		
		for(int i = 0; i< a.length; i++) {
			
			for(int j =0; j< b.length; j++) {
				
				for(int k =0; k< c.length; k++) {
					
					for(int l =0; l< d.length; l++) {
						
						double a3 =  Math.pow(a[i],3);;

						double b3 = Math.pow(b[j],3);

						double c3 = Math.pow(c[k],3);

						double d3 = Math.pow(d[l],3);
								
						if (  (a3 + b3) == ( c3 + d3 )  ) {
							System.out.println( (a3 + b3) +  " ===>   a " + a[i] + " b  " + b[j] + " c " + c[k] + " d  " + d[l]);
						} 
					}
				}
			} 
		} 
	}
	
	public void optimal ( int[] a, int[] b, int[] c, int[] d) {
		
		HashMap<Double, List<Pair>> map  = new HashMap<Double, List<Pair>>();
		
		for(int i = 0; i< a.length; i++) {
			
			for(int j =0; j< b.length; j++) {
				
				double a3 =  Math.pow(a[i],3);;

				double b3 = Math.pow(b[j],3);
				
				double sum = a3 + b3; 
				
				List<Pair> list = map.get(sum)  ; 
				
				if ( list == null ) {
					list = new ArrayList<Pair>();
					map.put(sum, list);
				}
				Pair p = new Pair(a[i], b[j]);
				list.add(p); 
				 
			} 
		} 
		
		HashMap<Double, List<Pair>> map1 = new HashMap<Double, List<Pair>>();
		
		for(int i = 0; i< c.length; i++) {
			
			for(int j =0; j< d.length; j++) {
				
				double c3 =  Math.pow(c[i],3);;

				double d3 = Math.pow(d[j],3);
				
				double sum = c3 + d3; 
				
				List<Pair> list = map1.get(sum)  ; 
				
				if ( list == null ) {
					list = new ArrayList<Pair>();
					map1.put(sum, list);
				}
				Pair p = new Pair(c[i], d[j]);
				list.add(p);  
			} 
		} 
		 
		
		for(Map.Entry<Double, List<Pair>> entry : map.entrySet() ) {
			Double key = entry.getKey();
			if (   map1.get(key)  != null )  {
				System.out.println( " Key " + key  + "  AB Pairs  " + entry.getValue().toString() +  " BC Pairs :: "+ map1.get(key).toString());
			}
		}
		
	}

	
	
	public static void main(String[] args) {

		int[]  a = { 1,2,4,7,8,9,4 };
		int[]  b = { 2,3,5,};
		
		int[]  d = { 4,3,1,5, 2,7,0 };
		int[]  c = { 7, 3,1,7 };
		
		
		DemoResue dr = new DemoResue();
		dr.bruteForce(a, b, c, d);
		
		System.out.println( " OPTIMALLLL ..DemoResue. " );
		dr.optimal(a, b, c, d);
	}

}
