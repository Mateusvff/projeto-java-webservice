package com.example.demo.domain;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class ItemPedidoPK implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ItemPedidoPK)) return false;
        ItemPedidoPK that = (ItemPedidoPK) obj;
        return Objects.equals(getPedido(), that.getPedido()) && Objects.equals(getProduto(), that.getProduto());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPedido(), getProduto());
    }
}
