package com.platzi.market.dto;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor // crea constructor
@NoArgsConstructor // crea constructor sin parametros
@Getter
@Setter
@Builder // crea constructores personalizados
public class CategoriaDto implements Serializable{

    private Integer idCategoria;
    private String descripcion;
    private String estado;


}
