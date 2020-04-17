import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Person {
    private String name;

    public Person(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

}

class Student extends Person {
    private String studyPlace;
    private int studyYears;

    public Student(String name, String studyPlace, int studyYears) {
        super(name);
        this.studyPlace = studyPlace;
        this.studyYears = studyYears;
    }

    public String getStudyPlace() {
        return studyPlace;
    }

    public void setStudyPlace(String studyPlace) {
        this.studyPlace = studyPlace;
    }

    public int getStudyYears() {
        return studyYears;
    }

    public void setStudyYears(int studyYears) {
        this.studyYears = studyYears;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((studyPlace == null) ? 0 : studyPlace.hashCode());
        result = prime * result + studyYears;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
        if (studyPlace == null) {
            if (other.studyPlace != null)
                return false;
        } else if (!studyPlace.equals(other.studyPlace))
            return false;
        if (studyYears != other.studyYears)
            return false;
        return true;
    }

}

class Worker extends Person {
    private String workPosition;
    private int experienceYears;

    public Worker(String name, String workPosition, int experienceYears) {
        super(name);
        this.workPosition = workPosition;
        this.experienceYears = experienceYears;
    }

    public String getWorkPosition() {
        return workPosition;
    }

    public void setWorkPosition(String workPosition) {
        this.workPosition = workPosition;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + experienceYears;
        result = prime * result + ((workPosition == null) ? 0 : workPosition.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Worker other = (Worker) obj;
        if (experienceYears != other.experienceYears)
            return false;
        if (workPosition == null) {
            if (other.workPosition != null)
                return false;
        } else if (!workPosition.equals(other.workPosition))
            return false;
        return true;
    }
}

public class MyUtils {
    public List<Person> maxDuration(List<Person> persons) {
        List<Person> experiensedPeople = new ArrayList<>();
        List<Worker> workers = new ArrayList<>();
        List<Student> students = new ArrayList<Student>();
        if(persons.size() > 1) {
            for (Person person : persons) {
                if (person instanceof Worker) {
                    if (!workers.contains(person)) {
                        workers.add((Worker) person);
                    }
                }
                if (person instanceof Student) {
                    if (!students.contains(person)) {
                        students.add((Student) person);
                    }
                }
            }
            
            Worker experiencedWorker = Collections.max(workers,Comparator.comparing(worker -> worker.getExperienceYears()));
            Student experiencedStudent = Collections.max(students, Comparator.comparing(student -> student.getStudyYears()));
            experiensedPeople.add(experiencedWorker);
            experiensedPeople.add(experiencedStudent);
            for(Worker worker:workers) {
                if(worker.getExperienceYears() == experiencedWorker.getExperienceYears()) {
                    experiensedPeople.add(worker);
                }
            }
            for(Student student:students) {
                if(student.getStudyYears() == experiencedStudent.getStudyYears()) {
                    experiensedPeople.add(student);
                }
            }
            
            return experiensedPeople;
        } else if(persons.size() == 1) {
            if(persons.get(0) instanceof Student || persons.get(0) instanceof Worker) {
                return persons;
            } else {
                return new ArrayList<>();
            }
        } else {
            return new ArrayList<>();
        }
        
    }
}
