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
			params.name = vm.keyword;
			params.parentCode = vm.parentCode;
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
		}, {
			field : "province",
			title : "省份",
			width : "60px",
			align : "center",
		}, {
			field : "city",
			title : "城市",
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
		carId:'',
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
		acceptClick:function(){
			console.log(vm.carId);
			var ck = $('#dataGrid').bootstrapTable('getSelections');
			if (checkedRow(ck)) {
				var customerId = ck[0].id;
				var params = {
						'carId':vm.carId,
						'customerId':customerId
				};
				$.ConfirmForm({
					url:'../../sys/car/relativeCustomer?_'+$.now(),
					param:params,
					success:function(data){
						$.currentIframe().vm.load();
					}
				});
			}

		},
		edit : function() {
			var ck = $('#dataGrid').bootstrapTable('getSelections');
			if (checkedRow(ck)) {
				dialogOpen({
					title : '编辑区域',
					url : 'base/customer/edit.html?_' + $.now(),
					width : '500px',
					height : '445px',
					success : function(iframeId) {
						top.frames[iframeId].vm.customer.id = ck[0].id;
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