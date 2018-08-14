/**
 * 新增-车辆js
 */
var vm = new Vue({
	el:'#main',
	data: {
		serviceEntity: {
			carId: '',
			type:'0',
			date:'',
			cost:0.0,
			mileage:0,
			remark:'',
			serviceCostList:[{
	        	name:'',
	        	price:0.0,
	        }],
	        materialCostList:[
  			{
  				name:'',
  				price:0.0,
  			}],
  			otherCostList:[
     		{
     			name:'',
     			price:0.0,
     		}],
		},
        carList:[],
        serviceType:[
            {'value':'0',text:'维修'},
            {'value':'1',text:'保养'},
            ],
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../sys/car/list?_' + $.now(),
		    	param: {},
		    	success: function(data) {
		    		vm.carList = data;
		    	}
			});
		},
		calculateCost:function(){
			this.serviceEntity.cost=0.0;
			for(var i=0;i<this.serviceEntity.serviceCostList.length;i++){
				if(this.serviceEntity.serviceCostList[i].price.trim() == ''){
					continue;
				}
				var price = parseFloat(this.serviceEntity.serviceCostList[i].price);
				this.serviceEntity.cost+=price;
			}
			for(var i=0;i<this.serviceEntity.materialCostList.length;i++){
				if(this.serviceEntity.materialCostList[i].price.trim() == ''){
					continue;
				}
				this.serviceEntity.cost+=parseFloat(this.serviceEntity.materialCostList[i].price);
			}
			for(var i=0;i<this.serviceEntity.otherCostList.length;i++){
				if(this.serviceEntity.otherCostList[i].price.trim() == ''){
					continue;
				}
				this.serviceEntity.cost+=parseFloat(this.serviceEntity.otherCostList[i].price);
			}
			console.log(this.serviceEntity.cost);
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../sys/service/save?_' + $.now(),
		    	param: vm.serviceEntity,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		},
		addServiceCost:function(){
			this.serviceEntity.serviceCostList.push({
				name:'',
				price:0.0,
			});
		},
		removeServiceCost:function(index){
			if(index == 0){
				return;
			}
			this.serviceEntity.serviceCostList.splice(index,1);
		},
		addMaterialCost:function(){
			this.serviceEntity.materialCostList.push({
				name:'',
				price:0.0,
			});
		},
		removeMaterialCost:function(index){
			if(index == 0){
				return;
			}
			this.serviceEntity.materialCostList.splice(index,1);
		},
		addOtherCost:function(){
			this.serviceEntity.otherCostList.push({
				name:'',
				price:0.0,
			});
		},
		removeOtherCost:function(index){
			if(index == 0){
				return;
			}
			this.serviceEntity.otherCostList.splice(index,1);
		},
	}
})
