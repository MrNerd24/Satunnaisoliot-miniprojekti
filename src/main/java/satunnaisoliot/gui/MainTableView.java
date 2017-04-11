
package satunnaisoliot.gui;

import javax.swing.table.TableModel;
import satunnaisoliot.datastructures.database.Dao;

public class MainTableView extends javax.swing.JTable {

    private Dao dao;
    private TableModel tablemodel;

    public MainTableView(Dao dao) {
        super(new ReferenceTable(dao));
        this.dao = dao;
        System.out.println("MainTableView created");

    }

}
