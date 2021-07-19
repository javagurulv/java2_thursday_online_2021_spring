var offerContainer = document.getElementById("offer-info");
var btn = document.getElementById("btn");


btn.addEventListener("click", function(){
  var ourRequest = new XMLHttpRequest();
ourRequest.open('GET','http://localhost:8090/get_all_offers')
ourRequest.onload = function() {
  var ourData = JSON.parse(ourRequest.responseText);
  renderHTML(ourData);
};
ourRequest.send();
});

function renderHTML(data){
  var htmlStringBeforeEnd = "beforeend";
  var htmlString2 = "";

  for(i = 0; i < data.length; i++){
    htmlString2 += 
    "<table> <tr> <td> "+ data[i].offerType +"</td>"+
    "<td> "+ data[i].offerCategory  +"</td>"+
    "<td> "+ data[i].description    +"</td>"+
    "<td> "+ data[i].price          +"</td> </tr> </table>";
  }
offerContainer.insertAdjacentHTML(htmlStringBeforeEnd, htmlString2);
}
