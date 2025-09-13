package controller.RoomController;

import javafx.collections.ObservableList;
import model.RoomDetails;

public interface RoomManagementService {
     void addRoomDetails(RoomDetails roomDetails);
     void updateDetails(RoomDetails details);
     void deleteRoomDetails(String id);
     ObservableList<RoomDetails> getAllRoomDetails();
}
