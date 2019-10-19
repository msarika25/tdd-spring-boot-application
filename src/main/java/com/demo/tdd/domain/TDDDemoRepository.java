package com.demo.tdd.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TDDDemoRepository extends JpaRepository<Car, Long> {

	Car findByName(String name);

}
