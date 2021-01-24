package com.example.jocare;

public class BloodReq {
    String PatientName;
    String PatientBloodType, BloodTypeNeeded, UnitsNeeded,NameOfBloodBank;

    public BloodReq(){

    }

    public String getNameOfBloodBank() {
        return NameOfBloodBank;
    }

    public void setNameOfBloodBank(String nameOfBloodBank) {
        NameOfBloodBank = nameOfBloodBank;
    }

    public void setPatientName(String patientName) {
        PatientName = patientName;
    }

    public String getPatientName() {
        return PatientName;
    }

    public String getPatientBloodType() {
        return PatientBloodType;
    }

    public void setPatientBloodType(String patientBloodType) {
        PatientBloodType = patientBloodType;
    }

    public String getBloodTypeNeeded() {
        return BloodTypeNeeded;
    }

    public void setBloodTypeNeeded(String bloodTypeNeeded) {
        BloodTypeNeeded = bloodTypeNeeded;
    }

    public String getUnitsNeeded() {
        return UnitsNeeded;
    }

    public void setUnitsNeeded(String unitsNeeded) {
        UnitsNeeded = unitsNeeded;
    }
}
