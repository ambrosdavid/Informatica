

var array;

function start() {
    var div1 = document.getElementById("div1");
    var div2 = document.getElementById("div2");
    var div3 = document.getElementById("div3");

    //div1.style.backgroundColor = "red";
    //div2.style.backgroundColor = "red";


    array = [div1, div2, div3];
    var i = 0;

    starta();
    riempiPos();
}

var i = -1;
var i2 = -1;

var accendi;
var spegni;
function starta() {

    accendi = setInterval(setColor, 1000);
    spegni = setInterval(resetColor, 1200);


}

var colori = ["rgb(255,0,0)", "rgb(0,0,255)", "rgb(0,128,0)"];
var indicePosizioni;
var indiceColori;

function setColor() {
    if (i == array.length - 1) {
        stopAccendi();
        i = -2;
    }
    var coloreRandom = Math.floor(Math.random() * 3);
    i++;
    console.log(i);
    array[i].style.backgroundColor = colori[coloreRandom];
}//"rgb(255,0,0)"


function resetColor() {
    if (i2 == array.length - 1) {
        stopSpegni();
        i2 = -2;
    }

    i2++;
    array[i2].style.backgroundColor = "white";
}

function stopAccendi() {
    clearInterval(accendi);

}
function stopSpegni() {
    clearInterval(spegni);

}

function riempiPos() {
    while (indicePosizioni.length < 4) {
        var indice = Math.random() * 3;
        var presente = false;
        for (var i = 0; i < indicePosizioni.length-1; i++) {
            if (indicePosizioni[i] == indice) {
                presente = true;
                break;
            }
        }
        if (presente == false) {
            indicePosizioni[indicePosizioni.length - 1] = indice;
        }
    }
    for (var i = 0; i < indicePosizioni.length; i++) {
        console.log("pos" + indicePosizioni[i]);
    }
}