package medium._735_AsteroidCollision;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
//        int[] ints = {-2, -1, 1, 2};
//        int[] ints = {-2,-2,1,-2};
//        int[] ints = {10,2,-5};
        int[] ints = {8,8,-8};
        System.out.println(asteroidCollision(ints));
    }


    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        createAsteroidsAfterCollisions(asteroids, stack);

        return addAsteroidsAfterCollisionsToArray(stack);
    }

    private static void createAsteroidsAfterCollisions(int[] asteroids, Stack<Integer> stack) {
        for (int asteroid : asteroids) {
            // asteroid 가 0 보다 크면 stack 에 담는다.
            if (asteroid > 0) {
                stack.push(asteroid);
            }

            // asteroid 가 0 작으면 stack 에 있는 값과 비교를 한다.
            if (asteroid < 0) {
                // 음수 asteroid 가 stack 에 있는 값 보다 크면 stack 에서 꺼낸다.
                // 음수 asteroid 의 절대값의 크기가 더 크기 때문에 반복해서 비교한다.
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroid)) {
                    stack.pop();
                }

                if (!stack.isEmpty() && stack.peek() > 0) {
                    // 크키가 같을 때, stack 에서 꺼낸다.
                    if (stack.peek() == Math.abs(asteroid)) {
                        stack.pop();

                    }
                    continue;
                }

                // 그 외 조건(충돌에서 이긴)은, stack 에 담는다.
                stack.push(asteroid);
            }
        }
    }

    private static int[] addAsteroidsAfterCollisionsToArray(Stack<Integer> stack) {
        int[] result = new int[stack.size()];

        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}

