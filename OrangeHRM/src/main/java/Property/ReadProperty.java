package Property;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.Properties;

import Project_Constant.Project_Path;

public class ReadProperty {


	private static Properties propFile;
	private static FileInputStream file;
	private static final Map<String, String> CONFIGMAP = new HashMap<>();;

	public static String setProperty(String key) throws Throwable {
		return CONFIGMAP.get(key);
	}
	
	static {

		try {
			file = new FileInputStream(Project_Path.getConfigFile());
			propFile = new Properties();
			propFile.load(file);
			for(Object kay : propFile.keySet()) {
				CONFIGMAP.put(String.valueOf(kay), String.valueOf(propFile.get(kay)));	
			}
		} catch (IOException e) {

			e.printStackTrace();
		}





	}







}
