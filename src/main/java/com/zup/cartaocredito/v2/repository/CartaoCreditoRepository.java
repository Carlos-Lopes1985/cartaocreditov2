package com.zup.cartaocredito.v2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zup.cartaocredito.v2.entity.CartaoCredito;

@Repository
public interface CartaoCreditoRepository extends JpaRepository<CartaoCredito, Integer>{
	
	CartaoCredito findByNumeroCartao(String numero);
	
	CartaoCredito findByNumeroCartaoAndCodSeguranca(String numero, String codSeguranca);
}
