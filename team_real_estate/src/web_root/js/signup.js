function get_all_offers() {
    return $.ajax({
      type: "GET",
      dataType: "jsonp",
      headers: { "Content-Type": "application/x-www-form-urlencoded" },
      url: "http://localhost:8090/get_all_offers",
    }).then(function (offerlist) {
      offerlist.forEach(function (offer) {
        $("ul").append(
          "<li>id: " +
            offer.id +
            " ,type:" +
            offer.offerType +
            " ,category: " +
            offer.offerCategory +
            ",description: " +
            offer.description +
            ", price: " +
            offer.price +
            "</li>"
        );
      });
    });
  };