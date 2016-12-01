package org.ninetripods.mq.badgeviewpro;

import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.ninetripods.mq.badgelibrary.BadgeViewPro;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv_recycle_view;
    private MyAdapter mAdatper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv_recycle_view = (RecyclerView) findViewById(R.id.rv_recycle_view);
        rv_recycle_view.addItemDecoration(new DividerItemDecoration());
        rv_recycle_view.setLayoutManager(new LinearLayoutManager(this));
        mAdatper = new MyAdapter();
        rv_recycle_view.setAdapter(mAdatper);
//        bv_view1.setStrColor(Color.parseColor("#ffffff"))//文本字体颜色
//                .setStrSize(10)//文本字体大小
//                .setMargin(15, 0, 15, 0)//目标View的Margin
//                .setStrBgColor(Color.parseColor("#000000"))//文本背景颜色
//                .setStrText("99+")//设置文本
//                .setShape(BadgeViewPro.SHAPE_OVAL)//文本背景形状
//                .setBgGravity(Gravity.CENTER)//文本背景位置
//                .setTargetView(iv_icon);
    }


    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = null;
            switch (viewType) {
                case 0:
                    //目标view是ImageView
                    itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycle_img_view, parent, false);
                    break;
                case 1:
                    //目标view是TextView
                    itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycle_text_view, parent, false);
                    break;
                case 2:
                    //目标view是RelativeLayout
                    itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycle_relativelayout, parent, false);
                    break;
                case 3:
                    //目标view是LinearLayout
                    itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycle_linearlayout, parent, false);
                    break;
            }
            return new MyViewHolder(itemView, viewType);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 4;
        }

        @Override
        public int getItemViewType(int position) {
            switch (position) {
                case 0:
                    //ImageView
                    return 0;
                case 1:
                    //TextView
                    return 1;
                case 2:
                    //RelativeLayout
                    return 2;
                case 3:
                    //LinearLayout
                    return 3;
                default:
                    return super.getItemViewType(position);
            }
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            ImageView iv_img1, iv_img2, iv_img3, iv_img4, iv_img5, iv_img6, iv_img7, iv_img8;
            TextView tv_text;
            RelativeLayout rl_layout;
            LinearLayout ll_layout;

            MyViewHolder(View itemView, int viewType) {
                super(itemView);
                switch (viewType) {
                    case 0:
                        iv_img1 = (ImageView) itemView.findViewById(R.id.iv_img1);
                        final BadgeViewPro bv1 = new BadgeViewPro(MainActivity.this);
                        bv1.setStrText("10").setMargin(10, 3, 10, 0).setStrSize(10).setTargetView(iv_img1);
                        iv_img2 = (ImageView) itemView.findViewById(R.id.iv_img2);
                        BadgeViewPro bv2 = new BadgeViewPro(MainActivity.this);
                        bv2.setStrText("1").setTargetView(iv_img2);
                        iv_img3 = (ImageView) itemView.findViewById(R.id.iv_img3);
                        BadgeViewPro bv3 = new BadgeViewPro(MainActivity.this);
                        bv3.setStrText("99+").setTargetView(iv_img3);
                        iv_img4 = (ImageView) itemView.findViewById(R.id.iv_img4);
                        BadgeViewPro bv4 = new BadgeViewPro(MainActivity.this);
                        bv4.setTargetView(iv_img4);
                        iv_img5 = (ImageView) itemView.findViewById(R.id.iv_img5);
                        BadgeViewPro bv5 = new BadgeViewPro(MainActivity.this);
                        bv5.setMargin(10, 3, 10, 0).setStrText("新").setShape(BadgeViewPro.SHAPE_ROUND_RECTANGLE).setTargetView(iv_img5);
                        iv_img6 = (ImageView) itemView.findViewById(R.id.iv_img6);
                        BadgeViewPro bv6 = new BadgeViewPro(MainActivity.this);
                        bv6.setStrText("矩形").setShape(BadgeViewPro.SHAPE_RECTANGLE).setTargetView(iv_img6);
                        iv_img7 = (ImageView) itemView.findViewById(R.id.iv_img7);
                        BadgeViewPro bv7 = new BadgeViewPro(MainActivity.this);
                        bv7.setStrText("椭圆").setBgGravity(Gravity.START | Gravity.TOP).setShape(BadgeViewPro.SHAPE_OVAL).setTargetView(iv_img7);
                        iv_img8 = (ImageView) itemView.findViewById(R.id.iv_img8);
                        BadgeViewPro bv8 = new BadgeViewPro(MainActivity.this);
                        bv8.setStrText("圆").setBgGravity(Gravity.END | Gravity.TOP).setShape(BadgeViewPro.SHAPE_CIRCLE).setTargetView(iv_img8);
                        break;
                    case 1:
                        tv_text = (TextView) itemView.findViewById(R.id.tv_text);
                        BadgeViewPro bvt1 = new BadgeViewPro(MainActivity.this);
                        bvt1.setStrText("10")
                                .setStrBgColor(Color.parseColor("#000000"))
                                .setShape(BadgeViewPro.SHAPE_OVAL)
                                .setStrSize(10)
                                .setMargin(10, 10, 10, 10)
                                .setTargetView(tv_text);
                        break;
                    case 2:
                        rl_layout = (RelativeLayout) itemView.findViewById(R.id.rl_layout);
                        BadgeViewPro bv_r = new BadgeViewPro(MainActivity.this);
                        bv_r.setStrText("10")
                                .setStrBgColor(Color.parseColor("#88dc4d"))
                                .setStrSize(10)
                                .setBgGravity(Gravity.END | Gravity.CENTER_VERTICAL)
                                .setTargetView(rl_layout);
                        break;
                    case 3:
                        ll_layout = (LinearLayout) itemView.findViewById(R.id.ll_layout);
                        BadgeViewPro bv_ll = new BadgeViewPro(MainActivity.this);
                        bv_ll.setStrText("999+")
                                .setStrBgColor(Color.parseColor("#3F51B5"))
                                .setStrSize(10)
                                .setBgGravity(Gravity.START | Gravity.TOP)
                                .setTargetView(ll_layout);
                        break;
                }
            }
        }
    }
}
