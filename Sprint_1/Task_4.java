public static int sumOfDigits(int number) {
        int countHundreds = number/100;
        int countDecades = number/10 - 10*countHundreds;
        int countUnits = number - (countHundreds*100 + countDecades*10);
        return countHundreds + countDecades + countUnits;
}
