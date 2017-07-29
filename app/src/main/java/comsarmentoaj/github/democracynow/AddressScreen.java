package comsarmentoaj.github.democracynow;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
                String Address = ((EditText) findViewById(R.id.streetaddress)).getText() + " " + ((EditText) findViewById(R.id.apartmentnumber)).getText() + " " + ((EditText) findViewById(R.id.city)).getText() + " " + ((EditText) findViewById(R.id.state)).getText() + " " + ((EditText) findViewById(R.id.zip)).getText();
                Address = Address.replaceAll("\\s+", "_");
                freedom(Address);
                Intent intent = new Intent(AddressScreen.this, Finalpage.class);
                startActivity(intent);
            }
        });
    }


    public void freedom(String addr) {
        String url = uri + "?address=" + addr + "&key=" + getString(R.string.api_key);

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest jsonr = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //String d = "Freedom";
                Politicalinfo.getInstance().politicalinfosingleton = response;
                // Log.d(d,Politicalinfo.getInstance().politicalinfosingleton);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonr);
    }
}