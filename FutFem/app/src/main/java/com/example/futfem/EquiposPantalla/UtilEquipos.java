package com.example.futfem.EquiposPantalla;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class UtilEquipos {

    public static void downloadBitmapToImageView(String url, ImageView imageView) {
        Context context = imageView.getContext();
        if (context instanceof Activity) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    Bitmap image = getBitmapFromURL(url);
                    ((Activity) context).runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            imageView.setImageBitmap(image);
                        }
                    });
                }
            });
            thread.start();
        }
    }

    private static Bitmap getBitmapFromURL(String urlString) {
        try {
            URL url = new URL(urlString);
            URLConnection connection = url.openConnection();
            connection.connect();
            InputStream input = connection.getInputStream();
            return BitmapFactory.decodeStream(input);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
