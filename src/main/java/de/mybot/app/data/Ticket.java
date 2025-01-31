package de.mybot.app.data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ticket {
    private String costumerID;
    private String ticketStatus;
    private String product;
    private String problemType;
    private String issue;
    private Boolean sparepartsNeeded;
    private String sparepart;
    private int feedback;

    private static Ticket instance;

    private Ticket() {
        //TODO: default values
        this.ticketStatus = "unresolved";
    }

    public static Ticket getInstance() {
        if (instance == null) {
            instance = new Ticket();
        }
        return instance;
    }

    public void setCostumerID(String costumerID) {
        this.costumerID = costumerID;
    }

    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setProblemType(String problemType) {
        this.problemType = problemType;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public void setSparepartsNeeded(Boolean sparepartsNeeded) {
        this.sparepartsNeeded = sparepartsNeeded;
    }

    public void setSparepart(String sparepart) {
        this.sparepart = sparepart;
    }

    public void setFeedback(int feedback) {
        this.feedback = feedback;
    }

    public String getCostumerID() {
        return costumerID;
    }

    public String getTicketStatus() {
        return ticketStatus;
    }

    public String getProduct() {
        return product;
    }

    public String getProblemType() {
        return problemType;
    }

    public String getIssue() {
        return issue;
    }

    public Boolean getSparepartsNeeded() {
        return sparepartsNeeded;
    }

    public String getSparepart() {
        return sparepart;
    }

    public int getFeedback() {
        return feedback;
    }
    public String getTimeStamp() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);
        return formattedDateTime;
    }
}
