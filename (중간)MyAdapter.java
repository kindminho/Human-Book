package team.everywhere.humanbook;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
        private ArrayList<Chat> mDataset;
        String stMyEmail = "";

        // Provide a reference to the views for each data item
        // Complex data items may need more than one view per item, and
        // you provide access to all the views for a data item in a view holder
        public static class MyViewHolder extends RecyclerView.ViewHolder {
            // each data item is just a string in this case
            public TextView textView;
            public MyViewHolder(View v) {
                super(v);

                textView = v.findViewById(R.id.tvChat);
            }
        }

    @Override
    public int getItemViewType(int position) {
//        return super.getItemViewType(position);
        if (mDataset.get(position).email.equals(stMyEmail)) {   // stMyEmail이라면 리턴1, 아니면 리턴2
            return 1;
        } else {
            return 2;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
        public MyAdapter(ArrayList<Chat> myDataset, String stEmail) {
            mDataset = myDataset;
            this.stMyEmail = stEmail;
        }


        // Create new views (invoked by the layout manager)
        @Override
        public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {
            // create a new view
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.my_text_view, parent, false);  // my_text_view가 채팅 버블을 가져와서 꾸며준다.
            if(viewType==1){
                v = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.right_text_view, parent, false); // 말풍선 오른쪽에 배치
            }

            MyViewHolder vh = new MyViewHolder(v);
            return vh;
        }

        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            // - get element from your dataset at this position
            // - replace the contents of the view with that element
            holder.textView.setText(mDataset.get(position).getText());

        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() { return mDataset.size(); }
    }
