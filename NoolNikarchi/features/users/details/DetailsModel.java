package com.zsgs.NoolNikarchi.features.users.details;


import com.zsgs.NoolNikarchi.features.base.BaseModel;
import com.zsgs.NoolNikarchi.repository.db.NoolNikarchidb;
import com.zsgs.NoolNikarchi.repository.dto.User;

import java.util.Optional;

class DetailsModel extends BaseModel {

    private final DetailsView view;

    public DetailsModel(DetailsView view) {
        this.view = view;
    }

    void getUserDetails(String userId) {
        if (userId == null || userId.trim().isEmpty()) {
            view.showMessage("Please enter a valid User ID.");
            return;
        }

        Optional<User> user = NoolNikarchidb.getInstance().getAllUsers().stream()
                .filter(u -> u.getUserId().equals(userId))
                .findFirst();

        view.displayUserDetails(user.orElse(null));
    }
}
