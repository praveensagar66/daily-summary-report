package au.com.abnamro.dailysummaryreport;

import java.io.File;
import java.io.FileWriter;
import java.util.Map;

import org.apache.log4j.Logger;

import com.opencsv.CSVWriter;

public class GenerateDailySummaryReport {

	private static final Logger LOGGER = Logger.getLogger(GenerateDailySummaryReport.class);

	public void generateSummaryReport(Map<String, Map<String, Double>> clientDataMap, String outputFile)
			throws Exception {

		File file = new File(outputFile);

		try (FileWriter outputfile = new FileWriter(file); CSVWriter writer = new CSVWriter(outputfile);) {
			LOGGER.info("Started writing data to csv file");
			String[] header = { "Client_Information", "Product_Information", "Total_Transaction_Amount" };
			writer.writeNext(header);

			for (Map.Entry<String, Map<String, Double>> entry1 : clientDataMap.entrySet()) {
				String client = entry1.getKey();
				for (Map.Entry<String, Double> entry2 : entry1.getValue().entrySet()) {
					String product = entry2.getKey();
					Double transaction = entry2.getValue();

					String[] data1 = { client, product, transaction.toString() };
					writer.writeNext(data1);
				}
			}
			LOGGER.info("Completed writing data to csv file");
		} catch (Exception e) {
			LOGGER.error("Exception while reading the data and writing to csv file : " + e.getMessage());
			throw e;
		}
	}
}
