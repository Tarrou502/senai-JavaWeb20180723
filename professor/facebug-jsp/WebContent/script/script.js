function validateForm() {
    let nome = document.forms['formulario']['nome'].value;

    if (nome == '') {
        alert("Nome deve ser preenchido!");
        document.getElementById('nome').style.borderColor = 'red';
        return false;
    } else {
        document.cookie = 'nome=' + nome;
        document.getElementById('nome').style.borderColor = 'steelblue';
    }

    let telefone = document.forms['formulario']['telefone'].value;

    if (isTelefoneValido(telefone)) {
        document.cookie = 'telefone=' + telefone;
        document.getElementById('telefone').style.borderColor = 'steelblue';
    } else {
        alert('Telefone é inválido');
        document.getElementById('telefone').style.borderColor = 'red';
        return false;
    }
    return true;
}

function isTelefoneValido(telefone) {
    var regex = '[0-9]{2}\\s[0-9]{5}\\-[0-9]{4}';
    if (telefone.match(regex)) {
        return true;
    } else {
        return false;
    }
}