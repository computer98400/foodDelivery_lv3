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
    private Long storeId;
    private String storeName;
    private String address;
    private String orderStatus;
    private String status;
}
