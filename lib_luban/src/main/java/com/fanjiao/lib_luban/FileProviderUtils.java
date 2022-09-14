package com.fanjiao.lib_luban;

import android.content.Context;
import android.net.Uri;
import android.os.Build;

import androidx.annotation.Nullable;
import androidx.core.content.FileProvider;

import java.io.File;

public class FileProviderUtils {
    @Nullable
    public static Uri getUriForFile(@Nullable Context context, @Nullable File file) {
        if (context == null || file == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            String authority = context.getApplicationInfo().packageName + ".fileprovider";
            return FileProvider.getUriForFile(context, authority, file);
        }

        return Uri.fromFile(file);
    }
}
