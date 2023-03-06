
var attempt = 0;
var attempt1 = 0

var cancel = document.getElementById('cancel');
var clear = document.getElementById('clear');
var enter = document.getElementById('enter');

var content = document.getElementById('content');

var card = document.getElementById('card');




card.onclick = welcome;

function welcome() {
	var image = document.getElementById('image')

	card.style.animationName = 'example';


	content.innerHTML = '<form action="ATM" Method="POST" id ="myForm"> <h2>WELCOME, <br> PLEASE ENTER YOUR PIN.</h2><input id="number" name="number" type=password ><input name="numCarte" type=hidden value="111">'
	keypad();

	clear.onclick = welcome;
	enter.onclick = sub;


};


	function sub() {
		enter.addEventListener('click', function() {
			document.getElementById("myForm").submit()
		});
	}

	function keypad() {
		var button1 = document.getElementById('button1');
		var button2 = document.getElementById('button2');
		var button3 = document.getElementById('button3');
		var button4 = document.getElementById('button4');
		var button5 = document.getElementById('button5');
		var button6 = document.getElementById('button6');
		var button7 = document.getElementById('button7');
		var button8 = document.getElementById('button8');
		var button9 = document.getElementById('button9');
		var button0 = document.getElementById('button0');
		var buttondel = document.getElementById('delete');
		var buttonspa = document.getElementById('space');

		var keypad = [button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttondel, buttonspa];

		var number = document.getElementById('number');

		keypad.forEach(function(key, idx) {
			key.addEventListener('click', function() {
				console.log(number.value);
				number.value += Number(keypad[idx].value);
				console.log(number.value);

			});
		});

	};
