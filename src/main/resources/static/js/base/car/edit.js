/**
 * 编辑-行政区域js
 */
var vm = new Vue({
	el:'#main',
	data: {
		car: {
			plateNumber: 0,
			carType: '3',
			age: 0,
			mileage: 0,
			remark:''
		},
		carTypeList:[
		            {text:'中大型车',value:'0'},
		            {text:'中型车',value:'1'},
		            {text:'紧凑型车',value:'2'},
		            {text:'小型车',value:'3'},
		            {text:'微型车',value:'4'},
		             ],
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../sys/car/info?_' + $.now(),
		    	param: vm.car.id,
		    	success: function(data) {
		    		vm.car = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../sys/car/update?_' + $.now(),
		    	param: vm.car,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})