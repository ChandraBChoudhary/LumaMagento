package TestCaptcha;
//TODO Auto-generated method stub
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import net.sourceforge.tess4j.Tesseract;

public class TestCaptchaImgEnhance_tesseract {

	
		
		    public String readCaptchaAndEnhance() throws IOException, Exception{
		    	
		            // Step 1: Load and Preprocess the Image
		            BufferedImage captchaImage = ImageIO.read(new File("C:\\Users\\chandrabl\\Desktop\\Personal\\MCA Project Work\\LumaMagento\\Captcha Images"));
		            BufferedImage processedImage = preprocessImage(captchaImage);

		            // Step 2: Apply OCR with Tesseract
		            Tesseract tesseract = new Tesseract();
		            tesseract.setDatapath("C:\\Users\\chandrabl\\Desktop\\Personal\\MCA Project Work\\LumaMagento\\tessdata");

		            String extractedText1 = tesseract.doOCR(processedImage);
		            System.out.println("Extracted Text: " + extractedText1);
		        
				return extractedText1;
		    	
		    }

		    private static BufferedImage preprocessImage(BufferedImage image) {
		        // Apply image preprocessing techniques here (e.g., resizing, contrast adjustment, noise reduction)
		        // Return the preprocessed image
		        return image;
		    }
		


}
