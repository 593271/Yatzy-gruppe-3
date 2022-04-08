class FormController {

     _passord;
     _passordRepetert;
    
    constructor(passord, passordRepetert) {
        this._passord = passord;
        this._passordRepetert = passordRepetert;
        
        this.sjekkPassordStyrke = this.sjekkPassordStyrke.bind(this);
        this._passord.addEventListener("input", this.sjekkPassordStyrke);
        
        this.sjekkPassordRepetert = this.sjekkPassordRepetert.bind(this);
        this._passordRepetert.addEventListener("input", this.sjekkPassordRepetert);
    }

sjekkPassordStyrke(event) {
    const validity = event.target.validity;    
    if (validity.valid) {
        if(event.target.value.length >= 14){
            event.target.classList.remove("mediumPassword");
        }else if(event.target.value.length >= 8){
            event.target.classList.add("mediumPassword");
        }
        }else{
            event.target.classList.remove("mediumPassword");
        }
     
     if(event.target.value == this._passordRepetert.value){
        this._passordRepetert.setCustomValidity("");
    }else{
        this._passordRepetert.setCustomValidity("Repetert passord er feil!");
    }
        
}

sjekkPassordRepetert(event){
    if(event.target.value == this._passord.value){
        event.target.setCustomValidity("");
    } else{
        event.target.setCustomValidity("Repetert passord er feil!");
    }
}

}
function init() {
    new FormController(document.getElementById("passord"), document.getElementById("passordRepetert"));
}

document.addEventListener("DOMContentLoaded", init);


