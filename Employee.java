package mini2;

public abstract class Employee {

    private static int countID;

    public String name;
    public int employeeID;
    public double baseSalary;
    public double bonus;

    public Employee manager;
    public Accountant accountSupport;
    public int headcount = 0;
    public double bonusBudget;

    public Employee(String name, double baseSalary){
        this.name = name;
        this.baseSalary = baseSalary;
        countID++;
        this.employeeID = countID;
    }

    public double getBaseSalary(){
        return this.baseSalary;
    }

    public String getName() {
        return this.name;
    }

    public int getEmployeeID(){
        return this.employeeID;
    }

    public Employee getManager(){
        return manager;
    }

    public Accountant getAccountSupport() {
        return accountSupport;
    }

    public void setManager(Employee manager){
        this.manager = manager;
    }

    public boolean equals(Employee other){
        return this.getEmployeeID() == other.getEmployeeID();
    }

    public String toString(){
        return getEmployeeID() + " " + getName();
    }

    public abstract String employeeStatus();

    public void getBonus(){

    }
}
