package net.zztst.nbshop.data;

import net.zztst.nbshop.data.bean.User;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Administrator on 2016/8/25.
 */
public interface ApiService {


	@FormUrlEncoded
	@POST(Constants.LOGIN)
	Observable<User> login(@Field("username") String name,@Field("password") String Psw);

}
