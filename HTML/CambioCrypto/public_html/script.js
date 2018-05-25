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
		xhttp.open("GET", "https://rest.coinapi.io//v1/exchangerate/BTC?apikey=EB6050E5-D457-4053-A39B-F7A5C0E84982", false);
		//https://docs.coinapi.io/#authorization
		xhttp.send();
		jvar = JSON.parse(ris);

		var daCrypto = document.getElementById("daValuta").selectedIndex;
		var aCrypto = document.getElementById("aValuta").selectedIndex;



		var da_Valuta = jvar.rates[daCrypto].rate;
		var a_Valuta = jvar.rates[aCrypto].rate;


		var tempABTC = 1 / da_Valuta;
		var BTCAtemp = tempABTC * a_Valuta;

		var num = document.getElementById("num").value;
		document.getElementById("demo").innerHTML = BTCAtemp * num;

	}

}





