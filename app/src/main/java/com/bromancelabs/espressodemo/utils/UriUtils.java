package com.bromancelabs.espressodemo.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class UriUtils {

    public static void goToURI(Context context, String url) {
        context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
    }
}
