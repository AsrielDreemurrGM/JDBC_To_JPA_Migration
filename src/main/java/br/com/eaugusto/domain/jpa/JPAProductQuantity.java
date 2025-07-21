package br.com.eaugusto.domain.jpa;

import java.math.BigDecimal;
import javax.persistence.*;

/**
 * @author Eduardo Augusto (github.com/AsrielDreemurrGM/)
 * @since July 21, 2025
 */
@Entity
@Table(name = "tb_product_quantity")
public class JPAProductQuantity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_quantity_seq")
	@SequenceGenerator(name = "product_quantity_seq", sequenceName = "sq_product_quantity", initialValue = 1, allocationSize = 1)
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL)
	private JPAProduct product;

	@Column(name = "quantity", nullable = false)
	private Integer quantity;

	@Column(name = "total_price", nullable = false)
	private BigDecimal totalPrice;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(
		name = "id_selling_fk",
		foreignKey = @ForeignKey(name = "fk_product_quantity_selling"),
		referencedColumnName = "id",
		nullable = false
	)
	private JPASelling selling;

	public JPAProductQuantity() {
		this.quantity = 0;
		this.totalPrice = BigDecimal.ZERO;
	}

	public JPAProduct getProduct() {
		return product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public Long getId() {
		return id;
	}

	public JPASelling getSelling() {
		return selling;
	}

	public void setProduct(JPAProduct product) {
		this.product = product;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setSelling(JPASelling selling) {
		this.selling = selling;
	}

	public void add(Integer quantity) {
		this.quantity += quantity;
		BigDecimal newPrice = this.product.getPrice().multiply(BigDecimal.valueOf(quantity));
		this.totalPrice = this.totalPrice.add(newPrice);
	}

	public void remove(Integer quantity) {
		if (quantity > this.quantity) {
			throw new IllegalArgumentException("Cannot remove more than existing quantity.");
		}
		this.quantity -= quantity;
		BigDecimal newPrice = this.product.getPrice().multiply(BigDecimal.valueOf(quantity));
		this.totalPrice = this.totalPrice.subtract(newPrice);
	}
}
