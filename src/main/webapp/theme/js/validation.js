{
    let nameField = document.querySelector("#name");

    nameField.addEventListener("focusin",() => {
        if(nameField.value == ""){
            nameField.classList.add("border-bottom-danger");
        }
    })

    nameField.addEventListener("focusout", () => {
        if (!nameField.value == "") {
            nameField.classList.remove("border-bottom-danger");
            nameField.classList.add("border-bottom-success");
        }
    })
}

{
    let surnameField = document.querySelector("#surname");

    surnameField.addEventListener("focusin",() => {
        if(surnameField.value == ""){
            surnameField.classList.add("border-bottom-danger");
        }
    })

    surnameField.addEventListener("focusout", () => {
        if (!surnameField.value == "") {
            surnameField.classList.remove("border-bottom-danger");
            surnameField.classList.add("border-bottom-success");
        }
    })

}

{
    let emailField = document.querySelector("#email");

    emailField.addEventListener("focusin",() => {
        if(emailField.value == ""){
            emailField.classList.add("border-bottom-danger");
        }
    })

    emailField.addEventListener("focusout", () => {
        if (!emailField.value == "") {
            emailField.classList.remove("border-bottom-danger");
            emailField.classList.add("border-bottom-success");
        }
    })

}

{
    let passField = document.querySelector("#pass")
    let pass2Field = document.querySelector("#re-pass")

    passField.addEventListener("focusin", () => {
        passField.classList.add("border-bottom-warning");
        pass2Field.classList.add("border-bottom-warning");
    })
    pass2Field.addEventListener("focusin", () => {
        passField.classList.add("border-bottom-warning");
        pass2Field.classList.add("border-bottom-warning");
    })

    passField.addEventListener("focusout", () => {
        if (passField.value != pass2Field.value){
            passField.classList.add("border-bottom-danger");
            pass2Field.classList.add("border-bottom-danger");
        }else {
            passField.classList.remove("border-bottom-danger", "border-bottom-warning");
            pass2Field.classList.remove("border-bottom-danger", "border-bottom-warning");
            passField.classList.add("border-bottom-success");
            pass2Field.classList.add("border-bottom-success");
        }
    })
    pass2Field.addEventListener("focusout", () => {
        if (passField.value != pass2Field.value){
            passField.classList.add("border-bottom-danger");
            pass2Field.classList.add("border-bottom-danger");
        }else{
            passField.classList.remove("border-bottom-danger", "border-bottom-warning");
            pass2Field.classList.remove("border-bottom-danger", "border-bottom-warning");
            passField.classList.add("border-bottom-success");
            pass2Field.classList.add("border-bottom-success");
        }
    })
}

{
    //TODO disable button when errors

    // let btnAdd = document.querySelector("#addBtn");
    // let forms = document.querySelectorAll(".form-control");
    //
    //
    // function checkAndDisable(){
    //     if(forms.classList.contains("border-bottom-danger")){
    //             btnAdd.classList.add("disabled")
    //         }
    //     // btnAdd.classList.add("btn-primary");
    // }
}