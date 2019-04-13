package com.example.nguyendangtinh.listview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import BLL.GiangVienBLL;
import BLL.LopBLL;
import BLL.SinhVienBLL;
import Entities.GiangVien;
import Entities.Lop;
import Entities.SinhVien;

public class MainActivity extends AppCompatActivity {
    ArrayList<Lop> danhSachLop;
    ListView lvLop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        danhSachLop = LopBLL.getList();
        LopAdapter lopAdapter = new LopAdapter(
                this,
                R.layout.itemrowclasslayout,
                danhSachLop
        );

//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
//                this,android.R.layout.simple_list_item_1,danhSachLop
//        );
        lvLop = (ListView)findViewById(R.id.lvLop);
        lvLop.setAdapter(lopAdapter);
    }
//    static ArrayList<String> getData(){
//        ArrayList<String> lsData = new ArrayList<>();
//        lsData.add("TinK38A");
//        lsData.add("TinK38B");
//        lsData.add("TinK38C");
//        lsData.add("TinK38D");
//        lsData.add("TinK39A");
//        lsData.add("TinK39B");
//        return  lsData;
//    }
}

class LopAdapter extends ArrayAdapter<Lop>{
    Activity context;
    int resource;
    ArrayList<Lop> lsLop;

    public LopAdapter(@NonNull Activity context, @LayoutRes int resource,  @NonNull ArrayList<Lop> objects) {
        super(context, resource, objects);


        this.context = context;
        this.resource = resource;
        this.lsLop = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if(view == null)
            view = context.getLayoutInflater().inflate(resource,null);
        final TextView txtTenGiaoVien = (TextView)view.findViewById(R.id.txtTen);
        TextView txtTenLop = (TextView)view.findViewById(R.id.txtTenLop);
        TextView txtSiSo= (TextView)view.findViewById(R.id.txtSiSo);
        ImageView imgGiaoVien = (ImageView)view.findViewById(R.id.imdGiaoVien);
        ImageView imgDanhSachSinhVien = (ImageView) view.findViewById(R.id.imgDanhSachSinhVien);

        final Lop lop = lsLop.get(position);
        txtTenGiaoVien.setText(lop.getTenGiaoVienCoVan());
        txtTenLop.setText(lop.getTenLop());
        txtSiSo.setText("Sĩ số: "+ lop.getSiSo() + " sinh viên");
        imgGiaoVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Thông tin giảng viên");
                View view1 = context.getLayoutInflater().inflate(R.layout.lecturelayout,null);
                TextView txtTenGiaoVien = view1.findViewById(R.id.txtTenGiaoVien);
                TextView txtNgaySinh = view1.findViewById(R.id.txtNgaySinh);
                TextView txtNoiSinh = view1.findViewById(R.id.txtNoiSinh);
                TextView txtGioiTinh = view1.findViewById(R.id.txtGioiTinh);

                GiangVien giangVien = GiangVienBLL.getByID(lop.getMaGiangVien());
                if(giangVien != null){
                    txtTenGiaoVien.setText(giangVien.getHoTen());
                    txtNgaySinh.setText(giangVien.getNgaySinh());
                    txtNoiSinh.setText(giangVien.getNoiSinh());

                    if(giangVien.isGioiTinh())
                        txtGioiTinh.setText("Nam");
                    else
                        txtGioiTinh.setText("Nữ");
                }

                builder.setView(view1);
                builder.create().show();
            }
        });

        imgDanhSachSinhVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                View view1 = context.getLayoutInflater().inflate(R.layout.liststudent,null);
                TextView txtMaSinhVien = view1.findViewById(R.id.txtMaSinhVien);
                TextView txtTenSinhVien = view1.findViewById(R.id.txtTenSinhVien);
                TextView txtDiaChi = view1.findViewById(R.id.txtDiaChi);

                SinhVien sinhVien = SinhVienBLL.getSinhVienByIDLop(lop.getMaLop());
                if(sinhVien != null){
                    txtMaSinhVien.setText(sinhVien.getMaSinhVien());
                    txtTenSinhVien.setText(sinhVien.getTenSinhVien());
                    txtDiaChi.setText(sinhVien.getDiaChi());
                }
                builder.setView(view1);
                builder.create().show();
            }
        });

        return view;
    }


}
