package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class DeliveryStarted extends AbstractEvent {

    private Long orderId;

    public DeliveryStarted(RiderTable aggregate) {
        super(aggregate);
    }

    public DeliveryStarted() {
        super();
    }
}
