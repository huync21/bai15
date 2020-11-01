
package javaapplication68;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;


public class JavaApplication68 {

    
    public static void main(String[] args) {
        //1
        ArrayList<SinhVien> sinhVienList=new ArrayList<>();
        Scanner s=null;
        try {
             s=new Scanner(new File("SV.INP"));
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
        
        while(s.hasNextLine()){
            int count=0;
            try {
                SinhVien sv=new SinhVien();
                
                count++;
                sv.setMaSV(Integer.parseInt(s.nextLine()));
                count++;
                sv.setTen(s.nextLine());
                count++;
                sv.setLop(s.nextLine());
                count++;
                sv.setDtb(Double.parseDouble(s.nextLine()));
                sinhVienList.add(sv);
            } catch (maSVException ex) {
                System.out.println(ex);
            } catch (tenException ex) {
                System.out.println(ex);
            } catch (lopException ex) {
                System.out.println(ex);
            } catch (dtbException ex) {
                System.out.println(ex);
            }
            
            if(count<4){
                for(int i=1;i<=4-count;i++){
                    if(s.hasNextLine()){
                        s.nextLine();
                    }
                }
            }
        }
        
        //2
        for(int i=0;i<sinhVienList.size();i++){
            System.out.println(sinhVienList.get(i));
        }
        
        //3
        Collections.sort(sinhVienList, new Comparator<SinhVien>(){
            @Override
            public int compare(SinhVien o1, SinhVien o2) {
               if(o1.getDtb()< o2.getDtb()) return 1;
               else if(o1.getDtb() == o2.getDtb()) return 0;
               else return -1;
            }
            
        });
        
        try {
            PrintStream ps=new PrintStream(new File("SX.OUT"));
            for(int i=0;i<sinhVienList.size();i++){
                ps.println(sinhVienList.get(i));
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
        
        //4 
        Collections.sort(sinhVienList, new Comparator<SinhVien>(){
            @Override
            public int compare(SinhVien o1, SinhVien o2) {
                StringTokenizer st=new StringTokenizer(o1.getTen());
                StringTokenizer st1=new StringTokenizer(o2.getTen());
                String ten1=null;
                String ten2=null;
                while(st.hasMoreTokens()){
                    ten1=st.nextToken();
                }
                while(st1.hasMoreTokens()){
                    ten2=st1.nextToken();
                }
                
                return (ten1.compareTo(ten2));
            }
        
        });
        
        try {
            PrintStream ps =new PrintStream(new File("XEPLOAI.OUT"));
            ps.println("GIOI: ");
            for(int i=0;i<sinhVienList.size();i++){
                double diem=sinhVienList.get(i).getDtb();
                if(diem>8) ps.println(sinhVienList.get(i)); 
            }
            
            ps.println("Kha: ");
            for(int i=0;i<sinhVienList.size();i++){
                double diem=sinhVienList.get(i).getDtb();
                if(diem>=7 && diem<=8) ps.println(sinhVienList.get(i)); 
            }
            
           ps.println("trung binh: ");
            for(int i=0;i<sinhVienList.size();i++){
                double diem=sinhVienList.get(i).getDtb();
                if(diem>=5 && diem<7) ps.println(sinhVienList.get(i)); 
            }
            
            ps.println("Yeu: ");
            for(int i=0;i<sinhVienList.size();i++){
                double diem=sinhVienList.get(i).getDtb();
                if(diem<5) ps.println(sinhVienList.get(i)); 
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
        
        
        
    }
    
}
