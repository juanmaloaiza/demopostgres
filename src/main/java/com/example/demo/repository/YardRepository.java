package com.example.demo.repository;


import com.example.demo.domain.Yard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YardRepository extends JpaRepository<Yard,Long> {

}
