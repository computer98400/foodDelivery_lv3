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
// @RequestMapping(value="/storeTables")
@Transactional
public class StoreTableController {

    @Autowired
    StoreTableRepository storeTableRepository;

    @RequestMapping(
        value = "storeTables/{id}/cookingstart",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public StoreTable cookingStart(
        @PathVariable(value = "id") Long id,
        @RequestBody CookingStartCommand cookingStartCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /storeTable/cookingStart  called #####");
        Optional<StoreTable> optionalStoreTable = storeTableRepository.findById(
            id
        );

        optionalStoreTable.orElseThrow(() -> new Exception("No Entity Found"));
        StoreTable storeTable = optionalStoreTable.get();
        storeTable.cookingStart(cookingStartCommand);

        storeTableRepository.save(storeTable);
        return storeTable;
    }

    @RequestMapping(
        value = "storeTables/{id}/cookingfinish",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public StoreTable cookingFinish(
        @PathVariable(value = "id") Long id,
        @RequestBody CookingFinishCommand cookingFinishCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /storeTable/cookingFinish  called #####");
        Optional<StoreTable> optionalStoreTable = storeTableRepository.findById(
            id
        );

        optionalStoreTable.orElseThrow(() -> new Exception("No Entity Found"));
        StoreTable storeTable = optionalStoreTable.get();
        storeTable.cookingFinish(cookingFinishCommand);

        storeTableRepository.save(storeTable);
        return storeTable;
    }
}
