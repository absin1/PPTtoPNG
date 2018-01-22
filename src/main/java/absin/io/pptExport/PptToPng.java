/**
 * 
 */
package absin.io.pptExport;

/**
 * @author absin
 *
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;

public class PptToPng {
	public static void main(String[] args) throws Exception {
		FileInputStream is = new FileInputStream("C:\\Users\\absin\\Downloads\\Session2.pptx");
		XMLSlideShow ppt = new XMLSlideShow(is);
		is.close();

		double zoom = 2; // magnify it by 2
		AffineTransform at = new AffineTransform();
		at.setToScale(zoom, zoom);

		Dimension pgsize = ppt.getPageSize();
		int i = 0;
		List<XSLFSlide> slide = ppt.getSlides();
		for (XSLFSlide xslfSlide : slide) {
			BufferedImage img = new BufferedImage((int) Math.ceil(pgsize.width * zoom),
					(int) Math.ceil(pgsize.height * zoom), BufferedImage.TYPE_INT_RGB);
			Graphics2D graphics = img.createGraphics();
			graphics.setTransform(at);

			graphics.setPaint(Color.white);
			graphics.fill(new Rectangle2D.Float(0, 0, pgsize.width, pgsize.height));
			xslfSlide.draw(graphics);
			FileOutputStream out = new FileOutputStream(
					"C:\\\\Users\\\\absin\\\\Downloads\\\\Session2\\slide-" + (++i + 1) + ".png");
			javax.imageio.ImageIO.write(img, "png", out);
			out.close();
		}
	}
}