package com.platzi.market.service;

import com.platzi.market.dto.CategoriaDto;
import com.platzi.market.dto.ProductoDto;

public interface ICategoriaService {
    void guardarCategoria (CategoriaDto categoriaDto)throws Exception;
}
