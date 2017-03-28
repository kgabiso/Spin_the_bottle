package com.example.kaysherman.spin_the_bottle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    ImageButton imageButton;
    Random r;
    int angel;
    boolean restart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView =(TextView)findViewById(R.id.textView);
        imageButton =(ImageButton)findViewById(R.id.imageView);
        r = new Random();
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(restart)
                {
                   angel = angel % 360;
                    RotateAnimation rotateAnimation = new RotateAnimation(angel ,360,
                            RotateAnimation.RELATIVE_TO_SELF,0.5f,
                            RotateAnimation.RELATIVE_TO_SELF,0.5f);
                    rotateAnimation.setFillAfter(true);
                    rotateAnimation.setDuration(1000);
                    rotateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
                    imageButton.startAnimation(rotateAnimation);

                    textView.setText(R.string.tv_spin);
                    restart = false;
                }
                else {
                    angel = r.nextInt(3600) + 360;
                    RotateAnimation rotateAnimation = new RotateAnimation(0,angel,
                            RotateAnimation.RELATIVE_TO_SELF,0.5f,
                            RotateAnimation.RELATIVE_TO_SELF,0.5f);
                    rotateAnimation.setFillAfter(true);
                    rotateAnimation.setDuration(3600);
                    rotateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
                    imageButton.startAnimation(rotateAnimation);
                    textView.setText("Reset");
                    restart = true;
                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.bottle1)
        {
            imageButton.setImageResource(R.drawable.beer_bottle_brown_md);
        }
        if(id == R.id.bottle2)
        {
            imageButton.setImageResource(R.drawable.beer_bottle_psd_463145);
        }
        if(id == R.id.bottle3)
        {
            imageButton.setImageResource(R.drawable.beer_bottle_512);
        }
        if(id == R.id.bottle4)
        {
            imageButton.setImageResource(R.drawable.beer_heineken);
        }

        return super.onOptionsItemSelected(item);
    }
}
