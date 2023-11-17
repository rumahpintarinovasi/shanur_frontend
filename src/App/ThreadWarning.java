/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;
/**
 *
 * @author vestrylyestin
 */
import App.gui.*;
import App.gui.Pemberitahuan;
import Util.DBConnector;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;



public class ThreadWarning extends java.lang.Thread{
    
    private boolean keepruning = true;
    private MainForms MainForm = new MainForms();
    private Pemberitahuan Peringatan = new Pemberitahuan();
    private Expire Exp = new Expire();
    
    public ThreadWarning(MainForms mainForm){
        MainForm = mainForm;
        keepruning = true;
        try {
            Peringatan = new Pemberitahuan();
        } 
        catch (Exception e) {
            Logger.getLogger(ThreadWarning.class.getName()).log(Level.SEVERE, null, e);
        }
        MainForm.getDesktopPane().add(Peringatan);
    }
    
    public void run(){
        try {
            Thread.sleep(1000);
        } 
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        while(keepruning){
//            System.out.println("Thread Peringatan Dieksekusi");
            try {
                String Expire = "2022-10-01";
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate TglExp = LocalDate.parse(Expire, dtf);
                LocalDate TglNow = LocalDate.now();
//                if(TglNow.compareTo(TglExp)<0){
                    
                    Integer Selisih = Math.abs(TglExp.lengthOfYear() - TglNow.getDayOfYear());
                    Peringatan.txtNotifikasi.setText(new String(""));
                    Peringatan.setVisible(true);
                    DBConnector.Inisialisasi();
                    Thread.sleep(4000);
////                }
////                else if(TglNow.compareTo(TglExp)>=0){
////                    JOptionPane.showMessageDialog(MainForm, "Masa Gratis Coba Telah Habis!");
////                    System.exit(0);
////                    Thread.sleep(1000);
////                }
            } 
            catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
    }
}
