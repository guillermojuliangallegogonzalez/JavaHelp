package javaayuda;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.net.URL;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenuBar;
import javax.swing.KeyStroke;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.URL;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;


public class JavaAyuda implements ActionListener, ItemListener {

    JTextArea output;
    JScrollPane scrollPane;
    String newline = "\n";

    public JMenuBar createMenuBar() {
        JMenuBar menuBar;
        JMenu menu, submenu;
        JMenuItem menuItem, menuItem2,menuItem3, menuItem4,menuItem5;
        JRadioButtonMenuItem rbMenuItem;
        JCheckBoxMenuItem cbMenuItem;

        //Create the menu bar.
        menuBar = new JMenuBar();
        HelpSet hs = obtenFicAyuda();
        HelpBroker hb = hs.createHelpBroker();

        //Build the first menu.
        menu = new JMenu("Ayuda");
        menu.setMnemonic(KeyEvent.VK_A);
        menuBar.add(menu);

        //a group of JMenuItems
        menuItem = new JMenuItem("Home Ayuda",
                KeyEvent.VK_T);
        menuItem2 = new JMenuItem("General");
        menuItem3 = new JMenuItem("Alumnos");
        menuItem4 = new JMenuItem("Curso");
        menuItem5 = new JMenuItem("Matricula");
        //menuItem.setMnemonic(KeyEvent.VK_T); //used constructor instead
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));

        hb.enableHelpOnButton(menuItem,"top",hs);
        hb.enableHelpOnButton(menuItem2,"general",hs);
        hb.enableHelpOnButton(menuItem3,"alumnos",hs);
        hb.enableHelpOnButton(menuItem4,"curso",hs);
        hb.enableHelpOnButton(menuItem5,"matricula",hs);

        menu.add(menuItem);
        menu.add(menuItem2);
        menu.add(menuItem3);
        menu.add(menuItem4);
        menu.add(menuItem5);

        //a group of radio button menu items
        return menuBar;
    }

    public HelpSet obtenFicAyuda() {
        try {
            ClassLoader cl = JavaAyuda.class.getClassLoader();
            File file = new File(JavaAyuda.class.getResource("../help/HelpSet.hs").getFile());
            URL url = file.toURI().toURL();
            // crea un objeto Helpset
            HelpSet hs = new HelpSet(null, url);
            return hs;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Fichero HelpSet no encontrado");
            return null;
        }
    }

    public Container createContentPane() {
        //Create the content-pane-to-be.
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setOpaque(true);

        //Create a scrolled text area.
        output = new JTextArea(5, 30);
        output.setEditable(false);
        scrollPane = new JScrollPane(output);

        //Add the text area to the content pane.
        contentPane.add(scrollPane, BorderLayout.CENTER);

        return contentPane;
    }

    // Returns just the class name -- no package info.
    protected String getClassName(Object o) {
        String classString = o.getClass().getName();
        int dotIndex = classString.lastIndexOf(".");
        return classString.substring(dotIndex + 1);
    }

    /**
     * Create the GUI and show it. For thread safety, this method should be
     * invoked from the event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("JavaHelp");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        JavaAyuda demo = new JavaAyuda();
        frame.setJMenuBar(demo.createMenuBar());
        frame.setContentPane(demo.createContentPane());

        //Display the window.
        frame.setSize(450, 260);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

