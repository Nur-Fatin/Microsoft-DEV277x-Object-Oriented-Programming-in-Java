public class SoftwareEngineer extends TechnicalEmployee{
    private boolean codeAccess;
    public double bonus;

    public SoftwareEngineer(String name) {
        super(name);
        checkIns = 0;
    }

    public boolean getCodeAccess() {
        return codeAccess;
    }

    public void setCodeAccess(boolean access) {
        codeAccess = access;
    }

    public int getSuccessfulCheckIns() {
        return checkIns;
    }

    public boolean checkInCode() {
        TechnicalLead manager = new TechnicalLead(getName());
        if (manager.approveCheckIn(this)) {
            checkIns++;
            return true;
        } else {
            codeAccess=false;
            return false;
        }
    }
}
