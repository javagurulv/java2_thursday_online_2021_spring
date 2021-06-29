
var offerContainer = document.getElementById("login-response");
var btn = document.getElementById("loginBTN");


btn.addEventListener("click", function(){
  var name = document.getElementById("username").value;
  var pass = document.getElementById("password").value;

  var ourRequest = new XMLHttpRequest();

ourRequest.open('GET','http://localhost:8090/find_in_registered_user')
ourRequest.setRequestHeader("Content-Type", "application/json");
ourRequest.onload = function() {
  var ourData = JSON.parse(ourRequest.responseText);
  renderHTML(ourData);
};
ourRequest.send(JSON.stringify({username: name, password: pass}));
});

function renderHTML(data){
  var htmlStringBeforeEnd = "beforeend";
  var htmlString2 = "";

if(data){
  htmlString2 = "Logged in successfully!";
} else {
  htmlString2 = "Incorrect username or password!"
}
offerContainer.insertAdjacentHTML(htmlStringBeforeEnd, htmlString2);
}