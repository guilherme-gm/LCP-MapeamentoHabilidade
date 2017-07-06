<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">
    <div class="col-md-12">
        <!-- It can be fixed with bootstrap affix http://getbootstrap.com/javascript/#affix-->
        <div id="sidebar" class="well sidebar-nav">
            <h5><i class="glyphicon glyphicon-list-alt"></i>
                <small><b>ADMINISTRAÇÃO</b></small>
            </h5>
            <ul class="nav nav-pills nav-stacked">
                <li <c:if test="${menu eq 'home'}">class="active"</c:if>><a href="<c:url value="/Home" />"><span class="glyphicon glyphicon-home"/> <b>Home</b></a></li>
                    <c:if test="${membro.hasPermissao('GERENCIAR_PROJETOS') eq true}">
                    <li <c:if test="${menu eq 'adminproj'}">class="active"</c:if>><a href="<c:url value="/ListarProjeto" />"><span class="glyphicon glyphicon-pencil"/>  <b>Administrar Projetos</b></a></li>
                    </c:if>
                    <c:if test="${membro.hasPermissao('GERENCIAR_HABILIDADES') eq true}">
                    <li <c:if test="${menu eq 'admintec'}">class="active"</c:if>><a href="<c:url value="/ListarTecnologia" />"><span class="glyphicon glyphicon-console"/>  <b>Administrar Tecnologias</b></a></li>
                    </c:if>
                    <c:if test="${membro.hasPermissao('GERENCIAR_MEMBROS') eq true}">
                    <li <c:if test="${menu eq 'adminmembro'}">class="active"</c:if>><a href="<c:url value="/ListarMembro"></c:url>"><span class="glyphicon glyphicon-user"/>  <b>Administrar Membros</b></a></li>
                    </c:if>
                    <c:if test="${membro.hasPermissao('GERENCIAR_CARGOS') eq true}">
                    <li <c:if test="${menu eq 'admincargo'}">class="active"</c:if>><a href="<c:url value="/ListarCargo"></c:url>"><span class="glyphicon glyphicon-edit"/>  <b>Administrar Cargos</b></a></li>
                    </c:if>
            </ul>
            <c:if test="${membro ne null}">
                <h5><i class="glyphicon glyphicon-user"></i>
                    <small><b>USUÁRIO</b></small>
                </h5>
                <ul class="nav nav-pills nav-stacked">

                    <li <c:if test="${menu eq 'mproj'}">class="active"</c:if>><a href="<c:url value="/MeusProjetos"/>"><span class="glyphicon glyphicon-folder-open"/>  <b>Meus Projetos</b></a></li>
                    <li><a href="<c:url value="/MinhasTecnologias"></c:url>"<span class="glyphicon glyphicon-cog"/>  <b>Minhas Tecnologias</b></a></li>
                    <li><a href="<c:url value="/DoLogout"></c:url>"><span class="glyphicon glyphicon-log-out"/>  <b>Logout</b></a></li>

                    </ul>
            </c:if>
        </div>
    </div>        
</div>