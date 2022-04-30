package com.example.studentadmin;

public class Database_helper_student {
    public Database_helper_student() {
    }

    String Branch, Roll_number, Registration_number, Name, Year, Address, Phone_number;

    public String getBranch() {
        return Branch;
    }

    public void setBranch(String branch) {
        Branch = branch;
    }

    public String getRoll_number() {
        return Roll_number;
    }

    public void setRoll_number(String roll_number) {
        Roll_number = roll_number;
    }

    public String getRegistration_number() {
        return Registration_number;
    }

    public void setRegistration_number(String registration_number) {
        Registration_number = registration_number;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhone_number() {
        return Phone_number;
    }

    public void setPhone_number(String phone_number) {
        Phone_number = phone_number;
    }

    public Database_helper_student(String branch, String roll_number, String registration_number, String name, String year, String address, String phone_number) {
        this.Branch = branch;
        this.Roll_number = roll_number;
        this.Registration_number = registration_number;
        this.Name = name;
        this.Year = year;
        this.Address = address;
        this.Phone_number = phone_number;
    }
}
