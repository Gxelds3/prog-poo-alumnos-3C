package mx.edu.utez.registroalumnos.Model.Dao;

import mx.edu.utez.registroalumnos.Model.Alumno;
import mx.edu.utez.registroalumnos.utils.SQLConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlumnoDao implements Dao<Alumno, Integer> {

    @Override
    public boolean create(Alumno entidad) {
        String sql = "INSERT INTO alumno(nombre, apellido_paterno, apellido_materno, edad, matricula, sexo, correo) VALUES(?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = SQLConnector.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, entidad.getNombre());
            ps.setString(2, entidad.getAppellido_paterno());
            ps.setString(2, entidad.getAppellido_materno());
            ps.setInt( 3, entidad.getEdad());
            ps.setString(4, entidad.getMatricula());
            ps.setString(5, entidad.getSexo());
            ps.setString(6, entidad.getCorreo());

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Alumno> getAll() {
        List<Alumno> listaAlumnos = new ArrayList<>();
        String sql = "SELECT * FROM ALUMNO";

        try (Connection con = SQLConnector.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Alumno d = new Alumno();
                d.setId_alumno(rs.getInt("id_alumno"));
                d.setNombre(rs.getString("nombre"));
                d.setAppellido_paterno(rs.getString("apellido_paterno"));
                d.setAppellido_materno(rs.getString("apellido_materno"));
                d.setEdad(rs.getInt("edad"));
                d.setMatricula(rs.getString("matricula"));
                d.setSexo(rs.getString("sexo"));
                d.setCorreo(rs.getString("correo"));


                listaAlumnos.add(d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaAlumnos;
    }

    @Override
    public Alumno getById(Integer id) {
        String sql = "SELECT * FROM ALUMNO WHERE id_alumno = ?";
        try (Connection con = SQLConnector.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Alumno d = new Alumno();
                    d.setId_alumno(rs.getInt("id"));
                    d.setNombre(rs.getString("nombre"));
                    d.setAppellido_paterno(rs.getString("apellido_paterno"));
                    d.setAppellido_materno(rs.getString("apellido_materno"));
                    d.setEdad(rs.getInt("edad"));
                    d.setMatricula(rs.getString("matricula"));
                    d.setSexo(rs.getString("sexo"));
                    d.setCorreo(rs.getString("correo"));


                    return d;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(Alumno entidad) {
        String sql = "UPDATE ALUMNO SET nombre = ?, apellido_paterno = ?, apellido_materno = ?, edad = ?, matricula = ?, correo = ?, sexo = ? WHERE id_alumno = ?";
        try (Connection con = SQLConnector.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {


            ps.setString(1, entidad.getNombre());
            ps.setString(2, entidad.getAppellido_paterno());
            ps.setString(2, entidad.getAppellido_materno());
            ps.setInt( 3, entidad.getEdad());
            ps.setString(4, entidad.getMatricula());
            ps.setString(5, entidad.getSexo());
            ps.setString(6, entidad.getCorreo());

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Integer id) {
        String sql = "DELETE FROM ALUMNO WHERE id_alumno = ?";
        try (Connection con = SQLConnector.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }



}
