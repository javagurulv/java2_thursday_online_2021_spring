var offerContainer = document.getElementById("offer-info");
var btn = document.getElementById("btn");


btn.addEventListener("click", function(){
  var ourRequest = new XMLHttpRequest();
ourRequest.open('GET','http://localhost:8090/get_all_offers')
ourRequest.onload = function() {
  var ourData = JSON.parse(ourRequest.responseText);
  renderHTML(ourData);
  console.log(ourData[0])
};
ourRequest.send();
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
