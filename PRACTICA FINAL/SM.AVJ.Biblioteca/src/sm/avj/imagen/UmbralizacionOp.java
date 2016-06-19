/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.avj.imagen;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import sm.image.BufferedImageOpAdapter;
import sm.image.BufferedImagePixelIterator;

/**
 *
 * @author antonio
 */
public class UmbralizacionOp extends BufferedImageOpAdapter {
    private int umbral;
    
    public UmbralizacionOp(int umbral) {
        this.umbral = umbral;
    }

    
    @Override
    public BufferedImage filter(BufferedImage src, BufferedImage dest) {
        if (src == null) {
            throw new NullPointerException("src image is null");
        }
        if (dest == null) {
            dest = createCompatibleDestImage(src, null);
        }

        WritableRaster raster = dest.getRaster();

        int val;
        BufferedImagePixelIterator.PixelData pixel;
        for (BufferedImagePixelIterator it = new BufferedImagePixelIterator(src); it.hasNext();) {
            pixel = it.next();

            float initRed = pixel.sample[0];
            float initGreen = pixel.sample[1];
            float initBlue = pixel.sample[2];
            
            float intensidad = (initRed+initBlue+initGreen)/3;
            
            if(intensidad >= umbral){
                val = 255;
            } else {
                val = 0;
            }

            pixel.sample[0] = val;
            pixel.sample[1] = val;
            pixel.sample[2] = val;

            raster.setPixel(pixel.col, pixel.row, pixel.sample);

        }
        return dest;
    }

}
