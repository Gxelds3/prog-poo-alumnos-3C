package mx.edu.utez.integradora_poo_2026.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mx.edu.utez.integradora_poo_2026.model.Pelicula;
import mx.edu.utez.integradora_poo_2026.model.dao.PeliculaDao;
import mx.edu.utez.integradora_poo_2026.utils.CSVManager;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "PeliculaServlet", value = "/pelicula")
public class PeliculaServlet extends HttpServlet {

    // Cambiar por tu DAO adaptado para Películas
    private final PeliculaDao peliculaDao = new PeliculaDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Recuperar la lista de películas desde el archivo CSV a través del DAO
        List<Pelicula> lista = peliculaDao.getAll();
        request.setAttribute("listaPeliculas", lista);

        // Redirige al JSP encargado de mostrar la cartelera/tabla
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        try {
            // Generar un ID incremental basado en los registros actuales del CSV
            int id = CSVManager.readCSV().size() + 1;

            // Capturar los nuevos parámetros del formulario HTML
            String nombre = request.getParameter("nombre");
            int anio = Integer.parseInt(request.getParameter("anio"));
            String genero = request.getParameter("genero");
            String imagen = request.getParameter("imagen");
            String idioma = request.getParameter("idioma");
            int duracion = Integer.parseInt(request.getParameter("duracion"));
            double calificacion = Double.parseDouble(request.getParameter("calificacion"));

            // Instanciar y asignar valores al objeto Película
            Pelicula nuevaPelicula = new Pelicula();
            nuevaPelicula.setId(id);
            nuevaPelicula.setNombre(nombre);
            nuevaPelicula.setAnio(anio);
            nuevaPelicula.setGenero(genero);
            nuevaPelicula.setImagen(imagen);
            nuevaPelicula.setIdioma(idioma);
            nuevaPelicula.setDuracion(duracion);
            nuevaPelicula.setCalificacion(calificacion);

            // Guardar en el CSV mediante el DAO
            peliculaDao.create(nuevaPelicula);

        } catch (NumberFormatException e) {
            System.err.println("Error al transformar datos numéricos en el registro de la película: " + e.getMessage());
            e.printStackTrace();
        }

        // Redirección limpia (Patrón Post-Redirect-Get) para evitar reenvíos duplicados de formulario
        response.sendRedirect("pelicula");
    }
}