class Solving {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        //This was a simple question. You just have to compare if the order of the characters of the elements of the both array are the same 
        // So i simply concatenated all the elements of each array and since they both have to be in order i just have to check if the concatention are equal 
        String value1 = "";
        String value2 = "";
        for(int i = 0; i < word1.length; i++){
            value1 += word1[i];
        }
        
        for(int i = 0; i < word2.length; i++){
            value2 += word2[i];
        }

        return value1.equals(value2);
    }
}