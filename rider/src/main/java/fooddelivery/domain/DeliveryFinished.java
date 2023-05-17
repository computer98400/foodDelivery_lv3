package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class DeliveryFinished extends AbstractEvent {

    private Long orderId;

    public DeliveryFinished(RiderTable aggregate) {
        super(aggregate);
    }

    public DeliveryFinished() {
        super();
    }
}
