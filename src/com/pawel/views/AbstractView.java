package com.pawel.views;

public abstract class AbstractView {
    public void showMenu() {
        boolean activeMenu = true;
        while(activeMenu) {
            activeMenu = show();
        }
    }
    protected abstract boolean show();
}
