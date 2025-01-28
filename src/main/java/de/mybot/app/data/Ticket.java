package de.mybot.app.data;

public class Ticket {
    private String status;
    private String product;
    private String issueType;
    private Boolean spareparts;
    private String costumerID;

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setSpareparts(Boolean spareparts) {
        this.spareparts = spareparts;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCostumerID(String costumerID) {
        this.costumerID = costumerID;
    }

    public String getIssueType() {
        return issueType;
    }

    public Boolean getSpareparts() {
        return spareparts;
    }

    public String getProduct() {
        return product;
    }

    public String getStatus() {
        return status;
    }

    public String getCostumerID() {
        return costumerID;
    }
}
