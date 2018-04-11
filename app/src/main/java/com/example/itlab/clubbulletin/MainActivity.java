package com.example.itlab.clubbulletin;

import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.content.Intent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SimpleDateFormat df;
    String formattedDate;
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main2,menu);
        Calendar c = new Calendar() {
            @Override
            protected int handleGetLimit(int i, int i1) {
                return 0;
            }

            @Override
            protected int handleComputeMonthStart(int i, int i1, boolean b) {
                return 0;
            }

            @Override
            protected int handleGetExtendedYear() {
                return 0;
            }
        };
        t1 = (TextView)findViewById(R.id.textView7);
        df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        formattedDate = df.format(c.getTime());
        t1.setText("Current Date and Time : "+formattedDate);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        RelativeLayout main_view = (RelativeLayout) findViewById(R.id.main_view);

        switch(item.getItemId())
        {
            case R.id.menu_acses:
                if(item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);

                Intent i = new Intent(this,ACSES.class);
                startActivity(i);
                return true;

            case R.id.menu_cesa:
                if(item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                Intent i1 = new Intent(this,CESA.class);
                startActivity(i1);
                return true;

            case R.id.menu_eesa:
                if(item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                Intent i2 = new Intent(this,EESA.class);
                startActivity(i2);
                return true;

            case R.id.menu_elesa:
                if(item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                Intent i3 = new Intent(this,ELESA.class);
                startActivity(i3);
                return true;

            case R.id.menu_mesamesc:
                if(item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                Intent i4 = new Intent(this,MESA.class);
                startActivity(i4);
                return true;

            case R.id.menu_sait:
                if(item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                Intent i5 = new Intent(this,SAIT.class);
                startActivity(i5);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

}


/*
package com.example.itlab.clubbulletin;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {
    Button b_prev, b_next;
    ImageSwitcher imageSwitcher;

    Integer [] images={R.drawable.image_1,R.drawable.image_2,R.drawable.image_3,
            R.drawable.image_4,R.drawable.image_5,R.drawable.image_6};
    int i= 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageSwitcher=(ImageSwitcher) findViewById(R.id.imageSwitcher);
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView=new ImageView(getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT));
                return imageView;


            }
        });
        Animation in= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.in);
        Animation out= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.out);
        imageSwitcher.setInAnimation(in);
        imageSwitcher.setOutAnimation(out);
        b_prev=(Button)findViewById(R.id.b_prev);
        b_next=(Button)findViewById(R.id.b_next);

        b_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i>0)
                {
                    i--;
                    imageSwitcher.setImageResource(images[i]);
                }

            }
        });
        b_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i<images.length-1)
                {
                    i++;
                    imageSwitcher.setImageResource(images[i]);
                }
            }
        });
    }
}
*/