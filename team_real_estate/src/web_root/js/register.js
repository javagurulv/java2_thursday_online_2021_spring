

var btn = document.getElementById("signupBTN");

btn.addEventListener("click", function(){
    var name = document.getElementById("username").nodeValue;
    var pass = document.getElementById("password").nodeValue;

  var ourRequest = new XMLHttpRequest();
ourRequest.open('POST','http://localhost:8090/add_to_registered_user')
ourRequest.send(JSON.stringify(name,pass));
});