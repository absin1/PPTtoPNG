package absin.io.pptExport;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import absin.io.pptExport.entities.CMSLesson;
import absin.io.pptExport.entities.CMSSlide;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws JAXBException {
		try {
			File folder = new File("C:\\Users\\absin\\Downloads\\Session2\\input");
			for (File imageFile : folder.listFiles()) {
				resize(imageFile.getAbsolutePath(),
						"C:\\Users\\absin\\Downloads\\Session2\\buffer\\" + imageFile.getName(), 3.0 / 4.0);
				resize("C:\\Users\\absin\\Downloads\\Session2\\buffer\\" + imageFile.getName(),
						"C:\\Users\\absin\\Downloads\\Session2\\output\\" + imageFile.getName(), 1600, 900, 200);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// createXML();
	}

	/**
	 * Resizes an image by a percentage of original size (proportional).
	 * 
	 * @param inputImagePath
	 *            Path of the original image
	 * @param outputImagePath
	 *            Path to save the resized image
	 * @param percent
	 *            a double number specifies percentage of the output image over the
	 *            input image.
	 * @throws IOException
	 */
	public static void resize(String inputImagePath, String outputImagePath, double percent) throws IOException {
		File inputFile = new File(inputImagePath);
		BufferedImage inputImage = ImageIO.read(inputFile);
		int scaledWidth = (int) (inputImage.getWidth() * percent);
		int scaledHeight = (int) (inputImage.getHeight() * percent);
		resize(inputImagePath, outputImagePath, scaledWidth, scaledHeight, 0);
	}

	public static void resize(String inputImagePath, String outputImagePath, int scaledWidth, int scaledHeight,
			int xoffSet) throws IOException {
		// reads input image
		File inputFile = new File(inputImagePath);
		BufferedImage inputImage = ImageIO.read(inputFile);

		// creates output image
		BufferedImage outputImage = new BufferedImage(scaledWidth, scaledHeight, inputImage.getType());

		// scales the input image to the output image
		Graphics2D g2d = outputImage.createGraphics();
		g2d.drawImage(inputImage, xoffSet, 0, scaledWidth - 2 * xoffSet, scaledHeight, null);
		g2d.dispose();

		// extracts extension of output file
		String formatName = outputImagePath.substring(outputImagePath.lastIndexOf(".") + 1);

		// writes to output file
		ImageIO.write(outputImage, formatName, new File(outputImagePath));
	}

	private static void createXML() throws JAXBException {
		CMSLesson cmsLesson = new CMSLesson();
		ArrayList<CMSSlide> slides = new ArrayList<CMSSlide>();
		File folder = new File("C:\\Users\\absin\\Downloads\\Session2");
		int i = 0;
		for (File image : folder.listFiles()) {
			CMSSlide cmsSlide = new CMSSlide();
			cmsSlide.setTemplateName("NO_CONTENT");
			cmsSlide.setImage_BG("http://cdn.talentify.in:9999//lessonXMLs/101/101/" + image.getName());
			cmsSlide.setId(i++);
			cmsSlide.setOrder_id(i);
			slides.add(cmsSlide);
		}
		cmsLesson.setSlides(slides);
		JAXBContext.newInstance(CMSLesson.class).createMarshaller().marshal(cmsLesson, System.out);
	}
}
