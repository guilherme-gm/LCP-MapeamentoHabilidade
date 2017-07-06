<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css" rel="stylesheet">
<div class="container">
    <div class="row">
        <div class=" col-md-8 col-lg-6">
            <div class="well profile">
                <div class="col-sm-12">
                    <div class="col-xs-12 col-sm-8">
                        <h2><c:out value="${membro.nome}"/></h2>
                        <p><strong>Cargo: </strong> <c:out value="${membro.cargo.nome}"/></p>
                        <p><strong>Habilidades: </strong>  
                        <c:forEach var="tec" items="${membro.tecnologiaMembro}">
                            <span class="tags"><c:out value="${tec.tecnologia.nome}"/></span>
                        </c:forEach>
                        </p>
                        <p><strong>Telefone: </strong><c:out value="${membro.telefone}"/></p>
                        <p><strong>Email: </strong><c:out value="${membro.email}"/></p>
                    </div>             
                    <div class="col-xs-12 col-sm-5 col-md-4 text-center">
                        <figure>
                            <img src="img/blank.jpg" alt="" class="img-circle ">                            
                        </figure>
                    </div>
                    <div class="col-xs-12 col-sm-12 text-center" style="margin-bottom: 10px;">    
                        <a href="<c:url value="/EditarPerfil"/>" class="btn btn-primary col-xs-10 col-sm-10 text-center"> Alterar Dados</a>
                    </div>                    
                    <div class="col-xs-12 col-sm-12 text-center">    
                        <button type="button" class="btn btn-primary col-xs-10 col-sm-10 text-center "> Alterar Habilidades</button>
                    </div>                     
                </div>
            </div>
        </div>
    </div>
</div>