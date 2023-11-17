/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.sql.SQLException;

/**
 *
 * @author Vestryl
 */
public interface PersistentObject {
    
    public void Simpan() throws SQLException;
    public boolean Ubah() throws SQLException;
    public void Query() throws  SQLException;
    public boolean Hapus() throws SQLException;
    
}
