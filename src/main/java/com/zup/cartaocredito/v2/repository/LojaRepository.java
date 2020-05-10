package com.zup.cartaocredito.v2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zup.cartaocredito.v2.entity.Loja;

@Repository
public interface LojaRepository extends JpaRepository<Loja, Integer> {

	Loja findByCnpj(String cnpj);
	
}
