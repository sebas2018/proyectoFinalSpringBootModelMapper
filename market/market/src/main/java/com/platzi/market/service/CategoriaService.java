package com.platzi.market.service;

import com.platzi.market.converter.CategoriaConverter;
import com.platzi.market.dto.CategoriaDto;
import com.platzi.market.repository.ICategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService implements ICategoriaService{

    @Autowired
    ICategoriaRepository iCategoriaRepository;

    @Override
    public void guardarCategoria(CategoriaDto categoriaDto) throws Exception {
        Optional categoria = iCategoriaRepository.findById(categoriaDto.getIdCategoria());
        if (categoria.isPresent())
            throw new Exception("No se pudo insertar la categoria por que ya existe en la bd");
        iCategoriaRepository.save(CategoriaConverter.categoriaDtoToCategoriaEntity(categoriaDto));
    }
}
