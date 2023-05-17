package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class CookingProcessed extends AbstractEvent {

    private Long storeId;
    private String storeName;
    private Long orderId;
    private String address;
}
