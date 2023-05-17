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
// @RequestMapping(value="/riderTables")
@Transactional
public class RiderTableController {

    @Autowired
    RiderTableRepository riderTableRepository;

    @RequestMapping(
        value = "riderTables/{id}/deliveryfinish",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public RiderTable deliveryFinish(
        @PathVariable(value = "id") Long id,
        @RequestBody DeliveryFinishCommand deliveryFinishCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /riderTable/deliveryFinish  called #####");
        Optional<RiderTable> optionalRiderTable = riderTableRepository.findById(
            id
        );

        optionalRiderTable.orElseThrow(() -> new Exception("No Entity Found"));
        RiderTable riderTable = optionalRiderTable.get();
        riderTable.deliveryFinish(deliveryFinishCommand);

        riderTableRepository.save(riderTable);
        return riderTable;
    }
}
