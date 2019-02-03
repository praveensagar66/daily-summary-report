package au.com.abnamro.dailysummaryreport;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class ProcessFields {

	private static final Logger LOGGER = Logger.getLogger(ProcessFields.class);

	public List<TransactionData> processOutputFields(BufferedReader br) {

		TransactionFields transactions = new TransactionFields();
		List<TransactionData> clientDataList = new ArrayList<>();
		String line;
		
		try {
			LOGGER.info("Reading the file data...");
			while ((line = br.readLine()) != null) {
				// Client Information
				String clientInformation = line.substring(3, 19).trim();

				// Product Information
				transactions.setExchangeCode(line.substring(27, 31).trim());
				transactions.setProductGroupCode(line.substring(25, 27).trim());
				transactions.setSymbol(line.substring(31, 37).trim());
				transactions.setExpirationCode(line.substring(37, 45).trim());
				String productInformation = transactions.getExchangeCode() + transactions.getProductGroupCode()
						+ transactions.getSymbol() + transactions.getExpirationCode();

				// Total Transaction Amount
				transactions.setQuantityLong(Double.valueOf(line.substring(52, 62)));
				transactions.setQuantityShort(Double.valueOf(line.substring(63, 73)));
				Double transactionAmount = transactions.getQuantityLong() - transactions.getQuantityShort();

				clientDataList.add(new TransactionData(clientInformation, productInformation, transactionAmount));

			}

		} catch (Exception e) {
			LOGGER.error("Process Fields :: Exception while reading the data : " + e.getMessage());
		}
		return clientDataList;
	}

}
