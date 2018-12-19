/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


class WetherApi {
   static loadWeather(city, country) {
        var xhttp = new XMLHttpRequest();
        var ris;
        xhttp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                // Typical action to be performed when the document is ready:
                ris = xhttp.responseText;
            }
        };
        xhttp.open("GET", "http://api.openweathermap.org/data/2.5/weather?q="+city+","+country+"&APPID=209a1816d8e3783a3c3b5e8ec118424f", false);
        xhttp.send();
        
        return ris;
    }
    
    
    static getTemp(string){
        this.jvar = JSON.parse(string); 
        document.getElementById("demo").innerHTML=this.jvar.main.temp;
        alert(this.jvar.main.temp);
    }
    static getPressure(string){
        this.jvar = JSON.parse(string); 
        document.getElementById("demo").innerHTML=this.jvar.main.pressure;
        alert(this.jvar.main.pressure);
    }
    static getHumidity(string){
        this.jvar = JSON.parse(string); 
        document.getElementById("demo").innerHTML=this.jvar.main.humidity;
        alert(this.jvar.main.humidity);
    }
}




