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
    public ResponseEntity<?> obtenerArticuloPorId(@PathVariable Long id) {
        Optional<ArticuloModel> articulo = articuloService.obtenerPorId(id);
        if (articulo.isPresent()) {
            return ResponseEntity.ok(articulo.get());
        } else {
            return ResponseEntity.status(404).body("Articulo con ID " + id + " no encontrado.");
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> eliminarArticulo(@PathVariable Long id) {
        boolean eliminado = articuloService.eliminarArticulo(id);
        if (eliminado) {
            return ResponseEntity.ok("Articulo con ID " + id + " eliminado.");
        } else {
            return ResponseEntity.status(404).body("Articulo con ID " + id + " no encontrado.");
        }
    }

    @PutMapping(path = "/{id}")
    public ArticuloModel actualizarArticuloPorId(@PathVariable("id")Long id,@RequestBody ArticuloModel articuloActualizado){
        return this.articuloService.actualizarArticulo(id,articuloActualizado);
    }





}
