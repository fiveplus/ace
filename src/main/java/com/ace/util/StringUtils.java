package com.ace.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 字符串帮助类
 * @author hack
 *
 */
public class StringUtils {
	public static final String DATE_FORMAT="yyyy-MM-dd HH:mm:ss";
	public static Date getStringToDate(String date){
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
			return sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static long getLongByString(String date){
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date d = sdf.parse(date);
			long time = getDateToLong(d);
			return time;
		}catch(Exception e){
			return 0;
		}
	}
	public static String getLongToString(long time){
		try{
			Date d = getLongToDate(time);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			return sdf.format(d);
		}catch(Exception e){
			return "";
		}
	}
	
	public static String getDatetToString(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		return sdf.format(date);
	}
	
	public static String getDateToSmallString(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.format(date);
	}
	public static String getDateToSmallString(long time){
		Date d = getLongToDate(time);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.format(d);
	}
	
	
	public static long getDateToLong(Date date){
		return date.getTime();
	}
	public static Date getLongToDate(long time){
		return new Date(time);
	}
	/**
	 * 格式转换
	 * @param temp DatePicker 传输数据格式 [dd/MM/yyyy - dd/MM/yyyy)
	 * @return beforeTime and afterTime;
	 */
	public static Map<String,Long> getBetweenTime(String temp){
		String before = temp.split("-")[0].trim();
		String after = temp.split("-")[1].trim();
		Map<String, Long> map = new HashMap<String, Long>();
		map.put("beforeTime", getLongByString(before+" 00:00:00","MM/dd/yyyy HH:mm:ss"));
		map.put("afterTime", getLongByString(after+" 23:59:59","MM/dd/yyyy HH:mm:ss"));
		return map;
	}
	
	public static long getLongByString(String date,String format){
		try{
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			Date d = sdf.parse(date);
			long time = getDateToLong(d);
			return time;
		}catch(Exception e){
			return 0;
		}
	}
	/*
	public static void main(String[] args) {
		//long time = getLongByString("2016-12-31 23:59:59","yyyy-MM-dd HH:mm:ss");
		//System.out.println(time);
	}*/
}
