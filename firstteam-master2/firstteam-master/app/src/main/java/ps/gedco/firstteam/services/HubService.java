package ps.gedco.firstteam.services;

import java.io.IOException;

import okhttp3.ResponseBody;
import ps.gedco.firstteam.constants.AppConstants;
import ps.gedco.firstteam.interfaces.APICallback;
import ps.gedco.firstteam.models.WeatherData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


//third step
public class HubService {

    private final HusInterface service;

    public HubService(){

        //third step , 1 step
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppConstants.AppAPIUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

         service = retrofit.create(HusInterface.class);
    }

    //third step , 2 step
    public void getWeather(String city, final APICallback callback){

        Call<WeatherData> rs = service.getWeather(city, AppConstants.WeatherAppid);
        System.out.println("start calling");
        rs.enqueue(new Callback<WeatherData>() {
            @Override
            public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {

                WeatherData weatherData = response.body();

                callback.onCallBack(weatherData);

            }

            @Override
            public void onFailure(Call<WeatherData> call, Throwable t) {
                t.printStackTrace();
                callback.onCallBack(null);
            }
        });
        System.out.println("end calling");
    }

    public void getWeatherAsString(String city){

        Call<ResponseBody> rs = service.getWeatherAsString(city, AppConstants.WeatherAppid);
        rs.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {


                try {
                    System.out.println(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
