package ui;

import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class UI extends JFrame {

    public UI() {
        createMenuButtons();

    }

    private void createMenuButtons() {
        JMenuBar menubar = new JMenuBar();
        JMenu fileMenu = new JMenu("Tiedosto");

        JMenuItem newItem = new JMenuItem("Uusi");
        JMenuItem openItem = new JMenuItem("Avaa");
        JMenuItem saveItem = new JMenuItem("Tallenna");
        JMenuItem exitItem = new JMenuItem("Lopeta");

        //what happens when item is clicked
        exitItem.addActionListener((ActionEvent event) -> {
            System.exit(0);
        });

        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);

        menubar.add(fileMenu);

        JMenu referenceMenu = new JMenu("Viite");

        JMenu newRef = new JMenu("Luo uusi viite");
        JMenuItem typARef = new JMenuItem("Luo tyypin A-viite");
        JMenuItem typBRef = new JMenuItem("Luo tyypin B-viite");
        newRef.add(typARef);
        newRef.add(typBRef);

        JMenuItem delRef = new JMenuItem("Poista viite");

        newRef.addActionListener((ActionEvent event) -> {
            //probably creates something...
        });

        typARef.addActionListener((ActionEvent event) -> {
            //does something...
        });

        typBRef.addActionListener((ActionEvent event) -> {
            //does something...
        });

        referenceMenu.add(newRef);
        referenceMenu.add(delRef);

        menubar.add(referenceMenu);

        JMenu exportMenu = new JMenu("Vie BibTeX");

        exportMenu.addActionListener((ActionEvent event) -> {
            //exportation..
        });
        menubar.add(exportMenu);

        setJMenuBar(menubar);

    }

}
