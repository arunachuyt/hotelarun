

var map = [];
map["one"] = 1;
map["two"] = 2;
map["three"] = 3;
map["four"] = 4;
//alert(map["four"]);

var map = {
	"one" : [1,2,3,4],
	"two" : {"aziz":1234,"ahmed":2,"rajath":["r","a","j","a"]},
	"three" :3,
	"four" : 5
};


alert(map["two"]["rajath"][1]);
alert(map["one"]);
alert(map["two"]["aziz"]);

var emp = {

	"employee" : [ {
		"empno" : 1234,
		"empname" : "thomas",
		"empsalary" : 1222,
		"department" : {
			"id" : 10,
			"deptname" : "tr",
			"deptloc" : "chennai"
		},
		"address" : {
			"id": 1,
			"street" : "thraipalla",
			"state" : "TN",
			"country" : "IN"
		},
		"skills" : [ {
			"skillid" : 1,
			"skillname" : "java"
		}, {
			"skillid" : 2,
			"skillname" : ".net"
		} ]
	} ]
};


alert("address "+emp["employee"][0]["address"]);

var str=JSON.stringify(emp["employee"][0]["address"]);

alert("Adddress as string "+str);

var json=JSON.parse(str);

alert("Adddress as object "+json);



function show() {

	var s = document.getElementById("hideshow");

	if (s.style.display === 'none') {
		s.style.display = 'block';
	} else {
		s.style.display = 'none';
	}
}

var count = 1;
var att = [];
att["idly"] = 1;
att["dosa"] = 2;
att["bhajji"] = 3;
att["puri"] = 4;
function display(x) {

	/*
	 * var allElements = document.getElementsByTagName('*'); for(var i = 0; i <
	 * allElements.length; i++) { // ensure the element has an Id that is not
	 * empty and does exist // and string other than empty, '', will return true
	 * allElements[i].id && console.log(allElements[i].id);
	 * if(allElements[i].startsWith("id")){
	 * 
	 * alert(1); }
	 *  }
	 */
	alert(x.value);
	alert(att[x.value]);
	// document.getElementById("quantity").value=att[x.value];
	var ip2 = document.createElement("input");
	ip2.setAttribute("name", "quatity");
	ip2.setAttribute("id", "quantity");
	// ip2.setAttribute("value", count++);

	// ip2.setAttribute("value", att[x.value]);
	// ip2.setAttribute("readonly", "readonly");

	var label1 = document.createElement("label");
	label1.innerText = "Enter Serial Number";

	ip2.setAttribute("placeholder", "Enter Quatity");

	var ip = document.createElement("input");
	ip.setAttribute("name", "sno");
	ip.setAttribute("id", "sno");
	ip.setAttribute("readonly", "readonly");
	ip.setAttribute("value", count++);
	ip.setAttribute("placeholder", "Enter sno");

	var label2 = document.createElement("label");
	label2.innerText = "Enter Quantity";

	var tab = document.getElementById("tab");

	var tr = document.createElement("tr");
	var td = document.createElement("td");

	td.appendChild(label1);
	td.appendChild(ip);
	td.appendChild(label2);
	td.appendChild(ip2);
	tr.appendChild(td);
	tab.appendChild(tr);

	// tab.appendChild(tr1);

	// var select= document.getElementById(x);

}

function removeItem() {
	var tab = document.getElementById("tab");
	tab.deleteRow(0);
}

function generateItem() {

	var itemNames = [ "idly", "dosa", "bhajji", "puri" ];
	var prices = [ 1, 2, 3, 4 ];

	var tab = document.getElementById("tab");

	var tr = document.createElement("tr");
	var td = document.createElement("td");

	/*
	 * var ip=document.createElement("input"); ip.setAttribute("name", "sno");
	 * ip.setAttribute("id", "sno"); //ip.setAttribute("value", ""+Math.round(
	 * Math.random()*1000 )+10000);
	 * 
	 * ip.setAttribute("placeholder", "Enter sno");
	 */
	/*
	 * var ip2=document.createElement("input"); ip2.setAttribute("name",
	 * "quatity"); ip2.setAttribute("id", "quantity");
	 * ip2.setAttribute("placeholder", "Enter Quatity");
	 */

	// for(j=0;j<5;j++){
	var label = document.createElement("label");
	label.innerText = "SElect Item";
	td.appendChild(label);

	var select = document.createElement("select");

	for (i = 0; i < itemNames.length; i++) {
		var a = Math.round(Math.random() * 1000);

		select.setAttribute("name", "name");
		// select.setAttribute("id", "id"+Math.round(Math.random()*1000));

		select.setAttribute("id", "id");

		select.setAttribute("onchange", "display(this)");

		var option = document.createElement("option");

		option.setAttribute("value", itemNames[i]);
		option.innerText = itemNames[i];
		// option.setAttribute("id", "option"+prices[i]);
		// option.setAttribute("name", "option"+prices[i]);

		select.appendChild(option);

		td.appendChild(select);

		// alert(i);
		// }

	}

	// td.appendChild(ip);
	// td.appendChild(ip2);

	tr.appendChild(td);
	tab.appendChild(tr);

}

function validate1() {

	var a1 = document.forms["dates"]["date1"].value;
	var b1 = document.forms["dates"]["date2"].value;
	var d1 = new Date(a1.toString());
	var d2 = new Date(b1.toString());

	if (d1 < d2) {
	} else {

		alert("first date should be before second date");
	}

}

function validate() {

	var val = document.getElementById("date").value;

	var datee = new Date(val.toString());
	alert(datee);
	var arr = val.split("/");
	var check = (arr[0] > 0 && arr[0] < 32) && (arr[1] > 0 && arr[1] < 13)
			&& (arr[2] > 0 && arr[2] < 20000);

	if (check) {
		alert("Date is valid");

	} else {
		alert("date is not valid");

	}

}

function validateDate() {

	var label = document.createElement("p");
	label.innerText = "Enter dod";

	var ip = document.createElement("input");
	ip.setAttribute("type", "text");
	ip.setAttribute("name", "date");
	ip.setAttribute("placeholder", "dd/MM/yyyy");
	ip.setAttribute("id", "date");

	var btn = document.createElement("BUTTOn");
	btn.setAttribute("type", "button");
	btn.setAttribute("name", "validate");
	// btn.setAttribute("value", "validate");
	btn.setAttribute("onclick", "validate()");

	btn.innerText = "validate";

	var div = document.getElementById("p1");

	div.appendChild(label);
	div.appendChild(ip);
	div.appendChild(btn);

	// document.body.appendChild(label);

	// document.body.appendChild(ip);

	// document.body.appendChild(btn);

}

function print1() {

	var p1 = document.getElementById("p1");
	p1.innerHTML = "<b>I am fine</b>"
			+ "<form name='fone' >"
			+ "<input type='text' name='uname' class='textbox' placeholder='Enter name' > <br>"
			+ "<input type='password' name='pass' class='textbox' placeholder='Enter password' ><br> "
			+ "<input type='submit' class='btn' name='submit' value='Fone'>"
			+ "</form>" + "<br>";

}

function helloo() {
	/*
	 * document.write("Welcome to jS"); var a=10; document.write(a+"<br>");
	 * a="Welcome"; document.write(a+"<br>");
	 * 
	 * a=123.45; document.write(a+"<br>");
	 * 
	 * a=new Date(); document.write(a+"<br>");
	 */

	var uname = document.forms["login"]["username"].value;
	var pass = document.forms["login"]["password"].value;
	if (uname == "" || pass == "") {
		alert("Username and password should be filled");
	}
	var regex = /^[0-9]{4}$/;
	var regex2 = /^[0-9]{4}[a-z]{4}$/;

	// var
	// regex2=/^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})/

	if (uname.match(regex)) {

		// alert("Username is 4 digits");

	} else {

		alert("Username is wrong digits");
		return false;
	}

	if (uname.match(regex) && pass.match(regex2)) {

		alert("password is 4 digits $ chars");
		return true;
	} else {

		alert("Password is wrong digits chars");
		return false;
	}

}
