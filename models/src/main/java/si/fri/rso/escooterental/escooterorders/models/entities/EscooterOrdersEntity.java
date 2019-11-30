package si.fri.rso.escooterental.escooterorders.models.entities;


import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name="escooterorders")
@NamedQueries(value =
        {
                @NamedQuery(name="EscooterOrdersEntity.getall",query = "SELECT c FROM EscooterOrdersEntity c" )
        })

public class EscooterOrdersEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @Column(name = "scooterid")
        private Integer scooterId;

        @Column(name = "totalhours" )
        private Float totalHours;
        @Column(name = "totalprice" )
        private Float totalPrice;
        @Column(name = "kilometerspassed")
        private Float kilometersPassed;
        @Column(name = "pickuplocation")
        private String pickupLocation;
        @Column(name = "leavelocation")
        private String leaveLocation;
        @Column(name = "completed",columnDefinition = "boolean default false")
        private Boolean completed;
        @Column(name = "timefrom")
        private Instant timeFrom;
        @Column(name = "timeto")
        private Instant timeTo;

        public Instant getTimeTo() {
            return timeTo;
        }

        public void setTimeTo(Instant timeTo) {
            this.timeTo = timeTo;
        }

        public Instant getTimeFrom() {
            return timeFrom;
        }

        public void setTimeFrom(Instant timeFrom) {
            this.timeFrom = timeFrom;
        }

        public Boolean getCompleted() {
            return completed;
        }

        public void setCompleted(Boolean completed) {
            this.completed = completed;
        }

        public String getLeaveLocation() {
            return leaveLocation;
        }

        public void setLeaveLocation(String leaveLocation) {
            this.leaveLocation = leaveLocation;
        }

        public String getPickupLocation() {
            return pickupLocation;
        }

        public void setPickupLocation(String pickupLocation) {
            this.pickupLocation = pickupLocation;
        }

        public Float getKilometersPassed() {
            return kilometersPassed;
        }

        public void setKilometersPassed(Float kilometersPassed) {
            this.kilometersPassed = kilometersPassed;
        }

        public Float getTotalPrice() {
            return totalPrice;
        }

        public void setTotalPrice(Float totalPrice) {
            this.totalPrice = totalPrice;
        }

        public Float getTotalHours() {
            return totalHours;
        }

        public void setTotalHours(Float totalHours) {
            this.totalHours = totalHours;
        }

        public Integer getScooterId() {
            return scooterId;
        }

        public void setScooterId(Integer scooterId) {
            this.scooterId = scooterId;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }
}
