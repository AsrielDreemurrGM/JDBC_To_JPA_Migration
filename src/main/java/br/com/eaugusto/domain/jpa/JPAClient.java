package br.com.eaugusto.domain.jpa;

import javax.persistence.*;

/**
 * Author: Eduardo Augusto (github.com/AsrielDreemurrGM/)
 * @since July 21, 2025
 */
@Entity
@Table(name = "tb_client")
public class JPAClient implements IPersistable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_seq")
	@SequenceGenerator(name = "client_seq", sequenceName = "sq_client", initialValue = 1, allocationSize = 1)
	private Long id;

	@Column(name = "name", nullable = false, length = 50)
	private String name;

	@Column(name = "cpf", nullable = false, unique = true)
	private Long cpf;

	@Column(name = "phone", nullable = false)
	private Long phone;

	@Column(name = "address", nullable = false, length = 100)
	private String address;

	@Column(name = "address_number", nullable = false)
	private Integer addressNumber;

	@Column(name = "city", nullable = false, length = 100)
	private String city;

	@Column(name = "state", nullable = false, length = 50)
	private String state;

	public String getName() {
		return name;
	}

	public Long getCpf() {
		return cpf;
	}

	public Long getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}

	public Integer getAddressNumber() {
		return addressNumber;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setAddressNumber(Integer addressNumber) {
		this.addressNumber = addressNumber;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
}
