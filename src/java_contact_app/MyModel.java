/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_contact_app;

import javax.swing.Icon;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Administrator
 */
public class MyModel extends AbstractTableModel {

    private String[] columns;
    private Object[][] rows;

    public MyModel() {
    }

    public MyModel(Object[][] data, String[] columnsName) {
        this.columns = columnsName;
        this.rows = data;
    }

    public Class getColumnclass (int col){
        if (col == 8) {
            return Icon.class;
        }
        else {
            return getValueAt(0, col).getClass();
        }
    }

    @Override
    public int getRowCount() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getColumnCount() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
