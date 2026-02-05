package com.zsgs.NoolNikarchi.features.base;


import com.zsgs.NoolNikarchi.features.registeration.RegistrationView;

public abstract class BaseView {

    protected void logoutApp(){
        System.out.println("Logging out...");
        new RegistrationView().init();
    }
    protected void exitApp(){
        System.out.println("Thank you for using LibraSphere!");
        System.exit(0);
    }
    public void showMessage(String message) {
        System.out.println(message);
    }
}
