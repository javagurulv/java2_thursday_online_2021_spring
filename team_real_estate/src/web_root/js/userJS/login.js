var offerContainer = document.getElementById("login-response");
var btn = document.getElementById("loginBTN");

btn.addEventListener("click", function(){
  var name = document.getElementById("username").value;
  var pass = document.getElementById("password").value;
  localStorage.setItem("name", name);
  localStorage.setItem("pass", pass);

  var ourRequest = new XMLHttpRequest();

ourRequest.open('POST','http://localhost:8090/find_in_registered_user')
ourRequest.setRequestHeader("Content-Type", "application/json");
ourRequest.onreadystatechange = function() {
  if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
      var data = ourRequest.responseText;
      renderHTML(data);
  } }
ourRequest.send(JSON.stringify({username: name, password: pass}));
});

function renderHTML(data){
  var htmlStringBeforeEnd = "beforeend";
  var htmlString2 = "";

  var dataString = JSON.stringify(data); 
  var stringTrue = JSON.stringify("true");

if(Boolean(dataString == stringTrue)){

  window.location.replace("http://127.0.0.1:5500/common/userpage.html");
} else {
  htmlString2 = "<p> Please try again : </p>" + "<p>"+ dataString + "</p>";
}

offerContainer.insertAdjacentHTML(htmlStringBeforeEnd, htmlString2);
}
