package com.hzh.hzhdeno.common.util;

import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StringUtil extends StringUtils {
	private static Random random = new Random();
	
	/**
	 * 获取web项目路径
	 * @return
	 */
	public static String getWebAppPath(){
		String path = StringUtil.class.getProtectionDomain().getCodeSource().getLocation()
				.getFile().replace("\\", "/");
		if(path.indexOf("/WEB-INF")>=0){
			path = path.substring(0, path.indexOf("/WEB-INF"))+"/WEB-INF/";
		}
		if(!path.endsWith("/")){
			path = path.substring(0, path.lastIndexOf("/")+1);
		}
		try{
			path = URLDecoder.decode(path, "utf-8");
		}catch (Exception e) {
		}
		return path;
	}
	
	public static String getAppPath() {
		String path = System.getProperty("user.dir");
		if(!path.endsWith(File.separator)){
			path = path+File.separator;
		}
		return path;
	}
	
	public static String getWebAppPath(String relPath) {
		if(isEmpty(relPath)){
			return getWebAppPath();
		}
		relPath = relPath.replace("/", File.separator).replace("\\", File.separator);
		String path = getWebAppPath();
		path = path+relPath;
		return path;
	}
	
	public static String getAppPath(String relPath) {
		if(isEmpty(relPath)){
			return getAppPath();
		}
		relPath = relPath.replace("/", File.separator).replace("\\", File.separator);
		String path = getAppPath();
		if(relPath.indexOf("config")<0 && (path.toLowerCase().indexOf("workspace")>=0||path.toLowerCase().indexOf("eclipse")>=0)){
			File file = new File("E:/Java");
			if(file.exists()){
				path = "E:/Java/导出程序/".replace("/", File.separator);
			}
		}
		path = path+relPath;
		return path;
	}
	
	public static String trim(String str){
		return isEmpty(str)?null:str.trim();
	}
	public static boolean isEmpty(String str){
		return str==null || str.trim().length()==0;
	}
	public static boolean isNotEmpty(String str){
		str = trim(str);
		return str!=null && str.length()>0;
	}
	public static int parseIntByObj(Object obj){
		if(obj==null){
			return 0;
		}
		if (obj instanceof Number) {
			return ((Number) obj).intValue();
		}else{
			return parseInt(obj.toString(), 0);
		}
	}
	public static int parseInt(String str){
		return parseInt(str, 0);
	}
	
	public static double parseDouble(String str){
		return parseDouble(str, 0);
	}
	
	public static int parseInt(String str, int defaultValue){
		try{
			return Integer.parseInt(trim(str));
		}catch (Exception e) {
			return defaultValue;
		}
	}
	
	public static long parseLong(String str){
		return parseLong(str, 0l);
	}
	public static long parseLong(String str, long defaultValue){
		try{
			return Long.parseLong(trim(str));
		}catch (Exception e) {
			return defaultValue;
		}
	}
	
	public static float parseFloat(String str, float defaultValue){
		try{
			return Float.parseFloat(trim(str));
		}catch (Exception e) {
			return defaultValue;
		}
	}
	
	public static double parseDouble(String str, double defaultValue){
		try{
			return Double.parseDouble(trim(str));
		}catch (Exception e) {
			return defaultValue;
		}
	}
	
	public static boolean parseBoolean(String str){
		str = trim(str);
		return "true".equalsIgnoreCase(str) || "1".equalsIgnoreCase(str);
	}
	
	public static boolean toBoolean(int type){
		return type-1==1;
	}
	
	public static int getRandomInteger(int max) {
		return random.nextInt(max);
	}
	
	public static String getRandomString(int length) {
		String baseStr = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			sb.append(baseStr.charAt(random.nextInt(baseStr.length())));
		}
		return sb.toString();
	}
	
	public static String getRandomString(int length, String baseStr) {
		if(isEmpty(baseStr)){
			return getRandomString(length);
		}
		if("number".equalsIgnoreCase(baseStr)){
			baseStr = "0123456789";
		}else if("lowercase".equalsIgnoreCase(baseStr)){
			baseStr = "abcdefghijklmnopqrstuvwxyz";
		}else if("uppercase".equalsIgnoreCase(baseStr)){
			baseStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			sb.append(baseStr.charAt(random.nextInt(baseStr.length())));
		}
		return sb.toString();
	}
	
	public static String toFieldString(String str){
		if(str==null){
			return null;
		}else{
			return "'"+str.replace("\\'", "'").replace("'", "\\'") + "'";
		}
	}
	
	public static String toLikeStr(String str){
		if(isEmpty(str)){
			return "%%";
		}else{
			return "%"+str.trim()+"%";
		}
	}
	public static String toLLikeStr(String str){
		if(isEmpty(str)){
			return "%%";
		}else{
			return "%"+str.trim();
		}
	}
	public static String toRLikeStr(String str){
		if(isEmpty(str)){
			return "%%";
		}else{
			return str.trim()+"%";
		}
	}

	
	public static String formatNumber(double number, String format){
		DecimalFormat df = new DecimalFormat(format);
		return df.format(number);
	}
	
	/**
	 * 转化为两位数的货币数值
	 * 如number=11.2345,结果为11.23
	 * @param number
	 * @return
	 */
	public static String formatMoney(double number){
		DecimalFormat df = new DecimalFormat("#0.00");
		return df.format(number);
	}
	
	/**
	 * 转化为两位数的货币数值，数值前加上货币符号
	 * 如number=11.2345,currency=￥时，结果为￥11.23
	 * @param number
	 * @param currency 货币符号
	 * @return
	 */
	public static String formatMoney(double number, String currency){
		DecimalFormat df = new DecimalFormat(currency+"#0.00");
		return df.format(number);
	}
	
	/**
	 * 保留8位数数字
	 * @param number
	 * @return
	 */
	public static String format8Decimal(double number){
		DecimalFormat df = new DecimalFormat("#.########");
		return df.format(number);
	}
	
	public static String encodeStr(String str){
		if(str==null){
			return str;
		}
		try{
			return URLEncoder.encode(str, "utf-8");
		}catch (Exception e) {
			return str;
		}
	}
	
	public static String decodeStr(String str){
		if(str==null){
			return str;
		}
		try{
			return URLDecoder.decode(str, "utf-8");
		}catch (Exception e) {
			return str;
		}
	}
	
	public static String trimAndHtmlEscape(String str){
		if(str==null||"".equals(str)){
			return null;
		}
		return htmlEscape(str.trim());
	}
	
	public static String htmlEscape(String str){
		if(str==null||str.length()==0){
			return null;
		}
		return str.replace("&", "&amp;")
				.replace("<", "&lt;")
				.replace(">", "&gt;")
				.replace("\"", "&quot;")
				.replace("'", "&apos;");
	}
	public static String htmlUnescape(String str){
		if(str==null||str.length()==0){
			return null;
		}
		return str.replace("&amp;", "&")
				.replace("&lt;", "<")
				.replace("&gt;", ">")
				.replace("&quot;", "\"")
				.replace("&apos;", "'");
	}
	public static String[] filterEmpty(String[] array){
		if(array==null){
			return null;
		}
		List<String> list = new ArrayList<String>(array.length);
		for(int i=0;i<array.length; i++){
			String str = trim(array[i]);
			if(isNotEmpty(str)){
				list.add(str);
			}
		}
		if(list.size()<=0){
			return null;
		}
		return list.toArray(new String[]{});
	}
	
	public static String[] trim(String[] array){
		if(array==null){
			return null;
		}
		for(int i=0;i<array.length; i++){
			array[i] = trim(array[i]);
		}
		return array;
	}
	public static String[] trimAndHtmlEscape(String[] array){
		if(array==null){
			return null;
		}
		for(int i=0;i<array.length; i++){
			array[i] = trimAndHtmlEscape(array[i]);
		}
		return array;
	}
	
	/**
	 * string 转换成 BigDecimal
	 */
	public static BigDecimal parseBigDecimal(String str){
		if(StringUtil.isEmpty(str)){
			str = "0";
		}
		BigDecimal bd=new BigDecimal(str.trim());   
		bd=bd.setScale(2, BigDecimal.ROUND_HALF_UP); 
		return bd;
	}
	
	/**
	 * 把中间字符替换成*号
	 * @param str
	 * @return
	 */
	public static String replaceStar(String str){
		if(str==null){
			return null;
		}else if(str.length()<4){
			return str;
		}else if(str.length()<=10){
			StringBuilder newStr = new StringBuilder();
			int pos = str.length()-4;
			for(int i=0;i<pos;i++){
				newStr.append("*");
			}
			newStr.append(str.substring(pos));
			return newStr.toString();
		}else{
			int pos1 = 3;
			StringBuilder newStr = new StringBuilder(str.substring(0, pos1));
			int pos2 = str.length()-4;
			for(int i=pos1;i<pos2;i++){
				newStr.append("*");
			}
			newStr.append(str.substring(pos2));
			return newStr.toString();
		}
	}
	
	public static int[] parseIntArray(String[] array){
		if(array==null){
			return null;
		}
		int[] value = new int[array.length];
		for(int i=0;i<array.length; i++){
			value[i] = parseInt(array[i]);
		}
		return value;
	}
	
	public static String[] getStringArray(HttpServletRequest request, String paramName){
		if(paramName==null){
			return null;
		}
		String paramName1 = paramName.replace("[]", "");
		String paramName2 = paramName1+"[]";
		String[] strArray = request.getParameterValues(paramName2);
		if(strArray==null||strArray.length<=0){
			strArray = request.getParameterValues(paramName1);
			if(strArray==null||strArray.length<=0){
				strArray = new String[]{request.getParameter(paramName1)};
			}
		}
		return strArray;
	}
	
	public static int[] getIntArray(HttpServletRequest request, String paramName){
		String[] strArray = getStringArray(request, paramName);
		return parseIntArray(strArray);
	}

	public static String parseNull(Object str){
		if(StringUtil.isEmpty(str)){
			return "";
		}else{
			return str.toString();
		}
	}

}
