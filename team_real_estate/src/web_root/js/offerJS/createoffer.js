var offerContainer = document.getElementById("create-errors");
var btn = document.getElementById("createBTN");

btn.addEventListener("click", function(){
  var type = document.getElementById("offerType").value;
  var cat = document.getElementById("offerCategory").value;
  var desc = document.getElementById("offerDescription").value;
  var price = document.getElementById("offerPrice").value;

  var ourRequest = new XMLHttpRequest();

ourRequest.open('POST','http://localhost:8090/create_offer');
ourRequest.setRequestHeader("Content-Type", "application/json");

ourRequest.onload = function() {
  var ourData = ourRequest.responseText;

  if(JSON.stringify(ourData).includes("created")){
    alert(ourData);
  } else {
  renderHTML(ourData);
  }
};
ourRequest.send(JSON.stringify({
  offerType: type,
  offerCategory: cat,
  description: desc,
  price: price
  }));
});


function renderHTML(data){
    var htmlStringBeforeEnd = "beforeend";
    var htmlString2 = "<p>"+JSON.stringify(data)+"</p>";
    
  offerContainer.insertAdjacentHTML(htmlStringBeforeEnd, htmlString2);
  }
