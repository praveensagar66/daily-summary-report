package au.com.abnamro.dailysummaryreport;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class ProcessData {
	private static final Logger LOGGER = Logger.getLogger(ProcessData.class);

	public Map<String, Map<String, Double>> processTransactionData(List<TransactionData> tData) {

		Map<String, Map<String, Double>> clientDataMap = new HashMap<>();

		LOGGER.info("Calculating the transaction amounts per product of a client");
		for (TransactionData t : tData) {
			if (!clientDataMap.containsKey(t.getClientInformation())) {
				Map<String, Double> newProductData = new HashMap<>();
				newProductData.put(t.getProductInformation(), t.getTotalTransactionAmount());
				clientDataMap.put(t.getClientInformation(), newProductData);

			} else {

				Map<String, Double> existingProductData = clientDataMap.get(t.getClientInformation());

				if (existingProductData.containsKey(t.getProductInformation())) {
					Double amount = existingProductData.get(t.getProductInformation()) + t.getTotalTransactionAmount();
					existingProductData.put(t.getProductInformation(), amount);
				} else {
					existingProductData.put(t.getProductInformation(), t.getTotalTransactionAmount());
				}

			}
		}

		return clientDataMap;
	}

}
