function validaForm(){
    if (document.form.nome.value==""){
        alert("O nome não pode estár em branco");
        document.forms.nome.focus();
        return false;

    }

    else{
        return true;
    }

}