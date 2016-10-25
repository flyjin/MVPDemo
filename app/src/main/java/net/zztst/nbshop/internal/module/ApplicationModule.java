package net.zztst.nbshop.internal.module;

import android.content.Context;

import net.zztst.nbshop.NBShpApplication;
import net.zztst.nbshop.data.ApiService;
import net.zztst.nbshop.data.Constants;
import net.zztst.nbshop.internal.ApplicationContext;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2016/8/19.
 */
@Module
public class ApplicationModule {

	private final NBShpApplication mApplication;

	public ApplicationModule(NBShpApplication application){
		mApplication= application;
	}

	@Provides
	@Singleton
	NBShpApplication provideApplication() {
		return mApplication;
	}

	@Provides
	@Singleton
	@ApplicationContext
	Context provideContext() {
		return mApplication;
	}

	@Provides
	@Singleton
	protected OkHttpClient provideClient() {
		return new OkHttpClient.Builder()
				.connectTimeout(5000, TimeUnit.MILLISECONDS)
				.readTimeout(5000, TimeUnit.MILLISECONDS)
				.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
				.build();
	}
	@Provides
	@Singleton
	protected ApiService provideApiService(OkHttpClient client) {
		return new Retrofit
				.Builder()
				.addCallAdapterFactory( RxJavaCallAdapterFactory.create())
				.addConverterFactory(GsonConverterFactory.create())
				.client(client)
				.baseUrl(Constants.BASE_URL)
				.build()
				.create(ApiService.class);
	}


}
