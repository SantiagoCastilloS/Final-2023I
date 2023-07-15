package uni.edu.pe.backend.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uni.edu.pe.backend.dto.Maquinaria;
import uni.edu.pe.backend.dto.TurnoOperador;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class AppDaoImp implements AppDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private Connection conexion;

    private void obtenerConexion(){
        try {
            this.conexion = jdbcTemplate.getDataSource().getConnection();
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }
    private void cerrarConexion(ResultSet resultado, Statement sentencia){
        try {
            if(resultado != null)
                resultado.close();
            if(sentencia != null)
                sentencia.close();
            this.conexion.commit();
            this.conexion.close();
            this.conexion = null;
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }

    @Override
    public List<TurnoOperador> obtenerTurnosOperador() {
        List<TurnoOperador> list = new ArrayList<>();
        String sql = "SELECT o.dni, o.nombre, t.turno, t.fecha_inicio, t.fecha_fin, t.estado, m.codigo, m.marca, m.modelo, m.descripcion, p.superficie, p.proceso FROM operador o INNER JOIN turnos_operacion t ON (o.id_operador = t.id_operador) INNER JOIN maquinaria m ON (m.id_maquinaria = t.id_maquinaria) INNER JOIN planta p ON (m.id_planta = p.id_planta) WHERE t.estado = 'A' OR t.estado IS NULL ORDER BY o.nombre ASC;";
        try{
            obtenerConexion();
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                list.add(extraerTurnoOperador(rs));
            }
            cerrarConexion(rs,st);
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public Maquinaria registrarMaquinaria(Maquinaria maquinaria) {
        try{
            obtenerConexion();
            String sql = "INSERT INTO maquinaria (id_maquinaria, codigo, marca, modelo, descripcion, id_planta) VALUES (?,?,?,?,?,?);";
            PreparedStatement st = conexion.prepareStatement(sql);
            st.setInt(1, maquinaria.getIdMaquinaria());
            st.setString(2, maquinaria.getCodigo());
            st.setString(3, maquinaria.getMarca());
            st.setString(4, maquinaria.getModelo());
            st.setString(5, maquinaria.getDescripcion());
            st.setInt(6, maquinaria.getIdPlanta());
            st.executeUpdate();
            st.close();
            cerrarConexion(null, st);
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return maquinaria;
    }
    private TurnoOperador extraerTurnoOperador (ResultSet resultado) throws SQLException {
        return new TurnoOperador(resultado.getString("dni"), resultado.getString("nombre"), resultado.getString("turno"), resultado.getString("fecha_inicio"), resultado.getString("fecha_fin"), resultado.getString("estado"),resultado.getString("codigo"),resultado.getString("marca"),resultado.getString("modelo"),resultado.getString("descripcion"), resultado.getInt("superficie"), resultado.getString("proceso"));
    }
}
