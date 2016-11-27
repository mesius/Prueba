package com.topiasoft.prueba;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //initial data
    Place[] myPlacesArray = new Place[]{
            new Place("Art House", 78701 , "art" ,"This place is tasteful"),
            new Place("Bike Shop", 78702, "bike","Cool bikes"),
            new Place("Camera Fix", 78702, "polaroids","These guys always rip me off"),
            new Place("YETspace", 78702, "radio", "I LOVE this place"),
            new Place("Secret Space Pad", 94103, "rocket","Not very secret, are they?"),
            new Place("Taylor's Tailor", 60610, "scissors" , "Looking good.."),
            new Place("Boathouse", 78701, "shipwheel" ,"That place is full of pirates!"),
            new Place("Not Apple Store", 78702, "tablet", "Android rules!"),
            new Place("Tool Battleground", 78702, "tools", "That place is dangerous"),
            new Place("Travelpediocity", 78702, "travelerbag" ,"This is where i booked my summer trip"),
            new Place("UFO Pick-a-part", 90210, "ufo","Out of this world stuff here."),
            new Place("Spawrk's House", 99999, "volume", "The music is always so good"),
    };

    String[] myStringArray = new String[]{
            "Art House",
            "Bike Shop",
            "Camera Fix",
            "YETspace",
            "Secret Space Pad",
            "Taylor's Tailor",
            "Boathouse",
            "Not Apple Store",
            "Tool Battleground",
            "Travelpediocity",
            "UFO Pick-a-part",
            "Spawrk's House",
    };

    private ListView mListView;
    private PlaceAdapter mPlaceAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.myListview);
        mPlaceAdapter = new PlaceAdapter(getApplicationContext(), R.layout.row, myPlacesArray);

        if (mListView !=null){
            mListView.setAdapter(mPlaceAdapter);
        }


        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Log.v("PLACE: ", myPlacesArray[i].mNameOfPlace );

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.prueba:
                Toast.makeText(this,"Selected Settings", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.test:
                Toast.makeText(this,"Test!", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


        //return super.onOptionsItemSelected(item);
    }
}
