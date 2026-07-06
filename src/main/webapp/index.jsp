<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css">

<div class="container my-5">
    <div class="row g-4">
        <div class="col-12">
            <h1 class="mb-4">Bienvenidos al registro de alumnos</h1>
        </div>

        <div class="col-md-7">
            <div class="row align-items-center mb-4">
                <h4 class="text-secondary col-sm-6 mb-2 mb-sm-0">Aquí están todos los registros de los alumnos</h4>
                <div class="col-sm-6 text-sm-end">
                    <a href="${pageContext.request.contextPath}/alumnos" class="btn btn-primary"><i class="bi bi-arrow-clockwise"></i> Cargar Alumnos</a>
                </div>
            </div>

            <c:choose>
                <%-- Condición 1: Si la lista es nula o está vacía --%>
                <c:when test="${empty listaAlumnos}">
                    <div class="alert alert-info text-center mt-4" role="alert">
                        <i class="bi bi-info-circle-fill"></i> No hay Alumnos registrados en este momento.
                    </div>
                </c:when>

                <%-- Condición por defecto: Si la lista SÍ tiene datos --%>
                <c:otherwise>
                    <div class="table-responsive">
                        <table class="table table-striped table-hover mt-4 align-middle">
                            <thead class="table-dark">
                            <tr>
                                <th>ID</th>
                                <th>Nombre</th>
                                <th>Apellido paterno</th>
                                <th>Apellido Materno</th>
                                <th>Edad</th>
                                <th>Matricula</th>
                                <th>Correo electronico</th>
                                <th>Sexo</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${listaAlumnos}" var="alumnos">
                                <tr>
                                    <td><strong>${alumnos.id_alumno}</strong></td>
                                    <td>${alumnos.nombre}</td>
                                    <td>${alumnos.appellido_paterno}</td>
                                    <td>${alumnos.appellido_materno}</td>
                                    <td>${alumnos.edad} años</td>
                                    <td><span class="badge bg-secondary">${alumnos.matricula}</span></td>
                                    <td>${alumnos.correo}</td>
                                    <td>${alumnos.sexo}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>

        <div class="col-md-5">
            <div class="card shadow-sm">
                <div class="card-body">
                    <h4 class="card-title text-primary mb-4"><i class="bi bi-plus-circle-fill"></i> ¡Registro de Alumnos!</h4>

                    <form action="${pageContext.request.contextPath}/alumnos" method="POST">
                        <input type="hidden" name="action" value="create">

                        <div class="mb-3">
                            <label for="nombre" class="form-label">Nombre del Alumno</label>
                            <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Ej: Luis" required>
                        </div>
                        <div class="mb-3">
                            <label for="appellido_paterno" class="form-label">Apellido paterno del Alumno</label>
                            <input type="text" class="form-control" id="appellido_paterno" name="appellido_paterno" placeholder="Ej: Perez" required>
                        </div>
                        <div class="mb-3">
                            <label for="appellido_materno" class="form-label">Apellido materno del Alumno</label>
                            <input type="text" class="form-control" id="appellido_materno" name="appellido_materno" placeholder="Ej: Lopez" required>
                        </div>

                        <div class="mb-3">
                            <label for="edad" class="form-label">Edad (Años)</label>
                            <input type="number" class="form-control" id="edad" name="edad" placeholder="Ej: 22" required min="0" max="120">
                        </div>

                        <div class="mb-3">
                            <label for="matricula" class="form-label">Matrícula</label>
                            <input type="text" class="form-control" id="matricula" name="matricula" placeholder="Ej: 20253ds067" required>
                        </div>

                        <div class="mb-3">
                            <label for="correo" class="form-label">Correo Electrónico</label>
                            <input type="email" class="form-control" id="correo" name="correo" placeholder="Ej: 20253ds067@utez.edu.mz" required>
                        </div>

                        <div class="mb-3">
                            <label for="sexo" class="form-label">Sexo</label>
                            <%-- Ajustado name a "sexo" en minúscula para hacer match exacto con tu request.getParameter("sexo") --%>
                            <select class="form-select" id="sexo" name="sexo" required>
                                <option value="" selected disabled>Selecciona una opción...</option>
                                <option value="M">Masculino</option>
                                <option value="F">Femenino</option>
                            </select>
                        </div>

                        <div class="mb-4 form-check form-switch">
                            <input class="form-check-input" type="checkbox" role="switch" id="registro" name="registro" value="true">
                            <label class="form-check-label" for="registro">¿Se encuentra registrado?</label>
                        </div>

                        <div class="d-grid">
                            <button type="submit" class="btn btn-primary"><i class="bi bi-save"></i> Guardar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>