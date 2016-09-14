
window.onload = function() {

    for (var i=1; i<=3; i++) {
        for (var j=1; j<=5; j++) {
            var id = "precentChart" + i + "-" + j;
            initPrecentChart(id);
        }
        initRadarChart("radarChart" + i);
    }

}


function  initPrecentChart(chartId) {
    zingchart.MODULESDIR = "https://cdn.zingchart.com/modules/";
    zingchart.THEME="classic";

    var myConfig = {
        "globals": {
            "font-family":"Lato",
            "font-weight":"100"
        },
        "graphset":[
            {
                "type":"ring",
                "background-color":"#fff",
                "tooltip":{
                    "visible":0
                },
                "plotarea":{
                    "margin":"0% 0% 0% 0%"
                },
                "plot":{
                    "slice":15,
                    "ref-angle":270,
                    "detach":false,
                    "hover-state":{
                        "visible":false
                    },
                    "value-box":{
                        "visible":true,
                        "type":"first",
                        "connected":false,
                        "placement":"center",
                        "text":"<div style='font-size:14px;'>30%</vid>",
                        "rules":[
                            {
                                "rule":"%v > 50",
                                "visible":false
                            }
                        ],
                        "font-color":"#000",
                        "font-size":"60px"
                    },
                    "animation":{
                        "delay":0,
                        "effect":2,
                        "speed":"600",
                        "method":"0",
                        "sequence":"1"
                    }
                },
                "series":[
                    {
                        "values":[30],
                        "background-color":"#FDCB0A",
                        "border-color":"#fff",
                        "border-width":"1px",
                        "shadow":0
                    },
                    {
                        "values":[70],
                        "background-color":"#eee",
                        "border-color":"#fff",
                        "border-width":"1px",
                        "shadow":0
                    }
                ]
            }
        ]
    };

    zingchart.render({
        id : chartId,
        data : myConfig,
        height: 50,
        width: 50,
        hideprogresslogo: true
    });
}



function initRadarChart(chartId) {
    zingchart.MODULESDIR = "https://cdn.zingchart.com/modules/"
    zingchart.THEME="classic";
    var myConfig =
    {
        "type": "radar",
        "plot": {
            "aspect": "line"
        },
        "background-color": "Transparent",

        "title": {
            "background-color": "none",
            "font-color": "000",
            //"font-size": "22px"
        },
        "tooltip": {
            //"text": "%t<br>%k Is %v",
            "shadow": 0,
            "border-radius": 3
        },
        "scale-k": {
            "background-color": "none",
            "values": [
                "收益性",
                "流动性",
                "平均期限",
                "风险性",
            ],
            "item": {
                "font-color":"#808080",
                "font-weight":"100",
                "font-size": "10px",
                "padding-left": "5px",
                "padding-bottom": "5px"
            },
            "guide": {
                "line-color": "",
                "line-style": "solid",
                "line-width": "2px",
                "items": [
                    {
                        "background-color": "#fff"
                    }
                ]
            },
            "tick": {
                "visible": false
            }
        },
        "scale-v": {
            "values": [
                20,40,60,80,100
            ],
            "item": {
                "font-color":"Transparent",
                "padding-left": "0px",
                "font-size": "10px"
            },
            "ref-line": {
                "line-color": ""
            },

            "tick": {
                "line-color": ""
            }
        },
        "series": [
            {
                "values": [
                    90,70,40,50
                ],
                "aspect": "line",
                "text": "ER",
                "line-color": "#11b7f3",
                "background-color": "none",
                "line-width": "2px",
                "alpha": "1",
                "marker": {
                    "background-color": "#11b7f3",
                    "size": "3",
                    "border-color": "#11b7f3",
                    "alpha": "1"
                }
            },
            {
                "aspect": "line",
                "text": "ENT",
                "line-color": "#11b7f3",
                "line-width": "4px",
                "alpha": "0",
                "marker": {
                    "background-color": "#666666",
                    "size": "4",
                    "border-color": "#666666",
                    "alpha": "0.55"
                }
            }
        ]
    };

    zingchart.render({
        id : chartId,
        data : myConfig,
        height: 300,
        width: 300
    });
}

