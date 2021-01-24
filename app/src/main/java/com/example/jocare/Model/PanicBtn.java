package com.example.jocare.Model;

public class PanicBtn {
    String PanicBt,ccpPanic;
    public PanicBtn() {

    }

    public PanicBtn(String panicBt, String ccpPanic) {
        this.PanicBt = panicBt;
        this.ccpPanic = ccpPanic;
    }

    public String getPanicBt() {
        return PanicBt;
    }

    public void setPanicBt(String panicBt) {
        PanicBt = panicBt;
    }

    public String getCcpPanic() {
        return ccpPanic;
    }

    public void setCcpPanic(String ccpPanic) {
        this.ccpPanic = ccpPanic;
    }
}
