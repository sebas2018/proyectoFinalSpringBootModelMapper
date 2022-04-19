package com.platzi.market.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "COMPRAS_PRODUCTOS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComprasProducto {

    @EmbeddedId //esta etiquete se utiliza cuando la llave primaria es compuesta
    private ComprasProductoPK id;
    private Integer cantidad;
    private Double total;
    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_compra", insertable = false, updatable = false)
    private Compra compra;

    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private Producto producto;


}
