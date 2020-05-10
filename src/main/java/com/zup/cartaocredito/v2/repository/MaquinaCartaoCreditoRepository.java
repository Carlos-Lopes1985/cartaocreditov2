package com.zup.cartaocredito.v2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zup.cartaocredito.v2.entity.MaquinaCartaoCredito;

@Repository
public interface MaquinaCartaoCreditoRepository extends JpaRepository<MaquinaCartaoCredito, Integer> {

	MaquinaCartaoCredito findBySerial(String serial);
}
