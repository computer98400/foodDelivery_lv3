package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class CookingProcessed extends AbstractEvent {

    private Long id;

    public CookingProcessed(StoreTable aggregate) {
        super(aggregate);
    }

    public CookingProcessed() {
        super();
    }
}
