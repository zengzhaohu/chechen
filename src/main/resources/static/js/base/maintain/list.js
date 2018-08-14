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
		url : '../../sys/maintain/list?_' + $.now(),
		height : $(window).height() - 108,
		queryParams : function(params) {
			params.plateNumber = vm.keyword;
			params.status = vm.status;
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
			width : "50px",
			formatter:function(value,row,index){
				if(value =='0'){
					return '维修';
				}else if(value == '1'){
					return '保养';
				}
			}
		},{
			field : "date",
			title : "日期",
			width : "100px",
		}, {
			field : "nextDate",
			title : "下次保养日期",
			width : "100px",
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
		},{
			field : "status",
			title : "状态",
			width : "100px",
			formatter:function(value,row,index){
				if(value ==0){
					return '保养中';
				}else if(value == 1){
					return '<span class="label label-danger">保养即将到期</span>';
				}else if(value == 2){
					return '已通知客户';
				}
			}
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
		status:'',
		parentCode : '0',
		parentName : null,
		carTypeList:[
            {text:'中大型车',value:'0'},
            {text:'中型车',value:'1'},
            {text:'紧凑型车',value:'2'},
            {text:'小型车',value:'3'},
            {text:'微型车',value:'4'},
             ],
             statusList:maintainStatusList,
	},
	methods : {
		load : function() {
			$('#dataGrid').bootstrapTable('refresh');
		},
		save : function() {
			dialogOpen({
				title : '新增维修',
				url : 'base/maintain/add.html?_' + $.now(),
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
					title : '编辑维修',
					url : 'base/maintain/edit.html?_' + $.now(),
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
					url : '../../sys/maintain/remove?_' + $.now(),
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