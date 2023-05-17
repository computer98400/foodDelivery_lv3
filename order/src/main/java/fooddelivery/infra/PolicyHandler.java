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
    OrderTableRepository orderTableRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeliveryFinished'"
    )
    public void wheneverDeliveryFinished_OrderProcess(
        @Payload DeliveryFinished deliveryFinished
    ) {
        DeliveryFinished event = deliveryFinished;
        System.out.println(
            "\n\n##### listener OrderProcess : " + deliveryFinished + "\n\n"
        );

        // Sample Logic //
        OrderTable.orderProcess(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeliveryStarted'"
    )
    public void wheneverDeliveryStarted_OrderProcess(
        @Payload DeliveryStarted deliveryStarted
    ) {
        DeliveryStarted event = deliveryStarted;
        System.out.println(
            "\n\n##### listener OrderProcess : " + deliveryStarted + "\n\n"
        );

        // Sample Logic //
        OrderTable.orderProcess(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderRejected'"
    )
    public void wheneverOrderRejected_OrderProcess(
        @Payload OrderRejected orderRejected
    ) {
        OrderRejected event = orderRejected;
        System.out.println(
            "\n\n##### listener OrderProcess : " + orderRejected + "\n\n"
        );

        // Sample Logic //
        OrderTable.orderProcess(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderAccepted'"
    )
    public void wheneverOrderAccepted_OrderProcess(
        @Payload OrderAccepted orderAccepted
    ) {
        OrderAccepted event = orderAccepted;
        System.out.println(
            "\n\n##### listener OrderProcess : " + orderAccepted + "\n\n"
        );

        // Sample Logic //
        OrderTable.orderProcess(event);
    }
}
