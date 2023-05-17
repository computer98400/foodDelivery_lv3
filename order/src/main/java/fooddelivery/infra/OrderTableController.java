package fooddelivery.infra;

import fooddelivery.domain.*;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @RequestMapping(value="/orderTables")
@Transactional
public class OrderTableController {

    @Autowired
    OrderTableRepository orderTableRepository;

    @RequestMapping(
        value = "orderTables/{id}/ordercancel",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public OrderTable orderCancel(
        @PathVariable(value = "id") Long id,
        @RequestBody OrderCancelCommand orderCancelCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /orderTable/orderCancel  called #####");
        Optional<OrderTable> optionalOrderTable = orderTableRepository.findById(
            id
        );

        optionalOrderTable.orElseThrow(() -> new Exception("No Entity Found"));
        OrderTable orderTable = optionalOrderTable.get();
        orderTable.orderCancel(orderCancelCommand);

        orderTableRepository.save(orderTable);
        return orderTable;
    }
}
