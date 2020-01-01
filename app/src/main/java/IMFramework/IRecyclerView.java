package IMFramework;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.myappim.MyContact;
import com.example.myappim.R;
import java.util.ArrayList;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class IRecyclerView extends RecyclerView.Adapter<IRecyclerView.ViewHolder> {

    private ArrayList<MyContact> mData;
    private LayoutInflater mInflater;

    // data is passed into the constructor
    public IRecyclerView(Context context, ArrayList<MyContact> mData) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = mData;
    }

    // inflates the row layout from xml when needed
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.layout_recycler_sell, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {


        holder.txtOffer.setText("" + mData.get(position).getOfferK());
        holder.txtName.setText("" + mData.get(position).getName());
        holder.txtNumber.setText(""+mData.get(position).getTxtNumber());
        holder.txtFi.setText("" + mData.get(position).getTxtFi());
        holder.txtPriceNoOffer.setText("" + mData.get(position).getTxtPriceNoOffer());
        holder.txtPriceOffer.setText("" + mData.get(position).getTxtPriceOffer());
        holder.txtSodkala.setText("" + mData.get(position).getSodSell());
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder  {
        private TextView txtId;
        private TextView txtName;
        private TextView txtFi;
        private TextView txtPriceNoOffer;
        private TextView txtPriceOffer;
        private TextView txtNumber;
        private TextView txtOffer;
        private TextView txtSodkala;



        ViewHolder(View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.txt_show_name_k);
            txtNumber = itemView.findViewById(R.id.txt_show_count_kala);
            txtFi = itemView.findViewById(R.id.txt_fi_k);
            txtPriceNoOffer = itemView.findViewById(R.id.txt_price_no_offer);
            txtPriceOffer = itemView.findViewById(R.id.txt_price_offer);
            txtOffer = itemView.findViewById(R.id.txt_offer);
            txtSodkala = itemView.findViewById(R.id.tv_show_sod_sell);


        }

    }





}