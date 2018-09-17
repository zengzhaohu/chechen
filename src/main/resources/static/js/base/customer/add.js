/**
 * 新增-车辆js
 */



var vm = new Vue({
	el:'#main',
	data: {
		customer: {
			userName: '',
			phone:'',
			gender:'',
			address:'',
			remark:''
		},
		genderList:[
		            {text:'女',value:'0'},
		            {text:'男',value:'1'},
		             ],
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
			var province = $("#province").find("option:selected").text();
			var city = $("#city").find("option:selected").text();
			var county = $("#county").find("option:selected").text();
			if(isNullOrEmpty(province)||isNullOrEmpty(city) ||isNullOrEmpty(county)){
				dialogAlert("请选择地址");
				return;
			}
			vm.customer.address=province+"-"+city+"-"+county;
		    $.SaveForm({
		    	url: '../../sys/customer/save?_' + $.now(),
		    	param: vm.customer,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	},
	created:function(){
		$("#distpicker").distpicker({
			province:'广西壮族自治区',
			city:'柳州市',
			district:'柳江区'
		});
	}
})
