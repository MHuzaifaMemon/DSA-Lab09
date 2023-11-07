package Tasks;

/*
 * . (Priority Queue using sorted array)
After completing Task 01, your task is to modify task 01 to implement priority queue using sorted
array. You just have to modify insert method to add element in ascending order and extractMax
and getMax method to return last element
 */
public class PriorityQueueUsingsortedArray {
	     int[] array;
	     int size;
	    int capacity;
	    // Constructor
	     PriorityQueueUsingsortedArray(int capacity){
	      array = new int[10]; // Initial size can be adjusted as needed
	        size = 0;
	        this.capacity=capacity;
	    }
	     // Insert data in array in any order
	     public void insert(int data) {
	     	if (size == array.length) {
	             System.out.println("Priority Queue is full. Cannot insert.");
	             return;
	         }
	     	int index = size - 1;

	         // Find the index to insert the new element in ascending order
	         while (index >= 0 && array[index] > data) {
	             array[index + 1] = array[index];
	             index--;
	         }

	         array[index + 1] = data;
	         size++;
	         }

	     // Return and remove max value from array
	     public int extractMax() {
	     	if (size == 0) {
	             System.out.println("Priority Queue is empty. Cannot extract max.");
	             return -1;       
	             }
	         // Find the index of the maximum element in the array
	     	int max = array[size - 1];
	         size--;

	         return max;
	         }

	     // Just return the max value from the array
	     public int getMax() {
	         if (size == 0) {
	             System.out.println("Priority Queue is empty. Cannot extract max.");
	             return -1;
	         }

	        return array[size-1];
	     		   }


	     // Search data in the array
	     public boolean searchData(int data) {
	         for (int i = 0; i < size; i++) {
	             if (array[i] == data) {
	                 return true;
	             }
	         }

	         return false;
	     }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueueUsingArray priorityQueue = new PriorityQueueUsingArray(10);

        priorityQueue.insert(3);
        priorityQueue.insert(8);
        priorityQueue.insert(2);
        priorityQueue.insert(7);

        System.out.println("Max Value: " + priorityQueue.getMax()); 
        System.out.println("Extracted Max Value: " + priorityQueue.extractMax()); 
        System.out.println("Search 2: " + priorityQueue.searchData(2)); 
        System.out.println("Search 5: " + priorityQueue.searchData(5)); 
	}

}
