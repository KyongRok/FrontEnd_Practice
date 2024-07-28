/* 4413 23Su Task 1 - write your code here */

function lightOn(buttonid){
 /* set image src to be that for light 1, and set message texts to be "light #1 is on"  */

 var x = document.getElementById("light");
 var y = document.getElementById("message");
 if(buttonid=="1"){
    x.src = "images/light/light_1.jpg";
    y.innerHTML = "light #1 is on";
 }else if(buttonid=="2"){
    x.src = "images/light/light_2.jpg";
    y.innerHTML = "light #2 is on";
 }else if(buttonid=="3"){
    x.src = "images/light/light_3.jpg";
    y.innerHTML = "light #3 is on";
 }else if(buttonid=="4"){
    x.src = "images/light/light_4.jpg";
    y.innerHTML = "light #4 is on";
 }else if(buttonid=="5"){
    x.src = "images/light/light_5.jpg";
    y.innerHTML = "light #5 is on";
 }else{
    var x = document.getElementById("light");
    x.src = "images/light/light_0.jpg";
    var y = document.getElementById("message");
    y.innerHTML = "click button to turn on/off light"
 }
}

 