package pdftohtmlconversion;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.Timestamp;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.fit.pdfdom.PDFDomTree;

public class PdfToHtmlConcurrency {

	private static void generateHTMLFromPDF(String filename, int counter) throws IOException {

		PDDocument pdf = PDDocument.load(new File(filename));

		File htmlTemplateFile = new File("//C:/Users/chitaranjan.patra/Downloads/pdf for testing/pdf" + counter + ".html");//this will be the output file

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

		ExecutorService executorService = Executors.newFixedThreadPool(3);

		for (int j = 0; j < filenameList.length; j++) {
			int k = j;

			Runnable task1 = new Runnable() {

				public void run() {

					String threadName = Thread.currentThread().getName();

					System.out.println("My " + threadName + " started at time- "+ new Timestamp(System.currentTimeMillis()) + " for file- " + filenameList[k]);

					try {

						generateHTMLFromPDF(filenameList[k], k); // my logic

					} catch (IOException e) {

						e.printStackTrace();

					}

					System.out.println("My " + threadName + " End at time- "+ new Timestamp(System.currentTimeMillis()) + " for file- " + filenameList[k]);

				}

			};

			executorService.submit(task1);

		}

		executorService.shutdown();
	}

}