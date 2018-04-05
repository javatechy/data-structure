package general;

/**
Leaders in an array
Write a program to print all the LEADERS in the array. An element is leader if it is greater than all the elements to its right side. And the rightmost element is always a leader. For example int the array {16, 17, 4, 3, 5, 2}, leaders are 17, 5 and 2.

Let the input array be arr[] and size of the array be size.

*/
class LeadersInAnArray {

    public static void main(String[] argv) throws Exception {
        int[] arr = new int[] { 16, 17, 4, 3, 5, 2 };
        int length = arr.length;
        int leader = arr[length - 1];
        print("Leader " + leader);
        int max = leader;
        for (int i = length - 1; i >= 0; i--) {
            // print("arr[i]" + arr[i]+ " max "+max);
            if (arr[i] > max) {
                print("Leader " + arr[i]);
            }
            if (arr[i] > max)
                max = arr[i];
        }
        System.out.println();
    }

    public static void print(Object o) {
        System.out.println(o);
    }
}