/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.awt.Color;
import java.io.FileOutputStream;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jdesktop.swingx.renderer.DefaultTableRenderer;

/**
 *
 * @author Yestin
 */
public class Table {
	
	public void TransparentTable(JTable Table,JScrollPane ScrlPane){
            ScrlPane.setOpaque(false);
            ScrlPane.getViewport().setOpaque(false);
            Table.setOpaque(false);
            Table.setShowGrid(false);
            ScrlPane.setViewportView(Table);
            ((DefaultTableCellRenderer)Table.getDefaultRenderer(Object.class)).setOpaque(false);
            
            DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
            dtcr.setOpaque(false);
            
            Table.setBackground(new Color(0, 0, 0, 0));
	}
	public void setHeaderForegroundColor(JTable Table,Color HeadColor){
            JTableHeader Head = Table.getTableHeader();
            Head.setForeground(HeadColor);
        }
        public void ExportTable(JTable Table,String path) throws Exception{
            new WorkbookFactory();
            Workbook wb = new XSSFWorkbook();
            Sheet sheet = wb.createSheet();
            DefaultTableModel model = (DefaultTableModel)Table.getModel();
            Row row = sheet.createRow(model.getRowCount());
            Row FirstRow = sheet.createRow(2);
            Row HeaderRow = sheet.createRow(0);
            for(int i=0;i<model.getColumnCount();i++){
                HeaderRow.createCell(i).setCellValue(model.getColumnName(i));
                
                Object Value = model.getValueAt(0, i);
                if(Value instanceof String){
                    FirstRow.createCell(i).setCellValue(((String)model.getValueAt(0, i)).toString());
                }
                else if(Value instanceof Integer){
                    FirstRow.createCell(i).setCellValue(((Integer)model.getValueAt(0, i)).intValue());
                }
                else if(Value instanceof Double){
                    FirstRow.createCell(i).setCellValue(((Double)model.getValueAt(0, i)).doubleValue());
                }
                else if(Value instanceof Long){
                    FirstRow.createCell(i).setCellValue(((Long)model.getValueAt(0, i)).doubleValue());
                }
                else if(Value instanceof Float){
                    FirstRow.createCell(i).setCellValue(((Float)model.getValueAt(0, i)).floatValue());
                }
            }
            for(int rows=0;rows<model.getRowCount();rows++){
                for(int cols=0;cols<model.getColumnCount();cols++){
                    
                    Object Value = model.getValueAt(rows, cols);
                    if(Value instanceof String){
                        row.createCell(cols).setCellValue(((String)model.getValueAt(rows, cols)).toString());
                    }
                    else if(Value instanceof Integer){
                        row.createCell(cols).setCellValue(((Integer)model.getValueAt(rows, cols)).intValue());
                    }
                    else if(Value instanceof Double){
                        row.createCell(cols).setCellValue(((Double)model.getValueAt(rows, cols)).doubleValue());
                    }
                    else if(Value instanceof Long){
                        row.createCell(cols).setCellValue(((Long)model.getValueAt(rows, cols)).doubleValue());
                    }
                    else if(Value instanceof Float){
                        row.createCell(cols).setCellValue(((Float)model.getValueAt(rows, cols)).floatValue());
                    }
                }
                row = sheet.createRow(rows + 3);
            }
            FileOutputStream out = new FileOutputStream(path);
            wb.write(out);
            out.close();
        }
        
        public void TableAlignment1(JTable Table,int CellAlignment1,int HeaderAlignment){
            DefaultTableCellRenderer dtcr1 = new DefaultTableCellRenderer();
            dtcr1.setHorizontalAlignment(CellAlignment1);
            
            Table.getColumnModel().getColumn(0).setCellRenderer(dtcr1);
            
            TableCellRenderer HeadAlignment = Table.getTableHeader().getDefaultRenderer();
            ((DefaultTableCellRenderer)HeadAlignment).setHorizontalAlignment(HeaderAlignment);
            for(int i=0;i<Table.getColumnModel().getColumnCount();i++){
                Table.getColumnModel().getColumn(i).setHeaderRenderer(HeadAlignment);
            }
        }
        
        public void TableAlignment2(JTable Table,int CellAlignment1,int CellAlignment2,int HeaderAlignment){
            DefaultTableCellRenderer dtcr1 = new DefaultTableCellRenderer();
            dtcr1.setHorizontalAlignment(CellAlignment1);
            DefaultTableCellRenderer dtcr2 = new DefaultTableCellRenderer();
            dtcr2.setHorizontalAlignment(CellAlignment2);
            
            Table.getColumnModel().getColumn(0).setCellRenderer(dtcr1);
            Table.getColumnModel().getColumn(1).setCellRenderer(dtcr2);
            
            TableCellRenderer HeadAlignment = Table.getTableHeader().getDefaultRenderer();
            ((DefaultTableCellRenderer)HeadAlignment).setHorizontalAlignment(HeaderAlignment);
            for(int i=0;i<Table.getColumnModel().getColumnCount();i++){
                Table.getColumnModel().getColumn(i).setHeaderRenderer(HeadAlignment);
            }
        }
        
        public void TableAlignment3(JTable Table,int CellAlignment1,int CellAlignment2,int CellAlignment3,int HeaderAlignment){
            DefaultTableCellRenderer dtcr1 = new DefaultTableCellRenderer();
            dtcr1.setHorizontalAlignment(CellAlignment1);
            DefaultTableCellRenderer dtcr2 = new DefaultTableCellRenderer();
            dtcr2.setHorizontalAlignment(CellAlignment2);
            DefaultTableCellRenderer dtcr3 = new DefaultTableCellRenderer();
            dtcr3.setHorizontalAlignment(CellAlignment3);
            
            Table.getColumnModel().getColumn(0).setCellRenderer(dtcr1);
            Table.getColumnModel().getColumn(1).setCellRenderer(dtcr2);
            Table.getColumnModel().getColumn(2).setCellRenderer(dtcr3);
            
            TableCellRenderer HeadAlignment = Table.getTableHeader().getDefaultRenderer();
            ((DefaultTableCellRenderer)HeadAlignment).setHorizontalAlignment(HeaderAlignment);
            for(int i=0;i<Table.getColumnModel().getColumnCount();i++){
                Table.getColumnModel().getColumn(i).setHeaderRenderer(HeadAlignment);
            }
        }
        
        public void TableAlignment4(JTable Table,int CellAlignment1,int CellAlignment2,int CellAlignment3,int CellAlignment4,int HeaderAlignment){
            DefaultTableCellRenderer dtcr1 = new DefaultTableCellRenderer();
            dtcr1.setHorizontalAlignment(CellAlignment1);
            DefaultTableCellRenderer dtcr2 = new DefaultTableCellRenderer();
            dtcr2.setHorizontalAlignment(CellAlignment2);
            DefaultTableCellRenderer dtcr3 = new DefaultTableCellRenderer();
            dtcr3.setHorizontalAlignment(CellAlignment3);
            DefaultTableCellRenderer dtcr4 = new DefaultTableCellRenderer();
            dtcr4.setHorizontalAlignment(CellAlignment4);
            
            Table.getColumnModel().getColumn(0).setCellRenderer(dtcr1);
            Table.getColumnModel().getColumn(1).setCellRenderer(dtcr2);
            Table.getColumnModel().getColumn(2).setCellRenderer(dtcr3);
            Table.getColumnModel().getColumn(3).setCellRenderer(dtcr4);
            
            TableCellRenderer HeadAlignment = Table.getTableHeader().getDefaultRenderer();
            ((DefaultTableCellRenderer)HeadAlignment).setHorizontalAlignment(HeaderAlignment);
            for(int i=0;i<Table.getColumnModel().getColumnCount();i++){
                Table.getColumnModel().getColumn(i).setHeaderRenderer(HeadAlignment);
            }
        }
        
        public void TableAlignment5(JTable Table,int CellAlignment1,int CellAlignment2,int CellAlignment3,int CellAlignment4,int CellAlignment5,
                int HeaderAlignment){
            DefaultTableCellRenderer dtcr1 = new DefaultTableCellRenderer();
            dtcr1.setHorizontalAlignment(CellAlignment1);
            DefaultTableCellRenderer dtcr2 = new DefaultTableCellRenderer();
            dtcr2.setHorizontalAlignment(CellAlignment2);
            DefaultTableCellRenderer dtcr3 = new DefaultTableCellRenderer();
            dtcr3.setHorizontalAlignment(CellAlignment3);
            DefaultTableCellRenderer dtcr4 = new DefaultTableCellRenderer();
            dtcr4.setHorizontalAlignment(CellAlignment4);
            DefaultTableCellRenderer dtcr5 = new DefaultTableCellRenderer();
            dtcr5.setHorizontalAlignment(CellAlignment5);
            
            Table.getColumnModel().getColumn(0).setCellRenderer(dtcr1);
            Table.getColumnModel().getColumn(1).setCellRenderer(dtcr2);
            Table.getColumnModel().getColumn(2).setCellRenderer(dtcr3);
            Table.getColumnModel().getColumn(3).setCellRenderer(dtcr4);
            Table.getColumnModel().getColumn(4).setCellRenderer(dtcr5);
            
            TableCellRenderer HeadAlignment = Table.getTableHeader().getDefaultRenderer();
            ((DefaultTableCellRenderer)HeadAlignment).setHorizontalAlignment(HeaderAlignment);
            for(int i=0;i<Table.getColumnModel().getColumnCount();i++){
                Table.getColumnModel().getColumn(i).setHeaderRenderer(HeadAlignment);
            }
        }
        
        public void TableAlignment6(JTable Table,int CellAlignment1,int CellAlignment2,int CellAlignment3,int CellAlignment4,int CellAlignment5,
                int CellAlignment6,int HeaderAlignment){
            DefaultTableCellRenderer dtcr1 = new DefaultTableCellRenderer();
            dtcr1.setHorizontalAlignment(CellAlignment1);
            DefaultTableCellRenderer dtcr2 = new DefaultTableCellRenderer();
            dtcr2.setHorizontalAlignment(CellAlignment2);
            DefaultTableCellRenderer dtcr3 = new DefaultTableCellRenderer();
            dtcr3.setHorizontalAlignment(CellAlignment3);
            DefaultTableCellRenderer dtcr4 = new DefaultTableCellRenderer();
            dtcr4.setHorizontalAlignment(CellAlignment4);
            DefaultTableCellRenderer dtcr5 = new DefaultTableCellRenderer();
            dtcr5.setHorizontalAlignment(CellAlignment5);
            DefaultTableCellRenderer dtcr6 = new DefaultTableCellRenderer();
            dtcr6.setHorizontalAlignment(CellAlignment6);
            
            Table.getColumnModel().getColumn(0).setCellRenderer(dtcr1);
            Table.getColumnModel().getColumn(1).setCellRenderer(dtcr2);
            Table.getColumnModel().getColumn(2).setCellRenderer(dtcr3);
            Table.getColumnModel().getColumn(3).setCellRenderer(dtcr4);
            Table.getColumnModel().getColumn(4).setCellRenderer(dtcr5);
            Table.getColumnModel().getColumn(5).setCellRenderer(dtcr6);
            
            TableCellRenderer HeadAlignment = Table.getTableHeader().getDefaultRenderer();
            ((DefaultTableCellRenderer)HeadAlignment).setHorizontalAlignment(HeaderAlignment);
            for(int i=0;i<Table.getColumnModel().getColumnCount();i++){
                Table.getColumnModel().getColumn(i).setHeaderRenderer(HeadAlignment);
            }
        }
        
        public void TableAlignment7(JTable Table,int CellAlignment1,int CellAlignment2,int CellAlignment3,int CellAlignment4,int CellAlignment5,
                int CellAlignment6,int CellAlignment7,int HeaderAlignment){
            DefaultTableCellRenderer dtcr1 = new DefaultTableCellRenderer();
            dtcr1.setHorizontalAlignment(CellAlignment1);
            DefaultTableCellRenderer dtcr2 = new DefaultTableCellRenderer();
            dtcr2.setHorizontalAlignment(CellAlignment2);
            DefaultTableCellRenderer dtcr3 = new DefaultTableCellRenderer();
            dtcr3.setHorizontalAlignment(CellAlignment3);
            DefaultTableCellRenderer dtcr4 = new DefaultTableCellRenderer();
            dtcr4.setHorizontalAlignment(CellAlignment4);
            DefaultTableCellRenderer dtcr5 = new DefaultTableCellRenderer();
            dtcr5.setHorizontalAlignment(CellAlignment5);
            DefaultTableCellRenderer dtcr6 = new DefaultTableCellRenderer();
            dtcr6.setHorizontalAlignment(CellAlignment6);
            DefaultTableCellRenderer dtcr7 = new DefaultTableCellRenderer();
            dtcr7.setHorizontalAlignment(CellAlignment7);
            
            Table.getColumnModel().getColumn(0).setCellRenderer(dtcr1);
            Table.getColumnModel().getColumn(1).setCellRenderer(dtcr2);
            Table.getColumnModel().getColumn(2).setCellRenderer(dtcr3);
            Table.getColumnModel().getColumn(3).setCellRenderer(dtcr4);
            Table.getColumnModel().getColumn(4).setCellRenderer(dtcr5);
            Table.getColumnModel().getColumn(5).setCellRenderer(dtcr6);
            Table.getColumnModel().getColumn(6).setCellRenderer(dtcr7);
            
            TableCellRenderer HeadAlignment = Table.getTableHeader().getDefaultRenderer();
            ((DefaultTableCellRenderer)HeadAlignment).setHorizontalAlignment(HeaderAlignment);
            for(int i=0;i<Table.getColumnModel().getColumnCount();i++){
                Table.getColumnModel().getColumn(i).setHeaderRenderer(HeadAlignment);
            }
        }
        
        public void TableAlignment8(JTable Table,int CellAlignment1,int CellAlignment2,int CellAlignment3,int CellAlignment4,int CellAlignment5,
                int CellAlignment6,int CellAlignment7,int CellAlignment8,int HeaderAlignment){
            DefaultTableCellRenderer dtcr1 = new DefaultTableCellRenderer();
            dtcr1.setHorizontalAlignment(CellAlignment1);
            DefaultTableCellRenderer dtcr2 = new DefaultTableCellRenderer();
            dtcr2.setHorizontalAlignment(CellAlignment2);
            DefaultTableCellRenderer dtcr3 = new DefaultTableCellRenderer();
            dtcr3.setHorizontalAlignment(CellAlignment3);
            DefaultTableCellRenderer dtcr4 = new DefaultTableCellRenderer();
            dtcr4.setHorizontalAlignment(CellAlignment4);
            DefaultTableCellRenderer dtcr5 = new DefaultTableCellRenderer();
            dtcr5.setHorizontalAlignment(CellAlignment5);
            DefaultTableCellRenderer dtcr6 = new DefaultTableCellRenderer();
            dtcr6.setHorizontalAlignment(CellAlignment6);
            DefaultTableCellRenderer dtcr7 = new DefaultTableCellRenderer();
            dtcr7.setHorizontalAlignment(CellAlignment7);
            DefaultTableCellRenderer dtcr8 = new DefaultTableCellRenderer();
            dtcr8.setHorizontalAlignment(CellAlignment8);
            
            Table.getColumnModel().getColumn(0).setCellRenderer(dtcr1);
            Table.getColumnModel().getColumn(1).setCellRenderer(dtcr2);
            Table.getColumnModel().getColumn(2).setCellRenderer(dtcr3);
            Table.getColumnModel().getColumn(3).setCellRenderer(dtcr4);
            Table.getColumnModel().getColumn(4).setCellRenderer(dtcr5);
            Table.getColumnModel().getColumn(5).setCellRenderer(dtcr6);
            Table.getColumnModel().getColumn(6).setCellRenderer(dtcr7);
            Table.getColumnModel().getColumn(7).setCellRenderer(dtcr8);
            
            TableCellRenderer HeadAlignment = Table.getTableHeader().getDefaultRenderer();
            ((DefaultTableCellRenderer)HeadAlignment).setHorizontalAlignment(HeaderAlignment);
            for(int i=0;i<Table.getColumnModel().getColumnCount();i++){
                Table.getColumnModel().getColumn(i).setHeaderRenderer(HeadAlignment);
            }
        }
        public void TableAlignment9(JTable Table,int CellAlignment1,int CellAlignment2,int CellAlignment3,int CellAlignment4,int CellAlignment5,
                int CellAlignment6,int CellAlignment7,int CellAlignment8,int CellAlignment9,int HeaderAlignment){
            DefaultTableCellRenderer dtcr1 = new DefaultTableCellRenderer();
            dtcr1.setHorizontalAlignment(CellAlignment1);
            DefaultTableCellRenderer dtcr2 = new DefaultTableCellRenderer();
            dtcr2.setHorizontalAlignment(CellAlignment2);
            DefaultTableCellRenderer dtcr3 = new DefaultTableCellRenderer();
            dtcr3.setHorizontalAlignment(CellAlignment3);
            DefaultTableCellRenderer dtcr4 = new DefaultTableCellRenderer();
            dtcr4.setHorizontalAlignment(CellAlignment4);
            DefaultTableCellRenderer dtcr5 = new DefaultTableCellRenderer();
            dtcr5.setHorizontalAlignment(CellAlignment5);
            DefaultTableCellRenderer dtcr6 = new DefaultTableCellRenderer();
            dtcr6.setHorizontalAlignment(CellAlignment6);
            DefaultTableCellRenderer dtcr7 = new DefaultTableCellRenderer();
            dtcr7.setHorizontalAlignment(CellAlignment7);
            DefaultTableCellRenderer dtcr8 = new DefaultTableCellRenderer();
            dtcr8.setHorizontalAlignment(CellAlignment8);
            DefaultTableCellRenderer dtcr9 = new DefaultTableCellRenderer();
            dtcr9.setHorizontalAlignment(CellAlignment9);
            
            Table.getColumnModel().getColumn(0).setCellRenderer(dtcr1);
            Table.getColumnModel().getColumn(1).setCellRenderer(dtcr2);
            Table.getColumnModel().getColumn(2).setCellRenderer(dtcr3);
            Table.getColumnModel().getColumn(3).setCellRenderer(dtcr4);
            Table.getColumnModel().getColumn(4).setCellRenderer(dtcr5);
            Table.getColumnModel().getColumn(5).setCellRenderer(dtcr6);
            Table.getColumnModel().getColumn(6).setCellRenderer(dtcr7);
            Table.getColumnModel().getColumn(7).setCellRenderer(dtcr8);
            Table.getColumnModel().getColumn(8).setCellRenderer(dtcr9);
            
            TableCellRenderer HeadAlignment = Table.getTableHeader().getDefaultRenderer();
            ((DefaultTableCellRenderer)HeadAlignment).setHorizontalAlignment(HeaderAlignment);
            for(int i=0;i<Table.getColumnModel().getColumnCount();i++){
                Table.getColumnModel().getColumn(i).setHeaderRenderer(HeadAlignment);
            }
        }
        public void TableAlignment10(JTable Table,int CellAlignment1,int CellAlignment2,int CellAlignment3,int CellAlignment4,int CellAlignment5,
                int CellAlignment6,int CellAlignment7,int CellAlignment8,int CellAlignment9,int CellAlignment10,int HeaderAlignment){
            DefaultTableCellRenderer dtcr1 = new DefaultTableCellRenderer();
            dtcr1.setHorizontalAlignment(CellAlignment1);
            DefaultTableCellRenderer dtcr2 = new DefaultTableCellRenderer();
            dtcr2.setHorizontalAlignment(CellAlignment2);
            DefaultTableCellRenderer dtcr3 = new DefaultTableCellRenderer();
            dtcr3.setHorizontalAlignment(CellAlignment3);
            DefaultTableCellRenderer dtcr4 = new DefaultTableCellRenderer();
            dtcr4.setHorizontalAlignment(CellAlignment4);
            DefaultTableCellRenderer dtcr5 = new DefaultTableCellRenderer();
            dtcr5.setHorizontalAlignment(CellAlignment5);
            DefaultTableCellRenderer dtcr6 = new DefaultTableCellRenderer();
            dtcr6.setHorizontalAlignment(CellAlignment6);
            DefaultTableCellRenderer dtcr7 = new DefaultTableCellRenderer();
            dtcr7.setHorizontalAlignment(CellAlignment7);
            DefaultTableCellRenderer dtcr8 = new DefaultTableCellRenderer();
            dtcr8.setHorizontalAlignment(CellAlignment8);
            DefaultTableCellRenderer dtcr9 = new DefaultTableCellRenderer();
            dtcr9.setHorizontalAlignment(CellAlignment9);
            DefaultTableCellRenderer dtcr10 = new DefaultTableCellRenderer();
            dtcr10.setHorizontalAlignment(CellAlignment10);
            
            Table.getColumnModel().getColumn(0).setCellRenderer(dtcr1);
            Table.getColumnModel().getColumn(1).setCellRenderer(dtcr2);
            Table.getColumnModel().getColumn(2).setCellRenderer(dtcr3);
            Table.getColumnModel().getColumn(3).setCellRenderer(dtcr4);
            Table.getColumnModel().getColumn(4).setCellRenderer(dtcr5);
            Table.getColumnModel().getColumn(5).setCellRenderer(dtcr6);
            Table.getColumnModel().getColumn(6).setCellRenderer(dtcr7);
            Table.getColumnModel().getColumn(7).setCellRenderer(dtcr8);
            Table.getColumnModel().getColumn(8).setCellRenderer(dtcr9);
            Table.getColumnModel().getColumn(9).setCellRenderer(dtcr10);
            
            TableCellRenderer HeadAlignment = Table.getTableHeader().getDefaultRenderer();
            ((DefaultTableCellRenderer)HeadAlignment).setHorizontalAlignment(HeaderAlignment);
            for(int i=0;i<Table.getColumnModel().getColumnCount();i++){
                Table.getColumnModel().getColumn(i).setHeaderRenderer(HeadAlignment);
            }
        }
        
        public void TableAlignment11(JTable Table,int CellAlignment1,int CellAlignment2,int CellAlignment3,int CellAlignment4,int CellAlignment5,
                int CellAlignment6,int CellAlignment7,int CellAlignment8,int CellAlignment9,int CellAlignment10,int CellAlignment11,
                int HeaderAlignment){
            DefaultTableCellRenderer dtcr1 = new DefaultTableCellRenderer();
            dtcr1.setHorizontalAlignment(CellAlignment1);
            DefaultTableCellRenderer dtcr2 = new DefaultTableCellRenderer();
            dtcr2.setHorizontalAlignment(CellAlignment2);
            DefaultTableCellRenderer dtcr3 = new DefaultTableCellRenderer();
            dtcr3.setHorizontalAlignment(CellAlignment3);
            DefaultTableCellRenderer dtcr4 = new DefaultTableCellRenderer();
            dtcr4.setHorizontalAlignment(CellAlignment4);
            DefaultTableCellRenderer dtcr5 = new DefaultTableCellRenderer();
            dtcr5.setHorizontalAlignment(CellAlignment5);
            DefaultTableCellRenderer dtcr6 = new DefaultTableCellRenderer();
            dtcr6.setHorizontalAlignment(CellAlignment6);
            DefaultTableCellRenderer dtcr7 = new DefaultTableCellRenderer();
            dtcr7.setHorizontalAlignment(CellAlignment7);
            DefaultTableCellRenderer dtcr8 = new DefaultTableCellRenderer();
            dtcr8.setHorizontalAlignment(CellAlignment8);
            DefaultTableCellRenderer dtcr9 = new DefaultTableCellRenderer();
            dtcr9.setHorizontalAlignment(CellAlignment9);
            DefaultTableCellRenderer dtcr10 = new DefaultTableCellRenderer();
            dtcr10.setHorizontalAlignment(CellAlignment10);
            DefaultTableCellRenderer dtcr11 = new DefaultTableCellRenderer();
            dtcr11.setHorizontalAlignment(CellAlignment11);
            
            Table.getColumnModel().getColumn(0).setCellRenderer(dtcr1);
            Table.getColumnModel().getColumn(1).setCellRenderer(dtcr2);
            Table.getColumnModel().getColumn(2).setCellRenderer(dtcr3);
            Table.getColumnModel().getColumn(3).setCellRenderer(dtcr4);
            Table.getColumnModel().getColumn(4).setCellRenderer(dtcr5);
            Table.getColumnModel().getColumn(5).setCellRenderer(dtcr6);
            Table.getColumnModel().getColumn(6).setCellRenderer(dtcr7);
            Table.getColumnModel().getColumn(7).setCellRenderer(dtcr8);
            Table.getColumnModel().getColumn(8).setCellRenderer(dtcr9);
            Table.getColumnModel().getColumn(9).setCellRenderer(dtcr10);
            Table.getColumnModel().getColumn(10).setCellRenderer(dtcr11);
            
            TableCellRenderer HeadAlignment = Table.getTableHeader().getDefaultRenderer();
            ((DefaultTableCellRenderer)HeadAlignment).setHorizontalAlignment(HeaderAlignment);
            for(int i=0;i<Table.getColumnModel().getColumnCount();i++){
                Table.getColumnModel().getColumn(i).setHeaderRenderer(HeadAlignment);
            }
        }
        
        public void TableAlignment12(JTable Table,int CellAlignment1,int CellAlignment2,int CellAlignment3,int CellAlignment4,int CellAlignment5,
                int CellAlignment6,int CellAlignment7,int CellAlignment8,int CellAlignment9,int CellAlignment10,int CellAlignment11,
                int CellAlignment12,int HeaderAlignment){
            DefaultTableCellRenderer dtcr1 = new DefaultTableCellRenderer();
            dtcr1.setHorizontalAlignment(CellAlignment1);
            DefaultTableCellRenderer dtcr2 = new DefaultTableCellRenderer();
            dtcr2.setHorizontalAlignment(CellAlignment2);
            DefaultTableCellRenderer dtcr3 = new DefaultTableCellRenderer();
            dtcr3.setHorizontalAlignment(CellAlignment3);
            DefaultTableCellRenderer dtcr4 = new DefaultTableCellRenderer();
            dtcr4.setHorizontalAlignment(CellAlignment4);
            DefaultTableCellRenderer dtcr5 = new DefaultTableCellRenderer();
            dtcr5.setHorizontalAlignment(CellAlignment5);
            DefaultTableCellRenderer dtcr6 = new DefaultTableCellRenderer();
            dtcr6.setHorizontalAlignment(CellAlignment6);
            DefaultTableCellRenderer dtcr7 = new DefaultTableCellRenderer();
            dtcr7.setHorizontalAlignment(CellAlignment7);
            DefaultTableCellRenderer dtcr8 = new DefaultTableCellRenderer();
            dtcr8.setHorizontalAlignment(CellAlignment8);
            DefaultTableCellRenderer dtcr9 = new DefaultTableCellRenderer();
            dtcr9.setHorizontalAlignment(CellAlignment9);
            DefaultTableCellRenderer dtcr10 = new DefaultTableCellRenderer();
            dtcr10.setHorizontalAlignment(CellAlignment10);
            DefaultTableCellRenderer dtcr11 = new DefaultTableCellRenderer();
            dtcr11.setHorizontalAlignment(CellAlignment11);
            DefaultTableCellRenderer dtcr12 = new DefaultTableCellRenderer();
            dtcr12.setHorizontalAlignment(CellAlignment12);
            
            Table.getColumnModel().getColumn(0).setCellRenderer(dtcr1);
            Table.getColumnModel().getColumn(1).setCellRenderer(dtcr2);
            Table.getColumnModel().getColumn(2).setCellRenderer(dtcr3);
            Table.getColumnModel().getColumn(3).setCellRenderer(dtcr4);
            Table.getColumnModel().getColumn(4).setCellRenderer(dtcr5);
            Table.getColumnModel().getColumn(5).setCellRenderer(dtcr6);
            Table.getColumnModel().getColumn(6).setCellRenderer(dtcr7);
            Table.getColumnModel().getColumn(7).setCellRenderer(dtcr8);
            Table.getColumnModel().getColumn(8).setCellRenderer(dtcr9);
            Table.getColumnModel().getColumn(9).setCellRenderer(dtcr10);
            Table.getColumnModel().getColumn(10).setCellRenderer(dtcr11);
            Table.getColumnModel().getColumn(11).setCellRenderer(dtcr12);
            
            TableCellRenderer HeadAlignment = Table.getTableHeader().getDefaultRenderer();
            ((DefaultTableCellRenderer)HeadAlignment).setHorizontalAlignment(HeaderAlignment);
            for(int i=0;i<Table.getColumnModel().getColumnCount();i++){
                Table.getColumnModel().getColumn(i).setHeaderRenderer(HeadAlignment);
            }
        }
        
        public void TableAlignment13(JTable Table,int CellAlignment1,int CellAlignment2,int CellAlignment3,int CellAlignment4,int CellAlignment5,
                int CellAlignment6,int CellAlignment7,int CellAlignment8,int CellAlignment9,int CellAlignment10,int CellAlignment11,
                int CellAlignment12,int CellAlignment13,int HeaderAlignment){
            DefaultTableCellRenderer dtcr1 = new DefaultTableCellRenderer();
            dtcr1.setHorizontalAlignment(CellAlignment1);
            DefaultTableCellRenderer dtcr2 = new DefaultTableCellRenderer();
            dtcr2.setHorizontalAlignment(CellAlignment2);
            DefaultTableCellRenderer dtcr3 = new DefaultTableCellRenderer();
            dtcr3.setHorizontalAlignment(CellAlignment3);
            DefaultTableCellRenderer dtcr4 = new DefaultTableCellRenderer();
            dtcr4.setHorizontalAlignment(CellAlignment4);
            DefaultTableCellRenderer dtcr5 = new DefaultTableCellRenderer();
            dtcr5.setHorizontalAlignment(CellAlignment5);
            DefaultTableCellRenderer dtcr6 = new DefaultTableCellRenderer();
            dtcr6.setHorizontalAlignment(CellAlignment6);
            DefaultTableCellRenderer dtcr7 = new DefaultTableCellRenderer();
            dtcr7.setHorizontalAlignment(CellAlignment7);
            DefaultTableCellRenderer dtcr8 = new DefaultTableCellRenderer();
            dtcr8.setHorizontalAlignment(CellAlignment8);
            DefaultTableCellRenderer dtcr9 = new DefaultTableCellRenderer();
            dtcr9.setHorizontalAlignment(CellAlignment9);
            DefaultTableCellRenderer dtcr10 = new DefaultTableCellRenderer();
            dtcr10.setHorizontalAlignment(CellAlignment10);
            DefaultTableCellRenderer dtcr11 = new DefaultTableCellRenderer();
            dtcr11.setHorizontalAlignment(CellAlignment11);
            DefaultTableCellRenderer dtcr12 = new DefaultTableCellRenderer();
            dtcr12.setHorizontalAlignment(CellAlignment12);
            DefaultTableCellRenderer dtcr13 = new DefaultTableCellRenderer();
            dtcr13.setHorizontalAlignment(CellAlignment13);
            
            Table.getColumnModel().getColumn(0).setCellRenderer(dtcr1);
            Table.getColumnModel().getColumn(1).setCellRenderer(dtcr2);
            Table.getColumnModel().getColumn(2).setCellRenderer(dtcr3);
            Table.getColumnModel().getColumn(3).setCellRenderer(dtcr4);
            Table.getColumnModel().getColumn(4).setCellRenderer(dtcr5);
            Table.getColumnModel().getColumn(5).setCellRenderer(dtcr6);
            Table.getColumnModel().getColumn(6).setCellRenderer(dtcr7);
            Table.getColumnModel().getColumn(7).setCellRenderer(dtcr8);
            Table.getColumnModel().getColumn(8).setCellRenderer(dtcr9);
            Table.getColumnModel().getColumn(9).setCellRenderer(dtcr10);
            Table.getColumnModel().getColumn(10).setCellRenderer(dtcr11);
            Table.getColumnModel().getColumn(11).setCellRenderer(dtcr12);
            Table.getColumnModel().getColumn(12).setCellRenderer(dtcr13);
            
            TableCellRenderer HeadAlignment = Table.getTableHeader().getDefaultRenderer();
            ((DefaultTableCellRenderer)HeadAlignment).setHorizontalAlignment(HeaderAlignment);
            for(int i=0;i<Table.getColumnModel().getColumnCount();i++){
                Table.getColumnModel().getColumn(i).setHeaderRenderer(HeadAlignment);
            }
        }
        
        public void TableAlignment14(JTable Table,int CellAlignment1,int CellAlignment2,int CellAlignment3,int CellAlignment4,int CellAlignment5,
                int CellAlignment6,int CellAlignment7,int CellAlignment8,int CellAlignment9,int CellAlignment10,int CellAlignment11,
                int CellAlignment12,int CellAlignment13,int CellAlignment14,int HeaderAlignment){
            DefaultTableCellRenderer dtcr1 = new DefaultTableCellRenderer();
            dtcr1.setHorizontalAlignment(CellAlignment1);
            DefaultTableCellRenderer dtcr2 = new DefaultTableCellRenderer();
            dtcr2.setHorizontalAlignment(CellAlignment2);
            DefaultTableCellRenderer dtcr3 = new DefaultTableCellRenderer();
            dtcr3.setHorizontalAlignment(CellAlignment3);
            DefaultTableCellRenderer dtcr4 = new DefaultTableCellRenderer();
            dtcr4.setHorizontalAlignment(CellAlignment4);
            DefaultTableCellRenderer dtcr5 = new DefaultTableCellRenderer();
            dtcr5.setHorizontalAlignment(CellAlignment5);
            DefaultTableCellRenderer dtcr6 = new DefaultTableCellRenderer();
            dtcr6.setHorizontalAlignment(CellAlignment6);
            DefaultTableCellRenderer dtcr7 = new DefaultTableCellRenderer();
            dtcr7.setHorizontalAlignment(CellAlignment7);
            DefaultTableCellRenderer dtcr8 = new DefaultTableCellRenderer();
            dtcr8.setHorizontalAlignment(CellAlignment8);
            DefaultTableCellRenderer dtcr9 = new DefaultTableCellRenderer();
            dtcr9.setHorizontalAlignment(CellAlignment9);
            DefaultTableCellRenderer dtcr10 = new DefaultTableCellRenderer();
            dtcr10.setHorizontalAlignment(CellAlignment10);
            DefaultTableCellRenderer dtcr11 = new DefaultTableCellRenderer();
            dtcr11.setHorizontalAlignment(CellAlignment11);
            DefaultTableCellRenderer dtcr12 = new DefaultTableCellRenderer();
            dtcr12.setHorizontalAlignment(CellAlignment12);
            DefaultTableCellRenderer dtcr13 = new DefaultTableCellRenderer();
            dtcr13.setHorizontalAlignment(CellAlignment13);
            DefaultTableCellRenderer dtcr14 = new DefaultTableCellRenderer();
            dtcr14.setHorizontalAlignment(CellAlignment14);
            
            Table.getColumnModel().getColumn(0).setCellRenderer(dtcr1);
            Table.getColumnModel().getColumn(1).setCellRenderer(dtcr2);
            Table.getColumnModel().getColumn(2).setCellRenderer(dtcr3);
            Table.getColumnModel().getColumn(3).setCellRenderer(dtcr4);
            Table.getColumnModel().getColumn(4).setCellRenderer(dtcr5);
            Table.getColumnModel().getColumn(5).setCellRenderer(dtcr6);
            Table.getColumnModel().getColumn(6).setCellRenderer(dtcr7);
            Table.getColumnModel().getColumn(7).setCellRenderer(dtcr8);
            Table.getColumnModel().getColumn(8).setCellRenderer(dtcr9);
            Table.getColumnModel().getColumn(9).setCellRenderer(dtcr10);
            Table.getColumnModel().getColumn(10).setCellRenderer(dtcr11);
            Table.getColumnModel().getColumn(11).setCellRenderer(dtcr12);
            Table.getColumnModel().getColumn(12).setCellRenderer(dtcr13);
            Table.getColumnModel().getColumn(13).setCellRenderer(dtcr14);
            
            TableCellRenderer HeadAlignment = Table.getTableHeader().getDefaultRenderer();
            ((DefaultTableCellRenderer)HeadAlignment).setHorizontalAlignment(HeaderAlignment);
            for(int i=0;i<Table.getColumnModel().getColumnCount();i++){
                Table.getColumnModel().getColumn(i).setHeaderRenderer(HeadAlignment);
            }
        }
        public void TableAlignment15(JTable Table,int CellAlignment1,int CellAlignment2,int CellAlignment3,int CellAlignment4,int CellAlignment5,
                int CellAlignment6,int CellAlignment7,int CellAlignment8,int CellAlignment9,int CellAlignment10,int CellAlignment11,
                int CellAlignment12,int CellAlignment13,int CellAlignment14,int CellAlignment15,int HeaderAlignment){
            DefaultTableCellRenderer dtcr1 = new DefaultTableCellRenderer();
            dtcr1.setHorizontalAlignment(CellAlignment1);
            DefaultTableCellRenderer dtcr2 = new DefaultTableCellRenderer();
            dtcr2.setHorizontalAlignment(CellAlignment2);
            DefaultTableCellRenderer dtcr3 = new DefaultTableCellRenderer();
            dtcr3.setHorizontalAlignment(CellAlignment3);
            DefaultTableCellRenderer dtcr4 = new DefaultTableCellRenderer();
            dtcr4.setHorizontalAlignment(CellAlignment4);
            DefaultTableCellRenderer dtcr5 = new DefaultTableCellRenderer();
            dtcr5.setHorizontalAlignment(CellAlignment5);
            DefaultTableCellRenderer dtcr6 = new DefaultTableCellRenderer();
            dtcr6.setHorizontalAlignment(CellAlignment6);
            DefaultTableCellRenderer dtcr7 = new DefaultTableCellRenderer();
            dtcr7.setHorizontalAlignment(CellAlignment7);
            DefaultTableCellRenderer dtcr8 = new DefaultTableCellRenderer();
            dtcr8.setHorizontalAlignment(CellAlignment8);
            DefaultTableCellRenderer dtcr9 = new DefaultTableCellRenderer();
            dtcr9.setHorizontalAlignment(CellAlignment9);
            DefaultTableCellRenderer dtcr10 = new DefaultTableCellRenderer();
            dtcr10.setHorizontalAlignment(CellAlignment10);
            DefaultTableCellRenderer dtcr11 = new DefaultTableCellRenderer();
            dtcr11.setHorizontalAlignment(CellAlignment11);
            DefaultTableCellRenderer dtcr12 = new DefaultTableCellRenderer();
            dtcr12.setHorizontalAlignment(CellAlignment12);
            DefaultTableCellRenderer dtcr13 = new DefaultTableCellRenderer();
            dtcr13.setHorizontalAlignment(CellAlignment13);
            DefaultTableCellRenderer dtcr14 = new DefaultTableCellRenderer();
            dtcr14.setHorizontalAlignment(CellAlignment14);
            DefaultTableCellRenderer dtcr15 = new DefaultTableCellRenderer();
            dtcr15.setHorizontalAlignment(CellAlignment15);
            
            Table.getColumnModel().getColumn(0).setCellRenderer(dtcr1);
            Table.getColumnModel().getColumn(1).setCellRenderer(dtcr2);
            Table.getColumnModel().getColumn(2).setCellRenderer(dtcr3);
            Table.getColumnModel().getColumn(3).setCellRenderer(dtcr4);
            Table.getColumnModel().getColumn(4).setCellRenderer(dtcr5);
            Table.getColumnModel().getColumn(5).setCellRenderer(dtcr6);
            Table.getColumnModel().getColumn(6).setCellRenderer(dtcr7);
            Table.getColumnModel().getColumn(7).setCellRenderer(dtcr8);
            Table.getColumnModel().getColumn(8).setCellRenderer(dtcr9);
            Table.getColumnModel().getColumn(9).setCellRenderer(dtcr10);
            Table.getColumnModel().getColumn(10).setCellRenderer(dtcr11);
            Table.getColumnModel().getColumn(11).setCellRenderer(dtcr12);
            Table.getColumnModel().getColumn(12).setCellRenderer(dtcr13);
            Table.getColumnModel().getColumn(13).setCellRenderer(dtcr14);
            Table.getColumnModel().getColumn(14).setCellRenderer(dtcr15);
            
            TableCellRenderer HeadAlignment = Table.getTableHeader().getDefaultRenderer();
            ((DefaultTableCellRenderer)HeadAlignment).setHorizontalAlignment(HeaderAlignment);
            for(int i=0;i<Table.getColumnModel().getColumnCount();i++){
                Table.getColumnModel().getColumn(i).setHeaderRenderer(HeadAlignment);
            }
        }
}
