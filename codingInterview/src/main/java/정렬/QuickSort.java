package 정렬;

public class QuickSort {
    public static void doQuickSort(int[] arr) {
        doQuickSort(arr, 0, arr.length - 1);
    }

    private static void doQuickSort(int[] arr, int start, int end) {
        /* pivot 값을 기준으로 작은 값은 왼쪽, 큰 값은 오른쪽으로 나뉨 */
        int partition = makePartition(arr, start, end);
        /* 왼쪽 파티션이 1개 이상일 때만 재귀 호출 */
        if (start < partition - 1) {
            doQuickSort(arr, start, partition -1);
        }
        /* 오른쪽 파티션이 1개 이상일 때만 재귀 호출 */
        if (partition < end) {
            doQuickSort(arr, partition, end);
        }
    }

    private static int makePartition(int[] arr, int start, int end) {
        int pivot = arr[(start + end) / 2];

        while (start <= end) {
            /* 피벗 보다 큰 값일 때 조건 수행 */
            while (arr[start] < pivot) {
                start ++; // 뒤로
            }
            /* 피벗 보다 작은 값일 때 조건 수행 */
            while (arr[end] > pivot) {
                end --; // 앞으로
            }
            /* start와 end가 만남 */
            if (start <= end) {
                swap(arr, start, end);
                start ++;
                end --;
            }
        }
        return start;
    }

    private static void swap(int[] arr, int start, int end) {
        int tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
    }

    private static void printArray(int[] arr) {
        for (int data : arr) {
            System.out.print(data + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {3, 9, 4, 7, 5, 0, 1, 6, 8, 2};
        printArray(arr);
        doQuickSort(arr);
        printArray(arr);
    }
}
