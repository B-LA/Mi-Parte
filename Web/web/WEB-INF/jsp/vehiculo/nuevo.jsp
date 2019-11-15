<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Nuevo Vehiculo</title>
        <jsp:include page="/WEB-INF/jsp/cabecera.jsp"/>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.3/css/select2.min.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.3/js/select2.min.js"></script>
    </head>
    <body>
        <jsp:include page="/WEB-INF/jsp/menu.jsp"/>\
        <div class="container">
            <div class="row">
                <h3>Nuevo Vehiculo</h3>
            </div>
            <div class="row">
                <f:form action="create"
                        modelAttribute="vehiculo" method="post">
                    <f:errors cssClass="alert alert-danger" element="div" path="*"/>
                    <div class="well well-sm"><strong><span class="glyphicon glyphicon-asterisk"></span>Campo Requirido</strong></div>
                    
                                <div class="form-group">
                            <label for="marca">Marca</label>
                            <div class="input-group">
                                <f:input path="marca" cssClass="form-control"/>
                                <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                            </div>
                        </div>
                                <div class="form-group">
                            <label for="marca">Modelo</label>
                            <div class="input-group">
                                <f:input path="modelo" cssClass="form-control"/>
                                <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                            </div>
                        </div>
                                <div class="form-group">
                            <label for="marca">Placa</label>
                            <div class="input-group">
                                <f:input path="placa" cssClass="form-control"/>
                                <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                            </div>
                        </div>
                                <div class="form-group">
                            <label for="marca">Color</label>
                            <div class="input-group">
                                <f:input path="color" cssClass="form-control"/>
                                <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                            </div>
                                <div class="form-group">
                            <label for="marca">Numero Chasis</label>
                            <div class="input-group">
                                <f:input path="nchasis" cssClass="form-control"/>
                                <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                            </div>
                        </div>
                                <div class="form-group">
                            <label for="vehiculo">Cliente Dueño</label>
                            <div class="input-group">
                                <f:select path="cliente.idcliente" cssClass="form-control">
                                    <f:options items="${listarClientes}" itemLabel="nombre" itemValue="idcliente"/> 
                                </f:select>
                                <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                            </div>
                        </div>
                        </div>
                        </div>
                    <f:button class="btn btn-info">GUARDAR</f:button>
                        <a class="btn btn-danger" href="<s:url value="/vehiculo/list"/>">CANCELAR</a>
                </f:form>    
            </div>
        </div>
        
               <script>
                      //  $('#vehiculo').select2();
                     </script>
                   
        <jsp:include page="/WEB-INF/jsp/pie.jsp"/>
    </body>
</html>