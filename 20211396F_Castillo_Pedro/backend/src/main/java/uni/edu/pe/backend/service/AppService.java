package uni.edu.pe.backend.service;

import uni.edu.pe.backend.dto.Maquinaria;
import uni.edu.pe.backend.dto.TurnoOperador;

import java.util.List;

public interface AppService {
    List<TurnoOperador> obtenerTurnosOperador();
    Maquinaria registrarMaquinaria(Maquinaria maquinaria);
}
