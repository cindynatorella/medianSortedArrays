package arraymedian;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] n1 = {1,2,3,4};
		int[] n2 = {2,3,4,5};
		
		double result = findMedianSortedArrays(n1,n2);
		System.out.print("result: "+result);
	}
	
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length == 0 && nums2.length == 1)
        	return nums2[0];
        if(nums1.length == 1 && nums2.length == 0)
        	return nums1[0];
		//we do not need to merge the entire two table
		int sumLength = nums1.length + nums2.length; 
		boolean isEven = sumLength % 2 == 0; // n & 1 == 0 //different way to check with bit
		double temp=0;
		int i=0, j=0,k = 0;
		
		while(k<=sumLength/2) {
			System.out.println("i = "+i);
			System.out.println("j = "+j);
			System.out.println("______");
			if((j>=nums2.length && i<nums1.length)||(i<nums1.length && nums1[i]<nums2[j])) {
				if(isEven && k>= sumLength/2-1)
					temp+= nums1[i];
				if(!isEven && k == sumLength/2)
					return nums1[i];
				i++;
			}else {
				if((j<nums2.length && i>=nums1.length)|| (j<nums2.length && nums1[i]>=nums2[j])){
					if(isEven && k>= sumLength/2-1)
						temp+=nums2[j];
					if(!isEven && k == sumLength/2)
						return nums2[j];
					j++;
				}
			}
			k++;
		}
		
		return temp/2;
		
		
    }

}
