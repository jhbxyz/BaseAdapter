package com.jhb.baseadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.jhb.baseadapter.recyclerview.BaseRecyclerViewAdapter;
import com.jhb.baseadapter.recyclerview.BaseRecyclerViewHolder;

import java.util.ArrayList;
import java.util.List;

public class RecylerViewActivity extends AppCompatActivity {
    private List<MessageBean> messageBeans = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);

        for (int i = 0; i < 100; i++) {
            if (i % 5 == 0) {
                messageBeans.add(new MessageBean("标题RecyclerView - " + i, MyRvAdaprer.TYPE_TITLE));
            } else {
                messageBeans.add(new MessageBean("ITEM - " + i, MyRvAdaprer.TYPE_CONTENT));
            }

        }

        RecyclerView rv = findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        final MyRvAdaprer myRvAdaprer = new MyRvAdaprer(messageBeans);
        rv.setAdapter(myRvAdaprer);

        myRvAdaprer.setOnItemClickListener(new BaseRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(final int position, final View itemView, BaseRecyclerViewHolder holder) {
                //条目点击
                Toast.makeText(itemView.getContext(), "点击了-" + position, Toast.LENGTH_SHORT).show();
                //条目中的View点击
                if (myRvAdaprer.getItemType(position) == MyRvAdaprer.TYPE_TITLE) {
                    holder.getView(R.id.tvTitle).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(itemView.getContext(), "标题 - " + position, Toast.LENGTH_SHORT).show();
                        }
                    });
                }

            }
        });

    }

    private class MyRvAdaprer extends BaseRecyclerViewAdapter<MessageBean> {
        private static final int TYPE_TITLE = 0;
        private static final int TYPE_CONTENT = 1;

        private MyRvAdaprer(List<MessageBean> dataList) {
            super(dataList);
        }

        @Override
        protected int getLayoutId(int viewType) {
            if (viewType == TYPE_TITLE) {
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
        protected void fillData(BaseRecyclerViewHolder holder, MessageBean messageBean, int itemType, int position) {
            if (itemType == TYPE_TITLE) {
                holder.setText(R.id.tvTitle, messageBean.content);
            } else {
                holder.setText(R.id.tvContent, messageBean.content);
            }

        }
    }
}
