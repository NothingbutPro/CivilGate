package dev.raghav.civilgate.Api;



import android.database.Observable;

import java.io.File;

import dev.raghav.civilgate.Const_Files.Retro_Urls;
import dev.raghav.civilgate.Other_Parsing_Files.Get_level;
import dev.raghav.civilgate.Parsingfiles.LoginReg.Login_Responce;
import dev.raghav.civilgate.Parsingfiles.LoginReg.RegisPars_responce;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {


    @FormUrlEncoded
    @POST("Ragistration")
    Call<RegisPars_responce> Register_to_app(
            @Field("name") String name,
            @Field("mobile") String mobile,
            @Field("email") String email,
            @Field("password") String password,
            @Field("passout_year") String passout_year,
            @Field("collage_name") String collage_name,
            @Field("address") String address,
            @Field("profile_image") File profile_image,
            @Field("sign_image") File sign_image
    );
////jackson
//    @POST("login/{email}/{password}")
//    Call<Login_Responce> Login_that_dk(
//            @Path("email") String email,
//              @Path("password") String password
//    );
//@POST("/login")
//Call<Login_Responce> basicLogin();
@FormUrlEncoded
@POST("login")
Call<Login_Responce> Login_that_dk(
        @Field("email") String email,
        @Field("password") String password
);
@Headers("Content-Type: application/x-www-form-urlencoded")
@GET(Retro_Urls.About_us)
Call<Get_level> getLevelCall();

}
