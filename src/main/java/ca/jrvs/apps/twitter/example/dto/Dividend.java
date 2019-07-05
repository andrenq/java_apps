package ca.jrvs.apps.twitter.example.dto;

import java.math.BigDecimal;
import java.util.Date;

public class Dividend {
  private Date exDate;
  private Date paymentDate;
  private Date declareDate;
  private BigDecimal amount;

  public void setExDate(Date exDate) {
    this.exDate = exDate;
  }

  public void setPaymentDate(Date paymentDate) {
    this.paymentDate = paymentDate;
  }

  public void setDeclareDate(Date declareDate) {
    this.declareDate = declareDate;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public Date getExDate() {
    return exDate;
  }

  public Date getPaymentDate() {
    return paymentDate;
  }

  public Date getDeclareDate() {
    return declareDate;
  }

  public BigDecimal getAmount() {
    return amount;
  }
}
