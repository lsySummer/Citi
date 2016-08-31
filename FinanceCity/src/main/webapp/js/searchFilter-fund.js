/**
 * Created by Hermit on 16/8/30.
 */
window.onload = function() {
    initSlider();
    initSort();
};

function initSlider() {
    // $("#range").ionRangeSlider({
    //     type: "double",
    //     grid: true,
    //     min: 0,
    //     max: 1000,
    //     from: 200,
    //     to: 800,
    //     prefix: "$"
    // });
    $("#annualized_return").ionRangeSlider({
        type: "double",
        grid: true,
        min: 0,
        max: 1000,
        from: 200,
        to: 800,
        prefix: "$"
    });
}

var isAscend = true;
function initSort() {
    $("#sort_type").on("click", function() {
        isAscend = !isAscend;
        if(isAscend){
            $("#sort_type").html("升序<i class='fa fa-long-arrow-up'></i>");
        }else{
            $("#sort_type").html("降序<i class='fa fa-long-arrow-down'></i>");
        }
    });
}