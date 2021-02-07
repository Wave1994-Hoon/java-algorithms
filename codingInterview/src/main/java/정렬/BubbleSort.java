package 정렬;

/* 선택된 인덱스와 그 앞 인덱스의 크기를 서로 비교 -> 계속 반복 */
public class BubbleSort {
    private static void doBubbleSort(int[] array) {
        doBubbleSort(array, array.length -1);
    }

    private static void doBubbleSort(int[] array, int lastIndex) {
        if (lastIndex == 0) {
            return;
        }
        for (int i = 1; i <= lastIndex; i++) {
            if (array[i - 1] > array[i]) {
                swap(array, i - 1, i);
            }
        }
        doBubbleSort(array, lastIndex - 1);
    }

    private static void swap(int[] array, int soruce, int target) {
        int tmp = array[soruce];
        array[soruce] = array[target];
        array[target] = tmp;
    }

    private static void printArray(int[] array) {
        for (int data : array) {
            System.out.print(data + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {3,0,2,1};
        printArray(arr);
        doBubbleSort(arr);
        printArray(arr);
    }
}
