let inscription = document.getElementById("inscription");
let connexion = document.getElementById("connexion");


console.log($cookies.get("token"));
console.log("script JS TEST");


if ($cookies.get("token")){
    inscription.style.display = "none";
    connexion.style.display = "none";
}else{
    inscription.style.display = "";
    connexion.style.display = "";
}