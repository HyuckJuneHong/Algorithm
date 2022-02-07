package 자료구조;

import java.util.LinkedList;
import java.util.Queue;

/** Queue
 * - First In, First Out (FIFO, 선입선출)
 * - 은행 창구, 입구가 2개인 구조
 * - 큐는 인터페이스만 있고 별도의 클래스가 없다.
 *add()와 offer()의 차이
 * - add()는 큐가 가득차서 더 이상 추가할 수 없는 경우 예외를 발생시킨다.
 * - offer()는 add()와 달리 true, false만 반환한다.
 *remove()와 poll()의 차이
 * - queue가 비어 있어 삭제 실패시 예외 발생
 * - 실패 시 null을 반환한다.
 *element()와 peek()의 차이
 * - element는 실패 시 예외 발생
 * - 실패 시 null 반환
 */
public class QueueTest {

    public static void main(String[] args){

        //큐는 인터페이스만 있고 별도의 클래스가 없다.
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i<5; i++){
            queue.offer(i);
            System.out.println("peek(): "+queue.peek());
        }


        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }
}
