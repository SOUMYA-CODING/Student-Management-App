package com.example.student;

public class DataHelperClass {

    String Roll_number, Email;

    public String getRoll_number() {
        return Roll_number;
    }

    public DataHelperClass() {
    }

    public void setRoll_number(String roll_number) {
        Roll_number = roll_number;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public DataHelperClass(String roll_number, String email) {
        Roll_number = roll_number;
        Email = email;
    }
}
