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

    private Long orderId;

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
        /** Example 1:  new item 
        StoreTable storeTable = new StoreTable();
        repository().save(storeTable);

        OrderAccepted orderAccepted = new OrderAccepted(storeTable);
        orderAccepted.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(orderplaced.get???()).ifPresent(storeTable->{
            
            storeTable // do something
            repository().save(storeTable);

            OrderAccepted orderAccepted = new OrderAccepted(storeTable);
            orderAccepted.publishAfterCommit();

         });
        */

    }

    public static void orderStaging(OrderCancelled orderCancelled) {
        /** Example 1:  new item 
        StoreTable storeTable = new StoreTable();
        repository().save(storeTable);

        OrderAccepted orderAccepted = new OrderAccepted(storeTable);
        orderAccepted.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(orderCancelled.get???()).ifPresent(storeTable->{
            
            storeTable // do something
            repository().save(storeTable);

            OrderAccepted orderAccepted = new OrderAccepted(storeTable);
            orderAccepted.publishAfterCommit();

         });
        */

    }
}
