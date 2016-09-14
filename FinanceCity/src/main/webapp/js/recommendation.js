
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
    var chart = AmCharts.makeChart( chartId, {
        "type": "radar",
        "theme": "light",
        "dataProvider": [ {
            "country": "美不美债券",
            "litres": 156.9
        }, {
            "country": "稳赚利38天",
            "litres": 131.1
        }, {
            "country": "大长腿保险",
            "litres": 115.8
        }, {
            "country": "什么理财",
            "litres": 109.9
        }, {
            "country": "一个基金",
            "litres": 108.3
            //}, {
            //    "country": "UK",
            //"litres": 99
        } ],
        "valueAxes": [ {
            "axisTitleOffset": 20,
            "minimum": 0,
            "axisAlpha": 0.15
        } ],
        "startDuration": 2,
        "graphs": [ {
            "balloonText": "[[value]] litres of beer per year",
            "bullet": "round",
            "lineThickness": 2,
            "valueField": "litres"
        } ],
        "categoryField": "country",
        "export": {
            "enabled": false
        }
    } );
}

