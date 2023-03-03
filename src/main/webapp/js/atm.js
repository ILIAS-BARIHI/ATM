


var content = document.getElementById('content');

var card = document.getElementById('card');
var receiptpaper = document.getElementById('receiptpaper');


 

card.onclick = welcome; 


function welcome(){
    
    var image = document.getElementById('image')
    
    card.style.animationName='example';


    content.innerHTML ='<form><h2>WELCOME, ' + cust.Name + '<br> PLEASE ENTER YOUR PIN.</h2><input id="number" type=number max="9999">'
    keypad();
    

    
};

