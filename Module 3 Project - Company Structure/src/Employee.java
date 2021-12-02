 abstract class Employee {
    private static int numEmployees;
    private String name;
    private double baseSalary;
    private int employeeID;
    private Employee manager;

    public Employee(String name, double baseSalary) {
        numEmployees ++;
        this.name = name;
        this.baseSalary = baseSalary;
        employeeID = numEmployees;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
         this.baseSalary = baseSalary;
     }

    public String getName() {
        return name;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public Employee getManager() {
        return manager;
    }

    public boolean equals(Employee other) {
        return this.employeeID == other.employeeID;
    }

    public String toString() {
        return "ID: " + employeeID + ", Name: " + name;
    }

    abstract String employeeStatus();
}
