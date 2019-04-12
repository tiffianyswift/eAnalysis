<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <style>
        #heatmap{ width:930px; height:800px;border: 1px solid;border-color: gray;}
        #div1{margin-top:323px;}
    </style>
</head>
<body>
<%--<a href="js/heatmap.js">1111</a>--%>
<div id="heatmap" >
    <img id="" src="../img/2.jpg" width="1000px" height="800px">
</div>
<div id="div1"><button id="b1" style="width:600px;height:400px;">hello</button></div>
<div src="../img/map.jpg"></div>

<%--<img alt="" src="/img/1.jpg">--%>

</body>
<script src="../js/heatmap.js"></script>
<script src="../js/lib/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
    // 创建一个heatmap实例对象
    // “h337” 是heatmap.js全局对象的名称.可以使用它来创建热点图实例
    // 这里直接指定热点图渲染的div了.heatmap支持自定义的样式方案,网页外包接活具体可看官网api
    var heatmapInstance = h337.create({
        container: document.querySelector('#heatmap'),
    });
    //构建一些随机数据点,网页切图价格这里替换成你的业务数据
    $(document).ready(function(){
        $("#b1").click(function(){
            $.ajax({
                type:"POST",
                url:"/eAnalysis_war_exploded/servlet/pointservlet",
                datatype:"json",
                data:{
                    videoid:"hello"
                },
                success:function(data){
                    var x = data.X;
                    var y = data.Y;
                    var pointx = x.split(',');
                    var pointy = y.split(',');
                    var points = [];
                    var max = 0;
                    var width = 740;
                    var height = 600;
                    var len = 350;
                    while (len--) {
                        //console.log(pointx[len])
                        var val = Math.floor(Math.random()*10000);
                        max = Math.max(max, val);
                        var point = {
                            x: parseInt((Number(pointx[len])/100*3.225)*width+150),
                            y: parseInt((Number(pointy[len])/100*3.225)*height+143),
                            value: val
                        };
                        points.push(point);
                        console.log(point);
                    }
                    var data = {
                        max: max,
                        data: points
                    };//因为data是一组数据,web切图报价所以直接setData
                    heatmapInstance.setData(data); //数据绑定还可以使用
                }

            });
        });
    });
    // var points = [];
    // var max = 0;
    // var width = 740;
    // var height = 600;
    // var len = 33300;
    // while (len--) {
    //     var val = Math.floor(Math.random()*10000);
    //     max = Math.max(max, val);
    //     var point = {
    //         x: Math.floor(Math.random()*width)+150,
    //         y: Math.floor(Math.random()*height)+143,
    //         value: val
    //     };
    //     points.push(point);
    //     console.log(point);
    // }
    // var data = {
    //     max: max,
    //     data: points
    // };//因为data是一组数据,web切图报价所以直接setData
    // heatmapInstance.setData(data); //数据绑定还可以使用

</script>
</html>