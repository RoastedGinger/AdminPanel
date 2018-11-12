package com.example.robin.adminpanel;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TechAdapter extends RecyclerView.Adapter<TechAdapter.TechsViewHolder>{

    private Context mCtx;
    private List<AssignTechs> complaintList;
    String Server_url = "";

    public TechAdapter(Context mCtx, List<AssignTechs> techsList) {
        this.mCtx = mCtx;
        this.complaintList = techsList;
    }

    @Override
    public TechsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.techs, null);
        return new TechsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TechsViewHolder holder, int position) {
        AssignTechs techs= complaintList.get(position);
        final String x = techs.getCid();
        final String y = techs.getTname();
        final String z = techs.getStatus();
        final String a = techs.getTid();
        //loading the image
        holder.textViewTitle.setText(techs.getTname());
        holder.textViewShortDesc.setText(techs.getCid());
        holder.textViewRating.setText(techs.getStatus());
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {

                StringRequest request = new StringRequest(Request.Method.POST, Server_url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                String res=response.toString().trim();
                                if(!res.equals("0"))
                                {
                                    Toast.makeText(view.getContext(),"successfully logged in admin",Toast.LENGTH_LONG).show();

//
                                }
                                else
                                {
                                    //  avi.hide();
                                    Toast.makeText(view.getContext(), "invalid user name or password",Toast.LENGTH_LONG).show();
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        String voll = error.toString();
                        Toast.makeText(view.getContext(),voll,Toast.LENGTH_LONG).show();
                       // avi.hide();
                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> params = new HashMap<>();
                        params.put("comp_id",x);
                        params.put("tech_id",a);
                        return params;
                    }
                };
                MySingleton.getInstance(view.getContext()).addToRequestQue(request);
            }
        });
    }

    @Override
    public int getItemCount() {
        return complaintList.size();
    }

    class TechsViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle, textViewShortDesc, textViewRating;
        Button button;

        public TechsViewHolder(View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.name);
            textViewShortDesc = itemView.findViewById(R.id.cid);
            textViewRating = itemView.findViewById(R.id.status);
            button = itemView.findViewById(R.id.check);

        }
    }
}
