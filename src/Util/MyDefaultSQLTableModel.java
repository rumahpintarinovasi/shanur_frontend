/*
 * MyDefaultSQLTableModel.java
 *
 * Created on July 8, 2006, 6:33 PM
 */
package Util;

import javax.swing.table.AbstractTableModel;
import java.sql.*;
import java.util.Vector;

/**
 *
 * @author Irfin A
 *
 * @revision #1 : January 23, 2008 03:00 AM
 *      Adopsi fitur Plazma ERP+CRM yaitu fungsionalitas penentuan column-class
 *      secara otomatis dgn cara melakukan mapping tipe-tipe data SQL yg umum
 *      digunakan, ke kelas Java.
 */
public class MyDefaultSQLTableModel extends AbstractTableModel
{
    private java.sql.ResultSet m_rs = null;
    private int m_rowCount = 0;
    private int m_columnCount = 0;
    private String[] m_arrColClass = null;
    protected Vector dataVector;

    // @since Jan 23, 2008
    private Class[] m_arrColClass_v2 = null;
    private ResultSetMetaData m_rsMetaData = null;
    protected Vector vector;

    /**
     * Creates a new instance of MyDefaultSQLTableModel
     */
    public MyDefaultSQLTableModel (java.sql.ResultSet _rs)
    {
        m_rs = _rs;
        try {
            m_rs.first();

            m_rsMetaData = m_rs.getMetaData ();

            // get the column count and store it in a variable.
            m_columnCount = m_rsMetaData.getColumnCount ();

            // get the row count and store it in a variable.
            m_rs.last();
            m_rowCount = m_rs.getRow ();
            //m_rs.first();

            initColumnClass ();
        }
        catch (SQLException ex) {
            ex.printStackTrace ();
        }
    }

    public MyDefaultSQLTableModel (java.sql.ResultSet _rs, String[] _colClass) throws Exception
    {
        this (_rs);
        setColumnClass (_colClass);
    }
    
    public Vector getDataVector(){
        return dataVector;
    }

    /**
     * Will override the automatic column-class recognition performed by this
     *  class's constructor.
     *
     * @param _colClass
     * @throws java.lang.Exception
     * @revision since revision #1
     */
    public void setColumnClass (String[] _colClass) throws Exception
    {
        if (_colClass.length != this.getColumnCount())
            throw new Exception ("Jumlah tipe-kelas kolom tidak sama dengan jumlah kolom");
        else {
//            m_arrColClass = _colClass;
            m_arrColClass_v2 = new Class [_colClass.length];
            for (int i = 0; i < m_arrColClass_v2.length; i++) {
                m_arrColClass_v2[i] = Class.forName (_colClass[i]);
            }
        }
    }

    /**
     * @return A {@link java.sql.ResultSet} used as model for this class.
     * @revision April 19, 2007
     *
     * @author Irfin A.
     */
    public java.sql.ResultSet getResultSet ()
    {
        return m_rs;
    }

    public int getRowCount ()
    {
        return m_rowCount;
    }

    public int getColumnCount ()
    {
        return m_columnCount;
//        try {
//            return m_rs.getMetaData().getColumnCount();
//        }
//        catch (SQLException ex) {
//            ex.printStackTrace();
//            return 0;
//        }
    }

    public Object getValueAt (int _rowIdx, int _columnIdx)
    {
        try {
            m_rs.absolute (_rowIdx + 1);

            // Jika data bertipe string, cek apakah ada '\n' atau tidak. Jika ada
            //  maka ganti dgn spasi. Jika '\n' tidak diganti maka ditampilkan di JTable
            //  tanpa ada pemisah (alhasil 2 kata tergabung jadi 1).
            if (m_arrColClass_v2 != null) {
                //if (m_arrColClass_v2[_columnIdx].equals ("java.lang.String")) {
                if (m_arrColClass_v2[_columnIdx] == String.class) {
                    String retval = m_rs.getString (_columnIdx + 1);
                    if (retval != null)
                        return retval.replace ('\n', ' ');
                    else
                        return null;
                }
            }

            return m_rs.getObject (_columnIdx + 1);
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public String getColumnName (int _column)
    {
        try {
            return m_rsMetaData.getColumnName (_column + 1);
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            return super.getColumnName (_column);
        }
    }

    /**
     *
     * @param _colIdx
     * @return
     * @revision #1
     */
    public Class getColumnClass (int _colIdx)
    {
        if (m_arrColClass_v2 == null) {
            return super.getColumnClass (_colIdx);
        }
        else {
            return m_arrColClass_v2[_colIdx];
        }
    }

//    public Class getColumnClass (int _colIdx)
//    {
//        try {
//            /*return Class.forName (m_rs.getMetaData ().getColumnClassName (_colIdx + 1));*/
//
//            if (m_arrColClass == null)
//                return super.getColumnClass (_colIdx);
//            else
//                return Class.forName (m_arrColClass[_colIdx]);
//
//        }
//        /*catch (SQLException w) {
//            w.printStackTrace();
//            return super.getColumnClass (_colIdx);
//        }*/
//        catch (ClassNotFoundException c) {
//            c.printStackTrace();
//            return super.getColumnClass (_colIdx);
//        }
//    }

    /**
     * Always returns false.
     */
    public boolean isCellEditable (int _row, int _col)
    {
        return false;
    }
    public void RemoveRow(int row){
        vector.removeElementAt(row);
        fireTableRowsDeleted(row, row);
    }
    /**
     *
     * @throws java.sql.SQLException
     * @since revision #1
     */
    private void initColumnClass () throws SQLException
    {
        m_arrColClass_v2 = new Class [getColumnCount ()];

        for (int i = 0; i < m_arrColClass_v2.length; i++) {
            switch (m_rsMetaData.getColumnType (i + 1)) {
                case Types.CHAR:
                case Types.VARCHAR:
                    m_arrColClass_v2[i] = String.class;
                    break;
                case Types.LONGVARCHAR:
                    m_arrColClass_v2[i] = String.class;
                    break;

                case Types.BIT:
                case Types.BOOLEAN:
                    m_arrColClass_v2[i] = Boolean.class;
                    break;

                case Types.TINYINT:
                case Types.SMALLINT:
                case Types.INTEGER:
                    m_arrColClass_v2[i] = Integer.class;
                    break;

                case Types.BIGINT:
                    m_arrColClass_v2[i] = Long.class;
                    break;

                case Types.NUMERIC:
                case Types.DECIMAL:
                    m_arrColClass_v2[i] = Double.class;   // java.math.BigDecimal.class;
                    break;

                case Types.REAL:
                case Types.FLOAT:
                    m_arrColClass_v2[i] = Float.class;
                case Types.DOUBLE:
                    m_arrColClass_v2[i] = Double.class;
                    break;

                case Types.DATE:
                    m_arrColClass_v2[i] = java.sql.Date.class;
                    break;

                case Types.TIME:
                    m_arrColClass_v2[i] = java.sql.Time.class;
                    break;

                case Types.TIMESTAMP:
                    m_arrColClass_v2[i] = java.sql.Timestamp.class;
                    break;

                default:
                    m_arrColClass_v2[i] = Object.class;
            }
        }
    }
}
