package comsarmentoaj.github.democracynow;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class AddressScreen extends AppCompatActivity {

    String uri = "https://www.googleapis.com/civicinfo/v2/voterinfo";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String d = "hk";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_screen);

        Button button = (Button) findViewById(R.id.buttoninfo);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Address = ((EditText) findViewById(R.id.streetaddress)).getText() + "" + ((EditText) findViewById(R.id.apartmentnumber)).getText() + ((EditText) findViewById(R.id.city)).getText() + ((EditText) findViewById(R.id.state)).getText() + ((EditText) findViewById(R.id.zip)).getText();
                Address.replace(" ", "_");
                freedom(Address);
            }
        });
    }


    public void freedom(String addr) {
        String url = uri + "?address=" + addr + "&key=" + getString(R.string.api_key);
        String d = "f";

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest jsonr = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonr);
        Log.d(d, url);
    }


}