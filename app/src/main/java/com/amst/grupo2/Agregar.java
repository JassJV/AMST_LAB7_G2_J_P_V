package com.amst.grupo2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;


public class Agregar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);
        final EditText edtValorTemperatura = findViewById(R.id.edtValorTemperatura);
        Button btnAgregarTemperatura = findViewById(R.id.btnAgregarTemperatura);

        btnAgregarTemperatura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float valorTemperatura = Float.parseFloat(edtValorTemperatura.getText().toString());
                String url = "https://amst-lab-api.herokuapp.com/api/lecturas";
                JSONObject jsonBody = new JSONObject();
                try {
                    jsonBody.put("key", "temperatura");
                    jsonBody.put("value", valorTemperatura);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                RequestQueue requestQueue = Volley.newRequestQueue(Agregar.this);
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                        Request.Method.POST, url, jsonBody,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                Toast.makeText(Agregar.this, "Temperatura agregada exitosamente", Toast.LENGTH_SHORT).show();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(Agregar.this, "Temperatura no agregada", Toast.LENGTH_SHORT).show();
                            }
                        }
                );

                requestQueue.add(jsonObjectRequest);

            }
        });
    }
}