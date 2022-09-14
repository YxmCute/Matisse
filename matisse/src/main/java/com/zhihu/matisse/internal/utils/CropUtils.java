package com.zhihu.matisse.internal.utils;

import android.app.Activity;
import android.net.Uri;
import android.os.Build;
import androidx.core.content.FileProvider;
import com.soundcloud.android.crop.Crop;
import java.io.File;

/**
 * Created by chengjuechao on 2017/9/14.
 */

public class CropUtils {

  public static String CropPhoto(Uri inputPath, Activity activity, String authority,
      int requestCode) {
    File file = new File(activity.getExternalCacheDir() + "/Crop");
    if (!file.exists()) {
      file.mkdirs();
    }
    File takePhotoImg = new File(file.getAbsolutePath(),
        "crop" + System.currentTimeMillis() + ".png");
    Uri imgUri;
    if (Build.VERSION.SDK_INT >= 24) {
      imgUri = FileProvider.getUriForFile(activity, authority, takePhotoImg);
    } else {
      imgUri = Uri.fromFile(takePhotoImg);
    }
    Crop.of(inputPath, imgUri).asSquare().start(activity, requestCode);
    return takePhotoImg.getPath();
  }
}
