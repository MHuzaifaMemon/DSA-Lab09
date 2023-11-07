package Tasks;
/*
 * (Priority Queue using unsorted array)
Understand provided code and implement all required methods.
In this case, running time for insert will be O(1) and for extractMax/getMax will be 𝑂(𝑛).
 */
import java.util.Arrays;

class PriorityQueueUsingArray {
     int[] array;
     int size;
    int capacity;
    // Constructor
     PriorityQueueUsingArray(int capacity){
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

        array[size] = data;
        size++;
        }

    // Return and remove max value from array
    public int extractMax() {
    	if (size == 0) {
            System.out.println("Priority Queue is empty. Cannot extract max.");
            return -1;       
            }
    	int maxIndex = 0;
        int max = array[0];

        for (int i = 1; i < size; i++) {
            if (array[i] > max) {
                max = array[i];
                maxIndex = i;
            }
        }

        // Move the last element to the position of the extracted max
        array[maxIndex] = array[size - 1];
        size--;

        return max;
        }

    // Just return the max value from the array
    public int getMax() {
        if (size == 0) {
            System.out.println("Priority Queue is empty. Cannot extract max.");
            return -1;
        }
        int max = array[0];
        for (int i = 1; i < size; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        return max;    		  
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