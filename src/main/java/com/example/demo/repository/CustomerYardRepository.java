package com.example.demo.repository;


import com.example.demo.domain.CustomerYard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerYardRepository extends JpaRepository<CustomerYard,Long> {

    @Query ("SELECT (case when count(cy) > 0 then true else false end) from CustomerYard cy " +
            "where cy.customer.id =?1 and cy.yard.id =?2")
    Boolean existsByCustomerId (Long idCustomer, Long idYard);

    @Query ("SELECT (case when count(cy) > 0 then true else false end) from CustomerYard cy " +
            "where cy.customer.id =?1 ")
    Boolean existsByCustomerId (Long idCustomer);

    @Query ("SELECT (case when count(cy) > 0 then true else false end) from CustomerYard cy where cy.yard.id =?1")
    Boolean existsByYardId (Long idYard);

}
