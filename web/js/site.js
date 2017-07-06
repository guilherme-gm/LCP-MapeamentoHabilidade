function remover_cargo_click(id) {
    $("#idCargo").val(id);
    $("#remover").modal(); 
}

function remover_tecnologia_click(id) {
    $("#idTecnologia").val(id);
    $("#remover").modal(); 
}

function finalizar_projeto_click(id) {
    $("#idConcluir").val(id);
    $("#concluir").modal(); 
}

function cancelar_projeto_click(id) {
    $("#idCancelar").val(id);
    $("#cancelar").modal(); 
}

function remover_projeto_click(id, nome) {
    $("#delNome").val(nome);
    $("#projNome").val("");
    $("#btnDeleta").attr("disabled", "disabled");
    $("#idProjeto").val(id);
    $("#remover").modal(); 
}

function remover_projeto_change() {
    if ($("#projNome").val() === $("#delNome").val()) {
        $("#btnDeleta").removeAttr("disabled");
    } else {
        $("#btnDeleta").attr("disabled", "disabled");
    }
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
