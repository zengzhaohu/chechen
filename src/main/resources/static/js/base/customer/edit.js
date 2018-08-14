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
			province:'',
			city:'',
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
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../sys/customer/update?_' + $.now(),
		    	param: vm.customer,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})