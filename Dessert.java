package com.andira.user.cafeimpian;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Dessert extends AppCompatActivity {
    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dessert);

    }
    public void increment(View view) {
        //perintah tombol tambah
        if (quantity == 100) {
            Toast.makeText(this, "pesanan maximal 100", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity + 1;
        display(quantity);
    }

    public void decrement(View view) {//perintah tombol tambah
        if (quantity == 1) {
            Toast.makeText(this, "pesanan minimal 1", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity - 1;
        display(quantity);
    }

    public void Submitorder(View view) {
        EditText nameEditText = (EditText) findViewById(R.id.edt1);
        String name = nameEditText.getText().toString();
        Log.v("ActivityDessert", "Nama:" + name);
        CheckBox CheeseCake = (CheckBox) findViewById(R.id.rdg);
        boolean hascheese = CheeseCake.isChecked();
        Log.v("ActivityDessert", "has Cheesse Cake:" + hascheese);
        CheckBox BlackSalad = (CheckBox) findViewById(R.id.ag);
        boolean hasblack = BlackSalad.isChecked();
        Log.v("ActivityDessert", "has Black Salad:" + hasblack);}


    private int calculateprice(boolean addcheese, boolean addblack) {
        int harga = 5000;
        if (addcheese) {
            harga = harga + 40000;
        }
        if (addblack) {
            harga = harga + 30000;
        }

        return quantity * harga;
    }

    private String createOrderSummary(int price, String name, boolean addcheese, boolean addblack) {
        String pricemessage = " Nama = " + name;
        pricemessage += "\n Cheese Cake =" + addcheese;
        pricemessage += "\n Black salad =" + addblack;
                pricemessage += "\n Jumlah Pemesanan =" + quantity;
        pricemessage += "\n Total = Rp " + price;
        pricemessage += "\n Terimakasih";
        return pricemessage;
    }

    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_textview);
        priceTextView.setText(message);
    }

    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_textview);
        quantityTextView.setText("" + number);
    }

    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_textview);
    }
}

