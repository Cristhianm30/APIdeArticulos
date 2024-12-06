package com.cristhian.apiarticulos.Service;

import com.cristhian.apiarticulos.Model.ArticuloModel;
import com.cristhian.apiarticulos.Repository.ArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
@Service indica Los servicios en Spring que se utilizan para contener la lógica de negocio.
@Autowired se utiliza para inyectar automáticamente la dependencia
en este caso de ArticuloRepository en la clase ArticuloService.
Esto significa que Spring se encargará de crear la instancia de ArticuloRepository
 */
@Service
public class ArticuloService {
    @Autowired
    ArticuloRepository articuloRepository;

    public ArrayList<ArticuloModel> obtenerArticulos(){
        return (ArrayList<ArticuloModel>) articuloRepository.findAll();
    }

    public ArticuloModel crearArticulo(ArticuloModel articulo){
        return articuloRepository.save(articulo);
    }

    public Optional<ArticuloModel> obtenerPorId(Long id){
        return Optional.ofNullable(articuloRepository.findById(id).orElseThrow(() -> new RuntimeException("Artículo con ID " + id + " no encontrado.")));
    }

    public boolean eliminarArticulo(Long id) {
        if (articuloRepository.existsById(id)) {
            articuloRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public ArticuloModel actualizarArticulo (Long id,ArticuloModel articuloActualizado){
        Optional<ArticuloModel> existente = articuloRepository.findById(id);
        if(existente.isPresent()){
            ArticuloModel articulo = existente.get();
            articulo.setNombre(articuloActualizado.getNombre());
            articulo.setDescripcion(articuloActualizado.getDescripcion());
            articulo.setPrecio(articuloActualizado.getPrecio());
            articulo.setStock(articuloActualizado.getStock());
            return articuloRepository.save(articulo);
        }else {
            throw new RuntimeException("Articulo con ID:"+id+". No encontrado");
        }
    }




}
