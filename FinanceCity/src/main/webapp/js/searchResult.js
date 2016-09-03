/**
 * Created by Hermit on 16/8/24.
 */
window.onload = function() {
    getProduct();
};

function getProduct() {
    console.log(1);
    $.ajax({
        type: "post",
        url: "product/s",
        data: "keyword=1&type=2",
        dataType: "json",
        contentType: "application/json",
        success: function(data) {
            console.log(data);
        },
        error: function() {
            console.log("error");
        }
    });
}