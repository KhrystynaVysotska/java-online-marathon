/*REVERSE INTEGER
Given a 32-bit signed integer, reverse digits of an integer.
Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. 
For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.*/

class Solution {
    public int reverse(int x) {
        int reversed = 0;
        while(x != 0) {
            reversed = reversed*10 + x%10;
            x/=10;
        }
        if((reversed <= Integer.MIN_VALUE)||(reversed >=Integer.MAX_VALUE)){
            return 0;
        }
        return reversed;
    }
}
