package au.com.abnamro.dailysummaryreport;

public class TransactionData {

	private String clientInformation;
	private String productInformation;
	private Double totalTransactionAmount;
		
	TransactionData(String cInfo, String pInfo, Double tTransAmount){
		this.clientInformation = cInfo;
		this.productInformation = pInfo;
		this.totalTransactionAmount = tTransAmount;
	}
	
	public String getClientInformation() {
		return clientInformation;
	}
	public void setClientInformation(String clientInformation) {
		this.clientInformation = clientInformation;
	}
	public String getProductInformation() {
		return productInformation;
	}
	public void setProductInformation(String productInformation) {
		this.productInformation = productInformation;
	}
	public Double getTotalTransactionAmount() {
		return totalTransactionAmount;
	}
	public void setTotalTransactionAmount(Double totalTransactionAmount) {
		this.totalTransactionAmount = totalTransactionAmount;
	}	
	
}
