package general;

/**
Largest Sum Contiguous Subarray
Pair Sum
*/
class PairSum {

    public static void main(String[] argv) throws Exception {
        int[] arr = new int[] {-2,-3,-1,-5,-1,-2,-1,-5,-3};
        int sum = -6; 
		int pair1 = 0 ;
		int pair2 = 0; 
		for(int i =0 ; i<arr.length-1;i++){
			pair1 =  arr[i];
			pair2 = arr[i+1];
			if(sum == (pair1+pair2)){
				print("\n "+ pair1 +"  "+ pair2);
				break;
			}
		}
    }

    public static void print(Object o) {
        System.out.println(o);
    }
}