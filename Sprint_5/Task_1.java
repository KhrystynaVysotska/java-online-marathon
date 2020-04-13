abstract class Employee {
    protected String employeeID;

    public Employee(String employeeID) {
        this.employeeID = employeeID;
    }

    public abstract String getFullInfo();
}

class SalariedEmployee extends Employee {
    protected String socialSecurityNumber;

    public SalariedEmployee(String socialSecurityNumber, String employeeId) {
        super(employeeId);
        this.socialSecurityNumber = socialSecurityNumber;
    }

    @Override
    public String getFullInfo() {
        return employeeID + " " + socialSecurityNumber;
    }
}

class ContractEmployee extends Employee {
    protected String federalTaxIDMember;

    public ContractEmployee(String federalTaxIDMember, String employeeId) {
        super(employeeId);
        this.federalTaxIDMember = federalTaxIDMember;
    }

    @Override
    public String getFullInfo() {
        return employeeID + " " + federalTaxIDMember;
    }
}
