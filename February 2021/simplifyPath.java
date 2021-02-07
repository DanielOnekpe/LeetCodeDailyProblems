/**if we have a string 
we get the first slash 
then using indexof find the next slash
then we extract the char between the two slash
if its empty we continue
if its .. we pop from the string stack
else we push into the stack

https://www.geeksforgeeks.org/simplify-directory-path-unix-like/
Couldnt implement my idea so copied this cause they implemented the same thing
**/

class Solution {
    public String simplifyPath(String path) {
        Stack<String> folder = new Stack<>();
        for(int i = 0; i < path.length(); i++)
        {
            String dir = "";
            // skip all multiple / 
            while(i < path.length() && path.charAt(i) == '/')
            {
                i++;
            }
            // hold characters between the slashes
            while(i < path.length() && path.charAt(i) != '/')
            {
                dir += path.charAt(i);
                i++;
            }
            
            if(dir.length() > 0)
            {
                            // check if you need to pop
            if(dir.equals(".."))
            {
                if(!folder.isEmpty())
                {
                    folder.pop();
                }
            }
            // check if you dont need to make any changes
            else if(dir.equals("."))
            {
                continue;
            }
            // now push whatever string that has been found
            else
            {
                folder.push(dir);
            }
            }

        }
        
        if(folder.isEmpty())
        {
            return "/";
        }
        String res = "";
        while(!folder.isEmpty())
        {
            String curr = folder.pop();
            res = '/' + curr + res;
        }
        
        return res;
    }
}