<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row ">
    <div class="col-sm-12">
        <h1>Selecione os Membros</h1>
    </div>
</div>

<div class =" row">
    <div class="col-sm-12">
        <table class="table table-hover">
            <thead>
                <tr>
                    <th>Nome do Membro</th>
                    <th>Nível de Habilidade</th>
                    <th>A&ccedil;&otilde;es</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${membros}" var="membro">
                    <c:if test="${projeto.hasMembro(membro) eq true}">
                        <tr class="info">
                            <td><c:out value="${membro.nome}"/></td>
                            <td><span class="badge"><c:out value="${membro.rank}"/></span></td>
                            <td>
                                <a href="<c:url value="DoRemoverMembroProjeto?id=${membro.idMembro}"/>">
                                    <span class="glyphicon glyphicon-minus"></span>
                                </a>
                            </td>
                        </tr>
                    </c:if>
                    <c:if test="${projeto.hasMembro(membro) eq false}">
                        <tr>
                            <td><c:out value="${membro.nome}"/></td>
                            <td><span class="badge"><c:out value="${membro.rank}"/></span></td>
                            <td>
                                <a href="<c:url value="DoAdicionarMembroProjeto?id=${membro.idMembro}"/>">
                                    <span class="glyphicon glyphicon-plus"></span>
                                </a>
                            </td>
                        </tr>
                    </c:if>
                </c:forEach>
            </tbody>
        </table> 

        <div class="col-sm-offset-2 col-sm-10">
            <a href="<c:url value="/DoSalvarProjeto"/>" class="btn btn-default">Concluir</a>
            &nbsp;&nbsp;
            <a href="<c:url value="/SelecionaMembro"/>" class="btn btn-default">Voltar</a>
        </div>
    </div>
</div>