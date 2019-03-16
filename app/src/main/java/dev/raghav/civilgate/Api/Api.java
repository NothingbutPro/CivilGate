package dev.raghav.civilgate.Api;



import android.database.Observable;

import java.io.File;

import dev.raghav.civilgate.Parsingfiles.LoginReg.RegisPars_responce;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

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
    @Multipart
    @POST("user/updateprofile")
    Observable<ResponseBody> Register_to_app_with_profile(@Part("name") RequestBody fullName,
                                           @Part("mobile") RequestBody mobile,
                                           @Part("email") RequestBody email,
                                            @Part("password") RequestBody password,
                                            @Part("passout_year") RequestBody passout_year,
                                            @Part("collage_name") RequestBody collage_name,
                                            @Part("address") RequestBody address,
                                           @Part MultipartBody.Part gate_photo,
                                           @Part MultipartBody.Part gate_sign_photo);
//    @FormUrlEncoded
//    @POST("userlogin")
//    Call<LoginResponse> userLogin(
//            @Field("email") String email,
//            @Field("password") String password
//    );

//    @GET("allusers")
//    Call<UsersResponse> getUsers();

//    @FormUrlEncoded
//    @PUT("updateuser/{id}")
//    Call<LoginResponse> updateUser(
//            @Path("id") int id,
//            @Field("email") String email,
//            @Field("name") String name,
//            @Field("school") String school
//    );

//    @FormUrlEncoded
//    @PUT("updatepassword")
//    Call<DefaultResponse> updatePassword(
//            @Field("currentpassword") String currentpassword,
//            @Field("newpassword") String newpassword,
//            @Field("email") String email
//    );
//
//    @DELETE("deleteuser/{id}")
//    Call<DefaultResponse> deleteUser(@Path("id") int id);

}
