package com.platzi.market.dto;

import com.platzi.market.entity.Categoria;
import com.platzi.market.entity.ComprasProducto;
import com.platzi.market.entity.Producto;
import lombok.*;


import java.io.Serializable;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;

//@Data // crea getter and setter
@AllArgsConstructor // crea constructor
@NoArgsConstructor // crea constructor sin parametros
@Getter
@Setter
@Builder // crea constructores personalizados
public class ProductoDto implements Serializable {

    private Integer idProducto;
    private String nombre;
    private Integer idCategoria;
    private String codigoBarras;
    private Double precioVenta;
    private Integer cantidadStock;
    private String estado;
    //private Categoria categoria;
   // private List<ComprasProducto> compras;




}
