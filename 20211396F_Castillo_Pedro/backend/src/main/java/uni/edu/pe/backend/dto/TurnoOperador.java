package uni.edu.pe.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TurnoOperador {

    private String dni;
    private String nombre;
    private String turno;
    private String fecha_inicio;
    private String fecha_fin;
    private String estado;
    private String codigo;
    private String marca;
    private String modelo;
    private String descripcion;
    private int superficie;
    private String proceso;
}
