import java.util.Arrays;
import java.util.Comparator;

class PersonComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        if (o1.name != o2.name) {
            return o1.name.compareTo(o2.name);
        } else {
            return o1.age - o2.age;
        }
    }

}

class EmployeeComparator implements Comparator<Employee> {

    PersonComparator personComparator = new PersonComparator();

    @Override
    public int compare(Employee o1, Employee o2) {
        if (personComparator.compare(o1, o2) != 0) {
            return personComparator.compare(o1, o2);
        } else {
            return Double.compare(o1.getSalary(), o2.getSalary());
        }

    }
}

class DeveloperComparator implements Comparator<Developer> {

    EmployeeComparator employeeComparator = new EmployeeComparator();

    @Override
    public int compare(Developer o1, Developer o2) {
        if (employeeComparator.compare(o1, o2) != 0) {
            return employeeComparator.compare(o1, o2);
        } else {
            return o1.getLevel().compareTo(o2.getLevel());
        }
    }
}

class Utility {
    @SuppressWarnings("unchecked")
    public static <T extends Person> void sortPeople(T[] array, Comparator comparator) {
        Arrays.sort(array, comparator);
    }
}
