
package satunnaisoliot.gui;

import java.util.List;
import java.util.Locale;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import satunnaisoliot.datastructures.database.Dao;
import satunnaisoliot.datastructures.enums.FieldType;
import satunnaisoliot.datastructures.interfaces.Reference;

public class ReferenceTable extends AbstractTableModel {

    private Dao dao;
    private static final String[] dbColumns = {
        "reference_type",
        "bibtex_key",
        "address",
        "annote",
        "author",
        "booktitle",
        "chapter",
        "crossref",
        "edition",
        "editor",
        "howpublished",
        "institution",
        "journal",
        "bibkey",
        "month",
        "note",
        "number",
        "organization",
        "pages",
        "publisher",
        "school",
        "series",
        "title",
        "type",
        "volume",
        "year",
    };

    private static final String[] guiColumns = {
        "Type",
        "Key",
        "Publisher's address",
        "Annotation",
        "Author",
        "Book title",
        "Chapter",
        "Crossref key",
        "Edition",
        "Editor",
        "How published",
        "Institution",
        "Journal",
        "Sort key",
        "Month",
        "Note",
        "Number",
        "Organization",
        "Pages",
        "Publisher",
        "School",
        "Series",
        "Title",
        "Type",
        "Volume",
        "Year",
    };

    List<Reference> referenceList;

    public ReferenceTable(Dao dao) {
        this.dao = dao;
        updateReferenceList();
    }

    private void updateReferenceList() {
        this.referenceList = dao.findAll();
    }

    @Override
    public int getRowCount() {
        return dao.rowcount();
    }

    @Override
    public int getColumnCount() {
        return dbColumns.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return dbColumns[columnIndex];
        //return guiColumns[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        // screw it for now
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Reference ref = referenceList.get(rowIndex);
        String colToGet = dbColumns[columnIndex];
        String colNameAsEnumName = colToGet.toUpperCase(Locale.ROOT);
        FieldType ft = FieldType.valueOf(colNameAsEnumName);
        String fieldValue = ref.getField(ft);
        return fieldValue;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}
