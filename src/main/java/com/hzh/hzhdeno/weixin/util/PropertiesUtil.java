package com.hzh.hzhdeno.weixin.util;





import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PropertiesUtil {
	private static Properties properties = null;
	private static Logger logger = Logger.getLogger(PropertiesUtil.class);
	private static final String file = "/commons-config.properties";
	/**
	 * 读取配置文件信息

	 *            配置文件路径名称，相对于/WEB-INF/classes
	 * @return 
	 */
	private static void loadProperties(){
		URL resource = PropertiesUtil.class.getClassLoader().getResource(file);
		InputStream input = null;
		try {
			input = resource.openStream();
			properties = new Properties();
			properties.load(input);
		} catch (FileNotFoundException e) {
			logger.error("找不到配置文件：" + file);
		} catch (IOException e) {
			logger.error("读取配置文件时出错：" + file);
		}catch(Exception e){
			logger.error("加载配置文件其他未知错误：" + e.getMessage());
		} finally {
			try {
				if (input != null) {
					input.close();
				}
			} catch (Exception e) {
				logger.error("关闭配置文件：" + file + " 时出错！");
			}
		}
	}
	
	/**
	 * 读取配置文件信息
	 * 
	 * @param fileName
	 *            配置文件路径名称，相对于/WEB-INF/classes
	 * @return Properties
	 */
	public static Properties loadProperties(String fileName){
		URL resource = PropertiesUtil.class.getClassLoader().getResource(fileName);
		InputStream input = null;
		try {
			if(resource==null){
				return null;
			}
			input = resource.openStream();
			Properties properties = new Properties();
			properties.load(input);
			return properties;
		} catch (FileNotFoundException e) {
			logger.error("找不到配置文件：" + fileName);
		} catch (IOException e) {
			logger.error("读取配置文件时出错：" + fileName);
		} catch(Exception e){
			logger.error("加载配置文件其他未知错误：" + e.getMessage());
		} finally {
			try {
				if (input != null) {
					input.close();
				}
			} catch (Exception e) {
				logger.error("关闭配置文件：" + fileName + " 时出错！");
			}
		}
		return null;
	}
	
	public static String getProperty(String key){
		if(properties==null){
			loadProperties();
		}
		return properties==null ? null : properties.getProperty(key);
	}
	
	
	public static void refresh(){
		loadProperties();
	}
	
	public static void setProperty(String key, String value){
		if(properties==null){
			loadProperties();
		}
		if(properties==null){
			return;
		}
		properties.setProperty(key, value);
	}
	
	public static void setPropertyToFile(String key, String value){
		if(properties==null){
			loadProperties();
		}
		if(properties==null){
			return;
		}
		properties.setProperty(key, value);
		FileOutputStream out = null;
		try {
			URL resource = PropertiesUtil.class.getClassLoader().getResource(file);
			out = new FileOutputStream(resource.getPath());
			properties.store(out, null);
		} catch (FileNotFoundException e) {
			logger.error("找不到配置文件：" + file);
		} catch (IOException e) {
			logger.error("设置配置文件时出错：" + file);
		} finally{
			if(out!=null){
				try {
					out.close();
				} catch (IOException e) {
					logger.error("关闭配置文件：" + file + " 时出错！");
				}
			}
		}
	}
}
