package ovh.mariage.model;

public class User {

	private int id;
	private String name;
	private String code;
	private String type = "M";
	private String lang = "fr";
	private boolean solo = false;
	
	public User() {
	}
	
	public User(String name, String code, String type, String lang, boolean solo) {
		super();
		this.name = name;
		this.code = code;
		this.type = type;
		this.lang = lang;
		this.solo = solo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public boolean isSolo() {
		return solo;
	}
	public void setSolo(boolean solo) {
		this.solo = solo;
	}
	
	
	
}
