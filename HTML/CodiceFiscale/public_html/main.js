

function f() {
    let name = document.forms[0].elements[0].value;
    let surname = document.forms[0].elements[1].value;
    let bday = document.forms[0].elements[2].value;
    let man = document.getElementById("man").checked;
    let woman = document.getElementById("woman").checked;
    let res = document.forms[0].elements[5].value;

    if (name === "") {
        alert("Si prega di riempire il campo 'Nome'");
        return;
    }
    if (surname === "") {
        alert("Si prega di riempire il campo 'Cognome'");
        return;
    }
    if (!woman && !man){
        alert("Si prega di inserire la data di nascita");
        return;
    }
    if (bday === "") {
        alert("Si prega di riempire il campo 'Data'");
        return;
    }
    if (res === ""){
        alert("Si prega di selezionare il comune di nascita");
        return;
    }

    let code = calcName(surname, false) + calcName(name, true) + calcDate(bday, man) + residence(res);
    code += checkChar(code);
    document.getElementsByName("output")[0].value= code;
}

function calcName(name, isName){
    name = name.toUpperCase();
    let out = consonants(name) + vowels(name) + "XXX";
    if(isName && consonants(name).length > 3)
        return (out.charAt(0) + out.charAt(2) + out.charAt(3));
    return (out.substring(0, 3));
}
function calcDate(date, sex){
    let out = date.substring(2, 4);
    switch(date.substring(5, 7)){
        case "01": out += 'A'; break;
        case "02": out += 'B'; break;
        case "03": out += 'C'; break;
        case "04": out += 'D'; break;
        case "05": out += 'E'; break;
        case "06": out += 'H'; break;
        case "07": out += 'L'; break;
        case "08": out += 'M'; break;
        case "09": out += 'P'; break;
        case "10": out += 'R'; break;
        case "11": out += 'S'; break;
        case "12": out += 'T'; break;
    }
    if(sex)
        out += date.substring(8);
    else
        out += (40 + +date.substring(8));
    return(out);
}
function residence(city){
    return RES[city];
}
function checkChar(code){
    let char = 0;
    for(let i = 0 ; i < 15; i++)
        char += i % 2 === 0 ? CHECK_ODD[code.charAt(i)] : CHECK_EVEN[code.charAt(i)];
    return FINAL_CHECK.charAt(char % 26);

}

function consonants(str){
    let out = "";
    for(let i = 0; i < str.length; i++)
        if(!isVowel(str.charAt(i)))
            out += str.charAt(i);
    return (out);
}
function vowels(str){
    let out = "";
    for (let i = 0; i < str.length; i++)
        if(isVowel(str.charAt(i)))
            out += str.charAt(i);
    return (out);
}
function isVowel(c){
    return (c === 'A' || c ==='E' || c ==='I' || c ==='O' || c ==='U');
}

function reset(){
    document.forms[0].elements[0].value = "";
    document.forms[0].elements[1].value = "";
    document.forms[0].elements[2].value = "";
    document.forms[0].elements[5].value = "";
    document.getElementById("output").value = "";
}

const CHECK_EVEN = {
    0: 0,
    1: 1,
    2: 2,
    3: 3,
    4: 4,
    5: 5,
    6: 6,
    7: 7,
    8: 8,
    9: 9,
    A: 0,
    B: 1,
    C: 2,
    D: 3,
    E: 4,
    F: 5,
    G: 6,
    H: 7,
    I: 8,
    J: 9,
    K: 10,
    L: 11,
    M: 12,
    N: 13,
    O: 14,
    P: 15,
    Q: 16,
    R: 17,
    S: 18,
    T: 19,
    U: 20,
    V: 21,
    W: 22,
    X: 23,
    Y: 24,
    Z: 25
};
const CHECK_ODD = {
    0: 1,
    1: 0,
    2: 5,
    3: 7,
    4: 9,
    5: 13,
    6: 15,
    7: 17,
    8: 19,
    9: 21,
    A: 1,
    B: 0,
    C: 5,
    D: 7,
    E: 9,
    F: 13,
    G: 15,
    H: 17,
    I: 19,
    J: 21,
    K: 2,
    L: 4,
    M: 18,
    N: 20,
    O: 11,
    P: 3,
    Q: 6,
    R: 8,
    S: 12,
    T: 14,
    U: 16,
    V: 10,
    W: 22,
    X: 25,
    Y: 24,
    Z: 23
};
const RES = {
    "ANNONE VENETO" : "A302",
    "CAMPAGNA LUPIA" : "B493",
    "CAMPOLONGO MAGGIORE" : "B546",
    "CAMPONOGARA" : "B554",
    "CAORLE" : "B642",
    "CAVARZERE" : "C383",
    "JESOLO" : "C388",
    "CEGGIA" : "C422",
    "CHIOGGIA" : "C638",
    "CINTO CAOMAGGIORE" : "C714",
    "CONA" : "C938",
    "CONCORDIA SAGITTARIA" : "C950",
    "DOLO" : "D325",
    "ERACLEA" : "D415",
    "FIESSO D'ARTICO" : "D578",
    "FOSSALTA DI PIAVE" : "D740",
    "FOSSALTA DI PORTOGRUARO" : "D741",
    "FOSSO'" : "D748",
    "GRUARO" : "E215",
    "MARCON" : "E936",
    "MARTELLAGO" : "E980",
    "MEOLO" : "F130",
    "MIRA" : "F229",
    "MIRANO" : "F241",
    "MUSILE DI PIAVE" : "F826",
    "NOALE" : "F904",
    "NOVENTA DI PIAVE" : "F963",
    "PIANIGA" : "G565",
    "PORTOGRUARO" : "G914",
    "PRAMAGGIORE" : "G981",
    "QUARTO D'ALTINO" : "H117",
    "SALZANO" : "H735",
    "SAN DONA' DI PIAVE" : "H823",
    "SAN MICHELE AL TAGLIAMENTO" : "I040",
    "SANTA MARIA DI SALA" : "I242",
    "SANTO STINO DI LIVENZA" : "I373",
    "SCORZE'" : "I551",
    "SPINEA" : "I908",
    "STRA" : "I965",
    "TEGLIO VENETO" : "L085",
    "TORRE DI MOSTO" : "L267",
    "VENEZIA" : "L736",
    "VIGONOVO" : "L899",
    "CAVALLINO-TREPORTI" : "M308",
};

const FINAL_CHECK ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";