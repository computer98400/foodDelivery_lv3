package fooddelivery.domain;

import fooddelivery.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "storeTables",
    path = "storeTables"
)
public interface StoreTableRepository
    extends PagingAndSortingRepository<StoreTable, Long> {}
