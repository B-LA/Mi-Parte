
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" 
                    data-toggle="collapse" data-target="#navbar" 
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Desplegar navegación</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Ejemplo MVC</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="${pageContext.request.contextPath}/">Inicio</a></li> 
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" 
                       role="button" aria-haspopup="true" 
                       aria-expanded="false">Clientes<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="${pageContext.request.contextPath}/cliente/create">Registrar Cliente</a></li>
                        <li><a href="${pageContext.request.contextPath}/cliente/list">Ver lista de Clientes</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" 
                       role="button" aria-haspopup="true" 
                       aria-expanded="false">Gerentes<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="${pageContext.request.contextPath}/gerente/create">Registrar gerente</a></li>
                        <li><a href="${pageContext.request.contextPath}/gerente/list">Ver lista de gerente</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" 
                       role="button" aria-haspopup="true" 
                       aria-expanded="false">Mecanicos<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="${pageContext.request.contextPath}/mecanico/create">Registrar mecanico</a></li>
                        <li><a href="${pageContext.request.contextPath}/mecanico/list">Ver lista de mecanico</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" 
                       role="button" aria-haspopup="true" 
                       aria-expanded="false">Casos<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="${pageContext.request.contextPath}/caso/create">Registrar Caso</a></li>
                        <li><a href="${pageContext.request.contextPath}/caso/list">Ver lista de Casos</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" 
                       role="button" aria-haspopup="true" 
                       aria-expanded="false">Vehiculos<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="${pageContext.request.contextPath}/vehiculo/create">Registrar vehiculo</a></li>
                        <li><a href="${pageContext.request.contextPath}/vehiculo/list">Ver lista de vehiculo</a></li>
                    </ul>
                </li>
            </ul>
            <ul class="nav navbar-nav pull-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"
                       role="button" aria-haspopup="true"
                       aria-expanded="false">Lenguaje<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="?locale=es">Español</a></li>
                        <li><a href="?locale=en">Ingles</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>

