/* Sqrt(x)
Implement int sqrt(int x).
Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.*/

class Solution {
    public int mySqrt(int x) {
        int root = 0;
        int i = 1;
        while(x != 0) {
            x-=i;
            root+=1;
            i+=2;
        }
        return root;
    }
}
