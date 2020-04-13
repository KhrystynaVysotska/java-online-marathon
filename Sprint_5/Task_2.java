import java.util.Calendar;
class User {
    protected String name;
    protected String surname;

    public String getFullName() {
        return name + " " + surname;
    }

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}

class Student extends User {
    protected int year;

    public Student(int year, String name, String surname) {
        super(name, surname);
        this.year = year;
    }

    public int getCourseNumber() {
        int thisYear = Calendar.getInstance().get(Calendar.YEAR);
        int courseNumber = (thisYear - this.year) + 1;
        if (courseNumber > 6 || courseNumber < 1) {
            return -1;
        } else {
            return courseNumber;
        }
    }
}
