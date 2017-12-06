package cn.cclookme.info.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataMsg {
	
	public static String getNowYear(){
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy");
		String year = simpleDateFormat.format(new Date());
		return year;
	}
	
	public static String getNowDate(){
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
		String time = simpleDateFormat.format(new Date());
		return time;
	}
	
	public static void main(String[] args) {
		System.out.println(DataMsg.getNowDate());
	}
	
}
