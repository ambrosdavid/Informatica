/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var jvar;

class WetherApi {

    static convert() {
        
        var xhttp = new XMLHttpRequest();
        var ris;
        xhttp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                // Typical action to be performed when the document is ready:
                ris = xhttp.responseText;

            }
        };
        xhttp.open("GET", "http://data.fixer.io/api/latest?access_key=65f556c68f7fd2434be4c4dcb3ba7e73", false);
        xhttp.send();
        jvar = JSON.parse(ris);
        
        
        var daValuta = document.getElementById("daValuta").value;
        var aValuta = document.getElementById("aValuta").value;
        
        var da_Valuta = jvar.rates[daValuta];
        var a_Valuta = jvar.rates[aValuta];
       

        var tempAEuro = 1 / da_Valuta;
        var EuroAtemp = tempAEuro * a_Valuta;
        
        var num=document.getElementById("num").value;

        document.getElementById("demo").innerHTML = EuroAtemp*num;

    }

}





