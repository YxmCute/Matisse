package com.zhihu.matisse.internal.utils;

import android.app.Activity;
import android.net.Uri;
import com.fanjiao.lib_luban.Luban;
import com.fanjiao.lib_luban.OnCompressListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chengjuechao on 2017/9/14.
 */

public class CompressUtils {

  public static void CompressPhoto(Activity activity, List<Uri> uriList,boolean ignoreContentUri,
      OnCompressListener onCompressListener) throws IOException {
    Luban.with(activity.getApplicationContext())
        .load(uriList)                                   // 传入要压缩的图片列表
        .ignoreBy(250) .ignoreContentUri(ignoreContentUri)                                 // 忽略不压缩图片的大小
        .setCompressListener(onCompressListener).launch();    //启动压缩
  }
  public static void CompressPhoto(Activity activity, String path,
      OnCompressListener onCompressListener) throws IOException {
    Luban.with(activity.getApplicationContext())
        .load(path)                                   // 传入要压缩的图片列表
        .ignoreBy(250)                                  // 忽略不压缩图片的大小
        .setCompressListener(onCompressListener).launch();    //启动压缩
  }

  public static void CompressPhoto(Activity activity, Uri photo,boolean ignoreContentUri,
      OnCompressListener onCompressListener) throws IOException {
    List<Uri> photoList = new ArrayList<>(1);
    photoList.add(photo);
    CompressPhoto(activity, photoList,ignoreContentUri, onCompressListener);
  }
}


