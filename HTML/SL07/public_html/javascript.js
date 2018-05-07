/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var cognome;
var nome;
var matricola;
var telefono;
var email;
var regione;


function getVariabili() {
    cognome = document.getElementById("cognome");
    nome = document.getElementById("nome");
    matricola = document.getElementById("matricola");
    telefono = document.getElementById("telefono");
    email = document.getElementById("email");
    regione = document.getElementById("regione");
}


function checkNome() {
    return nome.value !== "";

}
function checkCognome() {
    return cognome.value !== "";

}

function checkMatricola() {
    return isNaN(matricola.value) || matricola.value == "";
}

function checkTelefono() {
    return telefono.value === "" || email.value === "" ;
}


function checkRegione() {
    return regione.options[regione.selectedIndex].value !== "";

}

function invia() {
    var ris = "";
    if (!checkNome()) {
        ris += " Nome Sbagliato; ";
    }
    if (!checkCognome()) {
        ris += " Cognome Sbagliato; ";
    }
    if (checkMatricola()) {
        ris += " Matricola sbagliata; ";
    }
    if (checkTelefono()) {
        ris += " Email o Telefono mancanti; ";
    }
    if (!checkRegione()) {
        ris += " campo Regione Sbagliato; ";
    }

    if (ris == "") {
        alert("Tutto Giusto");
    } else {
        alert(ris);
    }
}

function reset() {
    cognome.value="";
    nome.value="";
    matricola.value="";
    telefono.value="";
    email.value="";
    regione.value="";
}