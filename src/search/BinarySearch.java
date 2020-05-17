package search;

public class BinarySearch {

    public static int inputData[] = {10, 12, 14, 15, 23, 33, 66, 72, 85, 96, 99};

    public static void main(String[] args) {
        System.out.println(search(inputData, 12));
    }

    public static int search(int[] data, int input) {
        return binarySearch(data, input, 0, data.length - 1);
    }

    private static int binarySearch(int[] data, int input, int start, int end) {
        while (start <= end) {
            int middleIndex = (start + end) / 2;
            if (input == data[middleIndex]) {
                return middleIndex;
            }

            if (input < data[middleIndex]) {
                return binarySearch(data, input, start, middleIndex - 1);
            } else if (input > data[middleIndex]) {
                return binarySearch(data, input, middleIndex + 1, end);
            }
        }
        return -1;
    }
}
