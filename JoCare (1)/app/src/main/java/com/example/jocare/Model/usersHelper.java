package com.example.jocare.Model;

public class usersHelper {

    String fName,lName,email,pass,coPass/*,Patient,Doctor*/,natid,Role;

    public usersHelper() {

    }

    public usersHelper(String fName, String lName, String email, String pass, String coPass/*,String Patient,String Doctor*/, String natid, String Role) {
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.pass = pass;
        this.coPass = coPass;
        /*this.Patient = Patient;
        this.Doctor = Doctor;*/
        this.natid = natid;
        this.Role = Role;

    }

    public String getnatid() {
        return natid;
    }

    public void setnatid(String natid) {
        this.natid = natid;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }



    /*public String getPatient() {
        return Patient;
    }

    public void setPatient(String Patient) {
        this.Patient = Patient;
    }
    public String getDoctor() {
        return Doctor;
    }

    public void setDoctor(String Doctor) {
        this.Doctor = Doctor;
    }*/

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getCoPass() {
        return coPass;
    }

    public void setCoPass(String coPass) {
        this.coPass = coPass;
    }
}
