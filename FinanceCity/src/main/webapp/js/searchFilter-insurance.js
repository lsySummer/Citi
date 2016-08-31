/**
 * Created by Hermit on 16/8/30.
 */
window.onload = function() {
    initSlider();
};

function initSlider() {
    $("#range").ionRangeSlider({
        type: "double",
        grid: true,
        min: 0,
        max: 1000,
        from: 200,
        to: 800,
        prefix: "$"
    });
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