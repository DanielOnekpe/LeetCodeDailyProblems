import java.util.*;
/** 
    The problem has a start word that you change till you get a particular endword.
    How do you generate neighbours: Check letter by letter until you find word that is in the list and
    if its the end word then we return the length
    
    Algorithm:
    1. Setup a queue to hold the list of the result 
    2. Setup a set to hold the wordList so that we can have constant lookup time
    3. Remove the first word from the list and keep checking and add to queue
    4. Check the words in the queue and find all words that have a neighbour in the list
    5. The neighbour method will check through the letters of the char and comes up with a list of strings that happen by changing one letter of the string

    Time Complexity: O(M^2 * N)
    Space Complexity: O(M * N)
*/
class Solve{
    public int ladderLength(String beginWord, String endWord, List<String> wordList){
        Queue<String> queue = new LinkedList<>();
        Set<String> words = new HashSet<>(wordList);
        words.remove(beginWord);
        queue.add(beginWord);
        int level = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            level++;

            for(int i = 0; i < size; i++){
                String currentWord = queue.poll();
                if(currentWord.equals(endWord)) return level;
                List<String> neighbour = neighbours(currentWord);
                for(String neigh: neighbour){
                    if(words.contains(neigh)){
                        words.remove(neigh);
                        queue.add(neigh);
                    }
                }
            }
        }
        return 0;
    }

    public List<String> neighbours(String string){
        char[] chars = string.toCharArray();
        List<String> result = new ArrayList<>();

        for(int i= 0; i < chars.length; i++){
            char temp = chars[i]
            for(char c = 'a'; c <= 'z'; c++){
                chars[i] = c;
                String neighbour = new String(chars);
                result.add(neighbour);
            }
            chars[i] = temp;
        }
    }
}