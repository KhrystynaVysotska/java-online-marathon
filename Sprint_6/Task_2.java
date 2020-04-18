import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.math.BigDecimal;

class Employee {
    private String name;
    private int experience;
    private BigDecimal basePayment;

    public Employee(String name, int experience, BigDecimal payment) {
        super();
        this.name = name;
        this.experience = experience;
        this.basePayment = payment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public BigDecimal getPayment() {
        return basePayment;
    }

    public void setPayment(BigDecimal basePayment) {
        this.basePayment = basePayment;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((basePayment == null) ? 0 : basePayment.hashCode());
        result = prime * result + experience;
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
        Employee other = (Employee) obj;
        if (basePayment == null) {
            if (other.basePayment != null)
                return false;
        } else if (!basePayment.equals(other.basePayment))
            return false;
        if (experience != other.experience)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Employee [name=" + name + ", experience=" + experience + ", basePayment=" + basePayment + "]";
    }
    
}

class Manager extends Employee {
    private double coefficient;

    public Manager(String name, int experience, BigDecimal Payment, double coefficient) {
        super(name, experience, Payment);
        this.coefficient = coefficient;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }
    
    @Override
    public BigDecimal getPayment() {
        return super.getPayment().multiply(new BigDecimal(coefficient));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(coefficient);
        result = prime * result + (int) (temp ^ (temp >>> 32));
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
        Manager other = (Manager) obj;
        if (Double.doubleToLongBits(coefficient) != Double.doubleToLongBits(other.coefficient))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Manager [coefficient=" + coefficient + "]";
    }    
}

public class MyUtils {
    public List<Employee> largestEmployees(List<Employee> employees) {
        Set<Employee> largest = new LinkedHashSet<>();
        if (employees.size() > 1) {
            
            Employee highPaidEmployee = Collections.max(employees,
                    Comparator.comparing(employee -> employee.getPayment()));
            Employee experiencedEmployee = Collections.max(employees,
                    Comparator.comparing(employee -> employee.getExperience()));
            for (Employee employee : employees) {
                if (employee.getExperience() == experiencedEmployee.getExperience()) {
                    largest.add(employee);
                } else if ((employee.getPayment().compareTo(highPaidEmployee.getPayment())) == 0) {
                    largest.add(employee);
                } else if ((employee.getExperience() == experiencedEmployee.getExperience())) {
                    largest.add(employee);
                } else if ((employee.getPayment().compareTo(highPaidEmployee.getPayment()) == 0)) {
                    largest.add(employee);
                }
            }

        } else if (employees.size() == 1) {
            largest.add(employees.get(0));
        }
        return new ArrayList<>(largest);
    }
}

