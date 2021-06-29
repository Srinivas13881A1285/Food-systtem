package mini2;

public class TechnicalEmployee extends Employee {

    public int checkin;

    public TechnicalEmployee(String name){
        super(name, 75000);
        checkin = 0;
    }

    public String employeeStatus() {
        return super.toString() + " has " + checkin + " successful checkins";
    }

    public void setCheckin(){
        checkin++;
    }
}
