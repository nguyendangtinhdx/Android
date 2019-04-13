package com.example.nguyendangtinh.facebook;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.VideoView;

import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import com.facebook.share.widget.ShareDialog;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class ManHinhChucNang extends AppCompatActivity {

    EditText edttitle, edtdescript,edturl;
    Button btnsharelink,btnshareimage,btnpickvideo,btnsharevideo;
    ImageView imghinhanh;
    VideoView videoview;

    ShareDialog shareDialog; //8
    ShareLinkContent shareLinkContent; //8

    public static int Select_Image = 1;
    public static int Pick_Video = 2;
    Bitmap bitmap;
    Uri selectvideo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_chuc_nang);
        Anhxa();
        shareDialog = new ShareDialog(ManHinhChucNang.this);
        btnsharelink.setOnClickListener(new View.OnClickListener() { // share link
            @Override
            public void onClick(View view) {
                  if (ShareDialog.canShow(ShareLinkContent.class)){
                      shareLinkContent = new ShareLinkContent.Builder()
                      .setContentTitle(edttitle.getText().toString())
                      .setContentDescription(edtdescript.getText().toString())
                      .setContentUrl(Uri.parse(edturl.getText().toString()))
                      .build();
                  }
                  shareDialog.show(shareLinkContent);
            }
        });
        imghinhanh.setOnClickListener(new View.OnClickListener() { // import image
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,Select_Image);
            }
        });
        btnshareimage.setOnClickListener(new View.OnClickListener() {  // share image
            @Override
            public void onClick(View view) {
                SharePhoto photo = new SharePhoto.Builder()
                        .setBitmap(bitmap)
                        .build ();
                SharePhotoContent content = new SharePhotoContent.Builder()
                        .addPhoto(photo)
                        .build();
                shareDialog.show(content);
            }
        });

        btnpickvideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("video/*");
                startActivityForResult(intent,Pick_Video);
            }
        });
        btnsharevideo.setOnClickListener(new View.OnClickListener() {
            ShareVideo shareVideo = null;
            @Override
            public void onClick(View view) {
                shareVideo = new ShareVideo.Builder()
                        .setLocalUrl(selectvideo)
                        .build();
                ShareVideoContent content = new ShareVideoContent.Builder()
                        .setVideo(shareVideo)
                        .build();
                shareDialog.show(content);
                videoview.stopPlayback(); // khi share nó sẽ dừng video đang chạy
            }
        });
    }

    private void Anhxa() {
        edttitle = (EditText) findViewById(R.id.edittexttitle);
        edtdescript = (EditText) findViewById(R.id.edittextdescription);
        edturl = (EditText) findViewById(R.id.edittexturl);
        btnsharelink = (Button) findViewById(R.id.buttonsharelink);
        btnshareimage = (Button) findViewById(R.id.buttonshareimage);
        btnpickvideo = (Button) findViewById(R.id.buttonpickvideo);
        btnsharevideo = (Button) findViewById(R.id.buttonsharevideo);
        imghinhanh = (ImageView)findViewById(R.id.imagehinh);
        videoview = (VideoView)findViewById(R.id.videoview);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       if (requestCode == Select_Image && resultCode == RESULT_OK){ // image
           try {
               InputStream inputStream = getContentResolver().openInputStream(data.getData());
               bitmap = BitmapFactory.decodeStream(inputStream);
               imghinhanh.setImageBitmap(bitmap);
           } catch (FileNotFoundException e) {
               e.printStackTrace();
           }
       }
          if (requestCode == Pick_Video && requestCode == RESULT_OK){ // video
                selectvideo = data.getData();
              videoview.setVideoURI(selectvideo);
              videoview.start();
          }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
