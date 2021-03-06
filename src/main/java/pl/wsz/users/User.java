package pl.wsz.users;

public class User {
    private String userId;
    private int id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String nick;
    private String phone;

    public User() {
    }

    public User(String userId, int id, String name, String surname, String email, String password, String nick, String phone) {
        this.userId = userId;
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.nick = nick;
        this.phone = phone;
    }

    public User(String name, String surname, String email, String password, String nick, String phone, String userId) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.nick = nick;
        this.phone = phone;
        this.userId = userId;
    }

    public User(String name, String surname, String email, String password, String phone) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    public User(String name, String surname, String email, String password, String nick, String phone) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.nick = nick;
        this.phone = phone;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
