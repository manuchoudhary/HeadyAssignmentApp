package headyassignmentapp.app.io.headyassignmentapp.utils;

import android.support.design.widget.Snackbar;
import android.view.View;

import timber.log.Timber;

/**
 * Created by manish on 01/12/17.
 */

public class UiUtils {

    public static void handleThrowable(Throwable throwable) {
        Timber.e(throwable, throwable.toString());
    }

    public static void showSnackbar(View view, String message, int length) {
        Snackbar.make(view, message, length).setAction("Action", null).show();
    }
}
