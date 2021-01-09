package queue;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/*
* 문제
* 기능 개발, level 2
* url = https://programmers.co.kr/learn/courses/30/lessons/42586
*
* 제한 사항
* 작업의 개수(progresses, speeds배열의 길이)는 100개 이하입니다.
* 작업 진도는 100 미만의 자연수입니다.
* 작업 속도는 100 이하의 자연수입니다.
* 배포는 하루에 한 번만 할 수 있으며, 하루의 끝에 이루어진다고 가정합니다. 예를 들어 진도율이 95%인 작업의 개발 속도가 하루에 4%라면 배포는 2일 뒤에 이루어집니다.
*/
public class 기능개발 {
    public static void main(String[] args) {
        assertThat(solution(new int[] {93, 30, 55},  new int[] {1, 30, 5})).isEqualTo(new int[] {2, 1});
        assertThat(solution(new int[] {95, 90, 99, 99, 80, 99},  new int[] {1, 1, 1, 1, 1, 1})).isEqualTo(new int[] {1, 3, 2});
    }

    /*
    * 접근법
    * 큐에 객체를 넣은 후, 가장 앞에 있는 것 부터 차례대로 계산
    *
    * 시간 복잡도: O(n)
    * 공간 복잡도: O(n)
    */
    public static int[] solution(int[] progresses, int[] speeds) {
        int length = progresses.length;
        List<Integer> result = new LinkedList<>();
        Queue<Project> projects = new LinkedList<>();

        createProject(progresses, speeds, length, projects);
        divideSameReleaseDate(result, projects);

        return result.stream().mapToInt(integer -> integer).toArray();
    }

    private static void divideSameReleaseDate(List<Integer> result, Queue<Project> projects) {
        int index = 0;

        while (!projects.isEmpty()) {
            Project project = projects.peek();
            projects.remove(project);

            int count = 1;

            /* 현재 프로젝트 release date 보다 작거나 같은 프로젝트 개수 만큼 카운트 */
            while (true) {
                if (projects.isEmpty()) {
                    result.add(index,count);
                    break;
                }
                Project nextProject = projects.peek();

                if (project.releaseDate < nextProject.releaseDate) {
                    result.add(index,count);
                    index += 1;
                    break;
                }
                projects.remove(nextProject);
                count += 1;
            }
        }
    }

    private static void createProject(int[] progresses, int[] speeds, int length, Queue<Project> projects) {
        for (int currentIndex = 0; currentIndex < length; currentIndex++) {
            int jobProcess = progresses[currentIndex];
            int speed = speeds[currentIndex];
            int countDate = 0;

            /* release date 계산 */
            while(jobProcess <= 100) {
                jobProcess += speed;
                countDate += 1;
                if(jobProcess >= 100) { break; }
            }
            projects.offer(new Project(currentIndex, countDate));
        }
    }

    /* index, 작업이 끝나는 날짜 정보를 가지고 있는 객체 */
    static class Project {
        int index;
        int releaseDate;

        public Project(int index, int releaseDate) {
            this.index = index;
            this.releaseDate = releaseDate;
        }
    }
}

