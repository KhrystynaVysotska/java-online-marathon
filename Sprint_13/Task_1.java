public static Calendar convertDateToCalendar(Date date) {
     Calendar calendar = new GregorianCalendar();
     calendar.setTime(date);
     return calendar;
}
