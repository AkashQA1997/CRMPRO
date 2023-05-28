package Project_Constant;

public final class Project_Path {

	private Project_Path() {
	}
	private static String COMMONPATH = ".\\src\\main\\resources";
	private static final String ConfigFile = COMMONPATH +".\\Configaration_File\\Config.properties";
	public static String getConfigFile() {
		return ConfigFile;
	}
}
