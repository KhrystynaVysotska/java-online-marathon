public class MyUtils {
    public String intToRoman(int number) {
        if((number > 0) && (number <= 3999)) {
            String roman_number = "";
            int countThousands = number/1000;
            int countHundreds = number/100 - 10*countThousands;
            int countDecades = number/10 -(countThousands * 100 + 10*countHundreds);
            int countUnits = number - (countThousands*1000 + countHundreds*100 + countDecades*10);
            if(countThousands != 0) {
                for(int i = 0; i < countThousands; i++) {
                    roman_number +="M";
                }
            }
            if(countHundreds != 0) {
                if(countHundreds == 9) {
                    roman_number += "CM";
                } else if((countHundreds >= 5) && (countHundreds < 9)) {
                   roman_number += "D";
                   for(int i = 0; i < countHundreds - 5; i++) {
                       roman_number += "C";
                   }
                } else {
                    if(countHundreds == 4) {
                        roman_number += "CD";
                    } else {
                        for(int i = 0; i < countHundreds; i++) {
                            roman_number += "C";
                        }
                    }
                }
            } 
            if(countDecades != 0) {
                if(countDecades == 5) {
                    roman_number += "L";
                } else if (countDecades < 5) {
                    if(countDecades == 4) {
                        roman_number += "XL";
                    } else {
                        for(int i=0; i<countDecades; i++) {
                            roman_number += "X";
                        }
                    }
                } else if(countDecades > 5) {
                    if(countDecades == 9) {
                        roman_number += "XC";
                    } else {
                        roman_number += "L";
                        for(int i = 0; i < countDecades-5; i++) {
                            roman_number += "X";
                        }
                    }
                }
            }
            if(countUnits != 0) {
                if(countUnits <= 3) {
                    roman_number += "I";
                } else if (countUnits == 4) {
                    roman_number += "IV";
                } else if ((countUnits >= 5) && (countUnits < 9)) {
                    roman_number += "V";
                    for(int i = 0; i < countUnits - 5; i++) {
                        roman_number += "I";
                    }
                } else if(countUnits == 9) {
                    roman_number += "IX";
                }
            }
            return roman_number;
        } else {
            throw new IllegalArgumentException();
        }
    }
}

