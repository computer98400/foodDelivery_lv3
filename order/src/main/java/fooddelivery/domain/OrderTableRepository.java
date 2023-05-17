package fooddelivery.domain;

import fooddelivery.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "orderTables",
    path = "orderTables"
)
public interface OrderTableRepository
    extends PagingAndSortingRepository<OrderTable, Long> {}
