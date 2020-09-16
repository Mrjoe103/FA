package com.yidu.fund.pojo;


import java.io.Serializable;
import java.sql.Date;

/**
 * POJO_Description: BondTrade
 * @author wh
 * @since 2020-09-16
 */
public class BondTrade implements Serializable{

	private static final long serialVersionUID =  6976957882608887209L;
	private String bondTradeId;

	private String bondTradeNo;

	private String fundId;

	private String fundCode;

	private String fundName;

	private String bondId;

	private String bondCode;

	private String bondName;

	private String managerId;

	private String managerName;

	private String brokerId;

	private String brokerName;

	private int tradeType;

	private int tradeFlag;

	private double tradePrice;

	private Date tradeDate;

	private int share;

	private double turnover;

	private double stampTax;

	private double managementFees;

	private double transferFee;

	private double commission;

	private double brokerage;

	private double total;

	private double couponRate;

	private int tradeStatus;

	private String description;

	private Bond bond;


	public BondTrade() {

	}


	public String getBondTradeId() {
		return bondTradeId;
	}

	public void setBondTradeId(String bondTradeId) {
		this.bondTradeId = bondTradeId;
	}

	public String getBondTradeNo() {
		return bondTradeNo;
	}

	public void setBondTradeNo(String bondTradeNo) {
		this.bondTradeNo = bondTradeNo;
	}

	public String getFundId() {
		return fundId;
	}

	public void setFundId(String fundId) {
		this.fundId = fundId;
	}

	public String getFundCode() {
		return fundCode;
	}

	public void setFundCode(String fundCode) {
		this.fundCode = fundCode;
	}

	public String getFundName() {
		return fundName;
	}

	public void setFundName(String fundName) {
		this.fundName = fundName;
	}

	public String getBondId() {
		return bondId;
	}

	public void setBondId(String bondId) {
		this.bondId = bondId;
	}

	public String getBondCode() {
		return bondCode;
	}

	public void setBondCode(String bondCode) {
		this.bondCode = bondCode;
	}

	public String getBondName() {
		return bondName;
	}

	public void setBondName(String bondName) {
		this.bondName = bondName;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getBrokerId() {
		return brokerId;
	}

	public void setBrokerId(String brokerId) {
		this.brokerId = brokerId;
	}

	public String getBrokerName() {
		return brokerName;
	}

	public void setBrokerName(String brokerName) {
		this.brokerName = brokerName;
	}

	public int getTradeType() {
		return tradeType;
	}

	public void setTradeType(int tradeType) {
		this.tradeType = tradeType;
	}

	public int getTradeFlag() {
		return tradeFlag;
	}

	public void setTradeFlag(int tradeFlag) {
		this.tradeFlag = tradeFlag;
	}

	public double getTradePrice() {
		return tradePrice;
	}

	public void setTradePrice(double tradePrice) {
		this.tradePrice = tradePrice;
	}

	public Date getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}

	public int getShare() {
		return share;
	}

	public void setShare(int share) {
		this.share = share;
	}

	public double getTurnover() {
		return turnover;
	}

	public void setTurnover(double turnover) {
		this.turnover = turnover;
	}

	public double getStampTax() {
		return stampTax;
	}

	public void setStampTax(double stampTax) {
		this.stampTax = stampTax;
	}

	public double getManagementFees() {
		return managementFees;
	}

	public void setManagementFees(double managementFees) {
		this.managementFees = managementFees;
	}

	public double getTransferFee() {
		return transferFee;
	}

	public void setTransferFee(double transferFee) {
		this.transferFee = transferFee;
	}

	public double getCommission() {
		return commission;
	}

	public void setCommission(double commission) {
		this.commission = commission;
	}

	public double getBrokerage() {
		return brokerage;
	}

	public void setBrokerage(double brokerage) {
		this.brokerage = brokerage;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getCouponRate() {
		return couponRate;
	}

	public void setCouponRate(double couponRate) {
		this.couponRate = couponRate;
	}

	public int getTradeStatus() {
		return tradeStatus;
	}

	public void setTradeStatus(int tradeStatus) {
		this.tradeStatus = tradeStatus;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Bond getBond() {
		return bond;
	}

	public void setBond(Bond bond) {
		this.bond = bond;
	}

	@Override
	public String toString() {
		return "BondTrade{" +
				"bondTradeId='" + bondTradeId + '\'' +
				", bondTradeNo='" + bondTradeNo + '\'' +
				", fundId='" + fundId + '\'' +
				", fundCode='" + fundCode + '\'' +
				", fundName='" + fundName + '\'' +
				", bondId='" + bondId + '\'' +
				", bondCode='" + bondCode + '\'' +
				", bondName='" + bondName + '\'' +
				", managerId='" + managerId + '\'' +
				", managerName='" + managerName + '\'' +
				", brokerId='" + brokerId + '\'' +
				", brokerName='" + brokerName + '\'' +
				", tradeType=" + tradeType +
				", tradeFlag=" + tradeFlag +
				", tradePrice=" + tradePrice +
				", tradeDate=" + tradeDate +
				", share=" + share +
				", turnover=" + turnover +
				", stampTax=" + stampTax +
				", managementFees=" + managementFees +
				", transferFee=" + transferFee +
				", commission=" + commission +
				", brokerage=" + brokerage +
				", total=" + total +
				", couponRate=" + couponRate +
				", tradeStatus=" + tradeStatus +
				", description='" + description + '\'' +
				", bond=" + bond +
				'}';
	}
}
