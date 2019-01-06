package com.example.rathana.adapter_demo;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.rathana.adapter_demo.model.Article;
import com.example.rathana.adapter_demo.util.CurrentDateTimeHelper;

public class AddAmsActivity extends AppCompatActivity {

    private static final int PICK_IMAGE_CODE = 3;
    ImageView thumb;
    EditText title,author;

    String thumbName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_ams);

        checkRuntimePermission();

        thumb=findViewById(R.id.thumb);
        title=findViewById(R.id.title);
        author=findViewById(R.id.author);

        thumb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickImage();
            }
        });
    }

    private void pickImage() {
        Intent intent=new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        startActivityForResult(intent,PICK_IMAGE_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==PICK_IMAGE_CODE && resultCode==RESULT_OK){
            Uri uri= data.getData();
            try{
                String[] columnInfo={MediaStore.Images.Media.DATA};
                Cursor cursor=getContentResolver().
                        query(uri,columnInfo,null,null,null);

                cursor.moveToFirst();
                int columnIndex= cursor.getColumnIndex(columnInfo[0]);
                thumbName=cursor.getString(columnIndex);

                //covert image uri to bitmap
                Bitmap bitmap=BitmapFactory.decodeFile(thumbName);
                thumb.setImageBitmap(bitmap);

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void onSaveArticle(View view) {

        Article article=new Article();
        article.setTitle(title.getText().toString());
        article.setAuthorName(author.getText().toString());
        article.setThumb(thumbName==null?"":thumbName);
        article.setDate(CurrentDateTimeHelper.getCurrentDate().toString());

        Bundle b=new Bundle();
        b.putParcelable("data",article);
        Intent i=new Intent();
        i.putExtras(b);
        setResult(RESULT_OK,i);
        finish();

    }


    private void checkRuntimePermission(){
        if(ContextCompat.checkSelfPermission(this,Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED){
            //request Permission
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},99);

        }
    }

}
