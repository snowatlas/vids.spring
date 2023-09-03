package vids.spring.repository.projection;

import vids.spring.model.DeviceType;

import java.time.LocalDateTime;

public interface PurchaseItem { //decribe item 4
    String getName();
    DeviceType getType();
    Double getPrice();
    String getColor();
    LocalDateTime getPurchaseTime();
}
