package headyassignmentapp.app.io.headyassignmentapp.applications.builder;

import dagger.Module;
import dagger.Provides;
import headyassignmentapp.app.io.headyassignmentapp.api.ProductApi;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by manish on 01/12/17.
 */

@Module
public class CategoryApiServiceModule {

    private static final String BASE_URL = "http://coemygroup.fr/";
    @AppScope
    @Provides
    ProductApi provideApiService(OkHttpClient client, GsonConverterFactory gson, RxJavaCallAdapterFactory rxAdapter)
    {
        Retrofit retrofit =   new Retrofit.Builder().client(client)
                .baseUrl(BASE_URL).addConverterFactory(gson).
                        addCallAdapterFactory(rxAdapter).build();

        return  retrofit.create(ProductApi.class);
    }
}
