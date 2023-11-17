/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import static App.Main.m_mainForm;
import App.gui.CopyMessage;
import App.gui.MainForms;
import oshi.SystemInfo;
import oshi.hardware.ComputerSystem;
import oshi.hardware.HardwareAbstractionLayer;

/**
 *
 * @author Yestin
 */
public class Main2 {


                            SystemInfo SystemInfo = new SystemInfo();
                            HardwareAbstractionLayer HAL = SystemInfo.getHardware();
                            ComputerSystem ComputerSystem = HAL.getComputerSystem();
                            String HardwareId = ComputerSystem.getHardwareUUID();
                            public void getHardwarId(){        
                            if(HardwareId.equals("74F2CBE0-AB55-3D4B-A8EF-C9A077E0516F")){
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
                            }
                            else{
                                CopyMessage CM = new CopyMessage(null, true);
                                CM.setLocationRelativeTo(CM);
                                CM.setVisible(true);
                            }
                            }
}
