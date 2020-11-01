/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication68;

class maSVException extends Exception{
    public String toString(){
        return "ma sinh vien phai co 4 chu so";
    }
}

class tenException extends Exception{
    public String toString(){
        return "ten sinh vien ko duoc de trong";
        
    }
}

class lopException extends Exception{
    public String toString(){
        return "lop phai theo quy tac dat ten PTIt";
    }
}

class dtbException extends Exception{
    public String toString(){
        return "dtb phai tu 0-10";
    }
}

public class SinhVien {
    private int maSV;
    private String ten;
    private String lop;
    private double dtb;
    private static String quyChuanDatTen="D\\d{2}CQ(AT||CN||VT)\\d{2}-B";

    public SinhVien() {
    }

    public SinhVien(int maSV, String ten, String lop, double dtb) {
        this.maSV = maSV;
        this.ten = ten;
        this.lop = lop;
        this.dtb = dtb;
    }

    public void setMaSV(int maSV) throws maSVException {
        if(maSV>=1000 && maSV<=9999)
        this.maSV = maSV;
        else 
        throw new maSVException();
    }

    public void setTen(String ten) throws tenException {
        if(ten.matches("\\s*")) throw new tenException();
        else 
        this.ten = ten;
    }

    public void setLop(String lop) throws lopException {
        if(lop.matches(quyChuanDatTen))
        this.lop = lop;
        else throw new lopException();
    }

    public void setDtb(double dtb) throws dtbException {
        if(dtb>=0 && dtb <=10)
        this.dtb = dtb;
        else throw new dtbException();
    }

    public String getTen() {
        return ten;
    }

    public double getDtb() {
        return dtb;
    }
    
    
    
    public String toString(){
        return maSV+" "+ten+" "+lop+" "+dtb;
    }
    
}
