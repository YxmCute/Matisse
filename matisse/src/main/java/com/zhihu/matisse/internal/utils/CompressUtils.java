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


  public static void CompressPhoto(Activity activity, List<Uri> uriList,
      OnCompressListener onCompressListener) throws IOException {
    Luban.with(activity.getApplicationContext())
        .load(uriList)                                   // 传入要压缩的图片列表
        .ignoreBy(248)                                  // 忽略不压缩图片的大小
        .setTargetDir(
            activity.getApplicationContext().getExternalCacheDir().getPath())   // 设置压缩后文件存储位置
        .setCompressListener(onCompressListener).launch();    //启动压缩
  }

  public static void CompressPhoto(Activity activity, Uri photo,
      OnCompressListener onCompressListener) throws IOException {
    List<Uri> photoList = new ArrayList<>(1);
    photoList.add(photo);
    CompressPhoto(activity, photoList, onCompressListener);
  }
}


