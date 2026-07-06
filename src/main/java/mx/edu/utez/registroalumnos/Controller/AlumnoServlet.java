package mx.edu.utez.registroalumnos.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mx.edu.utez.registroalumnos.Model.Alumno;
import mx.edu.utez.registroalumnos.Model.Dao.AlumnoDao;

import java.io.IOException;
import java.util.List;


@WebServlet(name = "AlumnoServlet", value = "/alumnos")
public class AlumnoServlet extends HttpServlet {
    private final AlumnoDao alumnoDao = new AlumnoDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Alumno> lista = alumnoDao.getAll();
        request.setAttribute("listaAlumnos", lista);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        try {
            String nombre = request.getParameter("nombre");
            String appellido_paterno= request.getParameter("appellido_paterno");
            String appellido_materno= request.getParameter("appellido_materno");
            int edad = Integer.parseInt(request.getParameter("edad"));
            String matricula = request.getParameter("matricula");
            String correo = request.getParameter("correo");
            String sexo = request.getParameter("sexo");

            Alumno nuevoAlumno = new Alumno();
            nuevoAlumno.setNombre(nombre);
            nuevoAlumno.setAppellido_paterno(appellido_paterno);
            nuevoAlumno.setAppellido_materno(appellido_materno);
            nuevoAlumno.setEdad(edad);
            nuevoAlumno.setMatricula(matricula);
            nuevoAlumno.setCorreo(correo);
            nuevoAlumno.setSexo(sexo);

            alumnoDao.create(nuevoAlumno);
        } catch (NumberFormatException e) {
            System.err.println("Error al transformar datos numéricos en el registro: " + e.getMessage());
            e.printStackTrace();
        }

        response.sendRedirect("alumnos");
    }
}

