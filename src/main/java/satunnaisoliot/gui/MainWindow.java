package satunnaisoliot.gui;

import java.awt.Dimension;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import satunnaisoliot.structs.interfaces.Reference;
import satunnaisoliot.util.DataManager;
import satunnaisoliot.util.SqlDatastore;
import satunnaisoliot.util.MessageListener;
import satunnaisoliot.util.PostOffice;


public class MainWindow extends javax.swing.JFrame
        implements MessageListener {

    /**
     * Creates new form MainWindow
     */
    public MainWindow() {

        PostOffice.register(this, "reference added");

        this.setMinimumSize(new Dimension(200, 80));
        this.setPreferredSize(new Dimension(1024, 500));

        datastore = DataManager.getSqlDatastore();
        tableModel = new ReferenceTable(DataManager.getDao());

        initComponents();
    }

    private javax.swing.JButton addButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton exportButton;
    private javax.swing.JButton importButton;
    private javax.swing.JButton refreshButton;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar mainToolbar;
    private javax.swing.JButton newFileButton;
    private javax.swing.JButton openButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JScrollPane tableScroller;
    private JTable mainTable; // tableModel has to be created before mainTable
    private final ReferenceTable tableModel;
    private SqlDatastore datastore;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="initComponents()">
    private void initComponents() {

        mainToolbar = new javax.swing.JToolBar();
        openButton = new javax.swing.JButton();
        newFileButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        importButton = new javax.swing.JButton();
        exportButton = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        searchButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ReferenceManager");

        mainToolbar.setRollover(true);

        openButton.setText("Open File");
        openButton.setFocusable(false);
        openButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        openButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        openButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openButtonActionPerformed(evt);
            }
        });
        mainToolbar.add(openButton);

        newFileButton.setText("New File");
        newFileButton.setFocusable(false);
        newFileButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        newFileButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        newFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newFileButtonActionPerformed(evt);
            }
        });
        mainToolbar.add(newFileButton);
        mainToolbar.add(jSeparator1);

        addButton.setText("Add Reference");
        addButton.setName("AddButton");
        addButton.setToolTipText("Create a new reference in the table.");
        addButton.setFocusable(false);
        addButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        mainToolbar.add(addButton);

        deleteButton.setText("Delete Selected");
        deleteButton.setName("DeleteButton");
        deleteButton.setToolTipText("Delete selected references without warning.");
        deleteButton.setFocusable(false);
        deleteButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        deleteButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        mainToolbar.add(deleteButton);
        mainToolbar.add(jSeparator2);

        importButton.setText("Import...");
        importButton.setFocusable(false);
        importButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        importButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        importButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importButtonActionPerformed(evt);
            }
        });
        mainToolbar.add(importButton);

        exportButton.setText("Export...");
        exportButton.setName("ExportButton");
        exportButton.setToolTipText("Export all references into a BibTex file");
        exportButton.setFocusable(false);
        exportButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        exportButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        exportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportButtonActionPerformed(evt);
            }
        });
        mainToolbar.add(exportButton);
        mainToolbar.add(jSeparator3);

        searchButton.setText("Search...");
        searchButton.setFocusable(false);
        searchButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        searchButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        mainToolbar.add(searchButton);

        refreshButton.setText("Refresh");
        refreshButton.setFocusable(false);
        refreshButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        refreshButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });
        mainToolbar.add(refreshButton);

        getContentPane().add(mainToolbar, java.awt.BorderLayout.PAGE_START);

        mainTable = new JTable(tableModel);
        mainTable.setFillsViewportHeight(true);

        /*for (int i = 0; i < tableModel.getColumnCount(); i++) {
            TableColumn col = mainTable.getColumnModel().getColumn(i);
            col.setPreferredWidth(40);
        }*/

        tableScroller = new javax.swing.JScrollPane(mainTable);
        tableScroller.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        tableScroller.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        getContentPane().add(tableScroller, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>

    private void importButtonActionPerformed(java.awt.event.ActionEvent evt) {
        showUnimplementedFeatureMessageBox();
    }

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {
        showUnimplementedFeatureMessageBox();
    }

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {
        this.updateDataTable();
    }

    private void newFileButtonActionPerformed(java.awt.event.ActionEvent evt) {
        showUnimplementedFeatureMessageBox();
    }

    private void openButtonActionPerformed(java.awt.event.ActionEvent evt) {
        showUnimplementedFeatureMessageBox();
    }

    private void exportButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // Export-ikkunan luonti.
        new ExportTexWindow().setVisible(true);
    }

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // Tietueenlisäysikkunan luonti.
        TypeSelectionWindow w = new TypeSelectionWindow(datastore);
        w.setVisible(true);
    }

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {
        List<Reference> selectedReferences = this.tableModel.getSelectedReferences();
        for (Reference ref : selectedReferences) {
            //System.out.println("Deleting reference " + ref);
            DataManager.getDao().deleteReference(ref);
        }
        this.updateDataTable();
    }

    private void showUnimplementedFeatureMessageBox() {
        JOptionPane.showMessageDialog(rootPane, "This feature is unimplemented.");
    }

    // Call this method after creating/deleting/modifying data.
    public void updateDataTable() {
        this.tableModel.updateReferenceList();
        this.repaint();
    }

    @Override
    public void receiveMessage(String message) {
        updateDataTable();
    }

}
