package hackerrank.ictCodingTest;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Ex5 {

    static void superStack(String[] operations) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Integer> stack = new Stack<>();
        for(String operation : operations) {
            String[] split = operation.split(" ");
            if(split[0].equals("push")) {
                stack.push(Integer.parseInt(split[1]));
                bw.write(stack.peek() + "\n");
            }
            else if(split[0].equals("inc")) {
                for(int i=0; i<Integer.parseInt(split[1]); i++) {
                    stack.set(i, stack.get(i) + Integer.parseInt(split[2]));
                }
                bw.write(stack.peek() + "\n");
            }
            else {
                stack.pop();
                if(stack.size() == 0) {
                    bw.write("EMPTY\n");
                }
                else bw.write(stack.peek() + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
