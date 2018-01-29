package com.jhb.baseadapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.jhb.baseadapter.listview.BaseListViewAdapter;
import com.jhb.baseadapter.listview.BaseListViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jhb on 2018/1/29.
 */

public class ListViewActivity extends AppCompatActivity {
    private List<String> list = new ArrayList<>();
    private List<MessageBean> messageBeans = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        ListView lv = findViewById(R.id.lv);
        for (int i = 0; i < 100; i++) {
            list.add("条目FFFF - " + i);
        }

        for (int i = 0; i < 100; i++) {
            if (i % 5 == 0) {
                messageBeans.add(new MessageBean("标题ListView - " + i, MyLvAdapter.TYPE_TITLE));
            } else {
                messageBeans.add(new MessageBean("ITEM - " + i, MyLvAdapter.TYPE_CONTENT));
            }

        }

        lv.setAdapter(new MyLvAdapter(messageBeans, 2));

    }

    private class MyLvAdapter extends BaseListViewAdapter<MessageBean> {
        private static final int TYPE_TITLE = 0;
        private static final int TYPE_CONTENT = 1;

        /**
         * @param dataList      数据
         * @param itemTypeCount 条目类型的个数
         */
        public MyLvAdapter(List<MessageBean> dataList, int itemTypeCount) {
            super(dataList, itemTypeCount);
        }

        @Override
        protected int getlayoutId(int itemType) {
            if (itemType == TYPE_TITLE) {
                return R.layout.item_rv_title;
            } else {
                return R.layout.item_rv_content;
            }
        }

        @Override
        protected int getItemType(int position) {
            return dataList.get(position).type;
        }


        @Override
        protected void convert(BaseListViewHolder holder, MessageBean s, int itemType, int position) {
            if (itemType == TYPE_TITLE) {
                holder.setText(R.id.tvTitle, s.content);
            } else {
                holder.setText(R.id.tvContent, s.content);
            }

        }

    }
}
