/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Logic.Exercise;
import Storage.Memory;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.EnumSet;

/**
 *
 * @author Lennard
 */
public class Frame extends javax.swing.JFrame {

    //read data from file, create GUI maincomponent
    private Frame() {
        Memory.ReadMapFromFile();
        initComponents();
    }

    //initialize components
    private void initComponents() {
        
        jTabbedPane1 = new javax.swing.JTabbedPane();
        
        //iterate over enumclass Exercise and create a panel for each
        EnumSet.allOf(Exercise.class)
                .forEach(ex -> jTabbedPane1.add(ex + "", new Panel(ex)));

        //layout
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        //save changes of the Map to the file when closing the window
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                Memory.WriteMapToFile();
                System.exit(0);
            }
        });

        pack();

    }

    public static void main(String args[]) {


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Frame().setVisible(true);
        });

    }

    //variable declaration
    private javax.swing.JTabbedPane jTabbedPane1;

}
