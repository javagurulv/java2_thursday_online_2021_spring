var offerContainer = document.getElementById("offer-info");

var btn = document.getElementById("searchBTN");

btn.addEventListener("click", function(){
  var type = document.getElementById("offerType").value;
  var cat = document.getElementById("offerCategory").value;
  var price = document.getElementById("offerPrice").value;

  var ourRequest = new XMLHttpRequest();

ourRequest.open('POST','http://localhost:8090/search_offers');
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

  if(JSON.stringify(data).includes("Must not be empty")){
    htmlString2 = "<p>"+JSON.stringify(data)+"</p>";
  } else {

  for(i = 0; i < data.length; i++){
    htmlString2 = 
    "<table> <tr> <td> "+ data[i].offerType +"</td>"+
    "<td> "+ data[i].offerCategory  +"</td>"+
    "<td> "+ data[i].description    +"</td>"+
    "<td> "+ data[i].price          +"</td> </tr> </table>";
  }
}
offerContainer.insertAdjacentHTML(htmlStringBeforeEnd, htmlString2);
}