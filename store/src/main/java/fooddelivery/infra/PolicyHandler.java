package fooddelivery.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import fooddelivery.config.kafka.KafkaProcessor;
import fooddelivery.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PolicyHandler {

    @Autowired
    StoreTableRepository storeTableRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderPlaced'"
    )
    public void wheneverOrderPlaced_OrderStaging(
        @Payload OrderPlaced orderplaced
    ) {
        OrderPlaced event = orderplaced;
        System.out.println(
            "\n\n##### listener OrderStaging : " + orderplaced + "\n\n"
        );

        // Sample Logic //
        if(event.getOrderStatus().equals("orderPlaced")) {
            StoreTable.orderStaging(event);
        }
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderCancelled'"
    )
    public void wheneverOrderCancelled_OrderStaging(
        @Payload OrderCancelled orderCancelled
    ) {
        OrderCancelled event = orderCancelled;
        System.out.println(
            "\n\n##### listener OrderStaging : " + orderCancelled + "\n\n"
        );

        // Sample Logic //
        if(event.getStatus()!=null && event.getStatus().equals("orderCancelled")) {
            StoreTable.orderStaging(event);
        }
    }
}
