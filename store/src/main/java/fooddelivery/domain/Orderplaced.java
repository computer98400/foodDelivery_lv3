package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Orderplaced extends AbstractEvent {

    private Long id;
    private Long userId;
    private Long menuId;
    private Long storeId;
    private String storeName;
    private String address;
    private String status;
}
