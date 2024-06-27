package model;
public abstract class User {

    protected String email;
    protected String senha;
    protected String nickname;
    protected int id;
    protected static int prox = 1;


    public User(String email, String senha, String nickname) {
        this.email = email;
        this.senha = senha;
        this.nickname = nickname;
        this.id = prox++;
    }


    //GETTERs e SETTERs

    public String getEmail() {
        return email;
    }


    public String getSenha() {
        return senha;
    }


    public String getNickname() {
        return nickname;
    }


    public int getId() {
        return id;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public void setSenha(String senha) {
        this.senha = senha;
    }


    public void setNickname(String nickname) {
        this.nickname = nickname;
    }


    public void setId(int id) {
        this.id = id;
    }

  


}
