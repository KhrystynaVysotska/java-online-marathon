public static boolean isLeapYear(int year) {
        LocalDate localDate = LocalDate.of(year, 1, 1);
        return localDate.isLeapYear();
    }
