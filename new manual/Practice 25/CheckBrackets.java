import java.util.*;

public class CheckBrackets {

    private static boolean isValidBrackets(String input) {
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put(')', '(');
        brackets.put('}', '{');
        brackets.put(']', '[');
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) {
            if (brackets.containsValue(c))
                stack.push(c);
            else if (brackets.containsKey(c))
                if (stack.isEmpty() || stack.pop() != brackets.get(c))
                    return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValidBrackets("(abc*-ab)")); // 2 - true
        System.out.println(isValidBrackets("(({}[()]))")); // 3 - true
        System.out.println(isValidBrackets("(()")); // 4 - false
        System.out.println(isValidBrackets("((]")); // 5 - false
    }
}
