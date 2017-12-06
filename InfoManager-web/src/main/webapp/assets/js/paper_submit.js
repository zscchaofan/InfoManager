 $(document).ready(function () {
   		
   			$('#loading').dialog({
				height:50,
				width:180,
				autoOpen:false,
				modal:true,
				closeOnEscape:false,
				resizable:false,
				
			}).parent().find('.ui-widget-header').hide();
   			
   			//成绩框
   			$("#showScore").dialog({  
                autoOpen:false,  //设置对话框打开的方式 不是自动打开  
                show:"blind",    //打开时的动画效果  
                hide:"explode",    //关闭是的动画效果  
                modal:true,          //true代表运用遮罩效果  
                 buttons:[  
                     {  
                         text:"确定",  
                         click:function (){  
                        	 window.location.href = "examLogout.action"; //回首页
                             $(this).dialog("close");            //关闭对话框  
                         }  
                     }],  
       
                 closeOnEscape:false,    
                 position:"top",  //对话框打开的位置，默认center，有top、left、right、center、bottom  
                 width:500,      //设置对话框的宽度  
                 height:300,     //设置对话框的高度  
                 resizable:false,//是否可以改变对话框的尺寸的操作，默认true           
                 zIndex:1000
                  
             }).parent().find('.ui-widget-header').hide();  
   		

   		 var options = {
   		   	 	url:'submitPaper.action',
   				type:'POST',
   			   	beforeSend:function(){
   					$('#loading').dialog('open');
   					$('#loading').css('background','url(images/loading.gif) no-repeat 20px center').html("提交试卷中...");
   				},
   		        success: function (score,textStatus) {
   		        //alert(data);
   		           if(score!=-1){
   					
   					$('#loading').css('background','url(images/success.gif) no-repeat 20px center').html("成功提交试卷...");
   					setTimeout(function(){
   						$('#loading').dialog('close'); 
   						$('#loading').css('background','url(images/loading.gif) no-repeat 20px center').html("提交试卷中..");
   						
   					},1000);
   					
   					setTimeout(function(){
   						var usetime = useTime();  //用时
   						var myScore = "<h2>我的成绩</h2>";
   						myScore += "<ul>";
   						myScore += "<li><b>姓名：</b>"+$("#s_name").html()+"</li>";
   						myScore += "<li><b>学号：</b>"+$("#s_id").html()+"</li>";
   						myScore += "<li><b>成绩：</b>"+score+"</li>";
   						myScore += "<li><b>用时：</b>"+usetime+"</li>";
   						
   						var level = score/$("#p_total").html();
   						if(level<0.6){
   							myScore += "<p><img src='images/g4.png' /> <span> 不忍直视,赶紧恶补一下吧!</span></p>";
   						}else if(level>=0.6 && level< 0.75){
   							myScore += "<p><img src='images/g3.png' /> <span> 很危险,要继续努力呀!</span></p>";
   						}else if(level>=0.75 && level< 0.9){
   							myScore += "<p><img src='images/g2.png' /> <span> 一般一般,世界第三!</span></p>";
   						}else if(level>=0.9){
   							myScore += "<p><img src='images/g1.png' /> <span> 简直超神啦,继续保持哦!</span></p>";
   						}		
   						myScore += "</ul>";
   						$("#showScore").html(myScore);
	   			   		$("#showScore").dialog("open"); 
	   			 
   						
   					},1000);
   					
   				}else{
   					$('#loading').css('background','url(images/error.png) no-repeat 20px center').html("试卷提交失败...");
   					setTimeout(function(){
   						$('#loading').dialog('close'); 
   						$('#loading').css('background','url(images/loading.gif) no-repeat 20px center').html("提交试卷中..");
   						
   					},1000);
   			  }
	      	},
	      	//clearForm: true
	     
	     };
    

		$(".btn").click(function(){
			$("html, body").scrollTop(0); //回顶部
		
			
			//检测是否做完题目
   			if(!confirm("请检查题目是否已做完！确定提交试卷么？")){
				
   				return false; 
			 }
			
			 var fm = $("#submitPaperForm");
			 fm.ajaxSubmit(options);
			 return false;
		});
   
   		
//计算用时 
function useTime(){
			var lastTime = $('#lastTime').html();
			var totalTime = $('#p_time').html()*60;
			var intDiff = totalTime-lastTime;
		 var day=0,hour=0,minute=0,second=0;//时间默认值		
		 if(intDiff > 0){
			hour = Math.floor(intDiff / (60 * 60)) - (day * 24);
			minute = Math.floor(intDiff / 60) - (day * 24 * 60) - (hour * 60);
			second = Math.floor(intDiff) - (day * 24 * 60 * 60) - (hour * 60 * 60) - (minute * 60);
		  } 
		 
		 if (minute <= 9) minute = '0' + minute;
		 if (second <= 9) second = '0' + second;
		 
		 return hour+" 小时  "+minute+" 分钟 "+second+" 秒 ";
		}

});
 
 
 