package br.com.eaugusto.domain.jpa;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import javax.persistence.*;

/**
 * @author Eduardo Augusto (github.com/AsrielDreemurrGM/)
 * @since July 21, 2025
 */
@Entity
@Table(name = "tb_selling")
public class JPASelling implements IPersistable {

	public enum Status {
		STARTED, FINISHED, CANCELLED;

		public static Status getByName(String value) {
			for (Status status : Status.values()) {
				if (status.name().equalsIgnoreCase(value)) {
					return status;
				}
			}
			return null;
		}
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "selling_seq")
	@SequenceGenerator(name = "selling_seq", sequenceName = "seq_selling", initialValue = 1, allocationSize = 1)
	private Long id;

	@Column(name = "code", nullable = false, unique = true)
	private String code;

	@ManyToOne
	@JoinColumn(
		name = "id_client_fk",
		foreignKey = @ForeignKey(name = "fk_selling_client"),
		referencedColumnName = "id",
		nullable = false
	)
	private JPAClient client;

	@OneToMany(mappedBy = "selling", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<JPAProductQuantity> products;

	@Column(name = "total_price", nullable = false)
	private BigDecimal totalPrice;

	@Column(name = "date_sold", nullable = false)
	private Instant dateSold;

	@Enumerated(EnumType.STRING)
	@Column(name = "selling_status", nullable = false)
	private Status sellingStatus;

	public JPASelling() {
		products = new HashSet<>();
	}

	public String getCode() {
		return code;
	}

	public JPAClient getClient() {
		return client;
	}

	public Set<JPAProductQuantity> getProducts() {
		return products;
	}

	public Integer getTotalProductQuantity() {
		return products.stream()
			.reduce(0, (totalQuantity, product) -> totalQuantity + product.getQuantity(), Integer::sum);
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public Instant getDateSold() {
		return dateSold;
	}

	public Status getSellingStatus() {
		return sellingStatus;
	}

	public Long getId() {
		return id;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setClient(JPAClient client) {
		this.client = client;
	}

	public void setDateSold(Instant dateSold) {
		this.dateSold = dateSold;
	}

	public void setSellingStatus(Status sellingStatus) {
		this.sellingStatus = sellingStatus;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public void setProducts(Set<JPAProductQuantity> products) {
		this.products = products;
	}

	public void addProduct(JPAProduct product, Integer quantity) {
		validateStatus();
		Optional<JPAProductQuantity> optional = findProductQuantityByCode(product.getCode());

		if (optional.isPresent()) {
			JPAProductQuantity productQuantity = optional.get();
			productQuantity.add(quantity);
		} else {
			JPAProductQuantity productQuantity = new JPAProductQuantity();
			productQuantity.setSelling(this);
			productQuantity.setProduct(product);
			productQuantity.add(quantity);
			products.add(productQuantity);
		}
		recalculateTotalSellingPrice();
	}

	public void removeProduct(JPAProduct product, Integer quantity) {
		validateStatus();
		Optional<JPAProductQuantity> optional = findProductQuantityByCode(product.getCode());

		if (optional.isPresent()) {
			JPAProductQuantity productQuantity = optional.get();
			if (productQuantity.getQuantity() > quantity) {
				productQuantity.remove(quantity);
			} else {
				products.remove(productQuantity);
			}
			recalculateTotalSellingPrice();
		}
	}

	public void removeAllProducts() {
		validateStatus();
		products.clear();
		totalPrice = BigDecimal.ZERO;
	}

	public void recalculateTotalSellingPrice() {
		BigDecimal newTotalPrice = BigDecimal.ZERO;
		for (JPAProductQuantity product : this.products) {
			newTotalPrice = newTotalPrice.add(product.getTotalPrice());
		}
		this.totalPrice = newTotalPrice;
	}

	private Optional<JPAProductQuantity> findProductQuantityByCode(String code) {
		return products.stream()
			.filter(pq -> pq.getProduct().getCode().equals(code))
			.findAny();
	}

	private void validateStatus() {
		if (this.sellingStatus == Status.FINISHED) {
			throw new UnsupportedOperationException("CANNOT MODIFY A FINISHED SELLING");
		}
	}
}
