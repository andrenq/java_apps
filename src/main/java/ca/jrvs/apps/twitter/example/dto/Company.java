package ca.jrvs.apps.twitter.example.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "symbol",
        "companyName",
        "exchange",
        "description",
        "CEO",
        "sector",
        "financials",
        "dividends"
})
public class Company {
  @JsonProperty("symbol")
  private String symbol;
  @JsonProperty("companyName")
  private String companyName;
  @JsonProperty("exchange")
  private String exchange;
  @JsonProperty("description")
  private String description;
  @JsonProperty("CEO")
  private String cEO;
  @JsonProperty("sector")
  private String sector;
  @JsonProperty("financials")
  private List<Object> financial = new ArrayList <Object>();
  @JsonProperty("dividends")
  private List<Object>  dividends = new ArrayList <Object> ();

  @Override
  public String toString() {
    return "\nCompany:"
        + "\n\tsymbol:\t\t\t"
        + symbol
        + "\n\tcompanyName:\t"
        + companyName
        + "\n\texchange:\t\t"
        + exchange
        + "\n\tdescription:\t"
        + description
        + "\n\tCEO:\t\t\t"
        + cEO
        + "\n\tsector:\t\t\t"
        + sector+"\n"
        + "[Finantials: \n"
            +financial+"\n"
            +"]"
            +"[Dividends:" +
            dividends+"\n" +
            "]";
  }

  @JsonProperty("symbol")
  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }

  @JsonProperty("companyName")
  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  @JsonProperty("exchange")
  public void setExchange(String exchange) {
    this.exchange = exchange;
  }

  @JsonProperty("description")
  public void setDescription(String description) {
    this.description = description;
  }

  @JsonProperty("CEO")
  public void setcEO(String CEO) {
    this.cEO = CEO;
  }

  @JsonProperty("sector")
  public void setSector(String sector) {
    this.sector = sector;
  }

  @JsonProperty("financials")
  public void setFinancial(List<Object> financial) {
    this.financial = financial;
  }

  @JsonProperty("dividends")
  public void setDividends(List<Object> dividends) {
    this.dividends = dividends;
  }

  @JsonProperty("symbol")
  public String getSymbol() {
    return this.symbol;
  }

  @JsonProperty("companyName")
  public String getCompanyName() {
    return companyName;
  }
  @JsonProperty("exchange")
  public String getExchange() {
    return exchange;
  }

  @JsonProperty("description")
  public String getDescription() {
    return description;
  }
  @JsonProperty("CEO")
  public String getCEO() {
    return cEO;
  }
  @JsonProperty("sector")
  public String getSector() {
    return sector;
  }
  @JsonProperty("financial")
  public List<Object> getFinancial() {
    return financial;
  }

  @JsonProperty("dividend")
  public List<Object> getDividends() {
    return dividends;
  }


}
