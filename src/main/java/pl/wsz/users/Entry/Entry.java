package pl.wsz.users.Entry;

public class Entry {

    private int id;
    private int userId;
    private String content;
    private String addedTime;

    public Entry(int id, int userId, String content, String addedTime) {
        this.id = id;
        this.userId = userId;
        this.content = content;
        this.addedTime = addedTime;
    }

    public Entry(int userId, String content, String addedTime) {
        this.userId = userId;
        this.content = content;
        this.addedTime = addedTime;
    }

    public Entry() {
    }

    public Entry(int userId, String content) {
        this.userId = userId;
        this.content = content;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAddedTime() {
        return addedTime;
    }

    public void setAddedTime(String addedTime) {
        this.addedTime = addedTime;
    }
}
