package com.guercifzone.foodapp;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import org.jetbrains.annotations.Nullable;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;

public class StudentList extends AppCompatActivity {
    GridView gridView;
    ArrayList<Stoudent> list;
    StudentListAdapter adapter = null;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);
        gridView = (GridView) findViewById(R.id.gridView);
        list = new ArrayList<>();
        adapter = new StudentListAdapter(this, R.layout.student_items, list);
        gridView.setAdapter(adapter);

        // get all data from sqlite
        Cursor cursor = MainActivity.sqLiteHelper.getData("SELECT * FROM STUDENT");
        list.clear();
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String email = cursor.getString(2);
            String type = cursor.getString(3);
            String address = cursor.getString(4);
            String assurance = cursor.getString(5);
            String date_sing = cursor.getString(6);
            String date_burn = cursor.getString(7);
            byte[] image = cursor.getBlob(8);

            list.add(new Stoudent(id,name,email,type,address,assurance,date_sing,date_burn,image));
        }
        adapter.notifyDataSetChanged();

        gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                CharSequence[] items = {"تحديث البيانات", "حذف البيانات"};
                AlertDialog.Builder dialog = new AlertDialog.Builder(StudentList.this);

                dialog.setTitle("تحديد  المهام");
                dialog.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                        if (item == 0) {
                            // update
                            Cursor c = MainActivity.sqLiteHelper.getData("SELECT id FROM STUDENT");
                            ArrayList<Integer> arrID = new ArrayList<Integer>();
                            while (c.moveToNext()){
                                arrID.add(c.getInt(0));
                            }
                            // show dialog update at here
                            showDialogUpdate(StudentList.this, arrID.get(position));

                        } else {
                            // delete
                            Cursor c = MainActivity.sqLiteHelper.getData("SELECT id FROM STUDENT");
                            ArrayList<Integer> arrID = new ArrayList<Integer>();
                            while (c.moveToNext()){
                                arrID.add(c.getInt(0));
                            }
                            showDialogDelete(arrID.get(position));
                        }
                    }
                });
                dialog.show();
                return true;
            }
        });
    }

    ImageView imageViewFood;
    DatePickerDialog datePickerDialog1,datePickerDialog2;
    private void showDialogUpdate(Activity activity, final int position){

        final Dialog dialog = new Dialog(activity);
        dialog.setContentView(R.layout.update_student_activity);
        dialog.setTitle("تحديث");

        imageViewFood = (ImageView) dialog.findViewById(R.id.imageViewStudent);
        final EditText edtName = (EditText) dialog.findViewById(R.id.edtName);
        final EditText edtEmail = (EditText) dialog.findViewById(R.id.edtEmail);
        final EditText edtType = (EditText) dialog.findViewById(R.id.edtType);
        final EditText edtAddress = (EditText) dialog.findViewById(R.id.edtAddress);
        final EditText edtAssurnce = (EditText) dialog.findViewById(R.id.edtAssurance);
        final EditText edtdate_Sing = (EditText) dialog.findViewById(R.id.edtDate_sing);
        final EditText edtDate_Burn = (EditText) dialog.findViewById(R.id.edtDate_burn);


        Button btnUpdate = (Button) dialog.findViewById(R.id.btnUpdate);

        // set width for dialog
        int width = (int) (activity.getResources().getDisplayMetrics().widthPixels * 0.95);
        // set height for dialog
        int height = (int) (activity.getResources().getDisplayMetrics().heightPixels * 0.7);
        dialog.getWindow().setLayout(width, height);
        dialog.show();

        imageViewFood.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
            @Override
            public void onClick(View v) {
                // request photo library
                ActivityCompat.requestPermissions(
                        StudentList.this,
                        new String[]{Manifest.permission.READ_MEDIA_VIDEO,
                                Manifest.permission.READ_MEDIA_IMAGES,
                                Manifest.permission.READ_EXTERNAL_STORAGE
                        },
                        888
                );
            }
        });
edtdate_Sing.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        final Calendar calendar = Calendar.getInstance();
        int the_Year = calendar.get(Calendar.YEAR);
        int the_Month = calendar.get(Calendar.MONTH);
        int the_Day = calendar.get(Calendar.DAY_OF_MONTH);
        datePickerDialog1  = new DatePickerDialog(StudentList.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                     edtdate_Sing.setText(dayOfMonth + "/"+month+"/"+year);
                    }
                },the_Year,the_Month,the_Day);
        datePickerDialog1.show();
    }
});
edtDate_Burn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        final Calendar calendar = Calendar.getInstance();
        int the_Year = calendar.get(Calendar.YEAR);
        int the_Month = calendar.get(Calendar.MONTH);
        int the_Day = calendar.get(Calendar.DAY_OF_MONTH);
        datePickerDialog2 = new DatePickerDialog(StudentList.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        edtDate_Burn.setText(dayOfMonth + "/"+month+"/"+year);
                    }
                },the_Year,the_Month,the_Day);
        datePickerDialog2.show();
    }
});
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    MainActivity.sqLiteHelper.updateData(
                            edtName.getText().toString().trim(),
                            edtEmail.getText().toString().trim(),
                            edtType.getText().toString().trim(),
                            edtAddress.getText().toString().trim(),
                            edtAssurnce.getText().toString().trim(),
                            edtdate_Sing.getText().toString().trim(),
                            edtDate_Burn.getText().toString().trim(),
                            MainActivity.imageViewToByte(imageViewFood),
                            position
                    );
                    dialog.dismiss();
                    Toast.makeText(getApplicationContext(), "تم التحديث بنجاح",Toast.LENGTH_SHORT).show();
                }
                catch (Exception error) {
                    Log.e("خطأ في  التحديث", error.getMessage());
                }
                updateFoodList();
            }
        });
    }

    private void showDialogDelete(final int idFood){
        final AlertDialog.Builder dialogDelete = new AlertDialog.Builder(StudentList.this);

        dialogDelete.setTitle("تنبيه!!");
        dialogDelete.setMessage("هل انت متأكد من  حذف هذه المعطيات");
        dialogDelete.setPositiveButton("نعم", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                try {
                    MainActivity.sqLiteHelper.deleteData(idFood);
                    Toast.makeText(getApplicationContext(), "تم الحدف بنجاح",Toast.LENGTH_SHORT).show();
                } catch (Exception e){
                    Log.e("خطأ", e.getMessage());
                }
                updateFoodList();
            }
        });

        dialogDelete.setNegativeButton("إلغاء", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialogDelete.show();
    }

    private void updateFoodList(){
        // get all data from sqlite
        Cursor cursor = MainActivity.sqLiteHelper.getData("SELECT * FROM STUDENT");
        list.clear();
        while (cursor.moveToNext()) {
               int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String email = cursor.getString(2);
            String type = cursor.getString(3);
            String address = cursor.getString(4);
            String assurance = cursor.getString(5);
            String date_sing = cursor.getString(6);
            String date_burn = cursor.getString(7);
            byte[] image = cursor.getBlob(8);

            list.add(new Stoudent(id,name,email,type,address,assurance,date_sing,date_burn,image));
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if(requestCode == 888){
            if(grantResults.length >0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, 888);
            }
            else {
                Toast.makeText(getApplicationContext(), "ليس لديكم الصلاحيات ", Toast.LENGTH_SHORT).show();
            }
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == 888 && resultCode == RESULT_OK && data != null){
            Uri uri = data.getData();
            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                imageViewFood.setImageBitmap(bitmap);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}