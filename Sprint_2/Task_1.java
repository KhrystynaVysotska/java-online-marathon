class Solution {
    public boolean isPalindrome(int x) {
        int temporaryValue = x;
        int reversedValue = 0;
        while (temporaryValue != 0) {
            reversedValue = reversedValue * 10 + temporaryValue % 10;
            temporaryValue /= 10;
        }
        return reversedValue == x;
    }
}
