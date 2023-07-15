package uni.edu.pe.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uni.edu.pe.backend.dto.Maquinaria;
import uni.edu.pe.backend.dto.rest.RespuestaTurnoOperador;
import uni.edu.pe.backend.service.AppService;

@RestController
@CrossOrigin(origins = {"*"})
public class AppController {
    @Autowired
    private AppService service;
    @RequestMapping(value = "/obtenerTurnosOperador",
            method = RequestMethod.POST,
            produces = "application/json;charset=utf-8"
    )
    public RespuestaTurnoOperador obtenerTurnosOperador(){
        RespuestaTurnoOperador rpta = new RespuestaTurnoOperador();
        rpta.setTurnoOperadors(service.obtenerTurnosOperador());
        return rpta;
    }

    @RequestMapping(
            value = "/registrarMaquinaria",
            method = RequestMethod.POST,
            produces = "application/json;charset=utf-8"
    )
    public Maquinaria registrarMaquinaria(@RequestBody Maquinaria maquinaria) {
        return service.registrarMaquinaria(maquinaria);
    }
}
