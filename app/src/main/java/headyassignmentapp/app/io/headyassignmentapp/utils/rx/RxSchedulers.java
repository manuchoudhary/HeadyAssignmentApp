package headyassignmentapp.app.io.headyassignmentapp.utils.rx;

import rx.Scheduler;

/**
 * Created by manish on 01/12/17.
 */

public interface RxSchedulers {

    Scheduler runOnBackground();

    Scheduler io();

    Scheduler compute();

    Scheduler androidThread();

    Scheduler internet();
}
