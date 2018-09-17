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
		url : '../../sys/customer/list?_' + $.now(),
		height : $(window).height() - 108,
		queryParams : function(params) {
			params.userName = vm.keyword;
			return params;
		},
		columns : [ {
			checkbox : true
		}, {
			field : "id",
			title : "序号",
			width : "50px"
		}, {
			field : "userName",
			title : "客户名",
			width : "100px"
		}, {
			field : "phone",
			title : "电话",
			width : "200px",
		}, {
			field : "gender",
			title : "性别",
			width : "60px",
			formatter:function(value,row,index){
				if(value=='0'){
					return '女';
				}else
				if(value=='1'){
					return '男';
				}
			}
		}, {
			field : "address",
			title : "地址",
			width : "250px",
			align : "center",
		}, {
			field : "remark",
			title : "备注"
		} ]
	})
}

var setting = {
	async : {
		enable: true,
		type: "get",
		url: "../../sys/area/select",
		autoParam: ["areaCode"]
	},
	data : {
		simpleData : {
			enable : true,
			idKey : "areaCode",
			pIdKey : "parentCode",
			rootPId : "0"
		},
		key : {
			url : "nourl"
		}
	},
	callback : {
		onClick : function(event, treeId, treeNode) {
			vm.parentCode = treeNode.areaCode;
			vm.parentName = treeNode.name;
			vm.load();
		}
	}
};
var ztree;

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
				title : '新增客户',
				url : 'base/customer/add.html?_' + $.now(),
				width : '800px',
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
					url : 'base/customer/edit.html?_' + $.now(),
					width : '800px',
					height : '445px',
					success : function(iframeId) {
						top.frames[iframeId].vm.customer.id = ck[0].id;
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
					url : '../../sys/customer/remove?_' + $.now(),
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