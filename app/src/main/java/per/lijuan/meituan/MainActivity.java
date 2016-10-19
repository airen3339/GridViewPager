package per.lijuan.meituan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.kerchin.widget.GridItemClickListener;
import com.kerchin.widget.GridItemLongClickListener;
import com.kerchin.widget.GridViewPager;
import com.kerchin.widget.ImageSetListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String[] titles = {"美食", "电影", "酒店住宿", "休闲娱乐", "外卖", "自助餐", "KTV", "机票/火车票", "周边游", "美甲美睫",
            "火锅", "生日蛋糕", "甜品饮品", "水上乐园", "汽车服务", "美发", "丽人", "景点", "足疗按摩", "运动健身", "健身", "超市", "买菜",
            "今日新单", "小吃快餐", "面膜", "洗浴/汗蒸", "母婴亲子", "生活服务", "婚纱摄影", "学习培训", "家装", "结婚", "全部分配"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridViewPager mGridViewPager = (GridViewPager) findViewById(R.id.mGridViewPager);
        //初始化数据源
        mGridViewPager
                .setImageSetListener(new ImageSetListener() {
                    @Override
                    public void setImage(ImageView iv, int pos) {
                        iv.setBackgroundResource(mImgRes.get(pos));
                    }
                })
                .setData(initData())
                .setGridItemClickListener(new GridItemClickListener() {
                    @Override
                    public void click(int pos, int position, String str) {
                        Log.d("123", pos + "/" + str);
                    }
                })
                .setGridItemLongClickListener(new GridItemLongClickListener() {
                    @Override
                    public void click(int pos, int position, String str) {
                        Log.d("456", pos + "/" + str);
                    }
                });
    }

    List<String> mData;
    List<Integer> mImgRes;

    /**
     * 初始化数据源
     */
    private List<String> initData() {
        mData = new ArrayList<String>();
        mImgRes = new ArrayList<Integer>();
        for (int i = 0; i < titles.length; i++) {
            //动态获取资源ID，第一个参数是资源名，第二个参数是资源类型例如drawable，string等，第三个参数包名
            int imageId = getResources().getIdentifier("ic_category_" + i, "mipmap", getPackageName());
            mData.add(titles[i]);
            mImgRes.add(imageId);
        }
        return mData;
    }
}