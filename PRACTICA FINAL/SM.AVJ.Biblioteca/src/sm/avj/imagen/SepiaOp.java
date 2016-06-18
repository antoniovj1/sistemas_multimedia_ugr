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
public class SepiaOp extends BufferedImageOpAdapter {

    public SepiaOp() {
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
        
        BufferedImagePixelIterator.PixelData pixel;
        for (BufferedImagePixelIterator it = new BufferedImagePixelIterator(src); it.hasNext();) {
            pixel = it.next();

            float initRed = pixel.sample[0];
            float initGreen = pixel.sample[1];
            float initBlue = pixel.sample[2];

            pixel.sample[0] = Math.min(255, ((int)(initRed * 0.393f + initGreen * 0.769f + initBlue * 0.189f)));
            pixel.sample[1] = Math.min(255, ((int)( initRed * 0.349f + initGreen * 0.686f + initBlue * 0.168f)));
            pixel.sample[2] = Math.min(255, ((int)(initRed * 0.272f + initGreen * 0.534f + initBlue * 0.131f)));


            raster.setPixel(pixel.col, pixel.row, pixel.sample);

        }
        return dest;
    }

}
