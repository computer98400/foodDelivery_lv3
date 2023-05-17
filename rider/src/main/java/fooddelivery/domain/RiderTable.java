package fooddelivery.domain;

import fooddelivery.RiderApplication;
import fooddelivery.domain.DeliveryStarted;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "RiderTable_table")
@Data
public class RiderTable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long riderId;

    private String address;

    private Long userId;

    private Long menuId;

    private String riderName;

    @PostPersist
    public void onPostPersist() {
        DeliveryStarted deliveryStarted = new DeliveryStarted(this);
        deliveryStarted.publishAfterCommit();
    }

    public static RiderTableRepository repository() {
        RiderTableRepository riderTableRepository = RiderApplication.applicationContext.getBean(
            RiderTableRepository.class
        );
        return riderTableRepository;
    }

    public void deliveryFinish(DeliveryFinishCommand deliveryFinishCommand) {
        DeliveryFinished deliveryFinished = new DeliveryFinished(this);
        deliveryFinished.publishAfterCommit();
    }

    public static void riderPick(CookingProcessed cookingProcessed) {

        RiderTable riderTable = new RiderTable();
        riderTable.setStoreId(cookingProcessed.getStoreId());
        riderTable.setStoreId(cookingProcessed.getStoreName());
        riderTable.setAddress(cookingProcessed.getAddress());
        riderTable.setOrderId(cookingProcessed.getOrderId());

        repository().save(riderTable);

        DeliveryStarted deliveryStarted = new DeliveryStarted(riderTable);
        deliveryStarted.publishAfterCommit();

        /** Example 2:  finding and process
        
        repository().findById(cookingProcessed.get???()).ifPresent(riderTable->{
            
            riderTable // do something
            repository().save(riderTable);

            DeliveryStarted deliveryStarted = new DeliveryStarted(riderTable);
            deliveryStarted.publishAfterCommit();

         });
        */

    }
}
