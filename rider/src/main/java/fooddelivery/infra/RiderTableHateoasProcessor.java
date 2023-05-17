package fooddelivery.infra;

import fooddelivery.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class RiderTableHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<RiderTable>> {

    @Override
    public EntityModel<RiderTable> process(EntityModel<RiderTable> model) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/deliveryfinish")
                .withRel("deliveryfinish")
        );

        return model;
    }
}
