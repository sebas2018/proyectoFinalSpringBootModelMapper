package com.platzi.market.controller;

import com.platzi.market.dto.ProductoDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.websocket.server.PathParam;

public interface IProductoController {

    //----------------------------ModelMapper-------------------------------
    ResponseEntity<?> listarTodosLosProductos();
    ResponseEntity<?> buscarProductoPorId(@PathVariable Integer idProducto)throws Exception;
    ResponseEntity<?> buscarProductosPorIdCategoria(@PathVariable Integer idCategoria)throws Exception;
    ResponseEntity<?> buscarPorductosPorCantidadStockMenorqueValorYporEstado(@PathVariable Integer cantidadStock, @PathVariable String estado) throws  Exception;
    ResponseEntity<?> guardarProducto(@RequestBody ProductoDto productoDto) throws Exception;
    ResponseEntity<?> actualizarProducto(@RequestBody ProductoDto productoDto, Integer idProducto )throws Exception;
    //------------------------------------------------------------------



}
