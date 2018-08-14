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
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../sys/customer/save?_' + $.now(),
		    	param: vm.customer,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
