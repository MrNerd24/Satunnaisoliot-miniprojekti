package satunnaisoliot.gui;

import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import satunnaisoliot.util.DataManager;
import satunnaisoliot.util.SqlDatastore;

public class MainWindow extends javax.swing.JFrame {

    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        System.out.println("MainWindow is valid: " + this.isValid());
        this.setMinimumSize(new Dimension(300, 300));
        initComponents();
        System.out.println("MainWindow is valid: " + this.isValid());
        datastore = DataManager.getSqlDatastore();
        tableModel = new ReferenceTable(DataManager.getReferenceDao());
        
        mainTable = new JTable(tableModel);
        mainTable.setPreferredScrollableViewportSize(new Dimension(500, 70));
        mainTable.setFillsViewportHeight(true);
        System.out.println("Created mainTable");
        System.out.println("MainWindow is valid: " + this.isValid());
        tableScroller.add(mainTable);
        System.out.println("Added mainTable to tableScroller");
        System.out.println("MainWindow is valid: " + this.isValid());
        System.out.println("mainTable is visible: " + mainTable.isVisible());
        
        this.revalidate();
        System.out.println("Revalidated");
        System.out.println("MainWindow is valid: " + this.isValid());
        System.out.println("mainTable is valid: " + mainTable.isValid());
        System.out.println("tableScroller is valid: " + tableScroller.isValid());
        System.out.println("mainTable is visible: " + mainTable.isVisible());
        
        System.out.println("tableModel columns: " + tableModel.getColumnCount());
        System.out.println("tableModel rows: " + tableModel.getRowCount());
    }

    private javax.swing.JButton addButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton exportButton;
    private javax.swing.JButton importButton;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar mainToolbar;
    private javax.swing.JButton newFileButton;
    private javax.swing.JButton openButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JScrollPane tableScroller;
    private JTable mainTable;
    private ReferenceTable tableModel;
    private SqlDatastore datastore;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
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
        tableScroller = new javax.swing.JScrollPane();

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

        addButton.setText("Add Ref");
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

        deleteButton.setText("Delete");
        deleteButton.setToolTipText("Delete a selected reference");
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

        getContentPane().add(mainToolbar, java.awt.BorderLayout.PAGE_START);

        tableScroller.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        tableScroller.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        tableScroller.setViewportBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(tableScroller, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>

    private void importButtonActionPerformed(java.awt.event.ActionEvent evt) {
        showUnimplementedFeatureMessageBox();
    }

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {
        showUnimplementedFeatureMessageBox();
    }

    private void newFileButtonActionPerformed(java.awt.event.ActionEvent evt) {
        showUnimplementedFeatureMessageBox();
    }

    private void openButtonActionPerformed(java.awt.event.ActionEvent evt) {
        showUnimplementedFeatureMessageBox();
    }

    private void exportButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // Export-ikkunan luonti.
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ExportTexWindow().setVisible(true);
            }
        });
    }

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // Tietueenlisäysikkunan luonti.
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SelectReferenceTypeWin(datastore).setVisible(true);
            }
        });
    }

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {
        showUnimplementedFeatureMessageBox();
    }

    private void showUnimplementedFeatureMessageBox() {
        JOptionPane.showMessageDialog(rootPane, "This feature is unimplemented.");
    }

}

