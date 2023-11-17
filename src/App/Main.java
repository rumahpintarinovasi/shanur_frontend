/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import App.gui.CopyMessage;
import App.gui.MainForm;
import App.gui.MainForms;
import App.gui.Pemberitahuan;
import App.gui.Verification;
//import Inventori.gui.DaftarBarang;
import Util.DBConnector;
import java.awt.Dialog;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.type.OrientationEnum;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import oshi.SystemInfo;
import oshi.hardware.ComputerSystem;
import oshi.hardware.HardwareAbstractionLayer;
/**
 *
 * @author Yestin
 */
public class Main {

    private static String osname;
	public static MainForms m_mainForm = null;
        private boolean keeprunning = true;
	public static Pemberitahuan Peringatan = null;
	public static ThreadWarning JendelaPeringatan;
//        static DaftarBarang DB = new DaftarBarang(null, true);
        
        
	public static MainForms getMainForm(){
            return m_mainForm;
	}
	private static void setLookAndFeel (){
        // Try to use Nimbus L&F
            try {
                boolean useNimbus = false;
                if (useNimbus){
			UIManager.setLookAndFeel ("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		}
                else{
			String osname = System.getProperty ("os.name");

		}
		if (osname.toUpperCase ().indexOf ("WINDOWS") > -1){

			UIManager.setLookAndFeel (UIManager.getSystemLookAndFeelClassName ());
		}
                else{
                        UIManager.setLookAndFeel (UIManager.getCrossPlatformLookAndFeelClassName ());
                }
            }
            catch (Exception x) {
                try {
                    String osname = System.getProperty ("os.name");
                    if (osname.toUpperCase ().indexOf ("WINDOWS") > -1)
                        UIManager.setLookAndFeel (UIManager.getSystemLookAndFeelClassName ());
                    else
                        UIManager.setLookAndFeel (UIManager.getCrossPlatformLookAndFeelClassName ());
                }
                catch (Exception z) {
                    try {
                        UIManager.setLookAndFeel (UIManager.getCrossPlatformLookAndFeelClassName ());
                    }
                    catch (Exception w) {
                        w.printStackTrace();
                    }
            }
        }
    }

    public static void main(String[] args)
    {
        setLookAndFeel();

        // inisialisasi database melalui kelas yg sudah dibuat
        DBConnector.Inisialisasi();
//        int NoNota = 9;
//        java.util.Map<String, Object> params = new java.util.HashMap<String, Object>();
//        params.put("NoNota", NoNota);
//        JasperPrint JP = null;
//        String ReportPath = "Report/";
//        String ReportFileName = null;
//        ReportFileName = ReportPath + "StrukPenjualanPPNDiskon20.jasper";
//        try {
//            String path = "Report/StrukPenjualanPoinPPNDiskon.jrxml";
//            File file = new File(path);
//            JasperDesign jasperDesign = JRXmlLoader.load(file);
//            JasperReport report = JasperCompileManager.compileReport(jasperDesign);
//            JP = JasperFillManager.fillReport(report, params, DBConnector.getConnection());
////            JP = JasperFillManager.fillReport(ReportFileName, params, DBConnector.getConnection());
//            JP.setOrientation(OrientationEnum.PORTRAIT);
//            JP.setPageHeight(315);
//            JasperViewer JV = new JasperViewer(JP, false);
//            JV.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
//            JV.setVisible(true);
//            JV.setFitPageZoomRatio();
//        } catch (JRException ex) {
//            ex.printStackTrace();
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        try {
//            JasperCompileManager.compileReportToFile(
//                    "Report/StrukPenjualan1.jrxml", // the path to the jrxml file to compile
//                    "Report/StrukPenjualan1.jasper"); // the path and name we want to save the compiled file to
//        } catch (JRException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
        java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                
                SystemInfo SystemInfo = new SystemInfo();
                            HardwareAbstractionLayer HAL = SystemInfo.getHardware();
                            ComputerSystem ComputerSystem = HAL.getComputerSystem();
                            String HardwareId = ComputerSystem.getHardwareUUID();
                                    
//                            if(HardwareId.equals("74F2CBE0-AB55-3D4B-A8EF-C9A077E0516F")){
                                m_mainForm = new MainForms();
                                
                                m_mainForm.mInventori.setVisible(false);
                                m_mainForm.miRegistrasiKategori.setVisible(false);
                                m_mainForm.miDaftarKategori.setVisible(false);
                                m_mainForm.miRegistrasiMerek.setVisible(false);
                                m_mainForm.miDaftarMerek.setVisible(false);
                                m_mainForm.miRegistrasiSatuan.setVisible(false);
                                m_mainForm.miDaftarSatuan.setVisible(false);
                                m_mainForm.miRegistrasiItem.setVisible(false);
                                m_mainForm.miDaftarItem.setVisible(false);
                                m_mainForm.miPenerimaanBarangSupplier.setVisible(false);
                                m_mainForm.miDataStokItem.setVisible(false);
                                
                                m_mainForm.mTransaksi.setVisible(false);
                                m_mainForm.miPenjualanTunai.setVisible(false);
                                m_mainForm.miSetKasAwal.setVisible(false);
                                m_mainForm.miLaba.setVisible(false);
                                m_mainForm.miDataTransaksi.setVisible(false);
                                m_mainForm.miPelunasan.setVisible(false);
                                
                                m_mainForm.mAdministrasi.setVisible(false);
                                m_mainForm.miPengimputanFakturPembelian.setVisible(false);
                                m_mainForm.miRegistrasiSupplier.setVisible(false);
                                m_mainForm.miDataSupplier.setVisible(false);
                                m_mainForm.miPencetakanBarcode.setVisible(false);
                                m_mainForm.miSetNamaBisnis.setVisible(false);
                                m_mainForm.miRegistrasiOutlet.setVisible(false);
                                m_mainForm.miRegistrasiJenisPembayaran.setVisible(false);
                                m_mainForm.miDaftarJenisPembayaran.setVisible(false);
                                m_mainForm.miTambahSift.setVisible(false);
                                m_mainForm.miDaftarSift.setVisible(false);
                                m_mainForm.miRegistrasiMobil.setVisible(false);
                                m_mainForm.miDataMobil.setVisible(false);
                                
                                m_mainForm.mUser.setVisible(true);
                                m_mainForm.miRegistrasiUser.setVisible(false);
                                m_mainForm.miDaftarUser.setVisible(false);
                                m_mainForm.miGantiUsernamePassword.setVisible(false);
                                m_mainForm.miRegistrasiJenisIdentitas.setVisible(false);
                                m_mainForm.miDaftarJenisIdentitas.setVisible(false);
                                m_mainForm.miRegistrasiFitur.setVisible(false);
                                m_mainForm.miDaftarFitur.setVisible(false);
                                m_mainForm.miEditAkses.setVisible(false);
                                m_mainForm.miRegistrasiJenisPekerjaan.setVisible(false);
                                m_mainForm.miDaftarJenisPekerjaan.setVisible(false);
                                m_mainForm.miDataPekerjaan.setVisible(false);
                                m_mainForm.miLogin.setVisible(true);
                                m_mainForm.miLogout.setVisible(false);
                                
                                m_mainForm.mFinancial.setVisible(false);
                                m_mainForm.miRegistrasiAkun.setVisible(false);
                                m_mainForm.miDataAkun.setVisible(false);
                                m_mainForm.miPembuatanMutasi.setVisible(false);
                                m_mainForm.miDataMutasi.setVisible(false);
                                m_mainForm.miRegistrasiPenyimpanan.setVisible(false);
                                m_mainForm.miDataPenyimpanan.setVisible(false);
                                
                                m_mainForm.setVisible(true);
//                            }
//                            else{
//                                CopyMessage CM = new CopyMessage(null, true);
//                                CM.setLocationRelativeTo(CM);
//                                CM.setVisible(true);
//                            }
                            
                            Peringatan = new Pemberitahuan();
                            JendelaPeringatan = new ThreadWarning(m_mainForm);
                            JendelaPeringatan.start();
                
            }
        });
    }
    
}
