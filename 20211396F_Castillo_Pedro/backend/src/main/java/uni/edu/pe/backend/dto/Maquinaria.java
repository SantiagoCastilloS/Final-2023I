package uni.edu.pe.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Maquinaria {
    private int idMaquinaria;
    private String codigo;
    private String marca;
    private String modelo;
    private String descripcion;
    private int idPlanta;
}
