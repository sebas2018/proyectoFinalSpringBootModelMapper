package com.platzi.market.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "PRODUCTOS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id //esta etiqueta se utiliza cuando la llave primaria es sencilla es decir no es compuesta
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer idProducto;//Este atributo se llama distinto al campo de la bd por eso hay que poner la anotacion @Column
    private String nombre;//Este atributo se llama igual que en el campo de la bd por eso no se pone la etiqueta @Column
    @Column(name = "id_categoria")
    private Integer idCategoria;
    @Column(name = "codigo_barras")
    private String codigoBarras;
    @Column(name = "precio_venta")
    private Double precioVenta;
    @Column(name = "cantidad_stock")
    private Integer cantidadStock;
    private String estado;
    @ManyToOne
    @JoinColumn(name = "id_categoria", insertable = false, updatable = false)// a traves de la relacion(@ManyToOne) no se van a insertar ni actualizar una nueva categoria ya que esas acciones se hacen directamente desde la entity categoria la relacion solo sirve para saber a que categoria pertenece un producto
    private Categoria categoria;
    //@OneToMany(mappedBy = "compra" ) // no es una relacion que genere mucho valor por eso no es necesario crear todas las relaciones
    //private List<ComprasProducto>  compras; //Lista de compras que incluyeron un producto
}
