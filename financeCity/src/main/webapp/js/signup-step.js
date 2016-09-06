/**
 * Created by Hermit on 16/8/30.
 */
window.onload = function() {
    initSlider();
};

function initSlider() {
    $("#income").ionRangeSlider({
        type: "double",
        grid: true,
        min: 0,
        max: 100,
        from: 20,
        to: 80,
        postfix: "%"
    });
    
    $("#risk").ionRangeSlider({
        type: "double",
        grid: true,
        min: 0,
        max: 100,
        from: 20,
        to: 80,
        postfix: "%"
    });
    
}