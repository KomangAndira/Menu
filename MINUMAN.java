package com.andira.user.cafeimpian;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MINUMAN extends AppCompatActivity {
    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minuman);

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
        Log.v("ActivityMinuman", "Nama:" + name);
        CheckBox KopiHitam = (CheckBox) findViewById(R.id.rdg);
        boolean hasKopi = KopiHitam.isChecked();
        Log.v("ActivityMinuman", "has Kopi Hitam:" + hasKopi);

        CheckBox Cappuccino = (CheckBox) findViewById(R.id.dd);
        boolean hasCappuccino = Cappuccino.isChecked();
        Log.v("ActivityMinuman", "has Cappuccino:" + hasCappuccino);


        CheckBox Sparklingtea = (CheckBox) findViewById(R.id.ag);
        boolean hasSparklingtea = Sparklingtea.isChecked();
        Log.v("ActivityMinuman", "has Sparklingtea:" + hasSparklingtea);}


    private int calculateprice(boolean addkopi, boolean addCappuccino, boolean addSparklingtea) {
        int harga = 1000;
        if (addkopi) {
            harga = harga + 15000;
        }
        if (addCappuccino) {
            harga = harga + 20000;
        }
        if (addSparklingtea) {
            harga = harga + 15000;
        }

        return quantity * harga;
    }

    private String createOrderSummary(int price, String name, boolean addkopi, boolean addcappu, boolean addtea) {
        String pricemessage = " Nama = " + name;
        pricemessage += "\n Kopi Hitam =" + addkopi;
        pricemessage += "\n Cappuccino =" + addcappu;
        pricemessage += "\n Sparkling tea =" + addtea;
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
