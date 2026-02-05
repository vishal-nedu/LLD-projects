package com.zsgs.NoolNikarchi.features.users.serach;


import com.zsgs.NoolNikarchi.features.base.BaseModel;
import com.zsgs.NoolNikarchi.repository.db.NoolNikarchidb;
import com.zsgs.NoolNikarchi.repository.dto.User;

import java.util.List;
import java.util.stream.Collectors;

class SearchModel extends BaseModel {

    private final SearchView view;

    public SearchModel(SearchView view) {
        this.view = view;
    }

    void searchByName(String name) {
        if (name == null || name.trim().isEmpty()) {
            view.showMessage("Please enter a valid name.");
            return;
        }

        List<User> users = NoolNikarchidb.getInstance().getAllUsers().stream()
                .filter(user -> user.getFirstName().toLowerCase().contains(name.toLowerCase()) ||
                        user.getLastName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());

        view.displayUsers(users);
    }

    void searchByEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            view.showMessage("Please enter a valid email.");
            return;
        }

        List<User> users = NoolNikarchidb.getInstance().getAllUsers().stream()
                .filter(user -> user.getEmail().toLowerCase().contains(email.toLowerCase()))
                .collect(Collectors.toList());

        view.displayUsers(users);
    }

    void searchByMobile(String mobile) {
        if (mobile == null || mobile.trim().isEmpty()) {
            view.showMessage("Please enter a valid mobile number.");
            return;
        }

        List<User> users = NoolNikarchidb.getInstance().getAllUsers().stream()
                .filter(user -> user.getMobileNumber().contains(mobile))
                .collect(Collectors.toList());

        view.displayUsers(users);
    }
}
