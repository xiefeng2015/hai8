//路径配置
require.config({
	paths: {
		echarts: '../resources/js/build/dist'
	}
});

//使用
require(
	[
		'echarts',
		'echarts/theme/macarons2',
		'echarts/chart/pie' //使用饼状图就加载pie模块，按需加载
	],
	function (ec, theme) {
		// 基于准备好的dom，初始化echarts图表
		var myChart = ec.init(document.getElementById('main1'),theme); 
		//alert("");
		option = {
			title : {
				text: '测试结果图1',
				x:'center'
			},
			tooltip : {
				trigger: 'item',
				formatter: "{a} <br/>{b} : {c} ({d}%)",
			},
			legend: {
				orient : 'vertical',
				x : 'left',
				data:['成功数','失败数','跳过数']
			},
			calculable : true,
			series : [
				{
					type:'pie',
					radius : '40%',
					center: ['45%', '45%'],
					data:[
						{value:document.getElementById("total_pass").value, name:'成功数',itemStyle:{normal:{color:'green'}}},
						{value:document.getElementById("total_fail").value, name:'失败数',itemStyle:{normal:{color:'red'}}},
						{value:document.getElementById("total_skip").value, name:'跳过数',itemStyle:{normal:{color:'gray'}}},
					]
				}
			]
		};
		// 为echarts对象加载数据 
		myChart.setOption(option);
//		var picInfo = myChart.getImage();
//		alert(picInfo);
//		document.getElementById("pic1").appendChild(picInfo);
		var picInfo = encodeURIComponent(myChart.getDataURL("png"));
		document.getElementById("pic1").innerHTML(picInfo);
	}
);

require(
	[
		'echarts',
		'echarts/theme/roma',
		'echarts/chart/bar' //使用柱状图就加载bar模块，按需加载
	],
	function (ec, theme) {
		// 基于准备好的dom，初始化echarts图表
		var myBar = ec.init(document.getElementById('main2'),theme); 
		option = {
			title : {
				text: '测试结果图2',
				x:'center'
			},
			 tooltip : {
				trigger: 'axis'
			},
			legend: {
				orient : 'vertical',
				x : 'right',
				data:['跳过数','失败数','成功数']
			},
			calculable : true,
			xAxis : [
				{
					type : 'value',
					boundaryGap : [0, 2]
				}
			],
			yAxis : [
				{
					type : 'category',
					data : ['跳过数','失败数','成功数']
				}
			],
			series : [
				{
					name:'跳过数',
					type:'bar',
					itemStyle:{normal:{color:'gray'}},
					data:[document.getElementById("total_skip").value,0,0]
				},
				{
					name:'失败数',
					type:'bar',
					itemStyle:{normal:{color:'red'}},
					data:[0,document.getElementById("total_fail").value,0]
				},
				{
					name:'成功数',
					type:'bar',
					itemStyle:{normal:{color:'green'}},
					data:[0,0,document.getElementById("total_pass").value]
				}
			]
		};
		// 为echarts对象加载数据 
		myBar.setOption(option);
	}
);