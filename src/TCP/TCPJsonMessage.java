package TCP;

import com.google.gson.Gson;

public class TCPJsonMessage {
	private String type;
	private String data;
	public TCPJsonMessage() {
		this.type = "";
	}
	public TCPJsonMessage(String type) {
		this.type = type;
	}
	public String getData() {
		Gson gson = new Gson();
		this.data = gson.toJson(this);
		return this.data;
	}
	public static TCPJsonMessage toTCPJsonMessage(String data) {
		Gson gson = new Gson();
		return gson.fromJson(data, TCPJsonMessage.class);
	}
	public String getType() {
		return this.type;
	}
}
