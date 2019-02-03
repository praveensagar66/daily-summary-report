package au.com.abnamro.dailysummaryreport;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class DailySummaryReport 
{
	private static final String INPUT_FILENAME = "../DailySummaryReport/src/Input/Input.txt";
	private static final String OUTPUT_FILENAME = "../DailySummaryReport/src/Output/Output.csv";
	private static final Logger LOGGER = Logger.getLogger(DailySummaryReport.class);
	
	public void start() throws Exception {

		LOGGER.info("Started reading the input file.");
		
			ProcessFields processFields = new ProcessFields();
			ProcessData processData = new ProcessData();
			GenerateDailySummaryReport generateReport = new GenerateDailySummaryReport();

			try (BufferedReader br = new BufferedReader(new FileReader(INPUT_FILENAME))) {
			
				List<TransactionData> tData = processFields.processOutputFields(br);
				Map<String, Map<String, Double>> clientDataMap = processData.processTransactionData(tData);
				generateReport.generateSummaryReport(clientDataMap, OUTPUT_FILENAME);
				LOGGER.info("Completed reading the input file.");
		
			} catch (IOException e) {
				LOGGER.error("Exception in Start Program :"+e.getMessage());
				throw e;
		}
	}
	
	public static void main( String[] args ) 
    {
        DailySummaryReport summary = new DailySummaryReport();
        try {
			summary.start();
		} catch (Exception e) {
			LOGGER.error("Exception in Main Program :"+e.getMessage());
		}
    }
	
}
