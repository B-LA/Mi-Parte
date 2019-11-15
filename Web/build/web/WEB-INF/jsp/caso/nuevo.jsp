<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Nuevo Caso</title>
        <jsp:include page="/WEB-INF/jsp/cabecera.jsp"/>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.3/css/select2.min.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.3/js/select2.min.js"></script>
    </head>
    <body>
        <jsp:include page="/WEB-INF/jsp/menu.jsp"/>\
        <div class="container">
            <div class="row">
                <h3>Nuevo Caso</h3>
            </div>
            <div class="row">
                <f:form action="create"
                        modelAttribute="caso" method="post">
                    <f:errors cssClass="alert alert-danger" element="div" path="*"/>
                   
                    <div class="form-group">
                            <label for="vehiculo">Placa del Vehiculo</label>
                            <div class="input-group">
                                <f:select path="vehiculo.idvehiculo" cssClass="form-control">
                                     <f:options items="${listaVehiculo}" 
                                                   itemLabel="placa" 
                                                   itemValue="idvehiculo"/> 
                                </f:select>
                                <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                            </div>
                        </div>
                    <div class="form-group">
                            <label for="vehiculo">Mecanico</label>
                            <div class="input-group">
                                <f:select path="mecanico.idmecanico" cssClass="form-control">
                                     <f:options items="${listaMecanicos}" 
                                                   itemLabel="nombre" 
                                                   itemValue="idmecanico"/> 
                                </f:select>
                                <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                            </div>
                        </div>
                    <div class="form-group">
                            <label for="gerente">Gerente</label>
                            <div class="input-group">
                                <f:select path="gerente.idgerente" cssClass="form-control">
                                     <f:options items="${listaGerente}" 
                                                   itemLabel="nombre" 
                                                   itemValue="idgerente"/> 
                                </f:select>
                                <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                            </div>
                        </div>
                    <div class="form-group">
                            <label for="fechaE">Fecha Entrada</label>
                            <div class="input-group">
                                
                                <fmt:formatDate pattern="yyyy-MM-dd" value="${fechaEntrada}"/><f:input path="fechaEntrada" cssClass="form-control" />
                                <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                            </div>
                        </div>
                    <div class="form-group">
                            <label for="fechaE">Fecha Salida</label>
                            <div class="input-group">
                                <fmt:formatDate pattern="yyyy-MM-dd" value="${fechaSalida}"/><f:input path="fechaSalida" cssClass="form-control"/>
                                <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                            </div>
                        </div>
                            <div class="form-group">
                            <label for="detalle">Detalles del Caso</label>
                            <div class="input-group">
                                <f:input path="detalle" cssClass="form-control"/>
                                <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                            </div>
                        </div>
                                <div class="form-group">
                            <label for="descuento">Descuento</label>
                            <div class="input-group">
                                <f:input path="descuento" cssClass="form-control"/>
                                <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                            </div>
                        </div>
                                <div class="form-group">
                            <label for="presupuesto">Presupuesto</label>
                            <div class="input-group">
                                <f:input path="presupuesto" cssClass="form-control"/>
                                <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                            </div>
                        </div>
                        </div>
                    <f:button class="btn btn-info">GUARDAR</f:button>
                        <a class="btn btn-danger" href="<s:url value="/casos/list"/>">CANCELAR</a>
                </f:form>    
            </div>
        </div>
        
               <script>
                        $('#casos').select2();
                     </script>
                   
        <jsp:include page="/WEB-INF/jsp/pie.jsp"/>
    </body>
</html>