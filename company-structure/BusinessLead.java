package mini2;

import java.util.ArrayList;

public class BusinessLead extends BusinessEmployee{

    public ArrayList<Accountant> team;

    public BusinessLead(String name){
        super(name);
        this.baseSalary = getBaseSalary()*2;
        this.headcount = 10;
        this.team = new ArrayList<Accountant>();
    }

    public boolean hasHeadCount(){

        if (this.team.size()<this.headcount){
            return true;
        } else {
            return false;
        }
    }

    public boolean addReport(Accountant e, TechnicalLead supportTeam){

        if(hasHeadCount()){
            team.add(e);
            e.setManager(this);
            this.bonusBudget+=e.baseSalary*1.1;
            e.supportTeam(supportTeam);
            supportTeam.accountSupport = e;
            return true;
        } else {
            return false;
        }
    }

    public boolean requestBonus(Employee e, double bonus){

        if(bonus<=getBonusBudget()){
            this.bonusBudget-=bonus;
            e.bonusBudget+=bonus;
            return true;
        } else {
            return false;
        }
    }

    public boolean approveBonus(Employee e, double bonus){

        for (int i=0;i<team.size();i++){
            if(team.get(i).getTeamSupported().equals(e.manager)&&team.get(i).canApproveBonus(bonus)){
                e.bonus += bonus;
                team.get(i).bonusBudget -= bonus;
                return true;
            }
        }
        return false;
    }

    public String getTeamStatus(){

        if(team.size() == 0){
            return this.employeeStatus() + " and no direct reports yet";
        } else {
            String teamStatus = "";
            for (int i=0;i<team.size();i++){
                teamStatus+=("   " + team.get(i).employeeStatus() + "\n");
            }
            return this.employeeStatus() + " and is managing : \n" + teamStatus;
        }
    }

}
