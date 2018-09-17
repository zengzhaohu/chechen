/**
 * 行政区域js
 */

$(function() {
	initialPage();
	getGrid();
});

function initialPage() {
	$("#treePanel").css('height', $(window).height()-54);
	$(window).resize(function() {
		$("#treePanel").css('height', $(window).height()-54);
		$('#dataGrid').bootstrapTable('resetView', {
			height : $(window).height() - 108
		});
	});
}

function getGrid() {
	$('#dataGrid').bootstrapTableEx({
		url : '../../sys/car/list?_' + $.now(),
		height : $(window).height() - 108,
		queryParams : function(params) {
			params.plateNumber = vm.keyword;
			return params;
		},
		pagination : true,
		columns : [ {
			checkbox : true
		}, {
			field : "id",
			title : "序号",
			width : "50px"
		}, {
			field : "plateNumber",
			title : "车牌号码",
			width : "100px"
		}, {
			field : "carType",
			title : "车辆类型",
			width : "200px",
			formatter:function(value,row,index){
				if(value=='0'){
					return '<span class="label label-primary">中大型车</span>';
				}else
				if(value=='1'){
					return '<span class="label label-primary">中型车</span>';
				}else
				if(value=='2'){
					return '<span class="label label-primary">紧凑型车</span>';
				}else
				if(value=='3'){
					return '<span class="label label-primary">小型车</span>';
				}else
				if(value=='4'){
					return '<span class="label label-primary">微型车</span>';
				}
				
			}
		}, {
			field : "age",
			title : "车龄",
			width : "60px",
		}, {
			field : "mileage",
			title : "里程",
			width : "60px",
			align : "center",
		}, 
		{
			field : "userName",
			title : "车主",
			width : "160px",
			align : "center",
		},
		{
			field : "phone",
			title : "电话",
			width : "60px",
			align : "center",
		},{
			field : "remark",
			title : "备注"
		} ]
	})
}


var vm = new Vue({
	el : '#main',
	data : {
		keyword : null,
		parentCode : '0',
		parentName : null,
		carTypeList:[
            {text:'中大型车',value:'0'},
            {text:'中型车',value:'1'},
            {text:'紧凑型车',value:'2'},
            {text:'小型车',value:'3'},
            {text:'微型车',value:'4'},
             ],
	},
	methods : {
		load : function() {
			$('#dataGrid').bootstrapTable('refresh');
		},
		save : function() {
			dialogOpen({
				title : '新增车辆',
				url : 'base/car/add.html?_' + $.now(),
				width : '500px',
				height : '445px',
				success : function(iframeId) {
					//top.frames[iframeId].vm.area.parentCode = vm.parentCode;
					//top.frames[iframeId].vm.area.parentName = vm.parentName;
				},
				yes : function(iframeId) {
					top.frames[iframeId].vm.acceptClick();
				},
			});
		},
		edit : function() {
			var ck = $('#dataGrid').bootstrapTable('getSelections');
			if (checkedRow(ck)) {
				dialogOpen({
					title : '编辑区域',
					url : 'base/car/edit.html?_' + $.now(),
					width : '500px',
					height : '445px',
					success : function(iframeId) {
						top.frames[iframeId].vm.car.id = ck[0].id;
						top.frames[iframeId].vm.setForm();
					},
					yes : function(iframeId) {
						top.frames[iframeId].vm.acceptClick();
					}
				});
			}
		},
		remove : function() {
			var ck = $('#dataGrid').bootstrapTable('getSelections'), ids = [];
			if (checkedArray(ck)) {
				$.each(ck, function(idx, item) {
					ids[idx] = item.id;
				});
				$.RemoveForm({
					url : '../../sys/car/remove?_' + $.now(),
					param : ids,
					success : function(data) {
						vm.load();
					}
				});
			}
		},
		relativeCustomer:function(){
			var ck = $('#dataGrid').bootstrapTable('getSelections');
			if (checkedRow(ck)) {
				dialogOpen({
					title : '关联车主',
					url : 'base/car/relativeCustomer.html?_' + $.now(),
					width : '1000px',
					height : '650px',
					success : function(iframeId) {
						top.frames[iframeId].vm.carId = ck[0].id;
					},
					yes : function(iframeId) {
						top.frames[iframeId].vm.acceptClick();
					}
				});
			}
		},
	},
	created : function() {
	}
})