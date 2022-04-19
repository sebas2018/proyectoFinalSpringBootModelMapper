package com.platzi.market.service;
import com.platzi.market.dto.ProductoDto;
import com.platzi.market.entity.Producto;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

public interface IProductoService {
    //----------------------------ModelMapper-------------------------------
    List<ProductoDto> listarProductos();

    List<ProductoDto> buscarProductoPorId(Integer idProducto);

    List<ProductoDto> buscarProductosPorIdCategoria(Integer idCategoria);

    //List<ProductoDto> buscarPorductosPorCantidadStockMenorqueValorYporEstado(@PathParam("cantidad_stock") Integer cantidadStock, @PathParam("estado") String estado);
    List<ProductoDto> buscarPorductosPorCantidadStockMenorqueValorYporEstado(Integer cantidadStock, String estado);//La linea 17 tambien es otra forma de hacer la query y funciona
    void guardarProducto (ProductoDto productoDto)throws Exception;

    void actualizarProducto (ProductoDto productoDto, Integer idProducto) throws Exception;
    //----------------------------------------------------------------------


}

