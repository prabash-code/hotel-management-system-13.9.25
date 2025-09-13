package controller.staffController;

import javafx.collections.ObservableList;
import model.Staff;

public interface StaffManagementService {
    ObservableList<Staff> view();
    public void add(Staff staff);
    public void update(Staff staff);
    public void delete(String id);
}
