function bing(){
	data = [
        {name: 'web', value:6 },
        {name: 'mac', value: 10},
        {name: 'pc', value:20},
        {name: 'Android',  value: 28},
        {name: 'ios', value: 38},
      ];
      var Stat = G2.Stat;
      var chart = new G2.Chart({
        id: 'c1',
        forceFit: true,
        height: 450
      });
      chart.source(data);
      // 重要：绘制饼图时，必须声明 theta 坐标系
      chart.coord('theta', {
        radius: 0.8 // 设置饼图的大小
      });
      chart.legend('name', {
        position: 'bottom',
        itemWrap: true,
        formatter: function(val) {
          for(var i = 0, len = data.length; i < len; i++) {
            var obj = data[i];
            if (obj.name === val) {
              return val + ': ' + obj.value + '%'; 
            }
          }
        }
      });
      chart.tooltip({
        title: null,
        map: {
          value: 'value'
        }
      });
      chart.intervalStack()
        .position(Stat.summary.percent('value'))
        .color('name')
        .label('name*..percent',function(name, percent){
        percent = (percent * 100).toFixed(2) + '%';
        return name + ' ' + percent;
      });
      chart.render();
      // 设置默认选中
      var geom = chart.getGeoms()[0]; // 获取所有的图形
      var items = geom.getData(); // 获取图形对应的数据
      geom.setSelected(items[1]); // 设置选中
}
function huan(){
	 var data = [
        { number:'个人免费用户1000人', profit: 1000},
        { number:'个人付费用户232人', profit: 232},
        { number:'企业付费用户64人 ', profit: 64},
      ];
      var Stat = G2.Stat;
      var chart = new G2.Chart({
        id: 'c2',
        forceFit: true,
        height: 450,
        plotCfg: {
          margin: 80
        }
      });
      chart.source(data);
      // 以 year 为维度划分分面
      chart.legend({
        position: 'bottom'
      });
      chart.coord('theta', {
        radius: 1,
        inner: 0.35
      });
      chart.tooltip({
        title: null
      });
      chart.intervalStack().position(Stat.summary.percent('profit'))
        .color('number')
        .label('..percent', {
        offset: -2
      })
        .style({
        lineWidth: 1
      });
      chart.render();
}
function zhu(){
	     var data = [
        {name: '新增注册户数',data: [143,45,34,54,143,45,34,54,143,45,34,54]},
        {name: '新增个人付费用户数',data: [83,89,143,45,34,54,83,89,143,45,34,54]},
        {name: '新增个企业费用户数',data: [48,65,83,143,45,34,54,8,65,83,89,143,45]},
      ];
      for(var i=0; i < data.length; i++) {
        var item = data[i];
        var datas = item.data;
        var months = ['2017-08-01.','2017-08-02.','2017-08-03.','2017-08-04.','2017-08-05.','2017-08-06.','2017-08-07.','2017-08-08.','2017-08-10.','2017-08-11','2017-08-12.'];
        for(var j=0; j < datas.length; j++) {
          item[months[j]] = datas[j];
        }
        data[i] = item;
      }
      var Stat = G2.Stat;
      var Frame = G2.Frame;
      var frame = new Frame(data);
      frame = Frame.combinColumns(frame, ['2017-08-01.','2017-08-02.','2017-08-03.','2017-08-04.','2017-08-05.','2017-08-06.','2017-08-07.','2017-08-08.','2017-08-10.','2017-08-11','2017-08-12.'],'数量','时间','name');
      var chart = new G2.Chart({
        id: 'c3',
        forceFit: true,
        height : 350,
        plotCfg: {
          margin: [20,160,60,80]
        }
      });
      chart.source(frame);
      chart.col('name',{alias: '分类'});
      chart.intervalDodge().position('时间*数量').color('name');
      chart.render();
}
function huoyue(){
	  var data = [
        {month: '1', number: 7},
        {month: '2', number: 6},
        {month: '3', number: 9},
        {month: '4', number: 15},
        {month: '5', number: 18},
        {month: '6', number: 25},
        {month: '7', number: 22},
        {month: '8', number: 25},
        {month: '9', number: 23},
        {month: '10', number: 13},
        {month: '11', number: 19},
        {month: '12', number: 9}
      ];
      var chart = new G2.Chart({
        id: 'c4',
        forceFit: true,
        height: 450
      });
      chart.source(data, {
        month: {
          alias: '月份',
          range: [0, 1]
        },
        number: {
          alias: '数量'
        }
      });
      chart.line().position('month*number').size(2);
      chart.render();
}
function leiji(){
	   var data = [
        {name: '累计注册户数',data: [143,45,34,54,143,45,34,54,143,45,34,54]},
        {name: '累计个人付费用户数',data: [83,89,143,45,34,54,83,89,143,45,34,54]},
        {name: '累计个企业费用户数',data: [48,65,83,143,45,34,54,8,65,83,89,143,45]},
      ];
      for(var i=0; i < data.length; i++) {
        var item = data[i];
        var datas = item.data;
        var months = ['2017-08-01.','2017-08-02.','2017-08-03.','2017-08-04.','2017-08-05.','2017-08-06.','2017-08-07.','2017-08-08.','2017-08-10.','2017-08-11','2017-08-12.'];
        for(var j=0; j < datas.length; j++) {
          item[months[j]] = datas[j];
        }
        data[i] = item;
      }
      var Stat = G2.Stat;
      var Frame = G2.Frame;
      var frame = new Frame(data);
      frame = Frame.combinColumns(frame, ['2017-08-01.','2017-08-02.','2017-08-03.','2017-08-04.','2017-08-05.','2017-08-06.','2017-08-07.','2017-08-08.','2017-08-10.','2017-08-11','2017-08-12.'],'数量','时间','name');
      var chart = new G2.Chart({
        id: 'c5',
        forceFit: true,
        height : 350,
        plotCfg: {
          margin: [20,160,60,80]
        }
      });
      chart.source(frame);
      chart.col('name',{alias: '分类'});
      chart.intervalDodge().position('时间*数量').color('name');
      chart.render();
}
bing();
huan();
zhu();
huoyue();
leiji();
