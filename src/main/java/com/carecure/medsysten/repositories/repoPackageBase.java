package com.carecure.medsysten.repositories;

import com.carecure.medsysten.resources.resPackageBase;
import org.springframework.data.repository.CrudRepository;

public interface repoPackageBase extends CrudRepository<resPackageBase,Long> {
    long countByMemberships();
}
