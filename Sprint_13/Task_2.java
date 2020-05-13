public static String lastDayOfMonth(int month, int year) {
        if(month<0 || month>11) {
            return "Wrong Month";
        }
        GregorianCalendar calender = new GregorianCalendar(year, month, 1);
        int number_of_next_month = calender.get(Calendar.MONTH)+1;
        while(calender.get(Calendar.MONTH) != number_of_next_month) {
            calender.add(Calendar.DATE, 1);
            if(calender.get(Calendar.MONTH) == number_of_next_month) {
                calender.add(Calendar.DATE, -1);
                break;
            }
        }
        int max_day = calender.get(Calendar.DAY_OF_WEEK);
        switch (max_day-1) {
        case 1: {
            return "Monday";
        }
        case 2: {
            return "Tuesday";
        }
        case 3: {
            return "Wednesday";
        }
        case 4: {
            return "Thursday";
        }
        case 5: {
            return "Friday";
        }
        case 6: {
            return "Saturday";
        }
        case 7: {
            return "Sunday";
        }
        default:
            return "Sunday";   
        }
    }
