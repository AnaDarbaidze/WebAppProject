public class User {
    int id;
    String username;
    String firstname;
    String lastname;
    String profession;
    String password;
    String email;

    public User(int id, String username, String firstname, String lastname, String profession, String password, String email) {
        this.id = id;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.profession = profession;
        this.password = password;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getProfession() {
        return profession;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }


}


