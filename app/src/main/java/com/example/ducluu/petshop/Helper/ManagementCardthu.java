package com.example.ducluu.petshop.Helper;

import android.content.Context;
import android.widget.Toast;

import com.example.ducluu.petshop.model.thucung;

import java.util.ArrayList;

public class ManagementCardthu {

    private Context context;
    private TinyDBthu tinyDBthu;

    public ManagementCardthu(Context context) {
        this.context = context;
        this.tinyDBthu = new TinyDBthu(context);
    }

    public void DeleteListCard() {
        tinyDBthu.remove("CardList");
    }


    public ArrayList<thucung> getListCard() {
        return tinyDBthu.getListObject("CardList");
    }

    public void insertFood(thucung item){
        ArrayList<thucung>listFood = getListCard();
        boolean exitAlready = false;
        int n = 0;
        for(int i=0;i<listFood.size();i++){
            if(listFood.get(i).getTenthu().equals(item.getTenthu())){
                exitAlready = true;
                n = i;
                break;
            }
        }
        if (exitAlready) {
            listFood.get(n).setNumberInCard(item.getNumberInCard());
        } else {
            listFood.add(item);
        }

        tinyDBthu.putListObject("CardList", listFood);
        Toast.makeText(context, "Added to your Cart", Toast.LENGTH_SHORT).show();
    }

    public void plusNumberFood(ArrayList<thucung> listfood, int position, ChangeNumberItemListener changeNumberItemListener) {
        listfood.get(position).setNumberInCard(listfood.get(position).getNumberInCard() + 1);
        tinyDBthu.putListObject("CardList", listfood);
        changeNumberItemListener.changed();
    }

    public void MinusNumberFood(ArrayList<thucung> listfood, int position, ChangeNumberItemListener changeNumberItemListener) {
        if (listfood.get(position).getNumberInCard() == 1) {
            listfood.remove(position);
        } else {
            listfood.get(position).setNumberInCard(listfood.get(position).getNumberInCard() - 1);
        }
        tinyDBthu.putListObject("CardList", listfood);
        changeNumberItemListener.changed();
    }

    public Integer getTotalFee() {
        ArrayList<thucung> listFood2 = getListCard();
        int fee = 0;
        for (int i = 0; i < listFood2.size(); i++) {
            fee = fee + (listFood2.get(i).getGiatien() * listFood2.get(i).getNumberInCard());
        }
        return fee;
    }
}
