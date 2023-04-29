package com.pryabykh.onetomanyassotiation.repositories;

import com.pryabykh.onetomanyassotiation.entities.Petition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PetitionRepository extends JpaRepository<Petition, Long>, JpaSpecificationExecutor<Petition> {
}
