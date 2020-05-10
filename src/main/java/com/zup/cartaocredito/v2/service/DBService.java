package com.zup.cartaocredito.v2.service;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Service;

import com.zup.cartaocredito.v2.entity.CartaoCredito;
import com.zup.cartaocredito.v2.entity.Cliente;
import com.zup.cartaocredito.v2.entity.Compra;
import com.zup.cartaocredito.v2.entity.Funcionario;
import com.zup.cartaocredito.v2.entity.Loja;
import com.zup.cartaocredito.v2.entity.MaquinaCartaoCredito;
import com.zup.cartaocredito.v2.entity.Pessoa;
import com.zup.cartaocredito.v2.repository.CartaoCreditoRepository;
import com.zup.cartaocredito.v2.repository.CompraRepository;
import com.zup.cartaocredito.v2.repository.LojaRepository;
import com.zup.cartaocredito.v2.repository.MaquinaCartaoCreditoRepository;
import com.zup.cartaocredito.v2.repository.PessoaRepository;

@Service
public class DBService {
	
	@Autowired
	private PessoaRepository usuarioRepository;
	
	@Autowired
	private CartaoCreditoRepository cartaoCreditoRepository;
	
	@Autowired
	private CompraRepository compraRepository;
	
	@Autowired
	private LojaRepository lojaRepository;
	
	@Autowired
	private MaquinaCartaoCreditoRepository maquinaCartaoCreditoRepository;
	
//	@Autowired
//	private BCryptPasswordEncoder pe;
	
	public void instanciateTestDatabase()throws ParseException{
		
		Pessoa user1 = new Cliente(null,"Carlos",LocalDate.now(),"11792993706", "12345" ,"caka19_rj@hotmail.com");
		Pessoa user2 = new Cliente(null,"Roberto",LocalDate.now(),"11792993707","12345" ,"caka199_rj@hotmail.com");
		Pessoa user3 = new Funcionario(null,"Juvenal",LocalDate.now(),"11792993708","12345" ,"carlosslopes1985@hotmail.com","T565647",LocalDate.now());
//		Usuario user4 = new Usuario(null,"Carlos",LocalDate.now(),"11792993706", pe.encode("12345") ,"caka19_rj@hotmail.com");
//		Usuario user5 = new Usuario(null,"Roberto",LocalDate.now(),"11792993707",pe.encode("12345") ,"caka19_rj@hotmail.com");
//		Usuario user6 = new Usuario(null,"Juvenal",LocalDate.now(),"11792993708",pe.encode("123678"),"carlosslopes1985@hotmail.com");
//		Usuario user7 = new Usuario(null,"Carlos",LocalDate.now(),"11792993706", pe.encode("123678"),"caka19_rj@hotmail.com");
//		Usuario user8 = new Usuario(null,"Roberto",LocalDate.now(),"11792993707",pe.encode("123678"),"caka19_rj@hotmail.com");
//		Usuario user9 = new Usuario(null,"Juvenal",LocalDate.now(),"11792993708",pe.encode("123678"),"carlosslopes1985@hotmail.com");
		user1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));               
		user2.getTelefones().addAll(Arrays.asList("27363323", "93838393"));
		user3.getTelefones().addAll(Arrays.asList("27363323", "93838393"));
		
		CartaoCredito cc  = new CartaoCredito(null, "Master", "4235879000023233", "239", 2500., 1000., 200.,LocalDate.now(), user1);
		CartaoCredito cc1 = new CartaoCredito(null, "Visa",   "4235879000023243", "238", 1500., 200., 400.,LocalDate.now(), user1);
		CartaoCredito cc2 = new CartaoCredito(null, "Alelo",  "4235879000023253", "237", 5500., 2000., 600.,LocalDate.now(), user2);
		CartaoCredito cc3 = new CartaoCredito(null, "Sodex",  "4235879000023263", "236", 7500., 4000., 2700.,LocalDate.now(), user3);
		
		Loja l1 = new Loja(null,"lojas americanas", "11792993706");
		Loja l2 = new Loja(null,"Magazine luiza", "11792993707");
		Loja l3 = new Loja(null,"Pernambucanas", "11792993708");
		Loja l4 = new Loja(null,"Mariza", "11792993709");
		Loja l5 = new Loja(null,"CieloAdmin", "11792993729");
		
		lojaRepository.saveAll(Arrays.asList(l1,l2,l3,l4,l5));
		
		MaquinaCartaoCredito m1 = new MaquinaCartaoCredito(null, "222fffrrr60", "123", l1);
		MaquinaCartaoCredito m2 = new MaquinaCartaoCredito(null, "222fffrrr56", "123", l2);
		MaquinaCartaoCredito m3 = new MaquinaCartaoCredito(null, "222fffrrr57", "123", l2);
		MaquinaCartaoCredito m4 = new MaquinaCartaoCredito(null, "222fffrrr58", "123", l3);
		MaquinaCartaoCredito m5 = new MaquinaCartaoCredito(null, "222fffrrr59", "123", l3);
		MaquinaCartaoCredito m6 = new MaquinaCartaoCredito(null, "222fffrrr51", "123", l2);
		MaquinaCartaoCredito m7 = new MaquinaCartaoCredito(null, "222fffrrr52", "123", l4);
		MaquinaCartaoCredito m8 = new MaquinaCartaoCredito(null, "222fffrrr53", "123", l1);
		MaquinaCartaoCredito m9 = new MaquinaCartaoCredito(null, "222fffrrr54", "123", l2);
		MaquinaCartaoCredito m10 = new MaquinaCartaoCredito(null,"222fffrrr55", "123", l1);
		MaquinaCartaoCredito m11 = new MaquinaCartaoCredito(null,"222fffrrr61", "123", l5);
		
		maquinaCartaoCreditoRepository.saveAll(Arrays.asList(m1,m2,m3,m4,m5,m6,m7,m8,m9,m10,m11));
		
		Compra c1 = new Compra(null,LocalDate.now(),1,200.,10,l1,user3,cc);
		Compra c2 = new Compra(null,LocalDate.now(),1,500.,1,l2,user1,cc3);
		Compra c3 = new Compra(null,LocalDate.now(),1,300.,1,l2,user2,cc2);
		Compra c4 = new Compra(null,LocalDate.now(),1,400.,1,l3,user2,cc1);
		Compra c5 = new Compra(null,LocalDate.now(),1,700.,1,l1,user3,cc2);
		Compra c6 = new Compra(null,LocalDate.now(),1,500.,1,l2,user2,cc1);
		Compra c7 = new Compra(null,LocalDate.now(),1,200.,1,l3,user3,cc3);
		
		usuarioRepository.saveAll(Arrays.asList(user1,user2,user3));
		cartaoCreditoRepository.saveAll(Arrays.asList(cc,cc1,cc2,cc3));
		compraRepository.saveAll(Arrays.asList(c1,c2,c3,c4,c5,c6,c7));
	}
}
