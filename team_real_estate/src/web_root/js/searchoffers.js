var offerContainer = document.getElementById("offer-info");

var btn = document.getElementById("searchBTN");

btn.addEventListener("click", function(){
  var type = document.getElementById("offerType").value;
  var cat = document.getElementById("offerCategory").value;
  var price = document.getElementById("offerPrice").value;

  var ourRequest = new XMLHttpRequest();

ourRequest.open('GET','http://localhost:8090/search_offers');
ourRequest.setRequestHeader("Content-Type", "application/json");

ourRequest.onload = function() {
  var ourData = JSON.parse(ourRequest.responseText);
  renderHTML(ourData);
};
ourRequest.send(JSON.stringify({
  offerType: type,
  offerCategory: cat,
  price: price
  }));

});

function renderHTML(data){
  var htmlStringBeforeEnd = "beforeend";
  var htmlString2 = "";

  for(i = 0; i < data.length; i++){
    htmlString2 += "<p> offer type = " + data[i].offerType+
    ", offer category = "+ data[i].offerCategory +
    ", description  = "+ data[i].description +
    ", price = "+data[i].price +"</p>";
  }
offerContainer.insertAdjacentHTML(htmlStringBeforeEnd, htmlString2);
}