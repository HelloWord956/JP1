package Entity;

public enum OrderStatus {
    PENDING("Pending"),
    COMPLETED("Completed"),
    CANCEL("Cancelled"),
    PAID("Paid");

    private final String labelStatus;

    private OrderStatus(String labelStatus) {
        this.labelStatus = labelStatus;
    }

    public String getLabelStatus() {
        return labelStatus;
    }
}
