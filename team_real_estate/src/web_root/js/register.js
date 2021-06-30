

var btn = document.getElementById("signupBTN");

btn.addEventListener("click", function(){
    var name = document.getElementById("username").value;
    var pass = document.getElementById("password").value;

  var ourRequest = new XMLHttpRequest();
ourRequest.open('POST','http://localhost:8090/add_to_registered_user');
ourRequest.setRequestHeader("Content-Type", "application/json");
ourRequest.send(JSON.stringify({username: name, password: pass}));
});