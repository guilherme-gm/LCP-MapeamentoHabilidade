<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>Login</h1>
<c:if test="${erro ne ''}">
    <p>
        <span>
            <c:out value="${erro}"></c:out>
        </span>
    </p>
</c:if>
    <form method="POST" action="<c:url value="/doLogin"></c:url>">
    <label for="usuario">Usuário:</label><input type="text" name="usuario"/> <br />
    <label for="senha">Senha:</label><input type="password" name="senha"/> <br />
    <input type="submit" value="Login"/>
</form>