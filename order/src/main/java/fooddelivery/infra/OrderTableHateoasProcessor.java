package fooddelivery.infra;

import fooddelivery.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class OrderTableHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<OrderTable>> {

    @Override
    public EntityModel<OrderTable> process(EntityModel<OrderTable> model) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/ordercancel")
                .withRel("ordercancel")
        );

        return model;
    }
}
