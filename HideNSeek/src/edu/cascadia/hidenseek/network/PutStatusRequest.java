package edu.cascadia.hidenseek.network;

import org.json.JSONException;

import edu.cascadia.hidenseek.Player;
import edu.cascadia.hidenseek.network.NetworkBase.RequestType;

public abstract class PutStatusRequest extends NetworkRequest {

	public void DoRequest(Player p) {
		Request r = new Request();
		r.url = baseUrl + "players/" + p.GetId() + "/status/";
		r.type = RequestType.PUT;
		try {
			r.jsonArgs = p.StatusToJSON();
		} catch(JSONException e) {
			onException(e);
		}
		doRequest(r);
	}
	
	//To be overwritten
	protected void onComplete() { }
	
	@Override
	protected final void processPostExecute(String s) {
		onComplete();
	}
}