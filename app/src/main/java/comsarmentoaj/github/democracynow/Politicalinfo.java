package comsarmentoaj.github.democracynow;

import android.app.Application;

import org.json.JSONObject;

/**
 * Created by devin_000 on 7/29/2017.
 */

public class Politicalinfo extends Application {
    private JSONObject Politicalinfo;

    public JSONObject getPoliticalinfo() {
        return Politicalinfo;

    }

    public void setPoliticalinfo(JSONObject Politcalinfo) {
        this.Politicalinfo = Politcalinfo;
    }
}
