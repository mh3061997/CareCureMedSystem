package com.carecure.medsysten.repositories;

import com.carecure.medsysten.resources.resPackageBase;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface repoPackageBase extends CrudRepository<resPackageBase,Long> {
    //long countByMemberships();
    List<resPackageBase> findByStatus(String status);
}
