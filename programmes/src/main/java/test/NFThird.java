package test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class NFThird {

    public static void main(String[] args) {
        assertThat(solution(1,3 , new int[] {0,1,2,-2,3}, new int[] {0,1,4,1,0})).isEqualTo(2);
        assertThat(solution(2,4 , new int[] {4,0,1,-2}, new int[] {-4,4,3,0})).isEqualTo(1);
    }

    public static int solution(int inner, int outer, int[] points_x, int[] points_y) {
        // write your code in Java SE 8

        if (points_x.length != points_y.length) {
            throw new IllegalArgumentException();
        }

        int size = points_x.length;
        int outsideCount = 0;

        for (int i = 0; i < points_x.length; i++) {
            int x = points_x[i];
            int y = points_y[i];

            if (Math.abs(x) < inner && Math.abs(y) < inner) {
                outsideCount += 1;
                continue;
            }

            if (Math.abs(x) < inner && Math.abs(y) >= outer) {
                outsideCount += 1;
                continue;
            }

            if (Math.abs(x) > inner && Math.abs(y) < inner) {
                outsideCount += 1;
                continue;
            }

            if (Math.abs(x) > inner && Math.abs(y) >= outer) {
                outsideCount += 1;
                continue;
            }

            if (Math.abs(x) > outer && Math.abs(y) < inner) {
                outsideCount += 1;
                continue;
            }

            if (Math.abs(x) > outer && Math.abs(y) >= outer) {
                outsideCount += 1;
                continue;
            }

            if (Math.abs(x) < outer && Math.abs(y) < inner) {
                outsideCount += 1;
                continue;
            }

            if (Math.abs(x) < outer && Math.abs(y) >= outer) {
                outsideCount += 1;
            }
        }

        return size - outsideCount;
    }
}
