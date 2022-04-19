package com.platzi.market.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CATEGORIAS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Integer idCategoria;
    private String descripcion;
    private String estado;
    @OneToMany(mappedBy = "categoria") //el atributo de la tabla producto que respalda la relacion o cardinalidad (OneToMany@) es categoria y esta relacion solo sirve para saber la lista de productos que pertenecen a una categoria en especifico
    private List<Producto> productos;


}
