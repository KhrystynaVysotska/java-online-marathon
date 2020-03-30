public static boolean isLeapYear(int year) {
    if(year < 2000) {
        if((year%4 == 0) && (year%100 != 0)) {
            return true;
        } else {
            return false;
        }
    } else {
        if (year%4 == 0) {
            return true;
        } else {
            return false;
        }
    }
}
