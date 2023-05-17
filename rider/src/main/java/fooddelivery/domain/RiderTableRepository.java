package fooddelivery.domain;

import fooddelivery.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "riderTables",
    path = "riderTables"
)
public interface RiderTableRepository
    extends PagingAndSortingRepository<RiderTable, Long> {}
