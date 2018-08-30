package br.com.flexvision.ocrrsa;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("rsa")
public class Rsa {
	
	@Id
	private String id;
	
	private String passcode;

	public Rsa(String id, String passcode) {
		super();
		this.id = id;
		this.passcode = passcode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasscode() {
		return passcode;
	}

	public void setPasscode(String passcode) {
		this.passcode = passcode;
	}

	@Override
	public String toString() {
		return "{id=" + id + ", passcode=" + passcode + "}";
	}
	
}
