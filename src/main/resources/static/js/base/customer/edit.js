/**
 * 编辑-行政区域js
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
		setForm: function() {
			$.SetForm({
				url: '../../sys/customer/info?_' + $.now(),
		    	param: vm.customer.id,
		    	success: function(data) {
		    		vm.customer = data;
		    		var items = vm.customer.address.split('-');
		    		$("#distpicker").distpicker({
		    			province:items[0],
		    			city:items[1],
		    			district:items[2]
		    		});
		    	}
			});
		},
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
		    $.ConfirmForm({
		    	url: '../../sys/customer/update?_' + $.now(),
		    	param: vm.customer,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	},
	created:function(){
		
	}
})