var name = localStorage.getItem("name");
var pass = localStorage.getItem("pass");

var offerContainer = document.getElementById("user-info");
var btn = document.getElementById("btn");

btn.addEventListener("click", function(){
  var ourRequest = new XMLHttpRequest();

ourRequest.open('POST','http://localhost:8090/get_user')
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
  var errorStringCheck = "empty";

  if(dataString.includes(errorStringCheck)){
      htmlString2 = "<p>"+dataString+"</p>";
  } else {
      
      var dataJson = JSON.parse(data); 

    htmlString2 += "<p> Id = " + dataJson["id"]+
    ", Username = "+ dataJson["username"] +
    ", Email = "+dataJson["email"] +"</p>";
  
}
offerContainer.insertAdjacentHTML(htmlStringBeforeEnd, htmlString2);
}