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
    private Long id;

    private Long userId;

    private Long menuId;

    private String orderStatus;

    private String address;

    private String userName;


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

        repository().findById(deliveryFinished.getOrderId()).ifPresent(orderTable->{
            
            orderTable.setOrderStatus("deliveryFinished");
            repository().save(orderTable);

            OrderFinished orderFinished = new OrderFinished(orderTable);
            orderFinished.publishAfterCommit();

         });

    }

    public static void orderProcess(DeliveryStarted deliveryStarted) {
        /** Example 1:  new item 
        OrderTable orderTable = new OrderTable();
        repository().save(orderTable);

        OrderFinished orderFinished = new OrderFinished(orderTable);
        orderFinished.publishAfterCommit();
        */
        repository().findById(deliveryStarted.getOrderId()).ifPresent(orderTable->{
            orderTable.setOrderStatus("delivery Started");
            repository().save(orderTable);

            OrderFinished orderFinished = new OrderFinished(orderTable);
            orderFinished.publishAfterCommit();

         });

    }

    public static void orderProcess(OrderRejected orderRejected) {
        
        repository().findById(orderRejected.getOrderId()).ifPresent(orderTable->{
            
            orderTable.setOrderStatus("orderRejected"); // do something
            repository().save(orderTable);

            OrderFinished orderFinished = new OrderFinished(orderTable);
            orderFinished.publishAfterCommit();

         });

    }
}
