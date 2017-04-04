package ui;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import static javax.swing.GroupLayout.DEFAULT_SIZE;
import javax.swing.JComponent;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

public class UI extends JFrame implements UserInterface {

    private JTextArea textField;
    private JPanel panel;
    private String text;

    public UI() {
        createMenuButtons();
        createTextWindow();
        setWindowProperties();
    }

    private void setWindowProperties() {
        this.setTitle("viiteohjelma");
        this.setSize(500, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        EventQueue.invokeLater(() -> this.setVisible(true));
    }

    private void createTextWindow() {
        panel = (JPanel) getContentPane();

        //kenttä johon voi lisää tekstiä jne
        textField = new JTextArea();
        JScrollPane spane = new JScrollPane();
        spane.getViewport().add(textField);
        JToolBar toolbar = new JToolBar();
        createLayout(toolbar, spane);
    }

    public void setTextOnWindow(String text) {
        this.text = text;
        textField.setText(text);
    }

    public String getTextFromWindow() {
        return textField.getText();
    }

    public void addTextOnWindow(String text) {
        textField.append(text);
    }

    public void clearTextWindow() {
        textField.setText(null);
    }

    private void createMenuButtons() {
        //lisätään valikkopalkki..
        JMenuBar menubar = new JMenuBar();

        //luodaan eka valikkonappula
        JMenu fileMenu = new JMenu("Tiedosto"); //nappulan nimi..
        //tiedostonappulan alle seuraavat
        JMenuItem newItem = new JMenuItem("Uusi");
        JMenuItem openItem = new JMenuItem("Avaa");
        JMenuItem saveItem = new JMenuItem("Tallenna");
        JMenuItem exitItem = new JMenuItem("Lopeta");

        //määritellään nappuloiden toiminnot
        //kokeiluna lisäilty ja poistettu tekstiä teksti-ikkunasta jne
        newItem.addActionListener((ActionEvent event) -> {

        });

        openItem.addActionListener((ActionEvent event) -> {

        });

        saveItem.addActionListener((ActionEvent event) -> {

        });

        exitItem.addActionListener((ActionEvent event) -> {
            System.exit(0);
        });
        //lisätään nappulat tiedostonappulan alle
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);
        //lisätään tiedostonappula valikkopalkkiin
        menubar.add(fileMenu);

        //Luodaan toinen valikkonappula
        JMenu referenceMenu = new JMenu("Viite");

        JMenu newRef = new JMenu("Luo uusi viite");
        JMenuItem typARef = new JMenuItem("Luo tyypin A-viite");
        JMenuItem typBRef = new JMenuItem("Luo tyypin B-viite");
        newRef.add(typARef);
        newRef.add(typBRef);

        JMenuItem delRef = new JMenuItem("Poista viite");

        //määritellään nappuloiden toiminnot
        newRef.addActionListener((ActionEvent event) -> {

        });

        typARef.addActionListener((ActionEvent event) -> {
            //this.addTextOnWindow("New type A reference \n");
        });

        typBRef.addActionListener((ActionEvent event) -> {
            //this.addTextOnWindow("New type B reference \n");
        });

        referenceMenu.add(newRef);
        referenceMenu.add(delRef);

        menubar.add(referenceMenu);

        //lisätään kolmas nappula palkkiin
        JMenu exportMenu = new JMenu("Vie BibTeX");
        //nappulalle toiminnot
        exportMenu.addActionListener((ActionEvent event) -> {

        });
        menubar.add(exportMenu);

        setJMenuBar(menubar);

    }

    private void createLayout(JComponent... arg) {

        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setHorizontalGroup(gl.createParallelGroup()
                .addComponent(arg[0], DEFAULT_SIZE, DEFAULT_SIZE,
                        Short.MAX_VALUE)
                .addGroup(gl.createSequentialGroup()
                        .addComponent(arg[1]))
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
                .addGap(4)
                .addComponent(arg[1])
        );

        pack();
    }

}
