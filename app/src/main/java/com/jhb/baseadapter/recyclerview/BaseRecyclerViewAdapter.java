package com.jhb.baseadapter.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by jhb on 2018/1/29.
 */

public abstract class BaseRecyclerViewAdapter<T> extends RecyclerView.Adapter<BaseRecyclerViewHolder> {
    public List<T> dataList;

    public BaseRecyclerViewAdapter(List<T> dataList) {
        this.dataList = dataList;
    }

    @Override
    public BaseRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(getLayoutId(viewType), parent, false);
        return new BaseRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final BaseRecyclerViewHolder holder, final int position) {
        fillData(holder, dataList.get(position), getItemType(position), position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.OnItemClick(position, holder.itemView, holder);
                }
            }
        });
    }

    @Override
    public int getItemViewType(int position) {
        return getItemType(position);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    /**
     * @param viewType
     * @return 布局id
     */
    protected abstract int getLayoutId(int viewType);

    /**
     * @param position
     * @return 条目类型
     */
    protected abstract int getItemType(int position);

    /**
     * @param holder   继承ViewHolder的holder
     * @param t        传入的数据
     * @param itemType 条目类型
     * @param position
     */
    protected abstract void fillData(BaseRecyclerViewHolder holder, T t, int itemType, int position);

    private OnItemClickListener listener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public interface OnItemClickListener {
        void OnItemClick(int position, View itemView, BaseRecyclerViewHolder holder);
    }
}
