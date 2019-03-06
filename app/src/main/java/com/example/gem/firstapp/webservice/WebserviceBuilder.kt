package com.example.gem.firstapp.webservice

import com.example.gem.firstapp.webservice.weather.WeatherService
import okhttp3.Dispatcher
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

class WebserviceBuilder {

    companion object {
        private val BASE_URL: String = "https://api.openweathermap.org/data/2.5/"
        private val CONNECTION_TIME_OUT: Int = 50000
        private val READ_TIME_OUT: Int = 50000
        private var mInstance: WebserviceBuilder? = null

        fun getInstance(): WebserviceBuilder {
            synchronized(WebserviceBuilder::class.java) {
                if (mInstance == null) mInstance = WebserviceBuilder()
            }
            return mInstance!!
        }
    }

    private var mWeatherService: WeatherService? = null

    private fun getBaseUrl(): String {
        return BASE_URL
    }

    fun initServices() {
        var interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor()
        var dispatcher: Dispatcher = Dispatcher()
        dispatcher.maxRequests = 1

        var client: OkHttpClient = OkHttpClient.Builder()
            .connectTimeout(CONNECTION_TIME_OUT.toLong(), TimeUnit.MILLISECONDS)
            .readTimeout(READ_TIME_OUT.toLong(), TimeUnit.MILLISECONDS)
            .addInterceptor(interceptor)
            .build()

        var retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(getBaseUrl())
            .client(client)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        mWeatherService = retrofit.create(WeatherService::class.java)
    }

    fun getWeatherService(): WeatherService {
        return mWeatherService!!
    }
}