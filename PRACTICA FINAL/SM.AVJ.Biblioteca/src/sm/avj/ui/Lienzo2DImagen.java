package sm.avj.ui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import sm.avj.graficos.Rectangulo2D;

/**
 *
 * @author antonio
 */
public class Lienzo2DImagen extends Lienzo {

    BufferedImage image;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, 0, 0, this);
        }

        if (clip != null) {
            Graphics2D g2d = (Graphics2D) g;
            final float dash[] = {5.0f};

            clip.setStrokeDash(dash);
            clip.setStrokeWidth(1.5f);
          
            clip.paint(g2d);
        }
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage img) {
        this.image = img;
        if (img != null) {
            setPreferredSize(new Dimension(img.getWidth(), img.getHeight()));
            this.setClip(new Rectangulo2D(new Point2D.Double(0, 0), new Point2D.Double(img.getWidth(), img.getHeight())));
        }
    }

    public BufferedImage getImage(boolean drawVector) {
        if (drawVector) {
            Graphics2D g = image.createGraphics();
            super.paint(g);
            return image;

        } else {
            return getImage();
        }
    }

}
