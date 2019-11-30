package si.fri.rso.escooterental.escooterorders.lib;

import java.time.Instant;

public class EscooterOrders {
    private Integer orderId;
    private Integer scooterId;
    private Float totalHours;
    private Float totalPrice;
    private Float kilometersPassed;
    private String pickupLocation;
    private String leaveLocation;
    private Instant timeFrom;
    private Instant timeTo;
    private Boolean completed;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getScooterId() {
        return scooterId;
    }

    public void setScooterId(Integer scooterId) {
        this.scooterId = scooterId;
    }

    public Float getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(Float totalHours) {
        this.totalHours = totalHours;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Float getKilometersPassed() {
        return kilometersPassed;
    }

    public void setKilometersPassed(Float kilometersPassed) {
        this.kilometersPassed = kilometersPassed;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getLeaveLocation() {
        return leaveLocation;
    }

    public void setLeaveLocation(String leaveLocation) {
        this.leaveLocation = leaveLocation;
    }

    public Instant getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(Instant timeFrom) {
        this.timeFrom = timeFrom;
    }

    public Instant getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(Instant timeTo) {
        this.timeTo = timeTo;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}

