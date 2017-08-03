package com.chrishonwyllie.filterablerecyclerview;

/**
 * Created by Chrishon on 8/3/17.
 */

public class ListObject {

    // Custom Object used to populate data in recycler view
    // The results of the search can either depend on the listText, or the id

    public String listText;
    public String listTextId;

    // Empty constructor
    public ListObject() {
        listText = "";
        listTextId = "";
    }

    // Overloaded constructor
    public ListObject(String listText, String listTextId) {
        this.listText = listText;
        this.listTextId = listTextId;
    }

    // Setters
    public void setListText(String newText) {
        this.listText = newText;
    }

    public void setListTextID(String newTextId) {
        this.listTextId = newTextId;
    }

    // Getters
    public String getListText() {
        return listText;
    }

    public String getListTextId() {
        return listTextId;
    }

}
