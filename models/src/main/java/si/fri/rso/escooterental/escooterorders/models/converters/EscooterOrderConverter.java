package si.fri.rso.escooterental.escooterorders.models.converters;

import si.fri.rso.escooterental.escooterorders.lib.EscooterOrders;
import si.fri.rso.escooterental.escooterorders.models.entities.EscooterOrdersEntity;
public class EscooterOrderConverter {
    public static EscooterOrders toDto(EscooterOrdersEntity entity){
        EscooterOrders dto = new EscooterOrders();
        dto.setOrderId(entity.getId());
        dto.setScooterId(entity.getScooterId());
        dto.setCompleted(entity.getCompleted());
        dto.setKilometersPassed(entity.getKilometersPassed());
        dto.setLeaveLocation(entity.getLeaveLocation());
        dto.setPickupLocation(entity.getPickupLocation());
        dto.setTimeFrom(entity.getTimeFrom());
        dto.setTimeTo(entity.getTimeTo());
        dto.setTotalHours(entity.getTotalHours());
        dto.setTotalPrice(entity.getTotalPrice());

        return dto;
    }

    public static EscooterOrdersEntity toEntity(EscooterOrders dto){
        EscooterOrdersEntity entity = new EscooterOrdersEntity();
        entity.setId(dto.getOrderId());
        entity.setScooterId(dto.getScooterId());
        entity.setCompleted(dto.getCompleted());
        entity.setKilometersPassed(dto.getKilometersPassed());
        entity.setLeaveLocation(dto.getLeaveLocation());
        entity.setPickupLocation(dto.getPickupLocation());
        entity.setTimeFrom(dto.getTimeFrom());
        entity.setTimeTo(dto.getTimeTo());
        entity.setTotalHours(dto.getTotalHours());
        entity.setTotalPrice(dto.getTotalPrice());

        return entity;

    }
}
