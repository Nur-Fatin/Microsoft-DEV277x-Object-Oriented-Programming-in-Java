abstract class TechnicalEmployee extends Employee {
    public int checkIns;

    public TechnicalEmployee(String name) {
        super(name, 75000);
    }

    public String employeeStatus() {
       return "ID: " + getEmployeeID() + " Name: " + getName() + " has " + checkIns + " successful check ins.";
    }
}