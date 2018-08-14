/**
 * 客户信息js
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
		url : '../../sys/service/list?_' + $.now(),
		height : $(window).height() - 108,
		queryParams : function(params) {
			params.plateNumber = vm.keyword;
			return params;
		},
		pagination : false,
		columns : [ {
			checkbox : true
		}, {
			field : "id",
			title : "序号",
			width : "50px"
		}, {
			field : "plateNumber",
			title : "车牌",
			width : "100px"
		}, {
			field : "type",
			title : "类型",
			width : "200px",
			formatter:function(value,row,index){
				if(value =='0'){
					return '维修';
				}else if(value == '1'){
					return '保养';
				}
			}
		},{
			field : "date",
			title : "维修日期",
			width : "200px",
		}, {
			field : "cost",
			title : "费用",
			width : "60px",
			align : "center",
		}, {
			field : "mileage",
			title : "里程",
			width : "60px",
			align : "center",
		}, {
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
		}, {
			field : "remark",
			title : "备注"
		} ]
	})
}

var vm = new Vue({
	el : '#main',
	data : {
		keyword : null,
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
				title : '新增保养',
				url : 'base/service/add.html?_' + $.now(),
				width : '1200px',
				height : '800px',
				success : function(iframeId) {
					top.frames[iframeId].vm.setForm();
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
					title : '编辑保养',
					url : 'base/service/edit.html?_' + $.now(),
					width : '1200px',
					height : '800px',
					success : function(iframeId) {
						top.frames[iframeId].vm.serviceEntity.id = ck[0].id;
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
					url : '../../sys/service/remove?_' + $.now(),
					param : ids,
					success : function(data) {
						vm.load();
					}
				});
			}
		}
	},
	created : function() {
	}
})