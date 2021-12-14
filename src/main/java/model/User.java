package model;

import utils.Crypt;

public class User {

	private Integer id;
	private String username, password;
	private Boolean admin;
	private Double coins;
	private Double time;

	public User(Integer id, String username, String password, Double coins, Double time, Boolean admin) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.coins = coins;
		this.time = time;
		this.admin = admin;
	}

	public void addToItinerary(Atraccion atraccion) {
		this.coins -= atraccion.getCosto();
		this.time -= atraccion.getDuracion();
		// TODO agregar a su lista
	}

	public boolean canAfford(Atraccion attraction) {
		return attraction.getCosto() <= this.coins;
	}

	public boolean canAttend(Atraccion attraction) {
		return attraction.getDuracion() <= this.time;
	}

	public boolean checkPassword(String password) {
		// this.password en realidad es el hash del password
		return Crypt.match(password, this.password);
	}

	public Boolean getAdmin() {
		return admin;
	}

	public Double getCoins() {
		return coins;
	}

	public Integer getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public Double getTime() {
		return time;
	}

	public String getUsername() {
		return username;
	}

	public Boolean isAdmin() {
		return admin;
	}

	public boolean isNull() {
		return false;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public void setCoins(Double coins) {
		this.coins = coins;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = Crypt.hash(password);
	}

	public void setTime(Double time) {
		this.time = time;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", admin=" + admin + "]";
	}

}
