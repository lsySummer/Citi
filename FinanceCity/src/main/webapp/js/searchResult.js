/**
 * Created by Hermit on 16/8/24.
 */
window.onload = function() {
    //getProduct();
    initListener();
};

function initListener() {
    $("#sift_product_button").on("click", function() {
        getProduct();
    });
}

function getProduct() {
    console.log($("#search_filter").serialize());
}