package queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 프린터 {

  public static void main(String[] args) {
    int[] priorities1 = {2, 1, 3, 2};
    int location1 = 2;

    int[] priorities2 = {1, 1, 9, 1, 1, 1};
    int location2 = 0;

    solution(priorities1, location1);
  }

  public static int solution(int[] priorities, int location) {
    Queue<Task> queue = new LinkedList<>();

    for (int i = 0; i < priorities.length; i++) {
      queue.add(Task.of(i, priorities[i]));
    }

    int order = 0; // location 에 해당하는 문서가 인쇄 되는 순서

    System.out.println("queue: " + queue);
    System.out.println("priority:" + Arrays.asList(2, 1, 3, 2));

    while (!queue.isEmpty()) {
      Task headTask = queue.poll();
      boolean isFound = false;

      System.out.println("headTask: " + headTask + ", isFound: " + isFound);

      for (Task task : queue) {
        System.out.println("=> headTaskPriority: " + headTask.getPriority() + ", taskPriority: " + task.getPriority());

       if (headTask.getPriority() < task.getPriority()) {
        queue.add(headTask);
        isFound = true;  //
        break;
       }
      }

      if (!isFound) {
        order ++;

        System.out.println("order: " + order );
        if (headTask.getLocation() == location) {
          return order;
        }
      }
    }

    return order;
  }

  public static class Task {
    private final int location;
    private final int priority;

    private Task(int location, int priority) {
      this.location = location;
      this.priority = priority;
    }

    public static Task of(int index, int priority) {
      return new Task(index, priority);
    }

    public int getLocation() {
      return location;
    }

    public int getPriority() {
      return priority;
    }

    @Override
    public String toString() {
      return "Task{" +
          "location=" + location +
          ", priority=" + priority +
          '}';
    }
  }

}
