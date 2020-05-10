package com.zup.cartaocredito.v2.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Loja implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(unique=true)
	private String nome;
	
	@Column(unique=true)
	private String cnpj;
	
	@OneToMany(mappedBy = "loja")
	private List<Compra> compra;
	
	@JsonIgnore
	@OneToMany(mappedBy = "loja")
	private List<MaquinaCartaoCredito> maquinaCartao = new ArrayList<MaquinaCartaoCredito>();
	
//	@ElementCollection(fetch = FetchType.EAGER)
//	@CollectionTable(name="PERFIS")
//	private Set<Integer> perfis = new HashSet<>();
//	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Loja [id=");
		builder.append(getId());
		builder.append(", nome=");
		builder.append(getNome());
		builder.append(", cnpj=");
		builder.append(getCnpj());
		builder.append("]");
		return builder.toString();
	}


	public Loja(Integer id, String nome, String cnpj) {
		super();
		this.id = id;
		this.nome = nome;
		//this.senha = senha;
		this.cnpj = cnpj;
		//addPerfil(Perfil.CLIENTE);
	}

	public Loja(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	//	addPerfil(Perfil.CLIENTE);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Compra> getCompras() {
		return compra;
	}

	public void setCompras(List<Compra> compras) {
		this.compra = compras;
	}

	public List<MaquinaCartaoCredito> getMaquinaCartao() {
		return maquinaCartao;
	}

	public void setMaquinaCartao(List<MaquinaCartaoCredito> maquinaCartao) {
		this.maquinaCartao = maquinaCartao;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
//	//responsável por retornar todos os perfils do usuário
//	public Set<Perfil> getPerfils(){
//		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
//		
//	}
//	
//	public void addPerfil(Perfil perfil) {
//		perfis.add(perfil.getCod());
//	}
	
}
