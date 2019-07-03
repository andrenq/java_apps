package ca.jrvs.apps.jdbc;

import ca.jrvs.apps.jdbc.util.DataTransferObject;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Order implements DataTransferObject {
    private String          customerFirstName;
    private String          customerLastName;
    private String          customerEmail;
    private long            orderId;
    private Date            creationDate;
    private BigDecimal      totalDue;
    private String          status;
    private String          salespersonFirstName;
    private String          salespersonLastName;
    private String          salespersonEmail;
    private List<OrderLine> orderLines;

    public void setId(long orderId) {
        this.orderId = orderId;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setTotalDue(BigDecimal totalDue) {
        this.totalDue = totalDue;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public void setSalespersonFirstName(String salespersonFirstName) {
        this.salespersonFirstName = salespersonFirstName;
    }

    public void setSalespersonLastName(String salespersonLastName) {
        this.salespersonLastName = salespersonLastName;
    }

    public void setSalespersonEmail(String salespersonEmail) {
        this.salespersonEmail = salespersonEmail;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public BigDecimal getTotalDue() {
        return this.totalDue;
    }

    public String getStatus() {
        return this.status;
    }

    public String getCustomerFirstName() {
        return this.customerFirstName;
    }

    public String getCustomerLastName() {
        return this.customerLastName;
    }

    public String getCustomerEmail() {
        return this.customerEmail;
    }

    public String getSalespersonFirstName() {
        return this.salespersonFirstName;
    }

    public String getSalespersonLastName() {
        return this.salespersonLastName;
    }

    public String getSalespersonEmail() {
        return this.salespersonEmail;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }


    @Override
    public String toString() {
        return "Order" +
                "\n\tcustomer:\t\t\t" + customerFirstName + " " + customerLastName +
                "\n\tcustomerEmail:\t\t" + customerEmail +
                "\n\torderId:\t\t\t" + orderId +
                "\n\tcreationDate:\t\t" + creationDate +
                "\n\ttotalDue:\t\t\t" + totalDue +
                "\n\tstatus:\t\t\t\t" + status +
                "\n\tsalesperson:\t\t" + salespersonFirstName + ' ' + salespersonLastName +
                "\n\tsalespersonEmail:\t" + salespersonEmail +
                "\n\torderLines:\n" + orderLines;
    }

    @Override
    public long getId() {
        return this.orderId;
    }
}
