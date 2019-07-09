package ca.jrvs.apps.twitter.example.dto;

import java.math.BigInteger;
import java.util.Date;

public class Financial {
  Date reportDate;
  BigInteger grossProfit;
  BigInteger costRevenue;
  BigInteger operatingRevenue;
  BigInteger totalRevenue;
  BigInteger operationIncome;
  BigInteger netIncome;

  @Override
  public String toString() {
    return "Financial{"
        + "reportDate="
        + reportDate
        + ", grossProfit="
        + grossProfit
        + ", costRevenue="
        + costRevenue
        + ", operatingRevenue="
        + operatingRevenue
        + ", totalRevenue="
        + totalRevenue
        + ", operationIncome="
        + operationIncome
        + ", netIncome="
        + netIncome
        + '}';
  }

  public Date getReportDate() {
    return reportDate;
  }

  public void setReportDate(Date reportDate) {
    this.reportDate = reportDate;
  }

  public BigInteger getGrossProfit() {
    return grossProfit;
  }

  public void setGrossProfit(BigInteger grossProfit) {
    this.grossProfit = grossProfit;
  }

  public BigInteger getCostRevenue() {
    return costRevenue;
  }

  public void setCostRevenue(BigInteger costRevenue) {
    this.costRevenue = costRevenue;
  }

  public BigInteger getOperatingRevenue() {
    return operatingRevenue;
  }

  public void setOperatingRevenue(BigInteger operatingRevenue) {
    this.operatingRevenue = operatingRevenue;
  }

  public BigInteger getTotalRevenue() {
    return totalRevenue;
  }

  public void setTotalRevenue(BigInteger totalRevenue) {
    this.totalRevenue = totalRevenue;
  }

  public BigInteger getOperationIncome() {
    return operationIncome;
  }

  public void setOperationIncome(BigInteger operationIncome) {
    this.operationIncome = operationIncome;
  }

  public BigInteger getNetIncome() {
    return netIncome;
  }

  public void setNetIncome(BigInteger netIncome) {
    this.netIncome = netIncome;
  }
}
