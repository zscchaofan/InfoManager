 $(document).ready(function () {
   		
   			$('#loading').dialog({
				height:50,
				width:180,
				autoOpen:false,
				modal:true,
				closeOnEscape:false,
				resizable:false,
				
			}).parent().find('.ui-widget-header').hide();
   		
   		

   		 var options = {
   		   	 	url:'question-save.action',
   				type:'POST',
   		      	restForm:true,
   			   	beforeSend:function(){
   			   		
   					$('#loading').dialog('open');
   					$('#loading').css('background','url(images/loading.gif) no-repeat 20px center').html("数据交互中...");
   				},
   		        success: function (data,textStatus) {
   		        //alert(data);
   		           if(data=="success"){
   					
   					$('#loading').css('background','url(images/success.gif) no-repeat 20px center').html("试题添加成功...");
   					setTimeout(function(){
   						$('#loading').dialog('close'); 
   						$('#loading').css('background','url(images/loading.gif) no-repeat 20px center').html("数据交互中...");
   						
   					},1000);
   					
   					//清空form
   					$("input[name=option]").val("");
   					$("textarea[name=content]").val("");
   					$("textarea[name=answer_info]").val("");
   					
   				}else if(data=="error"){
   					$('#loading').css('background','url(images/error.png) no-repeat 20px center').html("试题添加失败...");
   					setTimeout(function(){
   						$('#loading').dialog('close'); 
   						$('#loading').css('background','url(images/loading.gif) no-repeat 20px center').html("数据交互中...");
   						
   					},1000);
   			  }else{
				$('#loading').dialog('close');
				alert("添加失败,请按要求填写数据!");
   				}
	      	}
	     
	     };
    

   			$(".btn").click(function(){
   				
   			     
   			      
   			     if($.trim($("textarea[name=content]").val()).length == 0 ){
   			    	 $("#contentError").html("题干不能为空!");
   			    	 return false;
   			     }
   			     
		    	 if($.trim($("input[name=option]")[0].value).length==0){
		    		$("#answerError").html("答案A选项不能为空!");
  			    	 return false;
		    	  }
		    	if($.trim($("input[name=option]")[1].value).length==0){
		    		$("#answerError").html("答案B选项不能为空!");
  			    	 return false;
		    	  }
		    	if($.trim($("input[name=option]")[2].value).length==0){
		    		$("#answerError").html("答案C选项不能为空!");
  			    	 return false;
		    	  }
		    	if($.trim($("input[name=option]")[3].value).length==0){
		    		$("#answerError").html("答案D选项不能为空!");
  			    	 return false;
		    	  }

   			      
   			     var fm = $("#questionSaveForm");
   				 fm.ajaxSubmit(options);
   				 return false;
   			});
   
   		
   		});