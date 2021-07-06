var offerContainer = document.getElementById("signUp-response");
var btn = document.getElementById("signupBTN");

btn.addEventListener("click", function(){
    var name = document.getElementById("username").value;
    var pass = document.getElementById("password").value;

  var ourRequest = new XMLHttpRequest();
ourRequest.open('POST','http://localhost:8090/add_to_registered_user');
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

  htmlString2 = "<p> "+data+" </p>"

offerContainer.insertAdjacentHTML(htmlStringBeforeEnd, htmlString2);
}