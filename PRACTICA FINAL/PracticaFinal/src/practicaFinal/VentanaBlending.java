/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaFinal;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import sm.image.BlendOp;

/**
 *
 * @author antonio
 */
public class VentanaBlending extends VentanaInterna {

    private final VentanaPrincipal ventanaPadre = null;
    private BufferedImage imgIzq;
    private BufferedImage imgDer;
    private boolean mezcladoFinalizado;

    /**
     * Creates new form VentanaBlending
     *
     * @param ventanaPadre
     */
    public VentanaBlending(VentanaPrincipal ventanaPadre) {
        super(ventanaPadre);
        mezcladoFinalizado = false;
         
        /**
         * @TODO Preguntar si hay una solución más simple
         * @see http://chuwiki.chuidiang.org/index.php?title=FocusListener_y_FocusAdapter
         * @see https://docs.oracle.com/javase/tutorial/uiswing/components/rootpane.html
         */
        this.getContentPane().addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent evt) {
                if (evt.getOppositeComponent() != ventanaPadre.sliderBend) {
                    finMezclado();
                }
            }
        });
    }

    public void setImages(BufferedImage img_izq, BufferedImage img_der) {
        this.imgIzq = img_izq;
        this.imgDer = img_der;
    }

    public void mezclar(float m) {
        BlendOp op = new BlendOp(imgIzq, m);
        BufferedImage imgdest = op.filter(imgDer, null);
        super.getLienzo().setImage(imgdest);
        repaint();
    }

    public void finMezclado() {
        imgDer = null;
        imgIzq = null;
        this.setTitle("Mezclado");
        mezcladoFinalizado = true;
        repaint();
    }

    public boolean isMezcladoFinalizado() {
        return mezcladoFinalizado;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lienzo = new sm.avj.ui.Lienzo2DImagen();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        lienzo.setFocusable(false);

        javax.swing.GroupLayout lienzoLayout = new javax.swing.GroupLayout(lienzo);
        lienzo.setLayout(lienzoLayout);
        lienzoLayout.setHorizontalGroup(
            lienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );
        lienzoLayout.setVerticalGroup(
            lienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        getContentPane().add(lienzo, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private sm.avj.ui.Lienzo2DImagen lienzo;
    // End of variables declaration//GEN-END:variables
}
