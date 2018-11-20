package dp;

import java.util.Arrays;

import utils.Common;

class Box {
	public int wid;
	public int ht;
	public int len;

	Box(int l, int w, int h) {
		this.wid = w;
		this.len = l;
		this.ht = h;
	}

	@Override
	public String toString() {
		return "Box [l=" + len + ", w=" + wid + ", h=" + ht + "]" + " Area ( " + (len * wid) + ")";
	}
}

public class BoxStackingProblem {

	public static void main(String args[]) {
		Box[] boxes = new Box[2];

		boxes[0] = new Box(1, 2, 4);
		boxes[1] = new Box(3, 2, 5);

		Box[] sortedBoxes = maxStackHeight(boxes);
		Arrays.sort(sortedBoxes, (b1, b2) -> (b2.len * b2.wid - b1.len * b1.wid));
		for (Box nbox : sortedBoxes) {
			Common.println(nbox);
		}

		int maxHeight = applyLISAndGetHeight(sortedBoxes);
	}

	/**
	 * Space : 3n =n 
	 * 
	 * Time : n2
	 * 
	 * @param sortedBoxes
	 * @return
	 */
	private static int applyLISAndGetHeight(Box[] sortedBoxes) {
		int max[] = new int[sortedBoxes.length];
		int result[] = new int[sortedBoxes.length];

		int k = 0;
		for (Box box : sortedBoxes) {
			max[k] = box.ht;
			result[k] = k;
			k++;
		}

		// Common.printArray(max);
		// Common.printArray(result);

		for (int i = 1; i < max.length; i++) {
			for (int j = 0; j < i; j++) {
				if (sortedBoxes[i].len < sortedBoxes[j].len && sortedBoxes[i].wid < sortedBoxes[j].wid) {
					if (max[j] + sortedBoxes[i].ht > max[i]) {
						max[i] = max[j] + sortedBoxes[i].ht;
						result[i] = j;
					}
				}
			}
		}
		Common.printArray(max);
		Common.printArray(result);

		int index = result[result.length - 1];
		while (index >= 0) {
			Common.println(sortedBoxes[index]);
			index = result[index];
		}
		return 0;
	}

	private static Box[] maxStackHeight(Box[] boxes) {
		int n = boxes.length;
		Box[] rot = new Box[n * 3];
		for (int i = 0; i < n; i++) {
			Box box = boxes[i];
			rot[3 * i] = new Box(Math.max(box.ht, box.wid), Math.min(box.ht, box.wid), box.len);
			rot[3 * i + 1] = new Box(Math.max(box.ht, box.len), Math.min(box.ht, box.len), box.wid);
			rot[3 * i + 2] = new Box(Math.max(box.wid, box.len), Math.min(box.wid, box.len), box.ht);
		}

		return rot;

	}

}