package headyassignmentapp.app.io.headyassignmentapp.api;

import headyassignmentapp.app.io.headyassignmentapp.models.Category;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by manish on 01/12/17.
 */

public interface ProductApi {

    @GET("test-mobile/iOS/json/test2.json")
    Observable<Category> getCategory();
}