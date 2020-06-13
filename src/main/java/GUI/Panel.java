package GUI;

import Storage.Memory;
import Logic.Exercise;
import Logic.Compute;

/**
 * @author Lennard
 * creates a panel for the tabbed panel, including table, buttons, labels and textboxes
 */
public class Panel extends javax.swing.JPanel {

    /**
     * Creates new Panel, sets exercise
     */
    public Panel(Exercise ex) {
        this.ex = ex;
        initComponents(ex);
    }

    @SuppressWarnings("unchecked")
    private void initComponents(Exercise ex) {

        jLabel2 = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        weightInText = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        //labels
        jLabel1.setText("Absolute Intensity");
        jLabel2.setText("Weight:");
        jLabel3.setText("Relative Intensity");

        //buttons
        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        //table
        setupTable(jTable1, ex);
        jTable1.setShowHorizontalLines(false);
        jTable1.setShowVerticalLines(false);

        jScrollPane1.setViewportView(jTable1);

        //textfield
        weightInText.setText(Double.toString(Memory.instance().getWeight(ex)));

        //layout
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(this);
        this.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 812, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(weightInText, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(26, 26, 26)
                                                .addComponent(saveButton))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(50, 50, 50)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(saveButton)
                                        .addComponent(weightInText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                                        .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

    }

    /*
    *create a table with 12 columns: percentage, weight and reps from 10 to 1
     */
    private void setupTable(javax.swing.JTable table, Exercise ex) {
        table.setModel(new javax.swing.table.DefaultTableModel(
                Compute.instance().computeTablePercentages(Memory.instance().getWeight(ex)),
                new String[]{
                    "Percentage", "Weight", "10Rep", "9Rep", "8Rep", "7Rep", "6Rep", "5Rep", "4Rep", "3Rep", "2Rep", "1Rep",}
        ) {

            Class[] types = new Class[]{
                java.lang.Object.class, java.lang.Object.class,
                java.lang.Object.class, java.lang.Object.class,
                java.lang.Object.class, java.lang.Object.class,
                java.lang.Object.class, java.lang.Object.class,
                java.lang.Object.class, java.lang.Object.class,
                java.lang.Object.class, java.lang.Object.class
            };

        });
    }

    /*
    *save value from textbox and trigger refresh table TO DO: table listens to button
     */
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {

        if (weightInText.getText() != null) {
            Memory.instance().setWeight(ex, Double.valueOf(weightInText.getText()));
            this.setupTable(jTable1, ex);

        }
    }

    /*
    *variable declaration
     */
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField weightInText;
    private Exercise ex;
}
