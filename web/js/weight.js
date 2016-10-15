/**
 * Created by valua on 9/2/2016.
 */
function weightCount(){
    $.ajax({
        url: '/indexpage',
        type: 'GET',
        dataType: 'json',
        data:{command: "weight"},
        success: function(data){
            var str2 = data.weight;
            $('.weight').replaceWith("<a>Total weight: "+str2+"carat.</a>");
        },
        error: function(url,data){
            alert(data);
        }


    });
    return false;

};

