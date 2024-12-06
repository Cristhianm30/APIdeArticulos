package com.cristhian.apiarticulos.Controller;


import com.cristhian.apiarticulos.Model.ArticuloModel;
import com.cristhian.apiarticulos.Service.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

/*
@RequestMapping se utiliza para mapear solicitudes HTTP a métodos específicos en un controlador.
@RequestMapping("/articulos") indica que todas las solicitudes que comiencen con /articulos
serán manejadas por este controlador.

 */
@RestController
@RequestMapping("/articulos")
public class ArticuloController {
    @Autowired
    ArticuloService articuloService;

    @GetMapping
    public ArrayList<ArticuloModel> obtenerArticulos(){
        return articuloService.obtenerArticulos();

    }

    @PostMapping
    public ArticuloModel crearArticulo (@RequestBody ArticuloModel articulo){
        return this.articuloService.crearArticulo(articulo);
    }

    @GetMapping(path = "/{id}")
    public Optional<ArticuloModel> obtenerArticuloPorId(@PathVariable("id")Long id){
        return this.articuloService.obtenerPorId(id);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarArticuloPorId(@PathVariable("id")Long id){
        boolean ok = this.articuloService.eliminarArticulo(id);
        if(ok){
            return "Se elimino el usuario con ID:"+id;
        }else {
            return "No se pudo eliminar el artículo con ID: " + id + ". Puede que no exista.";
        }
    }

    @PutMapping(path = "/{id}")
    public ArticuloModel actualizarArticuloPorId(@PathVariable("id")Long id,@RequestBody ArticuloModel articuloActualizado){
        return this.articuloService.actualizarArticulo(id,articuloActualizado);
    }

    // Manejo de excepciones específicas para este controlador
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> manejarExcepcion(RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }





}
