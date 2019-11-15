<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Lista de vehiculos</title>
        <jsp:include page="/WEB-INF/jsp/cabecera.jsp"/>
    </head>
    <body>
        <jsp:include page="/WEB-INF/jsp/menu.jsp"/>
        <div class="container">
            <div class="row">
                <h3>Lista Vehiculo</h3>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <a class="btn btn-primary btn-md" href="<s:url value="/vehiculo/create"/>">Nuevo Vehiculo</a>
                    <br><br>
                    <table class="table table-striped table-bordered table-hover" id="tabla">
                        <thead>
                            <tr>
                                <th>Codigo Vehiculo</th>
                                <th>Marca</th>
                                <th>Modelo</th>
                                <th>Placa</th>
                                <th>Color</th>
                                <th>Numero Chasis</th>
                                <th>CodigoCliente</th>
                            </tr>
                        </thead>
                        <tbody>     
                            <c:forEach items="${requestScope.listarVehiculo}" var="vehiculo">
                                <tr>
                                    <td>${vehiculo.idvehiculo}</td>
                                    <td>${vehiculo.marca}</td>
                                    <td>${vehiculo.modelo}</td>
                                    <td>${vehiculo.placa}</td>
                                    <td>${vehiculo.color}</td>
                                    <td>${vehiculo.nchasis}</td>
                                    <td>${vehiculo.cliente.idcliente}</td>
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
        </script>

        <jsp:include page="/WEB-INF/jsp/pie.jsp"/>
    </body>
</html>
