package com.platzi.market.repository;


import com.platzi.market.dto.ProductoDto;
import com.platzi.market.entity.Producto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//@Qualifier("dresses")
@Repository
public interface IProductoRepository extends JpaRepository<Producto, Integer> {

    //forma apropiada
    List<Producto> findByIdCategoria(int idCategoria);//Consulta los productos de una categoria

    List<Producto> findByCodigoBarras(String codigoBarras);

    //froma nativa
    @Query(value = "SELECT * FROM PRODUCTOS WHERE id_categoria = ?", nativeQuery = true)
    List<Producto> buscarProductosPorIdCategoria(int idCategoria);


    //forma apropiada
    List<Producto>findByCantidadStockLessThanAndEstado(int cantidadStock, String estado);

    //@Query(value = "SELECT producto.nombre FROM PRODUCTOS producto WHERE producto.cantidad_stock < cantidad_stock  AND producto.estado = :estado", nativeQuery = true)
    //Optional<List<Producto>> buscarProductosConCantidadStockMenorAvalorYEstadoAc(@Param("cantidad_stock") Integer cantidadStock, @Param("estado") String estado);

    // Obtenga el siguiente valor de la secuencia de Oracle, el tipo de retorno del método es Long o String puede ejecutarse normalmente
    @Query(value = "SELECT SEC_CODIGOPRODUCTO.nextval from DUAL", nativeQuery = true)
    Long currentSequence();

    Producto findByIdProducto(Integer idProducto);


}
