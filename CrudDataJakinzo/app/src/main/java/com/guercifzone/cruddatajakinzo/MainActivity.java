package com.guercifzone.cruddatajakinzo;

import android.Manifest;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import com.guercifzone.cruddatajakinzo.CropImage.CropImage;
import com.squareup.picasso.Picasso;
import org.jetbrains.annotations.NotNull;

import java.io.ByteArrayOutputStream;

import static com.guercifzone.cruddatajakinzo.DBmain.TABLENAME;
public class MainActivity extends AppCompatActivity {
    DBmain dBmain;
    SQLiteDatabase sqLiteDatabase;

    ImageView avatar;
    EditText name;
    Button submit,display,edite ,parcour;
    int id=0;
    public static final int CAMERA_REQUEST=100;
    public static final int STORGE_REQUEST=101;
    String[]cameraPermission;
    String[]storgePermission;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findid();
        insertData();
        imagePick();



    }

    private void imagePick() {
        parcour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int avatar = 0;
                    if (avatar == 0) {
                        if (!checkCameraPermission()) {
                            requestCameraPermission();
                        } else {
                            pickFromGallery();
                        }
                    } else if (avatar == 1) {
                        if (!checkstorgePermission()) {
                            requestStorgePermission();
                        } else {
                            pickFromGallery();
                        }
                    }

                }catch (Exception e){

                }

            }
        });
      /*  avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int avatar = 0;
                if (avatar == 0 ){
                    if (!checkCameraPermission()){
                        requestCameraPermission();
                    }else {
                        pickFromGallery();
                    }
                } else if (avatar == 1) {
                    if (!checkstorgePermission()){
                        requestStorgePermission();
                    }else {
                        pickFromGallery();
                    }

                }
            }
        });*/
    }

    private void requestStorgePermission() {
        requestPermissions(storgePermission,STORGE_REQUEST);
    }

    private boolean checkstorgePermission() {
        boolean result = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == (PackageManager.PERMISSION_GRANTED);
        return result;
    }

    private void pickFromGallery() {
      CropImage.activity().start(this);
    }

    private void requestCameraPermission() {
        requestPermissions(cameraPermission,CAMERA_REQUEST);
    }

    private boolean checkCameraPermission() {
        boolean result = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)==(PackageManager.PERMISSION_GRANTED);
        boolean result1 = ContextCompat.checkSelfPermission(this,Manifest.permission.CAMERA)==(PackageManager.PERMISSION_GRANTED);
        return result && result1;
    }

    private void insertData() {
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues cv = new ContentValues();
                cv.put("avatar",ImageViewToByte(avatar));
                cv.put("name",name.getText().toString());
                sqLiteDatabase = dBmain.getWritableDatabase();
                Long recinsert= sqLiteDatabase.insert(TABLENAME,null,cv);
                if (recinsert != null){
                    Toast.makeText(MainActivity.this, "insert successuflly", Toast.LENGTH_SHORT).show();
                    avatar.setImageResource(R.mipmap.ic_launcher);
                    name.setText("");
                }else {
                    Toast.makeText(MainActivity.this, "faild!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private byte[] ImageViewToByte(ImageView avatar) {
        Bitmap bitmap=((BitmapDrawable)avatar.getDrawable()).getBitmap();
        ByteArrayOutputStream stream= new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,80,stream);
        byte[]bytes=stream.toByteArray();
        return bytes;
    }

    private void findid() {
        parcour = (Button)findViewById(R.id.btn_img) ;
        avatar= (ImageView)findViewById(R.id.avatar) ;
        name=(EditText)findViewById(R.id.edite_name) ;
        submit=(Button) findViewById(R.id.btn_submit);
        display=(Button) findViewById(R.id.btn_display);
        edite=(Button) findViewById(R.id.btn_edite);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull @NotNull String[] permissions, @NonNull @NotNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
       switch (requestCode){
            case CAMERA_REQUEST:{
                if (grantResults.length>0){
                    boolean caera_accept = grantResults[0]==PackageManager.PERMISSION_GRANTED;
                    boolean storge_accept = grantResults[1] == PackageManager.PERMISSION_GRANTED;
                    if(caera_accept && storge_accept){
                        pickFromGallery();
                    }else {
                        Toast.makeText(this, "enable camera storge permission", Toast.LENGTH_SHORT).show();
                    }
                }
            }
            break;
            case STORGE_REQUEST:{
                if (grantResults.length>0){
                    boolean caera_accept = grantResults[0]==PackageManager.PERMISSION_GRANTED;
                    if(caera_accept){
                        pickFromGallery();
                    }else {
                        Toast.makeText(this, "enable storge permission", Toast.LENGTH_SHORT).show();
                    }
                }
            }
            break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
      if (requestCode==CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE){
            CropImage.ActivityResult result= CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK){
                Uri resultUri = result.getUri();
                Picasso.with(this).load(resultUri).into(avatar);
            }
        }
    }
}