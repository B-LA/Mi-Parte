<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Listar Clientes</title>
        <jsp:include page="/WEB-INF/jsp/cabecera.jsp"/>
    </head>
    <body>
        <jsp:include page="/WEB-INF/jsp/menu.jsp"/>
        <div class="container">
            <div class="row">
                <h3>Listar Cliente</h3>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <a class="btn btn-primary btn-md" href="<s:url value="/cliente/create"/>">Crear Cliente</a>
                    <br><br>
                    <table class="table table-striped table-bordered table-hover" id="tabla">
                        <thead>
                            <tr>
                                <th>ID cliente</th>
                                <th>Nombre usuario</th>
                                <th>Contraseña</th>
                                <th>Nombre</th>
                                <th>Telefono</th>
                                <th>Telefono Dos</th>
                                <th>Direccion</th>
                                <th>Dui</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${listarCliente}" var="cliente">
                                <tr>
                                    <td>${cliente.idcliente}</td>
                                    <td>${cliente.nombreusu}</td>
                                    <td>${cliente.password}</td>
                                    <td>${cliente.nombre}</td>
                                    <td>${cliente.telefono}</td>
                                    <td>${cliente.telefono2}</td>
                                    <td>${cliente.direccion}</td>
                                    <td>${cliente.dui}</td>
                                    <td>
                                        <a class="btn btn-primary"
                                           href="<s:url value="/cliente/edit/${cliente.idcliente}"/>">
                                            <span class="glyphicon glyphicon-edit"></span> Editar</a>
                                        <a class="btn btn-danger"
                                           href="javascript:eliminar('${cliente.idcliente}')">
                                            <span class="glyphicon glyphicon-trash"></span> Eliminar</a>
                                    </td>
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