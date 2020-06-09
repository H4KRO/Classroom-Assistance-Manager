package TCP;

import org.json.simple.JSONObject;

public abstract class TCPJsonMessage {
	private String type;
	protected JSONObject data;
	public TCPJsonMessage(String type) {
		this.type = type;
	}
	public JSONObject getData() {
		this.setData();
		this.data.put("type", this.type);
		return this.data;
	}
	public abstract void setData();
}
