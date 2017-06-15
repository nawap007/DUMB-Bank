package com.zoom.cce.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zoom.cce.domain.TransactionType;


@Repository
public interface TransactionTypeRepository extends CrudRepository<TransactionType, Long>{

}
