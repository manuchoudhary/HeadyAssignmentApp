package headyassignmentapp.app.io.headyassignmentapp.screens.main.core;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import butterknife.ButterKnife;
import headyassignmentapp.app.io.headyassignmentapp.R;
import headyassignmentapp.app.io.headyassignmentapp.screens.main.MainActivity;

/**
 * Created by manish on 01/12/17.
 */

public class MainView {

    private View view;

    public MainView(MainActivity context) {
        FrameLayout parent = new FrameLayout(context);
        parent.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        view = LayoutInflater.from(context).inflate(R.layout.activity_main, parent, true);
        ButterKnife.bind(view, context);
    }

    public View constructView() {
        return view;
    }
}
