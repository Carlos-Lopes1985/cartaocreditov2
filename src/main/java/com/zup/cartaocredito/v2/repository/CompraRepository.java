package com.zup.cartaocredito.v2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zup.cartaocredito.v2.entity.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Integer> {
	
	//Compra findByDataCompraAndCodSeguranca(String numero, String codSeguranca);
	
}
