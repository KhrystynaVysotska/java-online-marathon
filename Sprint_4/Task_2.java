Employee emp1 = new Employee();
Employee emp2 = new Employee();
emp1.fullName = "Khrystyna";
emp1.salary = 303493.4523f;
emp2.fullName = "Max";
emp2.salary = 3034.4523f;
Employee[] employees = new Employee[2];
employees[0] = emp1;
employees[1] = emp2;
String employeesInfo = "[";
    for (int i = 0; i < employees.length; i++) {
        employeesInfo += "{fullName: \"" + employees[i].fullName + "\", salary: " + employees[i].salary + "}";
        if(i+1<employees.length) {
            employeesInfo += ", ";
        }
    }
    employeesInfo += "]";
