package Tasks;
import java.util.*;

/*
 *  (Priority Queue using Heap)
We have already discussed heap pseudocode in class. Write a code from scratch for
implementation of Binary heap. Create and Design required attributes methods.
 */
public class PriorityQueueUsingHeap {
	  static int[] heap;
	  static int size=-1;
	  int capacity;

	    public PriorityQueueUsingHeap(int capacity) {
	        this.capacity = capacity;
	        this.size = 0;
	        this.heap = new int[capacity];
	    }
	    
	   public int parent(int i) {
		        return (i-1)/2;
		    }

		    private int leftChild(int i) {
		        return 2*i+1;
		    }

		    private int rightChild(int i) {
		        return 2*i+2;
		    }
		    private void swap(int i, int j) {
		        int temp = heap[i];
		        heap[i] = heap[j];
		        heap[j] = temp;
		    }
		    public void ShiftUp(int i) {
		    	while (i > 0 && heap[parent(i)] < heap[i]) {
		            swap(parent(i),i);
		            i = parent(i);
		        }

		    }
		    public void Shiftdown(int i) {
		    	 int maxIndex=i;
		    	 int L= leftChild(i);
		    	 if(L<=size && heap[L]>heap[maxIndex]) {
		    		 maxIndex=L;
		    	 }
		    	 int R= rightChild(i);
		    	 if(R<=size && heap[R]>heap[maxIndex]) {
		    		 maxIndex=R;
		    	 }
		    	 if(i!=maxIndex) {
		    		 swap(i,maxIndex);
		    		Shiftdown(maxIndex);
		    	 }
		    }
		  
		    public void insert(int data) {
		        if (size == capacity) {
		            System.out.println("Heap is full. Cannot insert.");
		            return;
		        }
		        size++;
		        int i = size - 1;
		        heap[i] = data;
		        ShiftUp(i);
		    }


          public void Remove(int i) {
        	   heap[i]=Integer.MAX_VALUE;
        	   ShiftUp(i);
        	   ExtractMax();
        	   
           }
          public int ExtractMax() {
        	  if (size <= 0) {
                  System.out.println("Heap is empty. Cannot extract max.");
                  return -1; // Return a sentinel value or throw an exception
              }
              if (size == 1) {
                  size--;
                  return heap[0];
              }
              int result = heap[0];
              heap[0] = heap[size - 1];
              size--;
              Shiftdown(0);
              return result;
        	  
          }
          public int getMax() {
              if (size <= 0) {
                  System.out.println("Heap is empty. No maximum value.");
                  return -1; // Return a sentinel value or throw an exception
              }

              return heap[0];
          }

        void changePriority(int i,int p){
        int oldp = heap[i];
            heap[i] = p;

          if (p > oldp) {
	            ShiftUp(i);
               }
        else{
	   Shiftdown(i);
}
}
          public static void main(String[] args) {
       	  PriorityQueueUsingHeap maxHeap = new PriorityQueueUsingHeap(10);

       	maxHeap.insert(42);
       	maxHeap.insert(24);
       	maxHeap.insert(44);
       	maxHeap.insert(22);
       	maxHeap.insert(30);
       	maxHeap.insert(2);
       	maxHeap.insert(11);
       	maxHeap.insert(14);
       	maxHeap.insert(7);

          int i = 0;
          System.out.print("Priority Queue : ");
          while (i <= size) {
          	System.out.print(heap[i] + " ");
          	i++;
          }
          System.out.print("\n");

          System.out.println("Extracted Max: " + maxHeap.ExtractMax());

          System.out.print("Priority queue after " + "extracting maximum : ");
         int j = 0;
         while (j <= size) {
          	System.out.print(heap[j] + " ");
         	j++;
        }

         maxHeap.changePriority(2, 49);
         System.out.println();

          System.out.println("Priority queue after priority change : ");
          int k = 0;
          while (k <= size)           {
          	System.out.print(heap[k] + " ");
          	k++;
          }

          System.out.println();

          //Remove element at index 7
          maxHeap.Remove(7);
          System.out.print("Priority queue after removing the element : ");
          int l = 0;
          while (l <= size) 
          {
          	System.out.print(heap[l] + " ");
          	l++;
          }
         }
         
}


