package agrawal.deepansh.coffebydeepu;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class deepu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deepu);
    }
    int quan=2;
    public void inc(View view)
    {
        if(quan>100)
            return;
        quan=quan+1;
        display(quan);
    }
    public void dec(View view)
    {
        if(quan<1)
        {
            Toast.makeText(this,"Order some Coffes ",Toast.LENGTH_SHORT).show();
            return;
        }

        quan=quan-1;
        display(quan);
    }
    public void display(int num)
    {
        TextView Qua=(TextView)findViewById(R.id.quan);
        Qua.setText(""+num);
    }
    public void order(View view)
    {
        EditText Name = (EditText) findViewById(R.id.name);
        String name=Name.getText().toString();
        int total=price();
        String toprint="Thank you "+name+"\nYour total Sum is $"+total;
        TextView print=(TextView)findViewById(R.id.price);
        print.setText(toprint);
    }
    public int price() {
        int price = quan * 5;
        CheckBox cho = (CheckBox) findViewById(R.id.c);
        CheckBox van = (CheckBox) findViewById(R.id.v);
        boolean ch = cho.isChecked();
        boolean va = van.isChecked();
        if (ch)
            price = price + 2 * quan;
        if (va)
            price += 1 * quan;
        return price;
    }
        public void in(View view)
    {
        Intent i =new Intent(Intent.ACTION_SENDTO);
        i.setData(Uri.parse("mailto:"));
        i.putExtra(Intent.EXTRA_EMAIL,"deepansh.agrawal7@gmail.com");
        i.putExtra(Intent.EXTRA_SUBJECT,"Coffee by Deepu!");
        i.putExtra(Intent.EXTRA_TEXT,"Here's ur coffee\nThanks");
        if(i.resolveActivity(getPackageManager()) != null)
        {
            startActivity(i);
        }
    }


}
