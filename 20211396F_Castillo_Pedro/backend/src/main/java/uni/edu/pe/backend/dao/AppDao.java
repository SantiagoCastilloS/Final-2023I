package uni.edu.pe.backend.dao;

import uni.edu.pe.backend.dto.Maquinaria;
import uni.edu.pe.backend.dto.TurnoOperador;

import java.util.List;

public interface AppDao {
    List<TurnoOperador> obtenerTurnosOperador();
    Maquinaria registrarMaquinaria(Maquinaria maquinaria);



}
