package March_2021;

public class inttoRoman {
    public String intToRoman(int num) {
        int [] integers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String [] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX"
            , "V", "IV", "I" };
        String retVal = "";
        for (int i = 0; i < integers.length; i++){
            while (num >= integers[i] && num > 0){
                retVal += symbols[i];
                num -= integers[i];
            }
        }
            return retVal;
    }
}
