package com.platzi.market.converter;

import com.platzi.market.dto.CategoriaDto;
import com.platzi.market.entity.Categoria;

public class CategoriaConverter {

    public static Categoria categoriaDtoToCategoriaEntity(CategoriaDto categoriaDto){
        return Categoria.builder()
                .idCategoria(categoriaDto.getIdCategoria())
                .descripcion(categoriaDto.getDescripcion())
                .estado(categoriaDto.getEstado())
                .build();
    }

    public static CategoriaDto categoriaToCategoriaDto(Categoria categoria){
        return CategoriaDto.builder()
                .idCategoria(categoria.getIdCategoria())
                .descripcion(categoria.getDescripcion())
                .estado(categoria.getEstado())
                .build();
    }
}
