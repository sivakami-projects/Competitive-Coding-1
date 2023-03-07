/*
Time Complexity - O(log N) where N is the size of the arr.
Space Complexity - O(1)
*/
public class missingNumber {
	
	public int getMissingNumber(int[] arr) {
		int left = 0, right = arr.length - 1;
		
		while(left <= right) {
			int mid = (right - left) / 2 + left;
			
			//if missing value is between mid and mid - 1
			if(mid > 0 && arr[mid] - arr[mid - 1] != 1)
					return arr[mid] - 1;
			
			//if missing value is between mid and mid + 1
			if(mid < arr.length - 1 && arr[mid + 1] - arr[mid] != 1)
					return arr[mid] + 1;
			
			//difference of value and index for mod and left is equal, 
			//then it confirms all elements in the left subarr are sorted.
			if(arr[mid] - arr[left] == mid - left)
				left = mid + 1;		//move to right.
			else 
				right = mid - 1;
		}
		return -1;
	}
	public static void main(String[] args) {
		missingNumber obj = new missingNumber();
		System.out.println(obj.getMissingNumber(new int[] {5,6,7,8,9,11}));
		System.out.println(obj.getMissingNumber(new int[] {5,7,8,9,10,11}));
		System.out.println(obj.getMissingNumber(new int[] {5,6,7,9,10,11}));
		System.out.println(obj.getMissingNumber(new int[] {5,6,7,8,10}));
		System.out.println(obj.getMissingNumber(new int[] {5,7,8,9,10}));
		System.out.println(obj.getMissingNumber(new int[] {5,7}));
	}
	
}
