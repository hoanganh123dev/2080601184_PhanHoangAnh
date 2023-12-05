package com.example.a2080601184_phanhoanganh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CandidateAdapter extends RecyclerView.Adapter<CandidateAdapter.ViewHolder> {
    private List<Candidate> list;
    private Candidate item;
    private OnVoteClickListener onVoteClickListener;
    int dt = 0, dcc = 0, lgbt= 0;
    public CandidateAdapter(List<Candidate> lists, OnVoteClickListener listener){
        list = lists;
        onVoteClickListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View ItemNA = inflater.inflate(R.layout.item_binhchon,parent,false);
        ViewHolder viewHolder = new ViewHolder(ItemNA);
        return  viewHolder;
    }
    public interface OnVoteClickListener {
        void onVoteClick(int position, String type);
    }

    public void setOnVoteClickListener(OnVoteClickListener listener) {
        this.onVoteClickListener = listener;
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Candidate candidate  = list.get(position);
        holder.txtDT.setText("ĐỘC THÂN: " + candidate .getDocThan() );
        holder.txtDCC.setText("ĐÃ CÓ CHỦ: " + candidate .getCoChu() );
        holder.txtLGBT.setText("LGBT: " + candidate .getLGBT() );
        Context context = holder.imageView.getContext();
        int imgId = context.getResources().getIdentifier(candidate.TenHinh,"drawable",context.getPackageName());
        if(imgId!=0){
            holder.imageView.setImageResource(imgId);
        }
        holder.btndt.setOnClickListener(v -> {
            if (onVoteClickListener != null) {
                onVoteClickListener.onVoteClick(position, "Độc Thân");
            }
        });

        holder.btndcc.setOnClickListener(v -> {
            if (onVoteClickListener != null) {
                onVoteClickListener.onVoteClick(position, "Đã Có Chủ");
            }
        });

        holder.btnlgbt.setOnClickListener(v -> {
            if (onVoteClickListener != null) {
                onVoteClickListener.onVoteClick(position, "LGBT");
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView txtDT, txtDCC, txtLGBT;

        Button btndt, btndcc, btnlgbt;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imgv);
            txtDCC = (TextView) itemView.findViewById(R.id.tvDCC);
            txtDT = (TextView) itemView.findViewById(R.id.tvDT);
            txtLGBT = (TextView) itemView.findViewById(R.id.tvLGBT);
            btndt =(Button) itemView.findViewById(R.id.btnDT);
            btndcc =(Button) itemView.findViewById(R.id.btnDCC);
            btnlgbt =(Button) itemView.findViewById(R.id.btnLGBT);
        }
    }
}