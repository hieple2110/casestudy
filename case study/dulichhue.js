
let myIndex = 0;
carousel();

function carousel() {
    let i;
    let x = document.getElementsByClassName("slide");
    for (i = 0; i < x.length; i++) {
        x[i].style.display = "none";
    }
    myIndex++;
    if (myIndex > x.length) { myIndex = 1 }
    x[myIndex - 1].style.display = "block";
    setTimeout(carousel, 2000); // Change image every 2 seconds
}


let today = new Date();
let date = today.getDate() + '/' + (today.getMonth() + 1) + '/' + today.getFullYear();
let time = today.getHours() + ":" + today.getMinutes();
let dateTime = date + ' ' + time;

document.getElementById("day").innerHTML = dateTime;






