package com.vithal.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vithal.code.entity.WikkiediaData;

public interface WikkiRepo extends JpaRepository<WikkiediaData, Long> {

}
