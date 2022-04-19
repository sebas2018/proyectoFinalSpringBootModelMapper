package com.platzi.market.controller;

import com.platzi.market.dto.CategoriaDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface ICategoriaController {
    ResponseEntity<?> registrarCategoria(@RequestBody CategoriaDto categoriaDto);
}
