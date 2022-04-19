package com.platzi.market.controller;
import com.platzi.market.dto.ProductoDto;
import com.platzi.market.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/market")
public class ProductoController implements IProductoController {

    @Autowired
    IProductoService iProductoService;

    //-----------------------------------ModelMapper---------------------------------------------------------
    @Override
    @GetMapping("/listarProductos")
    public ResponseEntity<?> listarTodosLosProductos() {
        try {

            return new ResponseEntity<>(iProductoService.listarProductos(), HttpStatus.OK);

        }catch (Exception e){

            return new ResponseEntity<>(e,HttpStatus.CONFLICT);

        }
    }

    @Override
    @GetMapping("/buscarProductoPorId/{idProducto}")
    public ResponseEntity<?> buscarProductoPorId(Integer idProducto) throws Exception {
        try {

            return new ResponseEntity<>(iProductoService.buscarProductoPorId(idProducto),HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(e, HttpStatus.CONFLICT);
        }

    }

    @Override
    @GetMapping("/buscarProductosPorIdCategoria/{idCategoria}")
    public ResponseEntity<?> buscarProductosPorIdCategoria(Integer idCategoria) throws Exception {
        try {

            return new ResponseEntity<>(iProductoService.buscarProductosPorIdCategoria(idCategoria),HttpStatus.OK);

        }catch (Exception e){
            return  new ResponseEntity<>(e,HttpStatus.CONFLICT);
        }
    }

    @Override
    @GetMapping("/buscarPorductosPorCantidadStockMenorqueValorYporEstado/{cantidadStock}/{estado}")
    public ResponseEntity<?> buscarPorductosPorCantidadStockMenorqueValorYporEstado(Integer cantidadStock, String estado) throws Exception {
        try {
            return new ResponseEntity<>(iProductoService.buscarPorductosPorCantidadStockMenorqueValorYporEstado(cantidadStock,estado),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e, HttpStatus.CONFLICT);
        }
    }

    @Override
    @PostMapping("/guardarProducto")
    public ResponseEntity<?> guardarProducto(@RequestBody ProductoDto productoDto) throws Exception {
        try {
            iProductoService.guardarProducto(productoDto);
            return  new ResponseEntity<>(productoDto,HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(e, HttpStatus.CONFLICT);
        }
    }

    @Override
    @PutMapping("/actualizarProducto/{idProducto}")
    public ResponseEntity<?> actualizarProducto(@RequestBody ProductoDto productoDto, @PathVariable Integer idProducto) throws Exception {
        try {

                iProductoService.actualizarProducto(productoDto,idProducto);
                return new ResponseEntity<>(productoDto,HttpStatus.OK);


        }catch (Exception e){
            return new ResponseEntity<>(e,HttpStatus.CONFLICT);
        }
    }


    //----------------------------------------------------------------------------------------------


}
