package com.example.fragment2_you_dynamic;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    @GET("/shivarajp/2cbe00030c04472c9d8ad4b0ec112dbe/raw/c651391e428182f08d60d59e79073f3fcf79b858/nobroker")
    /*** {userId} means your are continue changing the data write it if u do not want to error in the program if some one change last url of the retrofit*****/
    /******Here we are getting the the list from the retrofit Api *****/
    Call<List<ResponseModel>> getUser();
}
