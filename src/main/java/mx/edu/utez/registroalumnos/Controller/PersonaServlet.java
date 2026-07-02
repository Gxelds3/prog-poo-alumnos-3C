package mx.edu.utez.registroalumnos.Controller;

import jakarta.servlet.http.HttpServlet;

@WebServlet(name = "PersonaServlet", value = "/mascota")
public class PersonaServlet extends HttpServlet {

    private final PersonaDao personadao = new PersonaDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Mascota> lista = mascotaDao.getAll();
        request.setAttribute("listaMascotas", lista);
        request.getRequestDispatcher("gestion-mascotas.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        try {
            String nombre = request.getParameter("nombre");
            String especie = request.getParameter("especie");
            int edad = Integer.parseInt(request.getParameter("edad"));
            String personalidad = request.getParameter("personalidad");
            String foto = request.getParameter("foto");
            boolean vacunada = request.getParameter("vacunada") != null;

            Mascota nuevaMascota = new Mascota();
            nuevaMascota.setNombre(nombre);
            nuevaMascota.setEspecie(especie);
            nuevaMascota.setEdad(edad);
            nuevaMascota.setPersonalidad(personalidad);
            nuevaMascota.setFoto(foto);
            nuevaMascota.setVacunada(vacunada);

            mascotaDao.create(nuevaMascota);
        } catch (NumberFormatException e) {
            System.err.println("Error al transformar datos numéricos en el registro: " + e.getMessage());
            e.printStackTrace();
        }

        response.sendRedirect("mascota");
    }
}

}
