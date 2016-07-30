package domain;

import javax.persistence.*;

/**
 * Created by heno on 7/30/16.
 */
@Entity
@Table(name = "ordered_product", catalog = "bib")
public class OrderedProduct {
    private OrderedProductId id;
    private Product product;
    private CustomerOrder customerOrder;
    private short quantity;

    public OrderedProduct() {
    }

    public OrderedProduct(OrderedProductId id, Product product,
                          CustomerOrder customerOrder, short quantity) {
        this.id = id;
        this.product = product;
        this.customerOrder = customerOrder;
        this.quantity = quantity;
    }

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "customerOrderId", column = @Column(name = "customer_order_id", nullable = false)),
            @AttributeOverride(name = "productId", column = @Column(name = "product_id", nullable = false)) })
    public OrderedProductId getId() {
        return this.id;
    }

    public void setId(OrderedProductId id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false, insertable = false, updatable = false)
    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_order_id", nullable = false, insertable = false, updatable = false)
    public CustomerOrder getCustomerOrder() {
        return this.customerOrder;
    }

    public void setCustomerOrder(CustomerOrder customerOrder) {
        this.customerOrder = customerOrder;
    }

    @Column(name = "quantity", nullable = false)
    public short getQuantity() {
        return this.quantity;
    }

    public void setQuantity(short quantity) {
        this.quantity = quantity;
    }
}
