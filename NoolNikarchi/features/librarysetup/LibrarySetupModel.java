package com.zsgs.NoolNikarchi.features.librarysetup;


import com.zsgs.NoolNikarchi.features.base.BaseModel;
import com.zsgs.NoolNikarchi.repository.db.NoolNikarchidb;
import com.zsgs.NoolNikarchi.repository.dto.Library;

class LibrarySetupModel extends BaseModel {
    private final LibrarySetupView view;

    public LibrarySetupModel(LibrarySetupView view) {
        this.view = view;
    }

    void init() {
        if(NoolNikarchidb.getInstance().getLibrary()==null){
            view.proceedToSetupLibrary();
        }else{
            view.onLibrarySetupCompleted();
        }
    }

    void setupLibrary(Library library) {
        if (validateLibraryInfo(library)) {
            NoolNikarchidb.getInstance().setLibrary(library);
            view.onLibrarySetupCompleted();
        } else {
            view.showErrorMessage("Invalid library information. Please try again.");
        }
    }

    private boolean validateLibraryInfo(Library library) {
        return library != null &&
               library.getName() != null && !library.getName().trim().isEmpty() &&
               library.getAddress() != null && !library.getAddress().trim().isEmpty() &&
               library.getPhoneNo() != null && library.getPhoneNo().matches("\\d{10}") &&
               library.getEmailId() != null && library.getEmailId().matches("^[A-Za-z0-9+_.-]+@(.+)$") &&
               library.getIncharge() != null && !library.getIncharge().trim().isEmpty() &&
               library.getCapacity() != null && library.getCapacity() > 0 &&
               library.getOpeningTime() != null && library.getOpeningTime() >= 0 && library.getOpeningTime() <= 2359 &&
               library.getClosingTime() != null && library.getClosingTime() >= 0 && library.getClosingTime() <= 2359 &&
               library.getNoAvailableDays() != null && library.getNoAvailableDays() >= 1 && library.getNoAvailableDays() <= 7;
    }
}
