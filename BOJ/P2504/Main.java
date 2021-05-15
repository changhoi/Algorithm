package DAY03.P2504;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);

        String input = sc.next();
        Stack<Element> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char command = input.charAt(i);
            if(command == '(' || command == '[') {
                stack.add(new Element(input.charAt(i)));
            }else if(command == ')') {
                int sum = 0;
                boolean isInvalid = true;
                while(stack.size() > 0) {
                    Element element = stack.pop();
                    if(element.isValue) {
                        sum += element.value;
                    }else if(element.command == '('){
                        if(sum == 0) {
                            stack.push(new Element(2));
                        }else {
                            stack.push(new Element(sum * 2));
                        }
                        isInvalid = false;
                        break;
                    }else {
                        isInvalid = true;
                        break;
                    }
                }
                if(isInvalid){
                    System.out.println(0);
                    return;
                }

            }else if(command == ']') {
                int sum = 0;
                boolean isInvalid = true;
                while(stack.size() > 0) {
                    Element element = stack.pop();
                    if(element.isValue) {
                        sum += element.value;
                    }else if(element.command == '['){
                        if(sum == 0) {
                            stack.push(new Element(3));
                        }else {
                            stack.push(new Element(sum * 3));
                        }
                        isInvalid = false;
                        break;
                    }else {
                        isInvalid = true;
                        break;
                    }
                }
                if(isInvalid){
                    System.out.println(0);
                    return;
                }
            }
        }
        int sum = 0;
        while(stack.size() > 0) {
            Element element = stack.pop();
            if(element.isValue) {
                sum += element.value;
            }else {
                System.out.println(0);
                return;
            }
        }
        System.out.println(sum);
    }

}

class Element{
    boolean isValue;
    int value;
    char command;
    public Element(int value) {
        this.isValue = true;
        this.value = value;
    }

    public Element(char command) {
        this.isValue = false;
        this.command = command;
    }
}
