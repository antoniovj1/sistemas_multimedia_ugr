/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

/**
 *
 * @author antonio
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jSlider1 = new javax.swing.JSlider();
        jToggleButton1 = new javax.swing.JToggleButton();
        jSpinner1 = new javax.swing.JSpinner();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jSplitPane2 = new javax.swing.JSplitPane();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTree2 = new javax.swing.JTree();

        jScrollPane1.setViewportView(jTree1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jSlider1.setMaximum(80);
        jSlider1.setMinimum(10);
        getContentPane().add(jSlider1, java.awt.BorderLayout.PAGE_START);

        jToggleButton1.setBackground(new java.awt.Color(139, 144, 240));
        jToggleButton1.setText(" Toggle Button");
        getContentPane().add(jToggleButton1, java.awt.BorderLayout.PAGE_END);

        jSpinner1.setModel(new javax.swing.SpinnerDateModel());
        getContentPane().add(jSpinner1, java.awt.BorderLayout.LINE_END);

        jButton2.setText("jButton2");
        jPanel1.add(jButton2);

        jButton3.setText("jButton3");
        jPanel1.add(jButton3);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jTabbedPane2.addTab("tab1", jPanel3);

        jPanel4.add(jSplitPane2);

        jTabbedPane2.addTab("tab2", jPanel4);

        jScrollPane2.setViewportView(jTree2);

        jPanel5.add(jScrollPane2);

        jTabbedPane2.addTab("tab3", jPanel5);

        getContentPane().add(jTabbedPane2, java.awt.BorderLayout.LINE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTree jTree1;
    private javax.swing.JTree jTree2;
    // End of variables declaration//GEN-END:variables
}
