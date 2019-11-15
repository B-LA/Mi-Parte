<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Lista de Gerentes</title>
        <jsp:include page="/WEB-INF/jsp/cabecera.jsp"/>
    </head>
    <body>
        <jsp:include page="/WEB-INF/jsp/menu.jsp"/>
        <div class="container">
            <div class="row">
                <h3>Lista de Gerentes</h3>
            </div>
            <div class="row">
                <div class="col-md-10">
                    <a class="btn btn-primary btn-md" href="<s:url value="/gerente/create"/>"> Nuevo Gerente</a>
                    <br><br>
                    <table class="table table-striped table-bordered table-hover"
                           id="tabla">
                        <thead>
                            <tr>
                                <th>Codigo del Gerente</th>
                                <th>Nombre de usuario</th>
                                <th>Password</th>
                                <th>Nombre</th>
                                <th>Telefono1</th>
                                <th>Telefono2</th>
                                <th>DUI</th>
                                <th>NIT</th>
                                <th>Operaciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${listarGerente}" var="gerente">
                                <tr>
                                    <td>${gerente.idgerente}</td>
                                    <td>${gerente.nombreusu}</td>
                                    <td>${gerente.password}</td>
                                    <td>${gerente.nombre}</td>
                                    <td>${gerente.telefono}</td>
                                    <td>${gerente.telefono2}</td>
                                    <td>${gerente.dui}</td>
                                    <td>${gerente.nit}</td>
                                   
                                    <td>
                                        <a class="btn btn-primary"
                                           href="<s:url value="/gerente/edit/${gerente.idgerente}"/>">
                                           <span class="glyphicon glyphicon-edit"></span>Editar</a>
                                           
                                           <a class="btn btn-danger"
                                           href="<s:url value="javascript:eliminar('${gerente.idgerente}')"/>">
                                           <span class="glyphicon glyphicon-edit"></span>Eliminar</a>
                                           
                                           
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <jsp:include page="/WEB-INF/jsp/pie.jsp"/>
        <script>
            function eliminar(id){
                alertify.confirm("Realmente desea eliminar este Gerente", function(e){
                    if(e){
                        location.href="delete/"+id;
                    }
                });
            }
            
            
        </script>
        
        <script>
            $(document).ready(function () {
                $('#tabla').dataTable({
                    "language": {
                        "url": "cdn.datatables.net/plug-ins/1.10.15/i18n/Spanish.json"
                    }
                });
            });
        </script>
    </body>
</html>