package uni.edu.pe.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uni.edu.pe.backend.dao.AppDao;
import uni.edu.pe.backend.dto.Maquinaria;
import uni.edu.pe.backend.dto.TurnoOperador;

import java.util.List;
@Service
@Transactional
public class AppServiceImp implements AppService{
    @Autowired
    private AppDao dao;
    @Override
    public List<TurnoOperador> obtenerTurnosOperador() {
        return dao.obtenerTurnosOperador();
    }

    @Override
    public Maquinaria registrarMaquinaria(Maquinaria maquinaria) {
        return dao.registrarMaquinaria(maquinaria);
    }
}
