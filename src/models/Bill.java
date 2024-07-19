package models;

import java.util.Date;
import java.util.List;

public class Bill extends BaseModel {

    private Ticket ticket;
    private Date exitGate;
    private Gate gate;
    private int amount;
    private List<Payment> payments;
    private BillStatus billStatus;

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Date getExitGate() {
        return exitGate;
    }

    public void setExitGate(Date exitGate) {
        this.exitGate = exitGate;
    }

    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public BillStatus getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(BillStatus billStatus) {
        this.billStatus = billStatus;
    }
}
