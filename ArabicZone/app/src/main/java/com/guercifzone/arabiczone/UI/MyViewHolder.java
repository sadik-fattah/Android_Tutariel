package com.guercifzone.arabiczone.UI;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.guercifzone.arabiczone.R;

public class MyViewHolder extends RecyclerView.ViewHolder {

    TextView titleTxt,desctxt,dateTxt;
    ImageView img;

    public MyViewHolder(View itemView) {
        super(itemView);

        titleTxt= (TextView) itemView.findViewById(R.id.titleTxt);
        desctxt= (TextView) itemView.findViewById(R.id.descTxt);
        dateTxt= (TextView) itemView.findViewById(R.id.dateTxt);
       // img= (ImageView) itemView.findViewById(R.id.articleImage);
    }
}
