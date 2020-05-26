package com.hfad.mycoffee.orders;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.hfad.mycoffee.R;

public class MyAdapter extends RecyclerView.Adapter {

  private RecyclerView myRecyclerView;


  private class MyViewHolder extends RecyclerView.ViewHolder {
      public TextView name;
      public TextView order;
      public TextView doubleCoffee;
      public ImageButton buttonDelete;
      public ImageButton okButton;
      public CardView card;


      public MyViewHolder(View item) {
          super(item);
          name = (TextView) item.findViewById(R.id.name);
          order = (TextView) item.findViewById(R.id.order);
          doubleCoffee = (TextView) item.findViewById(R.id.double_info);
          buttonDelete = (ImageButton) item.findViewById(R.id.delete);
          okButton = (ImageButton) item.findViewById(R.id.ok_button);
          card =(CardView) item.findViewById(R.id.bin);
      }
  }

  public MyAdapter( RecyclerView recyclerView){
      this.myRecyclerView = recyclerView;
  }

  @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, final int position){
      View view = LayoutInflater.from(viewGroup.getContext())

                                     .inflate(R.layout.list_item, viewGroup, false);

      return new MyViewHolder(view);

  }


    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder viewHolder, final int i ) {

        Order myOrder = ListOfOrders.orders.get(i);
        ((MyViewHolder) viewHolder).name.setText(myOrder.getNameOfClient());
        ((MyViewHolder) viewHolder).order.setText(myOrder.getCoffee().toString());
        ((MyViewHolder) viewHolder).doubleCoffee.setText(doubleCoffee(myOrder) + System.lineSeparator() + sugarCoffee(myOrder));

        ((MyViewHolder) viewHolder).buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListOfOrders.orders.remove(i);
                notifyItemRemoved(i);
            }
        });

        ((MyViewHolder) viewHolder).okButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                ((MyViewHolder) viewHolder).card.setCardBackgroundColor(Color.GREEN);
                ((MyViewHolder) viewHolder).buttonDelete.setBackgroundColor(Color.GREEN);
                ((MyViewHolder) viewHolder).okButton.setBackgroundColor(Color.GREEN);
            }
        });

    }

    private String doubleCoffee(Order myOrder){

        if(myOrder.getCoffee().isDouble()){
            return "podwojna";
        }else {
            return "";
        }
    }

    private String sugarCoffee(Order myOrder){
      if(myOrder.getCoffee().isSugar()){
          return "cukier";
      }else{
          return "";
      }
    }

        @Override
        public int getItemCount() {
            return ListOfOrders.orders.size();
        }
}
