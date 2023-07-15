package uni.edu.pe.backend.dto.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uni.edu.pe.backend.dto.TurnoOperador;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespuestaTurnoOperador {
    private List<TurnoOperador> turnoOperadors;
}
