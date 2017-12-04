package headyassignmentapp.app.io.headyassignmentapp.models;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by manishchoudhary on 03/12/17.
 */

public class Categories implements Serializable {

    ArrayList<Category> categories;

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }
}
