package classes;

public class Person{

    private String name;
    private String pesel;

    public Person(String name, String pesel) {
        this.name = name;
        this.pesel = pesel;
    }

    public String getName(){
        return name;
    }
    public String getPesel(){
        return pesel;
    }

    @Override
    public String toString() {
       return getName() + " " + getPesel();
    }
}



abstract class  Staff extends Person{
    private final String StaffId;

    public Staff(String name, String pesel, String StaffId){
        super(name, pesel);
        this.StaffId = StaffId;
    }

    public String getStaffId(){
        return StaffId;
    }
}

abstract class MedicalStaff extends Staff{

    private boolean permissionNo;
    public MedicalStaff(String name, String pesel,String StaffId, boolean permissionNo){

        super(name,pesel, StaffId);
        this.permissionNo = permissionNo;

    }

    public boolean getPermission(){
        return permissionNo;
    }

    public void print(){
        System.out.println(getName() + " " + getPesel() + " " + getPermission());
    }
}

class OfficeStaff extends Staff implements Consultable{

    public OfficeStaff(String name, String pesel,String StaffId){
        super(name,pesel,StaffId);
    };

    public void print(){
        System.out.println(getName() + " " + getPesel() + " " +  getStaffId());
    }

    @Override
    public void consult(Staff s) {
        System.out.println(s.getName());
    }
}

class Nurse extends MedicalStaff{
    public Nurse(String name, String pesel, String StaffId, boolean permissionNo){
        super(name, pesel, StaffId, permissionNo);
    }

    public void makeInjection(Patient p){
        System.out.println("test");
    }
}


class Doctor extends MedicalStaff{

    private String specialization;
    public Doctor(String name, String pesel, String StaffId, boolean permissionNo){
        super(name, pesel, StaffId, permissionNo);
    }
    public void makeOperation(Patient p){
        System.out.println("test docto");
    }

}

class Patient extends Person implements Consultable{

    private final String patientId;
    private Illness illness;

    public void print(){
        System.out.println(getName() + " " + getPesel() + " " + patientId + " came with" + illness.getIllness());
    }
    public Patient(String name, String pesel, String id){
        super(name, pesel);
        patientId = id;
    }

    public boolean hasIllness(){
        if(illness != null){
            return true;
        }
        return false;
    }

    public void cureIllness(){
        illness = null;
    }



    private class Illness{
        private String illness;
        public Illness(String illness){
            this.illness = illness;
        }
        public String getIllness()
        {
            if(illness!= null)
                return illness;
            else
                return "brak choroby";
        }

    }


    @Override
    public void consult(Staff s) {
        System.out.println(s.getName());
    }
}
