package test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class NFSecond {
    public static void main(String[] args) {
        assertThat(solution(new int[] {1,2,5,9,9}, 5)).isEqualTo(2);
    }

    public static int solution(int[] A, int X) {
        int N = A.length;
        if (N == 0) {
            return -1;
        }
        int l = 0;
        int r = N - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (A[m] > X) {
                r = m - 1;
            } else {
                l = m;
            }
            /* modified logic, change location */
            if (A[l] == X) {
                return l;
            }
        }

        /* origin logic */
//        if (A[l] == X) {
//            return l;

        return -1;
    }
}
