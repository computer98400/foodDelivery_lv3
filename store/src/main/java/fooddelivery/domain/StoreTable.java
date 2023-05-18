package fooddelivery.domain;

import fooddelivery.StoreApplication;
import fooddelivery.domain.OrderAccepted;
import fooddelivery.domain.OrderRejected;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "StoreTable_table")
@Data
public class StoreTable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long storeId;

    private String storeName;

    private Long menuId;

    private String cookingStatus;

    private String address;
    private Long orderId;

    private String status;

    @PostPersist
    
    public void onPostPersist() {
        OrderRejected orderRejected = new OrderRejected(this);
        orderRejected.publishAfterCommit();

        OrderAccepted orderAccepted = new OrderAccepted(this);
        orderAccepted.publishAfterCommit();
    }

    public static StoreTableRepository repository() {
        StoreTableRepository storeTableRepository = StoreApplication.applicationContext.getBean(
            StoreTableRepository.class
        );
        return storeTableRepository;
    }

    public void cookingStart(CookingStartCommand cookingStartCommand) {
        CookingProcessed cookingProcessed = new CookingProcessed(this);
        cookingProcessed.publishAfterCommit();
    }

    public void cookingFinish(CookingFinishCommand cookingFinishCommand) {
        CookingProcessed cookingProcessed = new CookingProcessed(this);
        cookingProcessed.publishAfterCommit();
    }

    public static void orderStaging(Orderplaced orderplaced) {
        StoreTable storeTable = new StoreTable();
        storeTable.setOrderId(orderplaced.getId());
        storeTable.setStoreId(orderplaced.getStoreId());
        storeTable.setStoreName(orderplaced.getStoreName());
        storeTable.setMenuId(orderplaced.getMenuId());
        storeTable.setAddress(orderplaced.getAddress());
        storeTable.setCookingStatus("orderPlaced");
        repository().save(storeTable);

        OrderAccepted orderAccepted = new OrderAccepted(storeTable);
        orderAccepted.publishAfterCommit();


    }

    public static void orderStaging(OrderCancelled orderCancelled) {

        repository().findById(orderCancelled.getId()).ifPresent(storeTable->{
            
            storeTable.setStatus("orderCancelled");
            repository().save(storeTable);

            OrderAccepted orderAccepted = new OrderAccepted(storeTable);
            orderAccepted.publishAfterCommit();

         });

    }
}
