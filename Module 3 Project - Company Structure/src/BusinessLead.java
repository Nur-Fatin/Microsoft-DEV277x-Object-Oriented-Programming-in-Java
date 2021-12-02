import java.util.ArrayList;
public class BusinessLead extends BusinessEmployee {
    private int headCount;
    private ArrayList<Accountant> directReports = new ArrayList<Accountant>();

    public BusinessLead(String name) {
        super(name);
        setBaseSalary(getBaseSalary() * 2.0);
        headCount = 10;
    }

    public boolean hasHeadCount() {
        return directReports.size() < headCount;
    }

    public boolean addReport(Accountant e, TechnicalLead supportTeam) {
        if (hasHeadCount()) {
            directReports.add(e);
            bonusBudget += e.getBaseSalary() * 1.1;
            e.supportTeam(supportTeam);
            return true;
        } else {
            return false;
        }
    }

    public boolean requestBonus(SoftwareEngineer e, double bonus) {
        if (bonus <= bonusBudget) {
            e.bonus += bonus;
            bonusBudget -= bonus;
            return true;
        } else {
            return false;
        }
    }

    public boolean approveBonus(Employee e, double bonus) {
        for (int i = 0; i < directReports.size(); i++) {
            if (directReports.get(i).getTeamSupported() == e.getManager() && directReports.get(i).approveBonus(bonus)){
                return true;
            }
        }
        return false;
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
