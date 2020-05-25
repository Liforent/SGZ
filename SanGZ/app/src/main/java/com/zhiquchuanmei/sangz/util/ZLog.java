package com.zhiquchuanmei.sangz.util;

import android.util.Log;



public class ZLog {

    public static void e(String msg) {
        //if (SGConfig.IS_DEBUG) {
            final String[] info = getAutoJumpLogInfo();
            final String TAG = "类class" + "(" + info[0] + info[3] + ":" + info[2] + ")";
            Log.e(TAG, "\n=======" + msg + "\n");
       // }
    }

    public static void d(String msg) {
       // if (SGConfig.IS_DEBUG) {
            final String[] info = getAutoJumpLogInfo();
            final String TAG = "类class" + "(" + info[0] + info[3] + ":" + info[2] + ")";
            Log.d(TAG, "\n=======" + msg+ "\n");
       // }
    }

    public static void v(String msg) {
       // if (SGConfig.IS_DEBUG) {
            final String[] info = getAutoJumpLogInfo();
            final String TAG = "类class" + "(" + info[0] + info[3] + ":" + info[2] + ")";
            Log.v(TAG, "\n=======" + msg+ "\n");
       // }
    }

    public static void i(String msg) {
        //if (SGConfig.IS_DEBUG) {
            final String[] info = getAutoJumpLogInfo();
            final String TAG = "类class" + "(" + info[0] + info[3] + ":" + info[2] + ")";
            Log.i(TAG, "\n=======" + msg+ "\n");
       // }
    }

    /**
     * 获取打印信息所在方法名，行号等信息
     */
    private static String[] getAutoJumpLogInfo() {
        final String[] info = new String[]{"", "", "", ""};
        final StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        if (elements.length < 5) {
            Log.e("MyLogger", "Stack is too shallow!!!");
            return info;
        } else {
            if (elements[4].getClassName().contains("$")) { //用于内部类的名字解析
                info[0] = elements[4].getClassName().substring(elements[4].getClassName().lastIndexOf(".") + 1, elements[4].getClassName().indexOf("$"));
            } else {
                info[0] = elements[4].getClassName().substring(elements[4].getClassName().lastIndexOf(".") + 1);
            }

            info[1] = "=======" + elements[4].getMethodName() + "()";
            info[2] = elements[4].getLineNumber() + "";
            final String filename = elements[4].getFileName();
            if (filename != null) {
                info[3] = filename.contains(".kt") ? ".kt" : ".java";
            } else {
                info[3] = ".java";
            }
            return info;
        }
    }
}
