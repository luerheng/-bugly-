package com.myself.commondemo.utils;

import android.content.Context;
import android.widget.Toast;

public class CommonUtils {

    private static Toast toast;
    /**
     * 判断toast是否弹出,正在弹出则不执行弹出操作,如果没有弹出则弹出toast()
     *
     * @param context
     * @param content
     */
    public static void showToast(Context context, String content) {
        if (toast == null) {
            toast = Toast.makeText(context, content, Toast.LENGTH_SHORT);
        } else {
            toast.cancel();
            toast = Toast.makeText(context, content, Toast.LENGTH_SHORT);
//            toast.setText(content);
//            toast.setDuration(Toast.LENGTH_SHORT);
        }
        toast.show();
    }
}
