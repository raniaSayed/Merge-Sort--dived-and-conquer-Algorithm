import java.util.ArrayList;


public class MergeSort {
	static int[] divide(int arr[]){
		if(arr.length == 1) return arr; //size=1
		
		int left_length = arr.length/2;
		int right_length = arr.length - left_length; //remaining length
		int left[] = new int[left_length];
		int right[] = new int[right_length];
		for(int i = 0; i < left_length; i++) left[i] = arr[i]; 
		for(int i = 0; i < right_length; i++) right[i] = arr[left_length + i];
		left = divide(left);
		right = divide(right);
		return merge(left,right, left.length + right.length);
	}
	static int[] merge(int left[] , int right[],int size){

		int i=0,j=0;
		int array[] = new int[size];
			for(int k=0;k<size;k++){
				if(i==left.length){
					if(right.length>j){
						array[k]=right[j];
						j++;
					}
				}
				else if(j==right.length){
					if(left.length>i){
						array[k]=left[i];
						i++;
					}
				}
				if(left.length>i && right.length>j){
				if(left[i]>right[j]){
					array[k]=right[j];
					j++;
				}
				else if(right[j]>=left[i]){
					array[k]=left[i];
					i++;
				}
			}
			}
		   return array;
	}
	
	 public static void  main(String[]args){
		 int arr[] ={4,2,6,7,2,1};
	int array [] = divide(arr);
	for(int i=0;i<arr.length;i++){
		
		System.out.println("array["+i+"] ="+array[i]);
	}
	}
}
