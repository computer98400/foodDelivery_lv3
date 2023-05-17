package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Orderplaced extends AbstractEvent {

    private Long orderId;
    private Long userId;
    private Long menuId;
    private String orderStatus;
    private String address;
    private String userName;

    public Orderplaced(OrderTable aggregate) {
        super(aggregate);
    }

    public Orderplaced() {
        super();
    }
}
