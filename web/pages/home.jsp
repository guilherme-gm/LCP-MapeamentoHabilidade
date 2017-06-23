<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>Login</h1>
<c:if test="${erro ne ''}">
    <p>
        <span>
            <c:out value="${erro}"></c:out>
            </span>
        </p>
</c:if>
<form method="POST" action="<c:url value="/doLogin"></c:url>" class="form-horizontal">
        <div class="form-group">
            <label for="usuario" class="col-sm-4 control-label">Usuário:</label>
            <div class="col-sm-2">
                <input class="form-control" type="text" name="usuario" placeholder="Usuário"/> <br />
            </div>
        </div>
        <div class="form-group">
            <label for="senha" class="col-sm-4 control-label">Senha:</label>
            <div class="col-sm-2">
                <input class="form-control" type="password" name="senha" placeholder="Senha"/> <br />
            </div>
        </div>
        <div class="col-sm-offset-4 col-sm-10">
            <button type="submit" class="btn btn-default">Login</button>
        </div>
</form>

