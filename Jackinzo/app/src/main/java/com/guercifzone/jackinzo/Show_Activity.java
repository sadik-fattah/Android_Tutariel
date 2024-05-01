package com.guercifzone.jackinzo;

import android.Manifest;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import com.google.android.material.textfield.TextInputEditText;
import com.guercifzone.jackinzo.tools.SqliteHelper;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Calendar;

public class Show_Activity extends AppCompatActivity {
    TextInputEditText edtName, edtemail,edttype,edtaddress,edtassurance,edtdate_sing,edtdate_burn;
    Button btnChoose, btnAdd, btnMain;
    ImageView imageView;
    DatePickerDialog datePickerDialog1,datePickerDialog2;
    final int REQUEST_CODE_GALLERY = 999;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
         findTheVariableSource();

        edtdate_sing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                int the_Year = calendar.get(Calendar.YEAR);
                int the_Month = calendar.get(Calendar.MONTH);
                int the_Day = calendar.get(Calendar.DAY_OF_MONTH);
                datePickerDialog1 = new DatePickerDialog(Show_Activity.this, new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                edtdate_sing.setText(dayOfMonth + "/"+month+"/"+year);
                            }
                        } ,the_Year,the_Month,the_Day);
                datePickerDialog1.show();
            }
        });
        edtdate_burn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                int the_Year = calendar.get(Calendar.YEAR);
                int the_Month = calendar.get(Calendar.MONTH);
                int the_Day = calendar.get(Calendar.DAY_OF_MONTH);
                datePickerDialog2 = new DatePickerDialog(Show_Activity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                edtdate_burn.setText(dayOfMonth + "/"+month+"/"+year);
                            }
                        },the_Year,the_Month,the_Day);
                datePickerDialog2.show();
            }
        });
        btnChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCompat.requestPermissions(
                        Show_Activity.this,
                        new String[]{Manifest.permission.READ_MEDIA_VIDEO,
                                Manifest.permission.READ_MEDIA_IMAGES,
                                Manifest.permission.READ_EXTERNAL_STORAGE},
                        REQUEST_CODE_GALLERY
                );
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                  SqliteHelper  mydb = new SqliteHelper(Show_Activity.this);
                    mydb.AddRecord(
                            edtName.getText().toString().trim(),
                            edtemail.getText().toString().trim(),
                            edttype.getText().toString().trim(),
                            edtaddress.getText().toString().trim(),
                            edtassurance.getText().toString().trim(),
                            edtdate_sing.getText().toString().trim(),
                            edtdate_burn.getText().toString().trim(),
                            imageViewToByte(imageView)
                    );
                    Toast.makeText(getApplicationContext(), "تمت الإضافة بنجاح", Toast.LENGTH_SHORT).show();
                    edtName.setText("");
                    edtemail.setText("");
                    edttype.setText("");
                    edtaddress.setText("");
                    edtassurance.setText("");
                    edtdate_sing.setText("");
                    edtdate_burn.setText("");
                    imageView.setImageResource(R.mipmap.ic_launcher);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Show_Activity.this, MainActivity.class));
            }
        });
    }

    private byte[] imageViewToByte(ImageView image) {
        Bitmap bitmap = ((BitmapDrawable)image.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 50, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if(requestCode == REQUEST_CODE_GALLERY){
            if(grantResults.length >0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, REQUEST_CODE_GALLERY);
            }
            else {
                Toast.makeText(getApplicationContext(), "ليس لديكم الصلاحيات", Toast.LENGTH_SHORT).show();
            }
            return;
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == REQUEST_CODE_GALLERY && resultCode == RESULT_OK && data != null){
            Uri uri = data.getData();

            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);

                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                imageView.setImageBitmap(bitmap);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    private void findTheVariableSource() {
        edtName = (TextInputEditText) findViewById(R.id.edtName);
        edtemail = (TextInputEditText) findViewById(R.id.edtemail);
        edttype = (TextInputEditText) findViewById(R.id.edttype);
        edtaddress = (TextInputEditText) findViewById(R.id.edtaddress);
        edtassurance = (TextInputEditText) findViewById(R.id.edtassurance);
        edtdate_sing = (TextInputEditText) findViewById(R.id.edtdate_sing);
        edtdate_burn = (TextInputEditText) findViewById(R.id.edtdate_burn);
        btnChoose = (Button) findViewById(R.id.btnChoose);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnMain = (Button) findViewById(R.id.btnList);
        imageView = (ImageView) findViewById(R.id.imageView);
    }
}