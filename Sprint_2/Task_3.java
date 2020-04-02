/*Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
Return the quotient after dividing dividend by divisor.
The integer division should truncate toward zero, which means losing its fractional part. 
For example, truncate(8.345) = 8 and truncate(-2.7335) = -2.*/

class Solution {
    public int divide(int dividend, int divisor) {
        int quotient = 0;
        int temp = 0;
        while(temp + divisor <= dividend) {
            temp+=divisor;
            quotient+=1;
        }
        if((quotient <= Integer.MIN_VALUE)||(quotient >= Integer.MAX_VALUE)) {
            return Integer.MAX_VALUE;
        } else {
            return quotient;
        }
    }
}
