package net.zztst.nbshop.utils;

import android.graphics.drawable.Drawable;

import net.zztst.nbshop.NBShpApplication;

/**
 * Created by Administrator on 2016/8/19.
 */
public class ResourceUtils {
	public static String getString(int id) {
		return NBShpApplication.mContext.getResources().getString(id);
	}

	public static Drawable getDrawable(int id) {
		return NBShpApplication.mContext.getResources().getDrawable(id);
	}
}
