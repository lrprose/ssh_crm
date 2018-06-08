//使用ajax加载数据字典,生成select
	//参数1: 数据字典类型 (dict_type_code)
	//参数2: 将下啦选放入的标签id
	//参数3: 生成下拉选时,select标签的name属性值
	//参数4: 需要回显时,选中哪个option
	function loadSelect(typecode,positionId,selectname,selectId) {
		//1.创建select对象，并将name属性指定
		var $select = $("<select name="+selectname+" ></select>");
		//2.添加提示选项
		$select.append("<option value='' >---请选择---</option>");
		//3.调用ajax方法，访问后台action
		$.post(
				"${pageContext.request.contextPath}/BaseDictAction",
				{dict_type_code:typecode},
				function(data) {
					//4.返回json对象，并对其进行遍历
					$.each(data,function(i,json){
						//每次遍历创建一个option对象
						var $option = $("<option value='"+json['dict_id']+"'>"+json["dict_item_name"]+"</option>");
						//判断如果id相同则回显
						if(json['dict_id']==selectId) {
							$option.attr("selected","selected");
						}
						$select.append($option);
					}) ;
					
				},
				"json"
				
		);
		
		//5.将组装好的select对象放入页面
		$("#"+positionId).append($select);
	}