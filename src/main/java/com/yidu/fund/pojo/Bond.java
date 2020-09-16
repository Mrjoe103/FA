package com.yidu.fund.pojo;


import java.io.Serializable;
import java.sql.Date;

/**
 * POJO_Description: Bond
 * @author wh
 * @since 2020-09-16
 */
public class Bond implements Serializable{

	private static final long serialVersionUID =  8914254148101735909L;
	private String bondId;

	private String bondCode;

	private String bondShortName;

	private double actualIssuance;

	private double issuePrice;

	private double par;

	private int term;

	private String paymentFrequency;

	private Date valueDdate;

	private Date expireDate;

	private double couponRate;

	private String bondFullName;

	private String description;

	private String remark1;

	private String remark2;

	private String remark3;

	public Bond() {

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

	public String getBondShortName() {
		return bondShortName;
	}

	public void setBondShortName(String bondShortName) {
		this.bondShortName = bondShortName;
	}

	public double getActualIssuance() {
		return actualIssuance;
	}

	public void setActualIssuance(double actualIssuance) {
		this.actualIssuance = actualIssuance;
	}

	public double getIssuePrice() {
		return issuePrice;
	}

	public void setIssuePrice(double issuePrice) {
		this.issuePrice = issuePrice;
	}

	public double getPar() {
		return par;
	}

	public void setPar(double par) {
		this.par = par;
	}

	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}

	public String getPaymentFrequency() {
		return paymentFrequency;
	}

	public void setPaymentFrequency(String paymentFrequency) {
		this.paymentFrequency = paymentFrequency;
	}

	public Date getValueDdate() {
		return valueDdate;
	}

	public void setValueDdate(Date valueDdate) {
		this.valueDdate = valueDdate;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public double getCouponRate() {
		return couponRate;
	}

	public void setCouponRate(double couponRate) {
		this.couponRate = couponRate;
	}

	public String getBondFullName() {
		return bondFullName;
	}

	public void setBondFullName(String bondFullName) {
		this.bondFullName = bondFullName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRemark1() {
		return remark1;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}

	public String getRemark2() {
		return remark2;
	}

	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}

	public String getRemark3() {
		return remark3;
	}

	public void setRemark3(String remark3) {
		this.remark3 = remark3;
	}


	@Override
	public String toString() {
		return " Bond{" +
				"bondId='" + bondId + '\'' +
				"bondCode='" + bondCode + '\'' +
				"bondShortName='" + bondShortName + '\'' +
				"actualIssuance='" + actualIssuance + '\'' +
				"issuePrice='" + issuePrice + '\'' +
				"par='" + par + '\'' +
				"term='" + term + '\'' +
				"paymentFrequency='" + paymentFrequency + '\'' +
				"valueDdate='" + valueDdate + '\'' +
				"expireDate='" + expireDate + '\'' +
				"couponRate='" + couponRate + '\'' +
				"bondFullName='" + bondFullName + '\'' +
				"description='" + description + '\'' +
				"remark1='" + remark1 + '\'' +
				"remark2='" + remark2 + '\'' +
				"remark3='" + remark3 + '\'' +
				'}';
	}

}
