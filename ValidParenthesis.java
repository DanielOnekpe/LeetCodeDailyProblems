import java.util.*;
class Solution {
    public boolean isValid(String s) {
        // Use a stack as the best data structure to hold this values
        Stack<Character> brackets = new Stack<>(); 
        
        /*
            We loop acroos the string 
            If the current character we are at is an opening character we just add it to the stack
            If the current character is a closing character we then check if its opening character is at the top of the stack cause then it is valid. If not we return false
            When the loop is done we check if there any character in the stack that have not been closed yet if so the string is not valid so we return false else we return true if the stack is empty
        */
        
        for(int i = 0; i < s.length(); i++)
        {
            char current = s.charAt(i);
            if(current == '(' || current == '{' || current == '[')
            {
                brackets.push(current);
            }
            
            else
            {
                if(brackets.isEmpty())
                {
                    return false;
                }
                
                char top = brackets.peek();
                if((top == '(' && current == ')') || (top == '{' && current == '}') || (top == '[' && current == ']'))
                {
                    brackets.pop();
                }
                
                else
                {
                    return false;
                }
            }
        }
        
        return brackets.isEmpty();
    }
}