package com.tanjulia.photoeditor;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Button;
import android.graphics.Bitmap;
import android.content.pm.PackageManager;
import android.content.pm.PackageInfo;
import android.provider.MediaStore;

public class MainActivity extends ActionBarActivity {
    static final int Image_identifier =1;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button memeButton = (Button) findViewById(R.id.memeButton);
        Button photoButton = (Button) findViewById(R.id.photoButton);
        imageView = (ImageView) findViewById(R.id.imageView);

        //Check if the user has a camera. Give true or false accordingly.
        if (!hasCamera()){
            photoButton.setEnabled(false);
        }

        //To create the meme

        memeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),doge.class);

                startActivity(intent);
            }
        });



    }

    private boolean hasCamera(){
        return getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA);
    }


    public void startCamera(View view){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //Take a picture and pass results along to onActivityResult
        startActivityForResult(intent, Image_identifier);
    }

    //Save the image and return it
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //checks if the image was taken
        if(requestCode==Image_identifier && resultCode==RESULT_OK){
            Bundle extra = data.getExtras();
            Bitmap photos = (Bitmap) extra.get("data");
            imageView.setImageBitmap(photos);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
