var btn = document.getElementById("deletebtn");
var name = localStorage.getItem("name");
var pass = localStorage.getItem("pass");

btn.addEventListener("click", function(){
  var ourRequest = new XMLHttpRequest();

ourRequest.open('POST','http://localhost:8090/delete_from_registered_user')
ourRequest.setRequestHeader("Content-Type", "application/json");
ourRequest.onreadystatechange = function() {
  if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
      var data = ourRequest.responseText;
      alert(JSON.stringify(data));
  } }
ourRequest.send(JSON.stringify({username: name, password: pass}));
});
