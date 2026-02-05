package com.zsgs.NoolNikarchi.features.registeration;


import com.zsgs.NoolNikarchi.features.base.BaseModel;
import com.zsgs.NoolNikarchi.repository.db.NoolNikarchidb;
import com.zsgs.NoolNikarchi.repository.dto.RegistrationInfo;

public class RegistrationModel extends BaseModel {
    private final RegistrationView view;

    public RegistrationModel(RegistrationView registrationView) {
        view = registrationView;
    }

    void init() {
        if (NoolNikarchidb.getInstance().getRegistrationInfo() != null) {
            view.proceedLogin();
        } else {
            view.proceedRegistration();
        }
    }

    void registerUser(RegistrationInfo info) {
        if (ifAlreadyExisit(info.getUserName())) {
            view.showErrorMessage("Username already Exist");
        } else if (isWeakPassword()) {
            view.showErrorMessage("Please enter strong password");
        } else {
            NoolNikarchidb.getInstance().setRegistrationInfo(info);
            view.onRegistrationSuccess(info);
        }
    }

    private boolean isWeakPassword() {
        return false; // Write your logics here
    }

    private boolean ifAlreadyExisit(String userName) {
        return false;
    }

    public void validateCredentials(String userName, String password) {
        if(NoolNikarchidb.getInstance().validateLoginIngo(userName,password)){
            view.onSuccessLogin(userName);
        } else{
            view.onInvalidCredentials();
        }
    }
}
