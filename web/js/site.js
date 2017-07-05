function remover_cargo_click(id) {
    $("#idCargo").val(id);
    $("#remover").modal(); 
}

function remover_tecnologia_click(id) {
    $("#idTecnologia").val(id);
    $("#remover").modal(); 
}

function remover_projeto_click(id) {
    $("#idProjeto").val(id);
    $("#remover").modal(); 
}

function remover_membro_click(id) {
    $("#idMembro").val(id);
    $("#remover").modal(); 
}

function remover_tecmembro_click(id) {
    $("#idTecno").val(id);
    $("#remover").modal(); 
}

function editar_tecmembro_click(id, nome, nivel) {
    $("#idTecnologiaMembro").val(id);
    $("#nomeTecno").text(nome);
    $("#nivel").val(nivel);
    $("#editar").modal();
}
