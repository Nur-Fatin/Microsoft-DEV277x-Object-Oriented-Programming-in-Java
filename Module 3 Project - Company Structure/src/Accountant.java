public class Accountant extends BusinessEmployee {
    private TechnicalLead teamSupported;

    public Accountant(String name) {
        super(name);
        bonusBudget = 0;
    }

    public TechnicalLead getTeamSupported() {
        return teamSupported;
    }

    public void supportTeam(TechnicalLead lead) {
        teamSupported = lead;
        double total = 0;
        for (int i = 0; i < teamSupported.directReports.size(); i++) {
            total += teamSupported.directReports.get(i).getBaseSalary();
        }
        bonusBudget = total * 1.1;
    }

    public boolean approveBonus(double bonus) {
        return teamSupported != null && bonus < bonusBudget;
    }

    public String employeeStatus() {
        return super.employeeStatus() + " is supporting "  + teamSupported;
    }
}
