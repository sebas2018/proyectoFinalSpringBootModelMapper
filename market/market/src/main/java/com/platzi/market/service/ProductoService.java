package com.platzi.market.service;

import com.platzi.market.dto.ProductoDto;
import com.platzi.market.entity.Producto;
import com.platzi.market.repository.IProductoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    IProductoRepository iProductoRepository;

    @Autowired
    private ModelMapper modelMapper;

    private Producto producto;


    public ProductoService(IProductoRepository iProductoRepository, ModelMapper modelMapper) {
        this.iProductoRepository = iProductoRepository;
        this.modelMapper = modelMapper;

    }

    //----------------------ModelMapper--------------------------------------------------
    @Override
    public List<ProductoDto> listarProductos() {

        return iProductoRepository.findAll()
                .stream()
                .map(this::converterEntityToDto)//this::converterEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductoDto> buscarProductoPorId(Integer idProducto) {
        return iProductoRepository.findById(idProducto)
                .stream()
                .map(this::converterEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductoDto> buscarProductosPorIdCategoria(Integer idCategoria) {
        return iProductoRepository.buscarProductosPorIdCategoria(idCategoria)
                .stream()
                .map(this::converterEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductoDto> buscarPorductosPorCantidadStockMenorqueValorYporEstado(Integer cantidadStock, String estado) {
        return iProductoRepository.findByCantidadStockLessThanAndEstado(cantidadStock, estado)
                .stream()
                .map(this::converterEntityToDto)
                .collect(Collectors.toList());

    }

    @Override
    public void guardarProducto(ProductoDto productoDto) throws Exception {
        //Integer secuenciaActual = Math.toIntExact(iProductoRepository.currentSequence());
        List<Producto> producto = iProductoRepository.findByCodigoBarras(productoDto.getCodigoBarras());

        if (!producto.isEmpty())
            throw new Exception("EL PRODUCTO YA EXISTE EN LA BD");

        //producto
        // .stream()
        //.map(ProductoDto::new);

        iProductoRepository.save(converterDtoToEntity(productoDto));


    }

    @Override
    public void actualizarProducto(ProductoDto productoDto, Integer idProducto) throws Exception {
        Producto producto = iProductoRepository.findByIdProducto(idProducto);
        System.out.println(producto);

        if (producto.getIdProducto() == null)
            throw new Exception("El producto no se encuentra en la base de datos");

        producto.setCantidadStock(productoDto.getCantidadStock());
        producto.setPrecioVenta(productoDto.getPrecioVenta());
        iProductoRepository.save(producto);


    }


    private ProductoDto converterEntityToDto(Producto producto) {
        ProductoDto productoDto;
        productoDto = modelMapper.map(producto, ProductoDto.class);
        return productoDto;
    }
    //--------------------------------------------------------------------------------------------------

    private Producto converterDtoToEntity(ProductoDto productoDto) {
        Producto producto;
        producto = modelMapper.map(productoDto, Producto.class);
        return producto;

    }

}
