package ilya;

import java.util.Stack;

public class BracketTask {

    public static void main(String[] args) {
//        Stack<String> brackets = new Stack<>();
//        //(){}[]
//        brackets.push("(");
//        brackets.push(")");
//        brackets.push("{");
//        brackets.push("}");
//        brackets.push("[");
//        brackets.push("]");
//        System.out.println(checkBrackets(brackets));

//        Stack<String> brackets2 = new Stack<>();
//        //({[]})
//        brackets2.push("(");
//        brackets2.push("{");
//        brackets2.push("[");
//        brackets2.push("]");
//        brackets2.push("}");
//        brackets2.push(")");
//        System.out.println(checkBrackets(brackets2));
//
        Stack<String> brackets3 = new Stack<>();
        //(){[])}
        brackets3.push("[");
        brackets3.push("(");
        brackets3.push(")");
        brackets3.push("[");
        brackets3.push("]");
        brackets3.push("(");
        brackets3.push(")");
        brackets3.push("{");
        brackets3.push("}");
        brackets3.push("]");
        System.out.println(checkBrackets(brackets3));
    }

    public static boolean checkBrackets(Stack<String> brackets) {
        Stack<String> clonedStack = (Stack<String>) brackets.clone();
        int i = 0;
        for (String line : clonedStack) {
            if (!(clonedStack.search(revertBracket(clonedStack.peek())) % 2 == 0)
                    && clonedStack.search(revertBracket(clonedStack.peek())) != clonedStack.size()) {
                return false;
            }
            brackets.pop();
        }
        return true;
    }

    public static String revertBracket(String bracket) {
        String errorMessage = "";
        switch (bracket) {
            case "(":
                return ")";
            case ")":
                return "(";
            case "{":
                return "}";
            case "}":
                return "{";
            case "[":
                return "]";
            case "]":
                return "[";
            default:
                errorMessage = "Введён не допустимый символ " + bracket;
                System.out.println(errorMessage);
                return errorMessage;
        }
    }
}
