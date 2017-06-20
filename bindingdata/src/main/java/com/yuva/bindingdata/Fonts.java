package com.yuva.bindingdata;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.Log;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yuvaraj on 5/12/2017.
 */

public class Fonts {

    private static String TAG = "Fonts";
    private static final String FONT_DIR = "fonts";
    private static Map<String, Typeface> cache = new HashMap<>();
    private static Map<String, String> fontMapping = new HashMap<>();
    private static Fonts instance;
    private Context mContext;

    public static Fonts getInstance(Context context) {
        if (instance == null) {
            instance = new Fonts(context.getApplicationContext());
        }
        return instance;
    }

    public void addFont(String name, String fontFilename) {
        fontMapping.put(name, fontFilename);
    }

    private Fonts(Context context) {
        mContext = context;
        AssetManager am = context.getResources().getAssets();
        String fileList[];
        try {
            fileList = am.list(FONT_DIR);
        } catch (IOException e) {
            Log.e(TAG, "Error loading fonts from assets/fonts.");
            return;
        }

        for (String filename : fileList) {
            String alias = filename.substring(0, filename.lastIndexOf('.'));
            fontMapping.put(alias, filename);
            fontMapping.put(alias.toLowerCase(), filename);
        }
    }

    public Typeface get(String fontName) {
        String fontFilename = fontMapping.get(fontName);
        if (fontFilename == null) {
            Log.e(TAG, "Couldn't find font " + fontName + ". Maybe you need to call addFont() first?");
            return null;
        }
        if (cache.containsKey(fontFilename)) {
            return cache.get(fontFilename);
        } else {
            Typeface typeface = Typeface.createFromAsset(mContext.getAssets(), FONT_DIR + "/" + fontFilename);
            cache.put(fontFilename, typeface);
            return typeface;
        }
    }

}
