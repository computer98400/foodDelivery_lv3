package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private Long userId;
    private Long menuId;
    private String status;

    public OrderPlaced(OrderTable aggregate) {
        super(aggregate);
    }

    public OrderPlaced() {
        super();
    }
}
