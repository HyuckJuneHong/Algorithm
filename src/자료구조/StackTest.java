package 자료구조;

import java.util.Stack;

/** Stack
 * - First In, Last Out (FILO, 선입 후출)
 * - 상하차 개념, 입구가 하나만 있는 저장소
 * - 스택을 클래스로 구현하여 제공한다.
 */
public class StackTest {

    public static void main(String[] args){

        //스택을 클래스로 구현하여 제공한다.
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<5; i++){
            stack.push(i); //삽입
            System.out.println(stack.peek());
        }

        stack.pop(); //삭제
        System.out.println("pop() 실행 후 현재 값: " + stack.peek()); //현재 값
        System.out.println("search(0): " + stack.search(0)); //파라미터 위치 (1부터 시작)
        System.out.println("empty 여부: " + stack.empty()); //비어있는지 체크

    }
}
