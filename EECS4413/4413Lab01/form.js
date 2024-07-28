// put your JS functions here

// validate various form components{
function formcheck() {
    let counter = 0;
    var fn = document.getElementById("fname").value;
    var ln = document.getElementById("lname").value;
    var pw = document.getElementById("pword").value;
    var ma = document.getElementById("em").value;

    if (fn == "") {//first name check
        alert("First Name Must Be Filled Out!");
        counter++;
        return false;
    }

    if (ln == "") {
        alert("Last Name Must Be Filled Out!");
        counter++;
        return false;
    }

    if (pw == "") {
        alert("Password Must Be Filled Out!");
        counter++;
        return false;
    }

    if(ma==""){
        alert("Email Must Be Filled Out!");
        counter++;
        return false;
    }

    if (!checkMail(ma)){
        alert("Email Is In Wrong Format!");
        counter++;
        return false;
    }

    if(!checkbox()){
        alert("You Must Pick Atleast 1 Hobby!");
        counter++;
        return false;
    }

    if(!courseformat()){
        alert("Course Code Format Should Be EECSXXXX");
        counter++;
        return false;
    }

        if (counter == 0) {
            return true;
        } else {
            return false;
        }

}

//check course format
function courseformat(){
    var targ = document.getElementById("cname").value;
    var filter = /^EECS\d{4}$/;
    if(filter.test(targ)){
        return true;
    }else{
        return false;
    }
}

//check mail format
function checkMail(email){
	var filter  = /^[A-Za-z0-9;!-/=?#$%&'*+^_`{|}~.]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,3}$/;
	if (filter.test(email)) {
		return true;
	}
	return false;
}

//check atleast 1 checkbox
function checkbox(){
    var b = document.getElementsByName("hobby[]");
    var bool = false;

    for(var i = 0; i < b.length; i++){
        if(checkbox[i].checked){
            bool = true;
            break;
        }
    }

    if(bool){
        return true;
    }else{
        return false;
    }
}


//function for hiding textbox for droplist
function hide() {
    var sel = document.getElementById("droplist").value;
    var box = document.getElementById("input");
    if (sel === "OTHER") {
        document.getElementById("input").style.visibility = "visible";
    } else {
        document.getElementById("input").style.visibility = "hidden";
    }

}

// change logo
function changelogo() {
    var img = document.getElementById("im");

    if (img.getAttribute('src') === 'images/logo/york.png') {
        img.src = 'images/logo/LAS.png';
    } else {
        img.src = 'images/logo/york.png';
    }
}

// change background
function changebackground() {
    var col_current = document.getElementById("box");
    var css_current = window.getComputedStyle(col_current).backgroundColor;
    var col1 = "rgb(220, 220, 220)";
    if (css_current === col1) {
        col_current.style.backgroundColor = "rgb(173, 216, 230)";
    } else {
        col_current.style.backgroundColor = "rgb(220, 220, 220)";
    }
}


