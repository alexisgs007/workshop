package utility;

public class constant {

	
	public enum Alexis {
		
		URL("x", "value1"),
		USER("y","value2");
		
		
		private String x,y;
		private Alexis(String x, String y) {
			this.x = x;
			this.y = y;
		}
		public String getX() {
			return x;
		}
		public void setX(String x) {
			this.x = x;
		}
		public String getY() {
			return y;
		}
		public void setY(String y) {
			this.y = y;
		}
		
		
		
	}
	//OrangeHRM Tool
	public static final String URL = "https://opensource-demo.orangehrmlive.com/";
	public static final String Username = "Admin";
	public static final String Password = "admin123";
	
	
	
	//CLM Tool
	public static final String CLM_URL = "http://192.168.212.186:8081/prweb/beEBp4uRVTogorRwSwWqbOtn9IL2fwdI*/!STANDARD ";
	public static final String clm_username = "officer.guardado@rulesware.com";
	public static final String clm_password = "rules";

}
