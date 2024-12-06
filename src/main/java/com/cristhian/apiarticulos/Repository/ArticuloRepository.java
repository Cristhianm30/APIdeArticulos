package com.cristhian.apiarticulos.Repository;

import com.cristhian.apiarticulos.Model.ArticuloModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
el decorador indica que este componente es quien se encarga
del manejo de los datos y la extension de JPA es
la que hereda los metodos para el CRUD para la entidad
 */
@Repository
public interface ArticuloRepository extends JpaRepository<ArticuloModel, Long> {
}
