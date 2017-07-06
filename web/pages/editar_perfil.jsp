<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form method="POST" action="<c:url value="/DoEditarPerfil"/>">
  <h2>Alterar Dados</h2>
  <div class="form-group">
    <label for="exampleInputEmail1">Novo Email</label>
    <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Email" name="email" value="<c:out value="${membro.email}"/>">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Novo Telefone</label>
    <input type="phone" class="form-control" placeholder="Telefone" name="telefone" value="<c:out value="${membro.telefone}"/>">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Senha Atual</label>
    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Senha" name="senhaAtual">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Nova Senha</label>
    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Senha" name="senhaNova">
  </div>
  
  <div class="col-xs-12 col-sm-12 text-center" style="margin-bottom: 10px;">    
    <input type="submit" value="Alterar Dados" class="btn btn-primary col-xs-10 col-sm-10 text-center"  />
  </div>
</form>
  
