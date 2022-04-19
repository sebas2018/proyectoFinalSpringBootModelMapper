package com.platzi.market.repository;

import com.platzi.market.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICategoriaRepository extends JpaRepository<Categoria, Integer> {



}
