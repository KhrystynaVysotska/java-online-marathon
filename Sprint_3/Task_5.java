import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Objects;
public class MyUtils {
    public static class Student {
        private int id;
        private String name;
        
        public Student(int id, String name) {
            super();
            this.id = id;
            this.name = name;
        }
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
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
            result = prime * result + id;
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
            Student other = (Student) obj;
            if (id != other.id)
                return false;
            if (name == null) {
                if (other.name != null)
                    return false;
            } else if (!name.equals(other.name))
                return false;
            return true;
        }
    }
    public Set<Student> commonStudents(List<Student> list1, List<Student> list2){
        Set<Student> identicalStudents = new HashSet<>();
        for(Student student : list1) {
            for(Student anotherStudent : list2) {
                if(Objects.equals(student, anotherStudent)) {
                   identicalStudents.add(student); 
                }
            }
        }
        return identicalStudents;
    }
}
