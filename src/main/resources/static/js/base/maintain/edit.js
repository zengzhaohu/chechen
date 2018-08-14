/**
 * 编辑-行政区域js
 */
var vm = new Vue({
	el:'#main',
	data: {
		serviceEntity: {
			carId: '',
			date:'',
			type:'1',
			nextDate:'',
			cost:0.00,
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
     		removeServiceCostIDList:[],
     		removeMaterialCostIDList:[],
     		removeOtherCostIDList:[],
		},
        carList:[],
        serviceType:[
         {'value':'0',text:'维修'},
         {'value':'1',text:'保养'},
         ],
         statusList:maintainStatusList,
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
			$.SetForm({
				url: '../../sys/maintain/info?_' + $.now(),
		    	param: vm.serviceEntity.id,
		    	success: function(data) {
		    		vm.serviceEntity = data;
		    		vm.initCost(vm.serviceEntity);
		    	}
			});
		},
		initCost:function(serviceEntity){
			if(serviceEntity.serviceCostList.length == 0){
				serviceEntity.serviceCostList.push({
					name:'',
		        	price:0.0,
				});
			}
			if(serviceEntity.materialCostList.length == 0){
				serviceEntity.materialCostList.push({
					name:'',
		        	price:0.0,
				});
			}
			if(serviceEntity.otherCostList.length == 0){
				serviceEntity.otherCostList.push({
					name:'',
		        	price:0.0,
				});
			}
		},
		calculateCost:function(){
			this.serviceEntity.cost=0.0;
			for(var i=0;i<this.serviceEntity.serviceCostList.length;i++){
				if(this.serviceEntity.serviceCostList[i].price &&(this.serviceEntity.serviceCostList[i].price+"").trim()!==''){
					var price = parseFloat(this.serviceEntity.serviceCostList[i].price);
					this.serviceEntity.cost+=price;
				}
			}
			for(var i=0;i<this.serviceEntity.materialCostList.length;i++){
				if(this.serviceEntity.materialCostList[i].price &&(this.serviceEntity.materialCostList[i].price+"").trim()!==''){
					this.serviceEntity.cost+=parseFloat(this.serviceEntity.materialCostList[i].price);
				}
				
			}
			for(var i=0;i<this.serviceEntity.otherCostList.length;i++){
				if(this.serviceEntity.otherCostList[i].price &&(this.serviceEntity.otherCostList[i].price+"").trim()!==''){
					this.serviceEntity.cost+=parseFloat(this.serviceEntity.otherCostList[i].price);
				}
			}
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
			if(this.serviceEntity.serviceCostList[index].id){
				this.serviceEntity.removeServiceCostIDList.push(this.serviceEntity.serviceCostList[index].id);
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
			if(this.serviceEntity.materialCostList[index].id){
				this.serviceEntity.removeMaterialCostIDList.push(this.serviceEntity.materialCostList[index].id);
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
			if(this.serviceEntity.otherCostList[index].id){
				this.serviceEntity.removeOtherCostIDList.push(this.serviceEntity.otherCostList[index].id);
			}
			this.serviceEntity.otherCostList.splice(index,1);
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
			if(vm.serviceEntity.serviceCostList.length == 1 && vm.serviceEntity.serviceCostList[0].name == ''){
				vm.serviceEntity.serviceCostList.splice(0,1);
			}
			if(vm.serviceEntity.materialCostList.length == 1 && vm.serviceEntity.materialCostList[0].name == ''){
				vm.serviceEntity.materialCostList.splice(0,1);
			}
			if(vm.serviceEntity.otherCostList.length == 1 && vm.serviceEntity.otherCostList[0].name == ''){
				vm.serviceEntity.otherCostList.splice(0,1);
			}
		    $.ConfirmForm({
		    	url: '../../sys/maintain/update?_' + $.now(),
		    	param: vm.serviceEntity,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		},
	},
	created:function(){
		
	}
})