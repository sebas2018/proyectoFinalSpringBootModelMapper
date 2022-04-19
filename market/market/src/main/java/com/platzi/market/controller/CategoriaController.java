package com.platzi.market.controller;

import com.platzi.market.dto.CategoriaDto;
import com.platzi.market.service.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/market")
public class CategoriaController implements ICategoriaController{

    @Autowired
    ICategoriaService iCategoriaService;

    @Override
    @PostMapping("/registrarCategoria")
    public ResponseEntity<?> registrarCategoria(@RequestBody CategoriaDto categoriaDto) {
        try {
            iCategoriaService.guardarCategoria(categoriaDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e,HttpStatus.CONFLICT);

        }
    }
}
