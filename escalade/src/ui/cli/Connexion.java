package ui.cli;

public class Connexion {
	private String username;
	private String password;
	
	public Connexion(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public boolean verification(String username, String password) {
		if(username.equals(this.username) && password.contentEquals(this.password)) {
			return true;
		}
		else {
			return false;
		}
	}
}
