class Employee {
    private String fullName;
    private float salary;
    
    public Employee() {
        
    }
    public Employee(String fullName, float salary) {
        this.fullName = fullName;
        this.salary = salary;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public void setSalary(float salary) {
        this.salary = salary;
    }
    public String getFullName() {
        return fullName;
    }
    public float getSalary() {
        return salary;
    }
    
}
