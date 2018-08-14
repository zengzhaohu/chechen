/**
 * 新增-车辆js
 */
var vm = new Vue({
	el:'#main',
	data: {
		car: {
			plateNumber: "桂B",
			carType: '3',
			age: 0,
			mileage: 0
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
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../sys/car/save?_' + $.now(),
		    	param: vm.car,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
