package stack;

import java.util.Arrays;

import utils.Common;

/**
 * A Java class to represent k stacks in a single array of size n
 * 
 * @author deepak
 */
public class KstackImpl {

	static class KStack {
		int arr[]; // Array of size n to store actual content to be stored in stacks
		int top[]; // Array of size k to store indexes of top elements of stacks
		int next_index_arr[]; // Array of size n to store next entry in all stacks
		// and free list
		int array_size, no_of_stacks;
		int free; // To store beginning index of free list

		// @// @formatter:off
		/**
		 * 
		 * constructor to create k stacks in an array of size n k = 3, n = 10 After this
		 * constructor execution
		 * 
		 * free=0
		 * next[]= [1, 2, 3, 4, 5, 6, 7, 8, 9, -1]
		 * top[] = [-1,-1,-1]
		 * arr[] = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
		 */
		 
		// @formatter:on

		KStack(int no_of_stacks, int array_size) {
			// Initialize n and k, and allocate memory for all arrays
			this.no_of_stacks = no_of_stacks;
			this.array_size = array_size;

			// initialize with all zeros
			arr = new int[array_size];// size =10
			top = new int[no_of_stacks]; // size =3
			next_index_arr = new int[array_size]; // size =10

			// Initialize all stacks as empty [-1,-1,-1]
			Arrays.fill(top, -1);

			// Initialize all spaces as free
			free = 0;

			// next[]= [1, 2, 3, 4, 5, 6, 7, 8, 9, -1]
			for (int i = 0; i < array_size - 1; i++)
				next_index_arr[i] = i + 1;

			next_index_arr[array_size - 1] = -1; // -1 is used to indicate end of free list/ next list
			printValues("INIIALIZE ", -1, -1);
		}

		// To push an item in stack number 'stack_number' where stack_number is from 0
		// to k-1
		// 15, 2
		void push(int item, int stack_number) {
			// Overflow check
			if (isFull()) {
				System.out.println("Stack Overflow");
				return;
			}
			// 0
			int index_of_free_slot = free; // Store index of first free slot

			// Update index of free slot to index of next slot in free list or free++;
			free = next_index_arr[free];

			// Update next of top and then top for stack number 'stack_number'
			next_index_arr[index_of_free_slot] = top[stack_number];
			top[stack_number] = index_of_free_slot;

			// Put the item in array
			arr[index_of_free_slot] = item;
			printValues("PUSH ", item, stack_number);

		}

		private void printValues(String operationType, int item, int stack_number) {
			Common.println("-----------------------------"+operationType+"-------------------------------------");
			Common.println(operationType + " For Input item => " + item + " stack number => " + stack_number);
			Common.println("free => " + free);
			Common.print( "top array  => ");
			Common.printArray(top);
			Common.print( "next array => ");
			Common.printArray(next_index_arr);
			Common.print( "arr array  => ");
			Common.printArray(arr);
		}

		// To pop an from stack number 'stack_number' where stack_number is from 0 to
		// k-1
		int pop(int stack_number) {
			// Underflow check
			if (isEmpty(stack_number)) {
				System.out.println("Stack Underflow");
				return Integer.MAX_VALUE;
			}

			// Find index of top item in stack number 'stack_number'
			int index_of_top_item = top[stack_number];

			top[stack_number] = next_index_arr[index_of_top_item]; // Change top to store next of previous top

			// Attach the previous top to the beginning of free list
			next_index_arr[index_of_top_item] = free;
			free = index_of_top_item;

			// Return the previous top item
			int popped_Value = arr[index_of_top_item];
			printValues("POP :", popped_Value, stack_number);
			return popped_Value;
		}

		// To check whether stack number 'stack_number' is empty or not
		boolean isEmpty(int stack_number) {
			return (top[stack_number] == -1);
		}

		// A utility function to check if there is space available
		boolean isFull() {
			return (free == -1);
		}

	}

	// Driver program
	public static void main(String[] args) {
		// Let us create 3 stacks in an array of size 10
		int no_of_stacks = 3, total_size_of_array = 10;

		KStack kstack = new KStack(no_of_stacks, total_size_of_array);

		kstack.push(15, 2);
		kstack.push(45, 2);
		// Let us put some items in stack number 1
		kstack.push(17, 1);
		kstack.push(49, 1);
		//System.out.println("Popped element from stack 2 is " + kstack.pop(2));
		kstack.push(39, 1);
		//System.out.println("Popped element from stack 1 is " + kstack.pop(1));

		// Let us put some items in stack number 0
		kstack.push(11, 0);
		kstack.push(9, 0);
		kstack.push(7, 0);
		kstack.pop(1);
		kstack.pop(1);
		kstack.pop(2);
		kstack.pop(2);
		kstack.pop(1);
		kstack.pop(0);
		kstack.push(21, 0);
		kstack.push(27, 1);
		
		
		//System.out.println("Popped element from stack 0 is " + kstack.pop(0));
	}
}
