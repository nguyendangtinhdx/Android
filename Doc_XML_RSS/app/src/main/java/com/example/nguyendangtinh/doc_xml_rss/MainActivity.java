package com.example.nguyendangtinh.doc_xml_rss;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        runOnUiThread(new Runnable() { // yêu cầu chạy Async
            @Override
            public void run() {
                new ReadXML().execute("https://vnexpress.net/rss/tin-moi-nhat.rss");
            }
        });
    }
    // 1:String (đại diện URL) 2: Integer(bắt con số tải về máy là bao nhiêu) 3: kết quả trả ra là String
    class ReadXML extends AsyncTask<String,Integer,String>{ // đọc dữ liệu của đường dẫn truyền vào sau khi tải chuỗi về

        @Override
        protected String doInBackground(String... strings) {
            String kq = docNoiDung_Tu_URL(strings[0]); // đọc dữ liệu ra
            return kq;
        }

        @Override
        protected void onPostExecute(String s) {
//            super.onPostExecute(s);
//            Toast.makeText(MainActivity.this,s,Toast.LENGTH_LONG).show();

            // đọc XML
            XMLDOMParser parser = new XMLDOMParser(); // parser chứa hàm tương tác với XML
            Document doc = parser.getDocument(s); // all nội dung của s chứa trong biến doc
            NodeList nodeList = doc.getElementsByTagName("item"); // đọc các item

            String kq = "";
            for (int i = 0; i < nodeList.getLength();i++){
                Element e = (Element) nodeList.item(i); // nodeList phần tử thứ i
                kq = kq + parser.getValue(e,"title"); // đọc thẻ title
            }
            Toast.makeText(MainActivity.this,kq,Toast.LENGTH_LONG).show();
        }
    }

    private String docNoiDung_Tu_URL(String theUrl){
        StringBuilder content = new StringBuilder();
        try    {
            // create a url object
            URL url = new URL(theUrl);

            // create a urlconnection object
            URLConnection urlConnection = url.openConnection();

            // wrap the urlconnection in a bufferedreader
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String line;

            // read from the urlconnection via the bufferedreader
            while ((line = bufferedReader.readLine()) != null){
                content.append(line + "\n");
            }
            bufferedReader.close();
        }
        catch(Exception e)    {
            e.printStackTrace();
        }
        return content.toString();
    }
}
