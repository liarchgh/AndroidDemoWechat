package com.neu.demoUtil;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BitmapUtil {
	public static byte[] toByteArray(Bitmap bm) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		bm.compress(Bitmap.CompressFormat.PNG, 0, baos);
		return baos.toByteArray();
	}

	public static Bitmap fromByteArray(byte[] bmba) {
		return BitmapFactory.decodeByteArray(bmba, 0, bmba.length);
	}
}
