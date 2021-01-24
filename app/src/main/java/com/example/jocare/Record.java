package com.example.jocare;

public class Record {
    String PatientFName, PatientLName, PatientDob, PatientNatId, RecentExamination;
    String  GeneralHealth;
    String Hospitalization, HeartProblem, Endocarditis, HeartValve, PaceMaker, Prosthesis,
            BloodPressure, Stroke, BloodDisorders, HeadInjuries, ProlongBleeding, Emphysema, Asthma,
            KidneyDisease, LiverDisease, Jaundice, ThyroidDiseases, HormoneDeficiency, HighCholesterol,
            Diabetes, StomachUlcer;

    String BeingTreatedForIllnesses, ChangeInHealth, WeightMedications, Fatigued, FreqHeadaches, Smoker,
            Touchy, Depression, DietarySupplement, Pregnant, ProstateDisorder, BirthPills;
    String MedicalDescription , ListOfMedicine;

    public Record(){

    }


    public void setMedicalDescription(String medicalDescription) {
        MedicalDescription = medicalDescription;
    }

    public void setListOfMedicine(String listOfMedicine) {
        ListOfMedicine = listOfMedicine;
    }

    public String setPatientFName(String patientFName) {
        return  PatientFName = patientFName;
    }

    public String setPatientLName(String patientLName) {
        return  PatientLName = patientLName;
    }

    public String setPatientDob(String patientDob) {
        return  PatientDob = patientDob;
    }

    public String setPatientNatId(String patientNatId) {
        return  PatientNatId = patientNatId;
    }

    public String setRecentExamination(String recentExamination) {
        return RecentExamination = recentExamination;
    }

    public String getPatientFName() {
        return PatientFName;
    }

    public String getPatientLName() {
        return PatientLName;
    }

    public String getPatientDob() {
        return PatientDob;
    }

    public String getPatientNatId() {
        return PatientNatId;
    }

    public String getRecentExamination() {
        return RecentExamination;
    }

    public String getGeneralHealth() {
        return GeneralHealth;
    }

    public String setGeneralHealth(String generalHealth) {
        return  GeneralHealth = generalHealth;
    }

    //Checkboxes setters and getters

    //Checkboxes set get record2 start
    public String getBeingTreatedForIllnesses() {
        return BeingTreatedForIllnesses;
    }

    public void setBeingTreatedForIllnesses(String TreatedForIllnesses) {
        BeingTreatedForIllnesses = TreatedForIllnesses;
    }

    public String getChangeInHealth() {
        return ChangeInHealth;
    }

    public void setChangeInHealth(String changeInHealth) {
        ChangeInHealth = changeInHealth;
    }

    public String getWeightMedications() {
        return WeightMedications;
    }

    public void setWeightMedications(String weightMedications) {
        WeightMedications = weightMedications;
    }

    public String getFatigued() {
        return Fatigued;
    }

    public void setFatigued(String fatigued) {
        Fatigued = fatigued;
    }

    public String getFreqHeadaches() {
        return FreqHeadaches;
    }

    public void setFreqHeadaches(String freqHeadaches) {
        FreqHeadaches = freqHeadaches;
    }

    public String getSmoker() {
        return Smoker;
    }

    public void setSmoker(String smoker) {
        Smoker = smoker;
    }

    public String getTouchy() {
        return Touchy;
    }

    public void setTouchy(String touchy) {
        Touchy = touchy;
    }

    public String getDepression() {
        return Depression;
    }

    public void setDepression(String depression) {
        Depression = depression;
    }

    public String getDietarySupplement() {
        return DietarySupplement;
    }

    public void setDietarySupplement(String dietarySupplement) {
        DietarySupplement = dietarySupplement;
    }

    public String getPregnant() {
        return Pregnant;
    }

    public void setPregnant(String pregnant) {
        Pregnant = pregnant;
    }

    public String getProstateDisorder() {
        return ProstateDisorder;
    }

    public void setProstateDisorder(String prostateDisorder) {
        ProstateDisorder = prostateDisorder;
    }

    public String getBirthPills() {
        return BirthPills;
    }

    public void setBirthPills(String birthPills) {
        BirthPills = birthPills;
    }

    public String getMedicalDescription() {
        return MedicalDescription;
    }



    public String getListOfMedicine() {
        return ListOfMedicine;
    }


    //end checkboxes record2

    //start radio record1

    public String getHospitalization() {
        return Hospitalization;
    }

    public String setHospitalization(String hospitalization) {
        return Hospitalization = hospitalization;
    }

    public String getHeartProblem() {
        return HeartProblem;
    }

    public String setHeartProblem(String heartProblem) {
        return HeartProblem = heartProblem;
    }

    public String getEndocarditis() {
        return Endocarditis;
    }

    public String setEndocarditis(String endocarditis) {
        return Endocarditis = endocarditis;
    }

    public String getHeartValve() {
        return HeartValve;
    }

    public String setHeartValve(String heartValve) {
        return HeartValve = heartValve;
    }

    public String getPaceMaker() {
        return PaceMaker;
    }

    public String setPaceMaker(String paceMaker) {
        return PaceMaker = paceMaker;
    }

    public String getProsthesis() {
        return Prosthesis;
    }

    public String setProsthesis(String prosthesis) {
        return  Prosthesis = prosthesis;
    }

    public String getBloodPressure() {
        return BloodPressure;
    }

    public String setBloodPressure(String bloodPressure) {
        return BloodPressure = bloodPressure;
    }

    public String getStroke() {
        return Stroke;
    }

    public String setStroke(String stroke) {
        return  Stroke = stroke;
    }

    public String getBloodDisorders() {
        return BloodDisorders;
    }

    public String setBloodDisorders(String bloodDisorders) {
        return  BloodDisorders = bloodDisorders;
    }

    public String getHeadInjuries() {
        return HeadInjuries;
    }

    public String setHeadInjuries(String headInjuries) {
        return  HeadInjuries = headInjuries;
    }

    public String getProlongBleeding() {
        return ProlongBleeding;
    }

    public String setProlongBleeding(String prolongBleeding) {
        return  ProlongBleeding = prolongBleeding;
    }

    public String getEmphysema() {
        return Emphysema;
    }

    public String setEmphysema(String emphysema) {
        return  Emphysema = emphysema;
    }

    public String getAsthma() {
        return Asthma;
    }

    public String setAsthma(String asthma) {
        return  Asthma = asthma;
    }

    public String getKidneyDisease() {
        return KidneyDisease;
    }

    public String setKidneyDisease(String kidneyDisease) {
        return KidneyDisease = kidneyDisease;
    }

    public String getLiverDisease() {
        return LiverDisease;
    }

    public String setLiverDisease(String liveDisease) {
        return LiverDisease = liveDisease;
    }

    public String getJaundice() {
        return Jaundice;
    }

    public String setJaundice(String jaundice) {
        return Jaundice = jaundice;
    }

    public String getThyroidDiseases() {
        return ThyroidDiseases;
    }

    public String setThyroidDiseases(String thyroidDiseases) {
        return ThyroidDiseases = thyroidDiseases;
    }

    public String getHormoneDeficiency() {
        return HormoneDeficiency;
    }

    public String setHormoneDeficiency(String hormoneDeficiency) {
        return HormoneDeficiency = hormoneDeficiency;
    }

    public String getHighCholesterol() {
        return HighCholesterol;
    }

    public String setHighCholesterol(String highCholesterol) {
        return  HighCholesterol = highCholesterol;
    }

    public String getDiabetes() {
        return Diabetes;
    }

    public String setDiabetes(String diabetes) {
        return Diabetes = diabetes;
    }

    public String getStomachUlcer() {
        return StomachUlcer;
    }

    public String setStomachUlcer(String stomachUlcer) {
        return StomachUlcer = stomachUlcer;
    }
}
