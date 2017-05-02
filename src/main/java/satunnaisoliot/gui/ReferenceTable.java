package satunnaisoliot.gui;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import satunnaisoliot.structs.dao.Dao;
import satunnaisoliot.structs.enums.FieldType;
import satunnaisoliot.structs.enums.ReferenceType;
import satunnaisoliot.structs.interfaces.Reference;

public final class ReferenceTable extends AbstractTableModel {

    private Dao dao;
    private static final String[] dbColumns = {
        "selected",
        "reference_type",
        "bibtex_key",
//      "address",
//      "annote",
        "author",
//      "booktitle",
//      "chapter",
//      "crossref",
//      "edition",
        "editor",
//      "howpublished",
//      "institution",
        "journal",
        "bibkey",
//      "month",
//      "note",
//      "number",
//      "organization",
//      "pages",
        "publisher",
//      "school",
//      "series",
        "title",
//      "type",
//      "volume",
        "year",
    };

    // This can be used to have one set of column names for accessing the
    // reference data, and another set of names to display to the user.
    // The order 0f both arrays has to remain the same.
    private static final String[] guiColumns = {
        "Select",
        "Type",
        "Key",
//      "Publisher's address",
//      "Annotation",
        "Author",
//      "Book title",
//      "Chapter",
//      "Crossref key",
//      "Edition",
        "Editor",
//      "How published",
//      "Institution",
        "Journal",
        "Sort as",
//      "Month",
//      "Note",
//      "Number",
//      "Organization",
//      "Pages",
        "Publisher",
//      "School",
//      "Series",
        "Title",
//      "Type",
//      "Volume",
        "Year",
    };

    List<Reference> referenceList;
    ArrayList<Boolean> selectedReferences;

    public ReferenceTable(Dao dao) {
        this.dao = dao;
        selectedReferences = new ArrayList();
        updateReferenceList();
    }

    public void updateReferenceList() {
        this.referenceList = dao.findAll();
        int refcount = referenceList.size();
        selectedReferences.ensureCapacity(refcount);
        for (int i = 0; i < refcount; i++) {
            selectedReferences.add(i, Boolean.FALSE);
        }
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
        //return dbColumns[columnIndex];
        return guiColumns[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 0) return Boolean.class;
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 0;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Reference ref = referenceList.get(rowIndex);
        String fieldToGet = dbColumns[columnIndex];

        if (fieldToGet.equals("selected")) {
            return selectedReferences.get(rowIndex);
        } else if (fieldToGet.equals("reference_type")) {
            ReferenceType reftype = ref.getType();
            return reftype.toString();
        } else if (fieldToGet.equals("bibtex_key")) {
            return ref.getBibTexKey();
        } else if (fieldToGet.equals("bibkey")) {
            FieldType ft = FieldType.valueOf("KEY");
            return ref.getField(ft);
        } else {
            String fieldNameAsEnumName = fieldToGet.toUpperCase(Locale.ROOT);
            FieldType ft = FieldType.valueOf(fieldNameAsEnumName);
            String fieldValue = ref.getField(ft);
            return fieldValue;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            if (aValue.getClass() == Boolean.class) {
                Boolean b = (Boolean) aValue;
                selectedReferences.set(rowIndex, b);
            }
        }
    }

    public List<Reference> getSelectedReferences() {
        LinkedList<Reference> selectedRefs = new LinkedList();
        for (int i = 0; i < referenceList.size(); i++) {
            if (selectedReferences.get(i)) {
                selectedRefs.add(referenceList.get(i));
            }
        }
        return selectedRefs;
    }

}
