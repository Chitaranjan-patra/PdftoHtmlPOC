package pdftohtmlconversion;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.Timestamp;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.fit.pdfdom.PDFDomTree;

public class PdfToHtmlNoConcurrency {

	private static void generateHTMLFromPDF(String filename, int counter) throws IOException {

		PDDocument pdf = PDDocument.load(new File(filename));

		File htmlTemplateFile = new File("//C:/Users/chitaranjan.patra/Downloads/pdf for testing/pdf" + counter + ".html");// this will be the output file

		Writer output = new PrintWriter(htmlTemplateFile, "utf-8");
		new PDFDomTree().writeText(pdf, output);

		output.close();

	}

	public static void main(String[] args) throws IOException {

		System.out.println("total start time- " + new Timestamp(System.currentTimeMillis()));

		String[] filenameList = {
				"//C:/Users/chitaranjan.patra/Downloads/pdf for testing/Provisional Relieving Letter Chitaranjan Patra 2487.pdf",
				"//C:/Users/chitaranjan.patra/Downloads/pdf for testing/Relieving letter.pdf",
				"//C:/Users/chitaranjan.patra/Downloads/pdf for testing/Retention Bonus Letter_Chita Ranjan Patra.pdf",
				"//C:/Users/chitaranjan.patra/Downloads/pdf for testing/Axis_benefits_for_Infosys.pdf",
				"//C:/Users/chitaranjan.patra/Downloads/pdf for testing/ICICI_benefits_for_Infosys.pdf",
				"//C:/Users/chitaranjan.patra/Downloads/pdf for testing/LAST 3 MONTHS STATEMENT.pdf",
				"//C:/Users/chitaranjan.patra/Downloads/pdf for testing/APHYD15038110000000095_2021.pdf", 
				"//C:/Users/chitaranjan.patra/Downloads/pdf for testing/pan card.pdf"

		};
		

		
		for (int j = 0; j < filenameList.length; j++) {

			generateHTMLFromPDF(filenameList[j], j); // my logic

		}
		 
		
		System.out.println("total end time- " + new Timestamp(System.currentTimeMillis()));

	}

}
