package com.example.android.coffeeordering;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int quantity = 0;
    int price = 5;
    int chocolatePrice = 2;
    int creamPrice = 1;
    TextView quantityView;
    CheckBox checkBoxCream;
    CheckBox checkBoxChocolate;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quantityView = findViewById(R.id.quantity_text_view);
        checkBoxCream = findViewById(R.id.w_cream_checkbox);
        checkBoxChocolate = findViewById(R.id.chocolate_checkbox);
        editText = findViewById(R.id.name_edit_text);
    }

    private void displayQuantity() {
        quantityView.setText(Integer.toString(quantity));
    }

    private int totalPrice(boolean hasCream, boolean hasChoco) {
        int unitPrice = price;
        if (hasCream) {
            unitPrice += creamPrice;
        }
        if (hasChoco) {
            unitPrice += chocolatePrice;
        }
        return unitPrice * quantity;
    }

    private String createOrderSummary(boolean hasCream, boolean hasChocolate, String name) {
        String res = "Name: " + name;
        res += "\nAdd W cream: " + hasCream;
        res += "\nAdd chocolate: " + hasChocolate;
        res += "\nQuantity: " + quantity;
        res +="\ntotal: $" + totalPrice(hasCream, hasChocolate);
        res +="\n" + getString(R.string.thank_you);

        return res;
    }

    public void increase(View view) {
        quantity++;
        displayQuantity();
    }

    public void decrease(View view) {
        if (quantity > 0) {
            quantity--;
            displayQuantity();
        }
    }

    public void clickOrder(View view) {
        boolean hasCream = checkBoxCream.isChecked();
        boolean hasChocolate = checkBoxChocolate.isChecked();
        String name = editText.getText().toString();
        String orderSummary = createOrderSummary(hasCream, hasChocolate, name);
        composeEmail(name, orderSummary);
    }

    private void composeEmail(String name, String content) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Coffee ordering for: " + name);
        intent.putExtra(Intent.EXTRA_TEXT, content);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
