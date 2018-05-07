var nome_cognome;
var sesso;
var ateneo;
var cap;
var studente_lavoratore;
var descrizione;

function getView(){
	nome_cognome = document.getElementById("nome_cognome");
	sesso = document.getElementsByName("sesso");
	ateneo = document.getElementById("ateneo");
	cap = document.getElementById("cap");
	studente_lavoratore = document.getElementById("studente_lavoratore");
	descrizione = document.getElementById("descrizione");
}

function checkNomeCognome(){
	if(!containNumber(nome_cognome.value) && nome_cognome.value != "")
		nome_cognome.className = "correct";
	else
		nome_cognome.className = "error";
}

function checkCap(){
	if(cap.value.length > 5)
		cap.value = cap.value.substr(0, 5);

	if(isNumber(cap.value) && cap.value.length == 5)
		cap.className = "correct";
	else
		cap.className = "error";
}

function invia(){
  var error = "";

  if(cognome.value == "")
    error += "Campo Cognome vuoto!\n";

  if(nome.value == "")
    error += "Campo Nome vuoto!\n";

	if(matricola.value == "")
    error += "Campo Matricola vuoto!\n";
	else if(!isNumber(matricola.value))
    error += "Matricola contiente lettere!\n";

  if(regione.options[regione.selectedIndex].value == "")
    error += "Campo Regione vuoto!\n";

  if(email.value == "")
    error += "Campo Email vuoto!\n";

	if(telefono.value == "")
    error += "Campo Telefono vuoto!\n";
	else if(!isNumber(telefono.value))
    error += "Telefono contiente lettere!\n";

  if(error != "")
    alert(error);
  else
		alert("Dati corretti");

  return false;
}

function reset(){
  cognome.value = "";
  nome.value = "";
  matricola.value = "";
	regione.select = regione.options[0];
  email.value = "";
  telefono.value = "";
  richieste.value = "";
}

function isNumber(stringa){
  for(var i=0; i<stringa.length; i++){
    if(stringa.charAt(i) < '0' || stringa.charAt(i) > '9')
      return false;
  }
  return true;
}

function containNumber(stringa){
	var ret = false;
  for(var i=0; i<stringa.length; i++){
    if(stringa.charAt(i) >= '0' && stringa.charAt(i) <= '9')
      ret = true;
  }
  return ret;
}
