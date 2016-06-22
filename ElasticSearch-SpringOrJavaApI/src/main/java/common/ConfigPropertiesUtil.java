package common;

import java.io.IOException;
import java.util.Properties;

/***
* @ClassName: ConfigPropertiesUtil 
* @Description: TODO(ConfigProperties配置文件读取工具类) 
* @author Yashiro 
* @date 2016-6-3 上午11:39:33 
*/
public class ConfigPropertiesUtil {

	//配置文件
	private static Properties properties;
	
	//配置文件名称
	private final static String fileName = "/config.properties";
	
	static{
		properties = new Properties();
		try {
			properties.load(ConfigPropertiesUtil.class.getResourceAsStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	//根据properties的Key获取值
	public static String getProperty(String Key){
		String value = properties.getProperty(Key);
		return value;
	}
}
