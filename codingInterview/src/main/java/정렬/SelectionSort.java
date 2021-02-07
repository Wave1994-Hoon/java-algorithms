package 정렬;

/* 작은 값을 앞으로 계속 옮김 */
public class SelectionSort {
    private static void doSelectionSort(int[] array) {
        doSelectionSort(array, 0);
    }

    private static void doSelectionSort(int[] array, int start) {
        if (start >= array.length - 1) {
            return;
        }
        int minIndex = start;

        for (int i = start; i < array.length; i++) {
            if (array[i] < array[minIndex]) {
                minIndex = i;
            }
        }
        swap(array, start, minIndex);
        doSelectionSort(array, start + 1);
    }

    private static void swap(int[] array, int source, int target) {
        int tmp = array[source];
        array[source] = array[target];
        array[target] = tmp;
    }

    private static void printArray(int[] array) {
        for (int data : array) {
            System.out.print(data + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {3,6,1,8,2,4};
        printArray(arr);
        doSelectionSort(arr);
        printArray(arr);
    }
}
