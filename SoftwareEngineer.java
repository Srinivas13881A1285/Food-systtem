package mini2;

public class SoftwareEngineer extends TechnicalEmployee {

    public boolean codeAccess;

    public SoftwareEngineer(String name){
        super(name);
        setCodeAccess(true);
    }

    public boolean getCodeAccess(){
        return codeAccess;
    }

    public void setCodeAccess(boolean codeAccess) {
        this.codeAccess = codeAccess;
    }

    public int getSuccessfulCheckIns(){
        return checkin;
    }

    public boolean checkInCode(){
        TechnicalLead manager = (TechnicalLead) this.getManager();
        if(manager.approveCheckIn(this)){
            this.checkin++;
            return true;
        } else {
            codeAccess = false;
            return false;
        }
    }
}
