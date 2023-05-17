package fooddelivery.domain;

import fooddelivery.OrderApplication;
import fooddelivery.domain.OrderFinished;
import fooddelivery.domain.Orderplaced;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "OrderTable_table")
@Data
public class OrderTable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

    private Long userId;

    private Long menuId;

    private String orderStatus;

    private String address;

    private String userName;

    private Long storeId;

    private String storeName;

    @PostPersist
    public void onPostPersist() {
        Orderplaced orderplaced = new Orderplaced(this);
        orderplaced.publishAfterCommit();

        OrderFinished orderFinished = new OrderFinished(this);
        orderFinished.publishAfterCommit();
    }

    public static OrderTableRepository repository() {
        OrderTableRepository orderTableRepository = OrderApplication.applicationContext.getBean(
            OrderTableRepository.class
        );
        return orderTableRepository;
    }

    public void orderCancel(OrderCancelCommand orderCancelCommand) {
        OrderCancelled orderCancelled = new OrderCancelled(this);
        orderCancelled.publishAfterCommit();
    }

    public static void orderProcess(DeliveryFinished deliveryFinished) {
        /** Example 1:  new item 
        OrderTable orderTable = new OrderTable();
        repository().save(orderTable);

        OrderFinished orderFinished = new OrderFinished(orderTable);
        orderFinished.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryFinished.get???()).ifPresent(orderTable->{
            
            orderTable // do something
            repository().save(orderTable);

            OrderFinished orderFinished = new OrderFinished(orderTable);
            orderFinished.publishAfterCommit();

         });
        */

    }

    public static void orderProcess(DeliveryStarted deliveryStarted) {
        /** Example 1:  new item 
        OrderTable orderTable = new OrderTable();
        repository().save(orderTable);

        OrderFinished orderFinished = new OrderFinished(orderTable);
        orderFinished.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryStarted.get???()).ifPresent(orderTable->{
            
            orderTable // do something
            repository().save(orderTable);

            OrderFinished orderFinished = new OrderFinished(orderTable);
            orderFinished.publishAfterCommit();

         });
        */

    }

    public static void orderProcess(OrderRejected orderRejected) {
        /** Example 1:  new item 
        OrderTable orderTable = new OrderTable();
        repository().save(orderTable);

        OrderFinished orderFinished = new OrderFinished(orderTable);
        orderFinished.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(orderRejected.get???()).ifPresent(orderTable->{
            
            orderTable // do something
            repository().save(orderTable);

            OrderFinished orderFinished = new OrderFinished(orderTable);
            orderFinished.publishAfterCommit();

         });
        */

    }

    public static void orderProcess(OrderAccepted orderAccepted) {
        /** Example 1:  new item 
        OrderTable orderTable = new OrderTable();
        repository().save(orderTable);

        OrderFinished orderFinished = new OrderFinished(orderTable);
        orderFinished.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(orderAccepted.get???()).ifPresent(orderTable->{
            
            orderTable // do something
            repository().save(orderTable);

            OrderFinished orderFinished = new OrderFinished(orderTable);
            orderFinished.publishAfterCommit();

         });
        */

    }
}
