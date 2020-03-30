public static int century(int year) {
    int checkCentury = year/100;
    if(year%100 == 0) {
        return checkCentury;
    } else {
        return checkCentury + 1;
    }   
}
