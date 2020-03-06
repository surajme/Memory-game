package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView curView = null;
    private int countPair = 0;

    final int[] drawable = new int[] {R.drawable.tajmahal, R.drawable.australia, R.drawable.goldengate,
    R.drawable.lighthouse, R.drawable.london, R.drawable.asia};

        //Integrate array for position
    int[] pos =  {0,1,2,3,4,5,0,1,2,3,4,5 };

    int currentPos = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize gridView
        GridView gridView = (GridView) findViewById( R.id.gridView);

        //Set adapter to gridview
        ImageAdapter imageAdapter = new ImageAdapter(this );
        gridView.setAdapter(imageAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               // check if current position is less than zero

                if (currentPos < 0) {
                     currentPos = position;//position of index which we clicked
                     curView = (ImageView)view;
                    ((ImageView)view).setImageResource(drawable[pos[position]]);



                } else {

                    if ( currentPos == position) {
                        ((ImageView)view).setImageResource(R.drawable.multimedia);

                    } else if (pos[currentPos]!=pos[position]) {
                        curView.setImageResource(R.drawable.multimedia);
                        Toast.makeText(MainActivity.this, "No Match!!!", Toast.LENGTH_SHORT).show();
                    } else {
                        ((ImageView)view).setImageResource(drawable[pos[position]]);

                        countPair++;

                        if (countPair==0 ) {
                            Toast.makeText(MainActivity.this, "You win!!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    currentPos = -1;

                }
            }
        });






    }
}
