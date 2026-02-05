package com.zsgs.NoolNikarchi.features.librarysetup.details;


import com.zsgs.NoolNikarchi.features.base.BaseModel;
import com.zsgs.NoolNikarchi.repository.db.NoolNikarchidb;
import com.zsgs.NoolNikarchi.repository.dto.Library;

class LibraryDetailsModel extends BaseModel {
    private final LibraryDetailsView view;

    public LibraryDetailsModel(LibraryDetailsView view) {
        this.view = view;
    }

    void getLibraryDetails() {
        Library library = NoolNikarchidb.getInstance().getLibrary();
        view.displayLibraryDetails(library);
    }
} 