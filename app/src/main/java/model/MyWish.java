package model;

public class MyWish {
    public String title;
    public String content;
    public String recordDate;
    public int itemId;

    public int getItemid(){
        return itemId;
    }

    public void setItemId(int newId){
        this.itemId = newId;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String newTitle){
        this.title = newTitle;
    }

    public String getContent(){
        return content;
    }

    public void setContent(String newContent){
        this.content = newContent;
    }

    public String getRecordDate(){
        return recordDate;
    }

    public void setRecordDate(String newRecordDate){
        this.recordDate = newRecordDate;
    }

    public int getItemId() {
        return itemId;
    }
}
