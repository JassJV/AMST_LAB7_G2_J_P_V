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

public class Eliminar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar);
        final EditText edtValorTemperatura = findViewById(R.id.edtValorTemperatura);
        Button btnAgregarTemperatura = findViewById(R.id.btnEliminarTemperatura);

        btnAgregarTemperatura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String valorTemperatura = edtValorTemperatura.getText().toString();

                String strEndPoint = "https://amst-lab-api.herokuapp.com/api/lecturas/";
                String url = strEndPoint + valorTemperatura;

                RequestQueue requestQueue = Volley.newRequestQueue(Eliminar.this);
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                        Request.Method.DELETE, url, null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                Toast.makeText(Eliminar.this, "Temperatura eliminada exitosamente", Toast.LENGTH_SHORT).show();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(Eliminar.this, "Temperatura eliminada exitosamente", Toast.LENGTH_SHORT).show();
                            }
                        }
                );


                requestQueue.add(jsonObjectRequest);

            }
        });
    }
}