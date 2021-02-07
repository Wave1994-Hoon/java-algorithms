package 정렬;

public class MergeSort {
    private static void doMergeSort(int[] array) {
        int[] tmpArray = new int[array.length];
        doMergeSort(array, tmpArray, 0, array.length - 1);
    }

    private static void doMergeSort(int[] array, int[] tmpArray, int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;
            /* middle 값 기준으로 좌/우 나눠서 mergeSort 진행 */
            doMergeSort(array, tmpArray, start, middle);
            doMergeSort(array, tmpArray, middle + 1, end);
            /* 나누어진 배열을 병합 */
            merge(array, tmpArray, start, middle, end);
        }
    }

    private static void merge(int[] array, int[] tmpArray, int start ,int middle, int end) {
        /* 임시 저장소에 정렬된 배열을 필요한 만큼 복사 */
        for (int i = start; i <= end; i ++) {
            tmpArray[i] = array[i];
            System.out.print(tmpArray[i] + ", ");
        }
        int part1 = start; // 첫 번째 배열의 첫 번째 index
        int part2 = middle + 1; // 두 번째 배열의 첫 번째 index
        int index = start; // 저장할 인덱스, 앞에서 부터 뒤로 감

        while (part1 <= middle && part2 <= end) {
            /* 앞에 포인터가 작거나 같은 경우 */
            if (tmpArray[part1] <= tmpArray[part2]) {
                array[index] = tmpArray[part1];
                part1 ++; index ++;
                continue;
            }
            /* 뒤에 포인터가 작은 경우 */
            if (tmpArray[part1] > tmpArray[part2]) {
                array[index] = tmpArray[part2];
                part2 ++; index ++;
            }
        }

        /* 앞쪽 배열(part1)에 데이터가 남은 경우(middle까지 못간 경우), 남은 데이터를 저장
        *
        * ex) 앞쪽 배열이 남은 경우
        * 0 5 / 2 3
        * 0 -> 0 2 -> 0 2 3 -> 앞쪽 배열에 5 남음 -> 0 2 3 5
        *
        * ex) 뒤쪽 배열이 남은 경우
        * 0 3 / 2 5
        * 0 -> 0 2 -> 0 2 3 -> 앞쪽 배열 끝, 이미 기존 배열에 5 가 있기 때문에 -> 0 2 3 5
        * */
        for (int i = 0; i <= middle - part1; i++) {
            array[index + i] = tmpArray[part1 + i];
            System.out.println("here");
        }
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
        doMergeSort(arr);
        printArray(arr);
    }
}
