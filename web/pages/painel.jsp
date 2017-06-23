<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>Painel</h1>
<div>
    <ul>
        <li>Nome: <c:out value="${membro.nome}"></c:out></li>
        <li>E-mail: <c:out value="${membro.email}"></c:out></li>
    </ul>
</div>