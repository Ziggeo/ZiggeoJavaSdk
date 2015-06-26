package com.ziggeo;

public class Ziggeo {
	
	public String token;
	public String private_key;
	public String encryption_key;
	private ZiggeoConfig configObj;
	private ZiggeoConnect connectObj;
	private ZiggeoVideos videosObj = null;
	private ZiggeoStreams streamsObj = null;
	private ZiggeoAuthtokens authtokensObj = null;
	private ZiggeoAuth authObj = null;
	
	public Ziggeo(String token, String private_key, String encryption_key) {
		this.token = token;
		this.private_key = private_key;
		this.encryption_key = encryption_key;
		this.configObj = new ZiggeoConfig();
		this.connectObj = new ZiggeoConnect(this);
	}
	
	public ZiggeoConfig config() {
		return this.configObj;
	}
	
	public ZiggeoConnect connect() {
		return this.connectObj;
	}

	public ZiggeoVideos videos() {
		if (this.videosObj == null)
			this.videosObj = new ZiggeoVideos(this);
		return this.videosObj;
	}
	
	public ZiggeoStreams streams() {
		if (this.streamsObj == null)
			this.streamsObj = new ZiggeoStreams(this);
		return this.streamsObj;
	}
	
	public ZiggeoAuthtokens authtokens() {
		if (this.authtokensObj == null)
			this.authtokensObj = new ZiggeoAuthtokens(this);
		return this.authtokensObj;
	}
	
	public ZiggeoAuth auth() {
		if (this.authObj == null)
			this.authObj = new ZiggeoAuth(this);
		return this.authObj;
	}

}