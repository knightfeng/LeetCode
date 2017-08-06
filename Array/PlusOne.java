public class Solution {
    public int[] plusOne(int[] digits) {
        
        boolean carry = true;
        
        for(int i = digits.length - 1; i >= 0; i--) {
            if(digits[i] == 9 && carry) {
                carry = true;
                digits[i] = 0;                
            } else if (carry) {
                carry = false;
                digits[i] = digits[i] + 1;                
            } else {
                 return digits;
            }
            
        }
        
       
            int[] newResult = new int[digits.length + 1];
            newResult[0] = 1;
            return newResult;
        
        
       
    }
}