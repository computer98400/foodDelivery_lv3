package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderCancelled extends AbstractEvent {

    private Long orderId;

    public OrderCancelled(OrderTable aggregate) {
        super(aggregate);
    }

    public OrderCancelled() {
        super();
    }
}
