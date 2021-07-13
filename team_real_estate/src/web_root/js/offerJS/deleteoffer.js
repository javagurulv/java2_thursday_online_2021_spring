var btn = document.getElementById("deleteoffer");

btn.addEventListener("click", function(){
  var ourRequest = new XMLHttpRequest();
  var offerid = document.getElementById("offerid").value;

ourRequest.open('POST','http://localhost:8090/delete_offer')
ourRequest.setRequestHeader("Content-Type", "application/json");
ourRequest.onreadystatechange = function() {
  if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
      var data = ourRequest.responseText;
      alert(JSON.stringify(data));
  } }
ourRequest.send(JSON.stringify({id: offerid}));
});