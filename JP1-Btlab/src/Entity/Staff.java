package Entity;

import java.time.LocalDate;

public class Staff extends Person {
    private String id;
    private String school;
    private LocalDate dateJoin;
    private double pay;
    private Gender gender;

    public Staff(){;}

    public Staff(String id,String school, String name, String address, Gender gender, LocalDate dateJoin, double pay) {
        super(name, address);
        this.id = id;
        this.gender = gender;
        this.school = school;
        this.dateJoin = dateJoin;
        this.pay = pay;
    }

    public String getid() {
        return id;
    }

    public void setId(String id) {
        id = id;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    //Allow user rename
    public void changeName(String newName) {
        super.setName(newName);
    }

    @Override
    public String getName(){
        return super.getName();
    }

    @Override
    public void setName(String name){
        super.setName(name);
    }

    @Override
    public String toString() {
        return "Staff{" +
                "Id='" + id + '\'' +
                ", Name=" + this.getName() +
                ", address=" + this.getAddress() +
                ", school='" + school + '\'' +
                ", dateJoin=" + dateJoin +
                ", pay=" + pay +
                ", gender=" + gender +
                '}';
    }
}
