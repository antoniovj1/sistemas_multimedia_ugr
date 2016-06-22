/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.avj.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

public class ColorCellRenderer implements ListCellRenderer {

    private final DefaultListCellRenderer defaultRenderer;
    private final static Dimension PREFERRED_SIZE = new Dimension(25, 25);

    public ColorCellRenderer() {
        this.defaultRenderer = new DefaultListCellRenderer();
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

        JLabel renderer = (JLabel) defaultRenderer.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        if (value instanceof Color) {
            renderer.setBackground((Color) value);
            renderer.setText("");

            Border border;
            border = BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.LIGHT_GRAY);
            renderer.setBorder(border);

        }

        renderer.setPreferredSize(PREFERRED_SIZE);
        return renderer;
    }
}
