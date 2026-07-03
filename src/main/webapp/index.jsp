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
            <div class="row align-items-center">
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
                                <th>Apellidos</th>
                                <th>Edad</th>
                                <th>Matrícula</th>
                                <th>Correo Electrónico</th>
                                <th>Sexo</th>
                                <th>Registrado</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${listaAlumnos}" var="alumnos">
                                <tr>
                                    <td><strong>${alumnos.id}</strong></td>
                                    <td>${alumnos.nombre}</td>
                                        <%-- CORRECCIÓN 1: Se cambiaron los nombres de las propiedades a minúsculas camelCase comunes en Java Beans --%>
                                    <td>${alumnos.apellidoP} ${alumnos.apellidoM}</td>
                                    <td>${alumnos.edad} años</td>
                                    <td><span class="badge bg-secondary">${alumnos.matricula}</span></td>
                                    <td>${alumnos.correo}</td>
                                        <%-- CORRECCIÓN 2: Se corrigió "Sexo" por "sexo" en minúscula para evitar errores con los Getters de Java --%>
                                    <td>${alumnos.sexo}</td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${alumnos.registro}">
                                                <span class="text-success"><i class="bi bi-check-circle-fill"></i> Sí</span>
                                            </c:when>
                                            <c:otherwise>
                                                <span class="text-danger"><i class="bi bi-x-circle-fill"></i> No</span>
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
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
                            <label for="apellidoP" class="form-label">Apellido Paterno</label>
                            <input type="text" class="form-control" id="apellidoP" name="apellidoP" placeholder="Ej: Perez" required>
                        </div>
                        <div class="mb-3">
                            <label for="apellidoM" class="form-label">Apellido Materno</label>
                            <input type="text" class="form-control" id="apellidoM" name="apellidoM" placeholder="Ej: Lopez" required>
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
                            <label for="Sexo" class="form-label">Sexo</label>
                            <%-- RECOMENDACIÓN: Mantenemos el name como "Sexo" si el backend lo lee con mayúscula, pero es preferible usar "sexo" en minúsculas --%>
                            <select class="form-select" id="Sexo" name="Sexo" required>
                                <option value="" selected disabled>Selecciona una opción...</option>
                                <option value="Masculino">Masculino</option>
                                <option value="Femenino">Femenino</option>
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