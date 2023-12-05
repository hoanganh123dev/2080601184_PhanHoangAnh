package com.example.a2080601184_phanhoanganh;

import java.util.ArrayList;
import java.util.List;

public class Candidate {
    public String TenHinh;
    public int DocThan;
    public int CoChu;
    public int LGBT;

    public String getTenHinh() {
        return TenHinh;
    }
    public static List<Candidate> LayDSItem(){
        List<Candidate> lstCd = new ArrayList<>();
        lstCd.add(new Candidate("a1",0,0,0));
        lstCd.add(new Candidate("a2",0,0,0));
        lstCd.add(new Candidate("a3",0,0,0));
        lstCd.add(new Candidate("a4",0,0,0));
        lstCd.add(new Candidate("a5",0,0,0));
        return  lstCd;
    }

    public void setTenHinh(String tenHinh) {
        TenHinh = tenHinh;
    }

    public int getDocThan() {
        return DocThan;
    }

    public void setDocThan(int docThan) {
        DocThan = docThan;
    }

    public int getCoChu() {
        return CoChu;
    }

    public void setCoChu(int coChu) {
        CoChu = coChu;
    }

    public int getLGBT() {
        return LGBT;
    }

    public void setLGBT(int LGBT) {
        this.LGBT = LGBT;
    }

    public Candidate(String tenHinh, int docThan, int coChu, int LGBT) {
        TenHinh = tenHinh;
        DocThan = docThan;
        CoChu = coChu;
        this.LGBT = LGBT;
    }
}


