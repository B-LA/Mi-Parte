<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Listar Casos</title>
        <jsp:include page="/WEB-INF/jsp/cabecera.jsp"/>
    </head>
    <body>
        <jsp:include page="/WEB-INF/jsp/menu.jsp"/>
        <div class="container">
            <div class="row">
                <h3>Listar Caso</h3>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <a class="btn btn-primary btn-md" href="<s:url value="/caso/create"/>">Crear Caso</a>
                    <br><br>
                    <table class="table table-striped table-bordered table-hover" id="tabla">
                        <thead>
                            <tr>
                                <th>ID caso</th>
                                <th>ID vehiculo</th>
                                <th>ID mecanico</th>
                                <th>ID gerente</th>
                                <th>Fecha Entrada</th>
                                <th>Fecha Salida</th>
                                <th>Detalle</th>
                                <th>Descuento</th>
                                <th>Presupuesto</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${listarCasos}" var="caso">
                                <tr>
                                    <td>${caso.idcaso}</td>
                                    <td>${caso.vehiculo.idvehiculo}</td>
                                    <td>${caso.mecanico.idmecanico}</td>
                                    <td>${caso.gerente.idgerente}</td>
                                    <td>${caso.fechaEntrada}</td>
                                    <td>${caso.fechaSalida}</td>
                                    <td>${caso.detalle}</td>
                                    <td>${caso.descuento}</td>
                                    <td>${caso.presupuesto}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <script>
            $(document).ready(function () {
                $('#tabla').DataTable();
            });
            
            function eliminar(id) {
                alertify.confirm("Eliminar", function (e) {
                    if (e) {
                        location.href = "delete/" + id;
                    }
                });
            }
        </script>
        <jsp:include page="/WEB-INF/jsp/pie.jsp"/>
    </body>
</html>