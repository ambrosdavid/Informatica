/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var nome;
var cap;
var universita;
var studente;
var lavoratore;
var descrizione;



function getVariabili() {
    nome = document.getElementById("cognomeNome");
    cap = document.getElementById("cap");
    universita = document.getElementById("universita");
    studente = document.getElementById("studente");
    lavoratore = document.getElementById("lavoratore");
    descrizione = document.getElementById("descrizione");

    nome.style.borderColor = "#FFFFFF";
    cap.style.borderColor = "#FFFFFF";
}


function checkNomeCognome() {

    if (nome.value.length > 0 && isNaN(nome.value)) {
        nome.style.borderColor = "#7CFC00";
    } else {
        nome.style.borderColor = "#ff0000";
    }
    for (var i = 0; i < nome.value.length; i++) {
        if (!isNaN(nome.value.charAt(i))) {
            nome.style.borderColor = "#ff0000";
        }
    }
}



function checkStudente() {
    return (studente.checked && lavoratore.checked && descrizione.value == "");
}

function invia() {

    var ris = "";

    if (checkStudente()) {
        ris += " Descrizione Mancante; ";
    }
    if (checkRegione()) {
        ris += " Universita mancante; ";
    }
    if (nome.value === "") {
        ris += " Nome vuoto; ";
    }

    if (ris == "") {
        alert("Tutto Giusto");
    } else {
        alert(ris);
    }
}

function checkRegione() {
    return (universita.options[universita.selectedIndex].value == "");

}

function checkCap() {
    if (cap.value.length > 5)
        cap.value = cap.value.substr(0, 5);

    if (!isNaN(cap.value) && cap.value.length > 4) {
        cap.style.borderColor = "#7CFC00";
    } else {
        cap.style.borderColor = "#ff0000";
    }

}

function reset() {
    nome.style.borderColor = "#FFFFFF";
    cap.style.borderColor = "#FFFFFF";
    nome.value = "";
    cap.value = "";
    universita.value = "";
    studente.value = "";
    lavoratore.value = "";
    descrizione.value = "";


}
