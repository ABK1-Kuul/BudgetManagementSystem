package com.smartbudget.models;

public class Category {
    private int categoryId;
    private String categoryName;

    //No-Args constructor
    public Category(){}

    //All-Args constructor
    public Category(int categoryId, String categoryName){
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    //Getters and Setters
    public int getCategoryId(){return categoryId;}
    public void setCategoryId(int categoryId){this.categoryId = categoryId;}

    public String getCategoryName(){return categoryName;}
    public void setCategoryName(String categoryName){this.categoryName = categoryName;}

    @Override
    public String toString() {
        return "Category{" + "categoryId=" + categoryId + ", categoryName='" + categoryName + '\'' + '}';
    }
}

