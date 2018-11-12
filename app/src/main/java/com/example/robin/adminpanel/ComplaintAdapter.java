package com.example.robin.adminpanel;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ComplaintAdapter extends RecyclerView.Adapter<ComplaintAdapter.ProductViewHolder> {


    private Context mCtx;
    private List<Complaint> complaintList;

    public ComplaintAdapter(Context mCtx, List<Complaint> productList) {
        this.mCtx = mCtx;
        this.complaintList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.complaint_list, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        Complaint complaint= complaintList.get(position);
        final String x = complaint.getId();
        final String y = complaint.getMessage();
        final String z = complaint.getDate();
        final String a = complaint.getType();
        //loading the image
        holder.textViewTitle.setText(complaint.getId());
        holder.textViewShortDesc.setText(complaint.getMessage());
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent intent = new Intent(context, Showcom.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("cid",x);
                intent.putExtra("message",y);
                intent.putExtra("date",z);
                intent.putExtra("type",a);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return complaintList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle, textViewShortDesc, textViewRating, textViewPrice;
        ImageView imageView;
        Button button;

        public ProductViewHolder(View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.idno);
            textViewShortDesc = itemView.findViewById(R.id.subject);
            button = itemView.findViewById(R.id.submit);

        }
    }
}
