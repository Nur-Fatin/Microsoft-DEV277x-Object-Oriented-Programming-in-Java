import java.util.ArrayList;

public class TechnicalLead extends TechnicalEmployee{
    private int headCount;
    public ArrayList<SoftwareEngineer> directReports = new ArrayList<SoftwareEngineer>();

    public TechnicalLead(String name) {
        super(name);
        headCount = 4;
        setBaseSalary(getBaseSalary() * 1.3);
    }

    public boolean hasHeadCount() {
        return directReports.size() < headCount;
    }

    public boolean addReport(SoftwareEngineer e) {
        if (hasHeadCount()) {
            directReports.add(e);
            return true;
        } else {
            return false;
        }
    }

    public boolean approveCheckIn(SoftwareEngineer e) {
        return directReports.contains(e) && e.getCodeAccess();
    }

    public boolean requestBonus(Employee e, double bonus) {
        BusinessLead businessLead = new BusinessLead(e.getName());
        if (businessLead.approveBonus(e, bonus)) {
            return true;
        } else {
            return false;
        }
    }

    public String getTeamStatus() {
        if (directReports.size() == 0) {
            return employeeStatus() + " and no direct reports yet";

        } else {
            String teamStatus = employeeStatus() + " and is managing: \n";
            for (int i = 0; i < directReports.size(); i++) {
                teamStatus += directReports.get(i).employeeStatus() + "\n";
            }
            return teamStatus;
        }
    }
}
