package net.zztst.nbshop.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2016/8/22.
 */
public class AppUtils {
	/**
	 * convert px to dip
	 *
	 * @param context
	 * @param pxValue
	 * @return
	 */
	public static int px2dip(Context context, float pxValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (pxValue / scale + 0.5f);
	}

	/**
	 * convert px to sp
	 *
	 * @param context
	 * @param pxValue
	 * @return
	 */
	public static int px2sp(Context context, float pxValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (pxValue / scale + 0.5f);
	}

	/**
	 * 检测网络是否可用
	 *
	 * @param context
	 * @return
	 */
	public static boolean isNetWorkConnected(Context context) {
		if (context != null) {
			ConnectivityManager mConnectivityManager = (ConnectivityManager) context
					.getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo mNetworkInfo = mConnectivityManager
					.getActiveNetworkInfo();
			if (mNetworkInfo != null) {
				return mNetworkInfo.isAvailable();
			}
		}

		return false;
	}

	/**
	 * lxs 判断是否为正确的手机号
	 *
	 * @param phone
	 * @return
	 */
	public static boolean isPhone(String phone) {
		String strPattern = "^((13[0-9])|(14[0-9])|(15[0-9])|(18[0-9])|(17[0-9]))\\d{8}$";
		Pattern p = Pattern.compile(strPattern);
		Matcher m = p.matcher(phone);
		return m.matches();
	}

	/**
	 * 获取缓存目录
	 *
	 * @return
	 */
	public static String getTempPath() {
		String SDPATH = Environment.getExternalStorageDirectory().getPath();
		File dir = new File(SDPATH + "/卡车团/temp");
		if (!dir.exists()) {
			dir.mkdirs();
		}
		return dir.toString();
	}
}
