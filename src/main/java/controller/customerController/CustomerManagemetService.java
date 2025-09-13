package controller.customerController;

import javafx.collections.ObservableList;
import model.CustomerDetails;

public interface CustomerManagemetService {
     void addCustomer(CustomerDetails customerDetails);
     void deleteCustomer(String name);
     void updateCustomer(CustomerDetails customerDetails);
     ObservableList<CustomerDetails> loadData();
}
