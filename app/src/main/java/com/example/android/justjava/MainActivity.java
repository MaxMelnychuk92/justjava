package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.NumberFormat;


public class MainActivity extends AppCompatActivity {
    private int quantity;
    private int topping;
    private int topping2;
    private boolean checked;
    private boolean checkedChocolate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void chocolate(View view) {
        checkedChocolate = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.chocolate_checkbox:
                if (checkedChocolate) {
                    checkedChocolate = true;
                    topping2 = 1;
                } else {
                    checkedChocolate = false;
                    topping2 = 0;
                    break;
                }
        }
    }

    public void whipped(View view) {
        checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.notify_me_checkbox:
                if (checked) {
                    checked = true;
                    topping = 1;
                } else {
                    checked = false;
                    topping = 0;
                    break;
                }
        }
    }


    public void increment(View view) {

        quantity = quantity + 1;
        display(quantity);

    }

    public void decrement(View view) {

        quantity = quantity - 1;
        if (quantity < 0) {
            quantity = 0;
        }
        display(quantity);
    }



    public void submitOrder(View view) {

        EditText nameTextBox = (EditText) findViewById(R.id.name_view);
        String myname = nameTextBox.getText().toString();


        int price = (quantity * 5) + ((topping + topping2) * quantity);
        String priceMassage = "Price $ " + price + "\nThanks!" + "\n" + myname; ///
        String whipMassage = "\nCoffee with whipped cream!";
        String chocoMassage = "\nCoffee with Chocolate!";

        if (checkedChocolate == true && checked == true) {
            displayMessage(priceMassage + whipMassage + chocoMassage);

        } else if (checkedChocolate == false && checked == false) {
            displayMessage(priceMassage);

        } else if (checked == true) {
            displayMessage(priceMassage + whipMassage);

        } else if (checkedChocolate == true) {
            displayMessage(priceMassage + chocoMassage);

        }

    }

    public void editContact(Uri contactUri, String email, String message1) {
        Intent intent = new Intent(Intent.ACTION_EDIT);
        intent.setData(Uri.parse(""));
        intent.putExtra(ContactsContract.Intents.Insert.EMAIL, email);
        intent.putExtra(Intent.EXTRA_TEXT, massage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }


    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }


}

