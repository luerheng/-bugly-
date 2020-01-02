package com.myself.commondemo.contracts;

import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.myself.commondemo.R;
import com.myself.commondemo.utils.CommonUtils;

public class ContractsActivity extends AppCompatActivity {
    final String[] protocols = {
            "《测试产品认购合同》",
            "《测试注册申请合同》",
            "《测试系统服务合同》",
            "《测试中心服务合同》",
            "《测试第三方代理协议》"
    };

    String[] tags = {"精华", "活动","推荐"};
    private boolean isChecked;
    private SpannableStringBuilder spannableStringBuilder;
    private TextView mView;
    private TextView tv_tag;
    private ImageSpan unselectSpan;
    private ImageSpan selectSpan;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contracts);
        initView();
    }

    private void initView() {
        mView = findViewById(R.id.mview);
        tv_tag = findViewById(R.id.tv_tag);
        final String string = "  已阅读并同意";
        //图标(默认位选中)
        spannableStringBuilder = new SpannableStringBuilder(string);
//        unselectSpan = new ImageSpan(this,R.drawable.checked_nor2x);
//        selectSpan = new ImageSpan(this,R.drawable.checked_pre2x);
//        spannableStringBuilder.setSpan(unselectSpan,0,1,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        setIconSapn(spannableStringBuilder,R.drawable.checked_nor2x);
        mView.setText(getText());
        tv_tag.setText(getTagText1(tags));
        mView.setMovementMethod(LinkMovementMethod.getInstance());
        tv_tag.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private SpannableStringBuilder getTagText(String[] tags) {
        SpannableStringBuilder stringBuilder = new SpannableStringBuilder();
        for (final String tag : tags) {
            String thisTag = " " + tag + " ";
            stringBuilder.append(thisTag);
            RoundedBackgroundSpan span;
            ClickableSpan clickableSpan = new ClickableSpan() {
                @Override
                public void onClick(View widget) {
                    CommonUtils.showToast(ContractsActivity.this,"点击"+tag);
                }

                @Override
                public void updateDrawState(TextPaint ds) {
                    super.updateDrawState(ds);
                    ds.setUnderlineText(false);
                    ds.setColor(getResources().getColor(R.color.colorBlue));
                }
            };
            if("活动".equals(tag)){
                span= new RoundedBackgroundSpan(ContextCompat.getColor(this,R.color.colorAccent), ContextCompat.getColor(this,R.color.colorWhrite));
            }else if ("推荐".equals(tag)){
                span= new RoundedBackgroundSpan(ContextCompat.getColor(this,R.color.colorPrimary), ContextCompat.getColor(this,R.color.colorWhrite));
            }else{
                span= new RoundedBackgroundSpan(ContextCompat.getColor(this,R.color.colorBlue), ContextCompat.getColor(this,R.color.colorWhrite));
            }
            stringBuilder.setSpan(span, stringBuilder.length() - thisTag.length(), stringBuilder.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            stringBuilder.setSpan(clickableSpan, stringBuilder.length() - thisTag.length(), stringBuilder.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            stringBuilder.append(" ");
        }
        stringBuilder.append("符合规划有大哥好地方规划的,法规和公司法规和豆腐干和!");
        return stringBuilder;
    }

    private SpannableStringBuilder getText(){
        //选择按钮的点击事件
//        ClickableSpan imagClick = new ClickableSpan() {
//            @Override
//            public void onClick(View widget) {
//                CommonUtils.showToast(ContractsActivity.this,"点击了");
//                //显示协议内容
//                if (isChecked) {
//                    spannableStringBuilder.setSpan(unselectSpan,0,1,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
////                    setIconSapn(spannableStringBuilder, R.drawable.icon_unselect);
//                } else {
////                    setIconSapn(spannableStringBuilder, R.drawable.icon_select);
//                    spannableStringBuilder.setSpan(selectSpan,0,1,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//                }
//                isChecked = !isChecked;
//            }
//
//            @Override
//            public void updateDrawState(TextPaint ds) {
//                super.updateDrawState(ds);
//                ds.setUnderlineText(false);
//                ds.setColor(Color.WHITE);
//            }
//        };
//        spannableStringBuilder.setSpan(imagClick, 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        for (int i = 0; i < protocols.length; i++) {
            final String protocol = protocols[i];
            SpannableStringBuilder protocolStringBuild = new SpannableStringBuilder(protocol);
            //协议
            //点击span
            final int finalI = i;
            ClickableSpan clickableSpan = new ClickableSpan() {
                @Override
                public void onClick(View widget) {
                    //显示协议内容
//                    mView.setText(chart, finalI, protocols.length);
                    CommonUtils.showToast(ContractsActivity.this,"协议"+finalI);
                }

                @Override
                public void updateDrawState(TextPaint ds) {
                    super.updateDrawState(ds);
                    ds.setUnderlineText(false);
                    ds.setColor(getResources().getColor(R.color.colorBlue));
                }
            };
            protocolStringBuild.setSpan(clickableSpan, 0, protocol.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            //前景
//            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(mView.getResources().getColor(R.color.colorBlue));
//            protocolStringBuild.setSpan(foregroundColorSpan, 0, protocol.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            spannableStringBuilder.append(protocolStringBuild);
            //点
            if (i != protocols.length - 1) {
                SpannableStringBuilder dotStringBuild = new SpannableStringBuilder("、");
                ForegroundColorSpan dotSpan = new ForegroundColorSpan(mView.getResources().getColor(R.color.colorBlack));
                dotStringBuild.setSpan(dotSpan, 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                spannableStringBuilder.append(dotStringBuild);
            }
        }
        //去掉点击的背景色
        BackgroundColorSpan backgroundColorSpan=new BackgroundColorSpan(Color.parseColor("#FFFFFF"));
        RoundedBackgroundSpan span= new RoundedBackgroundSpan(ContextCompat.getColor(this,R.color.colorWhrite), ContextCompat.getColor(this,R.color.colorBlack));
        spannableStringBuilder.setSpan(backgroundColorSpan, 0, spannableStringBuilder.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannableStringBuilder;
    }
    /**
     * 设置徐泽状态图标
     *
     * @param spannableStringBuilder
     * @param resId
     */
    private void setIconSapn(SpannableStringBuilder spannableStringBuilder, int resId) {
        MyImageSpan imageSpan = new MyImageSpan(ContractsActivity.this, BitmapFactory.decodeResource(mView.getResources(), resId), 2);
        spannableStringBuilder.setSpan(imageSpan, 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
    }

    private SpannableStringBuilder getTagText1(String[] tags) {
        SpannableStringBuilder stringBuilder = new SpannableStringBuilder("符合规划有大哥好地方规划的,法规和公司法规和豆腐干和!");

        for (int i = 0; i < protocols.length; i++) {
            final String protocol = protocols[i];
            SpannableStringBuilder protocolStringBuild = new SpannableStringBuilder(protocol);
            //协议
            //点击span
            final int finalI = i;
            ClickableSpan clickableSpan = new ClickableSpan() {
                @Override
                public void onClick(View widget) {
                    CommonUtils.showToast(ContractsActivity.this,"协议"+finalI);
                }

                @Override
                public void updateDrawState(TextPaint ds) {
                    super.updateDrawState(ds);
                    ds.setUnderlineText(false);
                    ds.setColor(getResources().getColor(R.color.colorBlue));
                }
            };
            protocolStringBuild.setSpan(clickableSpan, 0, protocol.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            //前景
//            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(mView.getResources().getColor(R.color.colorBlue));
//            protocolStringBuild.setSpan(foregroundColorSpan, 0, protocol.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            stringBuilder.append(protocolStringBuild);
            //点
//            if (i != protocols.length - 1) {
//                SpannableStringBuilder dotStringBuild = new SpannableStringBuilder("、");
//                ForegroundColorSpan dotSpan = new ForegroundColorSpan(mView.getResources().getColor(R.color.colorBlack));
//                dotStringBuild.setSpan(dotSpan, 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//                stringBuilder.append(dotStringBuild);
//            }
        }

        RoundedBackgroundSpan span = new RoundedBackgroundSpan(ContextCompat.getColor(this, R.color.colorWhrite), ContextCompat.getColor(this, R.color.colorBlack));
        stringBuilder.setSpan(span, 1, 37, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return stringBuilder;
    }

}
