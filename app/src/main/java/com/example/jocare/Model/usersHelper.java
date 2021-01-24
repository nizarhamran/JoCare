package com.example.jocare.Model;

public class usersHelper {

    String fName,lName,emr,pass,coPass,ccpE,natid,Role;

    public usersHelper() {

    }


    public usersHelper(String fName, String lName, String emr, String pass, String coPass, String natid, String Role,String ccpE) {
        this.fName = fName;
        this.lName = lName;
        this.emr = emr;
        this.pass = pass;
        this.coPass = coPass;
        this.natid = natid;
        this.Role = Role;
        this.ccpE = ccpE;

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




    public String getCcpE() {
        return ccpE;
    }

    public void setCcpE(String ccpE) {
        this.ccpE = ccpE;
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

    public String getEmr() {
        return emr;
    }

    public void setEmr(String emr) {
        this.emr = emr;
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
