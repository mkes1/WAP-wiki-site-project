package com.uep.wap.model.userTypes;

import javax.persistence.Entity;

@Entity
public class Admin extends ContentManager {
    public void editSite() {
        // Logic for editing the site
    }

    public void manageSite() {
        // Logic for managing the site
    }

    public void manageAdmins() {
        // Logic for managing other admins
    }
}