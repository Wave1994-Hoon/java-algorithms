package Stack;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;


/*
* 문제
* 주식 가격, level 2
* url = https://programmers.co.kr/learn/courses/30/lessons/42584
*
* 제한사항
* prices의 각 가격은 1 이상 10,000 이하인 자연수입니다.
* prices의 길이는 2 이상 100,000 이하입니다.
*/
public class 주식가격 {
    public static void main(String[] args) {
        assertThat(solutionWithBruteForce(new int[] {1, 2, 3, 2, 3})).isEqualTo(new int[] {4, 3, 1, 1, 0});
        assertThat(solutionWithStack(new int[] {1, 2, 3, 2, 3})).isEqualTo(new int[] {4, 3, 1, 1, 0});
    }

    /*
    * 접근법
    * 완전 탐색으로 for-loop 두 번 사용
    *
    * 시간 복잡도: O(n^2)
    * 공간 복잡도: O(n)
    * */
    public static int[] solutionWithBruteForce(int[] prices) {
        int length = prices.length;
        int[] answer = new int[length];

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                answer[i]++;
                if (prices[i] > prices[j]) { break; }
            }
        }
        return answer;
    }

    /*
    * 접근법
    * 스택을 이용한 풀이, 스택에 값을 담고 그 이후이 값과 비교
    *
    * value  |  1  |  2  |  3  |  3  |  3  |
    * index  |  0  |  1  |  2  |  3  |  4  |
    * Result |  4  |  3  |  1  |  1  |  0  |
    *
    * 시간 복잡도: O(n)
    * 공간 복잡도: O(n)
    */
    public static int[] solutionWithStack(int[] prices){
        int[] answer = new int[prices.length];
        Stack<Stock> stack = new Stack<>();

        for(int currentIndex = 0; currentIndex < prices.length; currentIndex++){
            int currentPrice = prices[currentIndex];

            /* 스택이 비어있지 않으면 로직 실행 */
            while(!stack.isEmpty()){
                Stock topStockInStack = stack.peek();

                /* 현재 가격이 스택안에 있는 마지막 가격 보다 작음 */
                if(topStockInStack.price > currentPrice){
                    /* 스택안에 존재하는 마지막 stock은 그 다음 가격 보다 크기 때문에 answer에 넣음 */
                    answer[topStockInStack.index] = currentIndex - topStockInStack.index;
                    stack.pop();
                    continue;
                }
                break;
            }

            /* 스택에 현재 가격정보 push */
            stack.push(new Stock(currentIndex, currentPrice));
        }

        /* 스택이 비어 있지 않을 경우 */
        while(!stack.isEmpty()){
            /*
            * 남아 있는 값들은 떨어진 적이 없는 값들임
            * 스택에서 값을 꺼낸 후, 스택의 길이 - 자신의 인덱스 - 1
            */
            Stock topStockInStack = stack.pop();
            answer[topStockInStack.index] = prices.length - topStockInStack.index - 1;
        }
        return answer;
    }

    /* index, price 정보를 갖고 있는 객체 */
    private static class Stock {
        int index;
        int price;

        public Stock(int index, int price){
            this.index = index;
            this.price = price;
        }
    }
}
