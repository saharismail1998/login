package ps.gedco.firstteam.services;

import okhttp3.ResponseBody;
import ps.gedco.firstteam.models.WeatherData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


//second step
public interface HusInterface {

    @GET("weather")
    Call<WeatherData> getWeather(@Query("q") String city , @Query("appid") String appid);

    @GET("weather")
    Call<ResponseBody> getWeatherAsString(@Query("q") String city , @Query("appid") String appid);
}
