package com.andira.user.cafeimpian;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityMakanan extends AppCompatActivity {
    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makanan2);

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
        Log.v("ActivityMakanan", "Nama:" + name);
        CheckBox Batagor = (CheckBox) findViewById(R.id.rdg);
        boolean hasBatagor = Batagor.isChecked();
        Log.v("ActivityMakanan", "has Batagor:" + hasBatagor);

        CheckBox Cireng = (CheckBox) findViewById(R.id.dd);
        boolean hasCireng = Cireng.isChecked();
        Log.v("ActivityMakanan", "has Cireng:" + hasCireng);


        CheckBox NasiGoreng = (CheckBox) findViewById(R.id.ag);
        boolean hasNasigoreng = NasiGoreng.isChecked();
        Log.v("ActivityMakanan", "has Nasi Goreng:" + hasNasigoreng);}


    private int calculateprice(boolean addBatagor, boolean addCireng, boolean addNasiGoreng) {
        int harga = 4000;
        if (addBatagor) {
            harga = harga + 25000;
        }
        if (addCireng) {
            harga = harga + 10000;
        }
        if (addNasiGoreng) {
            harga = harga + 50000;
        }

        return quantity * harga;
    }

    private String createOrderSummary(int price, String name, boolean addBatagor, boolean addCireng, boolean addNasiGoreng) {
        String pricemessage = " Nama = " + name;
        pricemessage += "\n batagor =" + addBatagor;
        pricemessage += "\n cireng =" + addCireng;
        pricemessage += "\n nasi goreng =" + addNasiGoreng;
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
