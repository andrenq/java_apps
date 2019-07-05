package ca.jrvs.apps.twitter.example.dto;

public class Company {
    private String symbol;
    private String companyName;
    private String exchange;
    private String description;
    private String ceo;
    private String sector;

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCeo(String ceo) {
        this.ceo = ceo;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getExchange() {
        return exchange;
    }

    public String getDescription() {
        return description;
    }

    public String getCeo() {
        return ceo;
    }

    public String getSector() {
        return sector;
    }
}
