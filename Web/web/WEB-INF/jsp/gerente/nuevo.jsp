<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Nuevo Gerente</title>
        <jsp:include page="/WEB-INF/jsp/cabecera.jsp"/>
    </head>
    <body>
        <jsp:include page="/WEB-INF/jsp/menu.jsp"/>
        <div class="container">
            <div class="row">
                <h3>Nuevo Gerente</h3>
            </div>
            <div class="row">
                <div class=" col-md-7">
                     
                    <f:form action="create" method="POST"
                            modelAttribute="gerente">
                     <f:errors cssClass="alert alert-danger" element="div" path="*" />
                        <div class="well well-sm"><strong><span
                                    class="glyphicon glyphicon-asterisk"></span>Campos requeridos</strong></div>
                        <div class="form-group">
                            <label for="nombreusu">Nombre de usuario:</label>
                            <div class="input-group">
                                <f:input path="nombreusu" cssClass="form-control"/>
                                <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                            </div>
                        </div>
                                
                        <div class="form-group">
                            <label for="password">Password:</label>
                            <div class="input-group">
                                <f:input path="password" 
                                          cssClass="form-control"/>
                                <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                            </div>
                        </div>
                                
                      <div class="form-group">
                            <label for="nombre">Nombre:</label>
                            <div class="input-group">
                                <f:input path="nombre" 
                                          cssClass="form-control"/>
                                <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                            </div>
                        
                                <div class="form-group">
                            <label for="telefono">Telefono:</label>
                            <div class="input-group">
                                <f:input path="telefono" 
                                          cssClass="form-control"/>
                                <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                            </div>
                        </div>
                                
                                
                                <div class="form-group">
                            <label for="telefono2">Telefono 2:</label>
                            <div class="input-group">
                                <f:input path="telefono2" 
                                          cssClass="form-control"/>
                                <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                            </div>
                        </div>
                                
                        
                                <div class="form-group">
                            <label for="dui">DUI:</label>
                            <div class="input-group">
                                <f:input path="dui" 
                                          cssClass="form-control"/>
                                <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                            </div>
                        </div>
                                        
                                <div class="form-group">
                            <label for="nit">NIT:</label>
                            <div class="input-group">
                                <f:input path="nit" 
                                          cssClass="form-control"/>
                                <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                            </div>
                        </div>
                                   
                        <f:button class="btn btninfo">Guardar</f:button>
                        <a class="btn btn-danger" href="<s:url value="/gerente/list"/>">Cancelar</a>
                    </f:form>
                </div>
            </div>
        </div>
        <jsp:include page="/WEB-INF/jsp/pie.jsp"/>
    </body>
</html>