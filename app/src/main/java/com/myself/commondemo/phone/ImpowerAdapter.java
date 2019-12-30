package com.myself.commondemo.phone;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.myself.commondemo.R;

import java.util.List;
import java.util.Map;

public class ImpowerAdapter extends BaseAdapter {
    private Context context;
    private List<Map<String, String>> list;

    public ImpowerAdapter(Context context, List<Map<String, String>> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private ImpowerCustomHolder holder;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.slv_impower_item, parent, false);
            holder = new ImpowerCustomHolder();
            holder.ivImg = convertView.findViewById(R.id.iv_impower_item_img);
            holder.tvName = convertView.findViewById(R.id.tv_impower_item_name);
            holder.tvDuration = convertView.findViewById(R.id.tv_impower_item_duration);
            holder.tvTimeLead = convertView.findViewById(R.id.tv_impower_item_time_lead);
            convertView.setTag(holder);
        } else {
            holder = (ImpowerCustomHolder) convertView.getTag();
        }
        /**
         * 通话类型
         */
        if (TextUtils.equals((list.get(position).get("type") + ""), "打入")) { //"打入"
            holder.ivImg.setImageResource(R.drawable.icon_callin);
            holder.tvDuration.setTextColor(context.getResources().getColor(R.color.colorBlack));
            holder.tvDuration.setText("打入通话时长"+list.get(position).get("duration") + "");// 通话时长
        } else if (TextUtils.equals((list.get(position).get("type") + ""), "打出")) {  //"打出"
            if ("0秒".equals(list.get(position).get("duration"))){//判断通话时长为0秒则表示打出电话未接通
                holder.ivImg.setImageResource(R.drawable.icon_callup);
                holder.tvDuration.setTextColor(context.getResources().getColor(R.color.colorBlack));
                holder.tvDuration.setText("打出电话对方未接");// 通话时长
            }else {//通话时长大于0秒则表示打出电话接通
                holder.ivImg.setImageResource(R.drawable.icon_callup);
                holder.tvDuration.setTextColor(context.getResources().getColor(R.color.colorBlack));
                holder.tvDuration.setText("打出通话时长"+list.get(position).get("duration") + "");// 通话时长
            }

        } else if (TextUtils.equals((list.get(position).get("type") + ""), "未接")) { //"未接"
            holder.ivImg.setImageResource(R.drawable.icon_busy);
            holder.tvDuration.setTextColor(context.getResources().getColor(R.color.colorPrimaryDark,null));
            holder.tvDuration.setText("呼入未接通");// 通话时长
        } else {
            holder.ivImg.setImageResource(R.drawable.icon_unavailable);
            holder.tvDuration.setTextColor(context.getResources().getColor(R.color.colorBlue));
            holder.tvDuration.setText("呼入挂断");// 通话时长
        }
        /**
         * 通话记录的联系人
         */
        if (TextUtils.equals((list.get(position).get("name") + ""), "未备注联系人")) {// 通话记录的联系人
            holder.tvName.setText(list.get(position).get("number"));// 通话记录的联系人
        } else {
            holder.tvName.setText(list.get(position).get("name") + "(" + list.get(position).get("number") + ")");// 通话记录的联系人
        }
        holder.tvTimeLead.setText(list.get(position).get("date") + "  " + list.get(position).get("time"));// 通话距离
        return convertView;
    }

    class ImpowerCustomHolder {
        private ImageView ivImg;//图标
        private TextView tvName,//名字
                tvDuration,//时长
                tvTimeLead;//时间差
    }

}
