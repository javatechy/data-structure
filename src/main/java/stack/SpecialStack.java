package stack;

import utils.Common;

/**
 * A Java class to represent k stacks in a single array of size n
 * 
 * @author deepak
 */
public class SpecialStack {
	private int[] stack;
	private int[] auxyStack;

	private int size;
	private int top = -1;

	SpecialStack(int size) {
		stack = new int[size];
		auxyStack = new int[size];
		this.size = size;
	}

	boolean push(int element) {
		if (top == size) {
			return false; // stack is full;
		}
		if (top == -1) {
			top++;

			auxyStack[top] = element;
			stack[top] = element;

			return true;
		}

		int min = auxyStack[top];

		top++;
		stack[top] = element;
		if (element < min) {
			auxyStack[top] = element;
		} else {
			auxyStack[top] = min;
		}
		return false;
	}

	int pop() {
		if (top == -1) {
			return -1; // No element found
		}
		int element = stack[top];
		top--;
		return element;
	}

	int min() {
		if (top == -1)
			return -1;

		return auxyStack[top];
	}

	void printStacks() {
		Common.printArray(stack);
		Common.printArray(auxyStack);
	}

	// Driver program
	public static void main(String[] args) {
		SpecialStack s = new SpecialStack(5);

		s.push(10);
		s.push(20);
		s.push(30);
		s.push(5);
		s.push(15);
		s.printStacks();

		Common.print(s.min());
	}
}
