package com.example.jocare.Model;

public class Pinformation {
    String fName,lName,city,postal,phone,ccp,natId,Role,emps,civils,Natio,Address,Dob;

    public Pinformation() {

    }
    public Pinformation(String fName, String lName, String city, String postal, String phone, String ccp, String natId, String role, String emps, String civils, String natio, String address, String dob) {
        this.fName = fName;
        this.lName = lName;
        this.city = city;
        this.postal = postal;
        this.phone = phone;
        this.ccp = ccp;
        this.natId = natId;
        Role = role;
        this.emps = emps;
        this.civils = civils;
        Natio = natio;
        Address = address;
        Dob = dob;
    }

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCcp() {
        return ccp;
    }

    public void setCcp(String ccp) {
        this.ccp = ccp;
    }

    public String getNatId() {
        return natId;
    }

    public void setNatId(String natId) {
        this.natId = natId;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public String getEmps() {
        return emps;
    }

    public void setEmps(String emps) {
        this.emps = emps;
    }

    public String getCivils() {
        return civils;
    }

    public void setCivils(String civils) {
        this.civils = civils;
    }

    public String getNatio() {
        return Natio;
    }

    public void setNatio(String natio) {
        Natio = natio;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getDob() {
        return Dob;
    }

    public void setDob(String dob) {
        Dob = dob;
    }
}
