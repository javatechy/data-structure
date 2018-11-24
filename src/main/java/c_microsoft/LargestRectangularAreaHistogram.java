package c_microsoft;

import java.util.Stack;

import utils.Common;

/**
 * https://www.geeksforgeeks.org/largest-rectangle-under-histogram/
 *
 */
public class LargestRectangularAreaHistogram {

	public static void main(String[] args) {
		int hist[] = { 1, 2, 3, 4, 5 };// , 3, 3, 2 };
		System.out.println("Maximum area is " + getMaxArea(hist));
	}

	public static int getMaxArea(int histogram[]) {
		int n = histogram.length;
		int i = 0;
		Stack<Integer> stack = new Stack<>();

		int maxArea = 0;
		while (i < n) {
			if (stack.isEmpty() || histogram[stack.peek()] < histogram[i]) {
				stack.push(i);
				i++;
			} else {
				// histogram[i]< histogram[stack.peek()] // less than top element stop
				Common.println(i);
				int topIndexStack = stack.pop();
				int value = histogram[topIndexStack];
				int muliplicationFactor = stack.empty() ? i : i - stack.peek() - 1;
				int area = value * muliplicationFactor;
				if (area > maxArea)
					maxArea = area;
			}
		}
		Common.println(stack);

		while (!stack.isEmpty()) {
			int top = stack.pop();
			int area =0;
			// if stack is empty means everything till i has to be
			// greater or equal to input[top] so get area by
			// input[top] * i;
			if (stack.isEmpty()) {
				area = histogram[top] * i;
			}
			// if stack is not empty then everything from i-1 to input.peek() + 1
			// has to be greater or equal to input[top]
			// so area = input[top]*(i - stack.peek() - 1);
			else {
				area = histogram[top] * (i - stack.peek() - 1);
			}
			if (area > maxArea) {
				maxArea = area;
			}
		}

		return maxArea;
	}
}
