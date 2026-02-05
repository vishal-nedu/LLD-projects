package com.zsgs.NoolNikarchi.features.users;

import com.zsgs.NoolNikarchi.features.base.BaseModel;
import com.zsgs.NoolNikarchi.repository.db.NoolNikarchidb;
import com.zsgs.NoolNikarchi.repository.dto.User;

import java.util.List;

class UsersModel extends BaseModel {

    private final UsersView view;

    public UsersModel(UsersView view) {
        this.view = view;
    }

    void listAllUsers() {
        List<User> users = NoolNikarchidb.getInstance().getAllUsers();
        view.displayUsers(users);
    }
}