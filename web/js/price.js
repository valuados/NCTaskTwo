/**
 * Created by valua on 9/2/2016.
 */
function priceCount(){
    $.ajax({
        url: '/indexpage',
        type: 'GET',
        dataType: 'json',
        data:{command: "price"},
        success: function(data){
            var str = data.price;
            $('.price').replaceWith("<a>Total price: "+str+"$.</a>");
        },
        error: function(url,data){
            alert(data);
        }


    });
    return false;

};

