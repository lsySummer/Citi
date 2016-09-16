


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



