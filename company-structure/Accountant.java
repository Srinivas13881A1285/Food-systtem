package mini2;

public class Accountant extends BusinessEmployee {

    public TechnicalLead teamSupported;

    public Accountant(String name){
        super(name);
        bonusBudget = 0;
    }

    public TechnicalLead getTeamSupported(){
        return teamSupported;
    }

    public void supportTeam(TechnicalLead lead){
        this.teamSupported = lead;
        for (int i=0; i<lead.team.size(); i++){
            this.bonusBudget+=lead.team.get(i).getBaseSalary()*1.1;
        }
    }

    public boolean canApproveBonus(double bonus){
        double requestedBonus = bonus;
        if(requestedBonus<=getBonusBudget()){
            return true;
        } else {
            System.out.print(" Rejected because Budget not sufficient. ");
            return false;
        }
    }

    public String employeeStatus(){
        return this.toString() + " with a budget of " + getBonusBudget() + " is supporting " + this.getTeamSupported();
    }

}
