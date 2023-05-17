package fooddelivery.infra;

import fooddelivery.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class StoreTableHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<StoreTable>> {

    @Override
    public EntityModel<StoreTable> process(EntityModel<StoreTable> model) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/cookingstart")
                .withRel("cookingstart")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/cookingfinish")
                .withRel("cookingfinish")
        );

        return model;
    }
}
