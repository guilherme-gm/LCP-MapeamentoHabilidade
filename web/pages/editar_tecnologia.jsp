<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">
    <div class="col-sm-12">
        <h1>Editar Tecnologia</h1>
    </div>
</div>
<c:if test="${not empty msg}">
    <div class="alert <c:out value="${msg_tipo}"></c:out>">
        ${msg}
    </div>
</c:if>
<div class ="row">

    <form class="form-horizontal" method="POST" action = "<c:url value="/DoEditarTecnologia"/>">
        <div class="row"> 
        &nbsp;&nbsp;
        </div>

        <input type="hidden" name="idTecnologia" value=" <c:out value= "${tecnologia.idTecnologia}"/>"/> <br />
        <div class="form-group">
            <label for="nome" class="col-sm-2 control-label">Nome</label>
            <div class="col-sm-4">
                <input class="form-control" type="text" name="nome" placeholder="Nome" value="<c:out value="${tecnologia.nome}"/>"/> <br />
            </div>
        </div>

        <p>
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Confirmar</button>
                &nbsp;&nbsp;
                <button type="submit" class="btn btn-default">Voltar</button>
            </div>

           
        </p>
    </form>
</div>
