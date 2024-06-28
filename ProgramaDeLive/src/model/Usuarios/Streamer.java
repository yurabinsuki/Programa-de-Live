package model.Usuarios;
import java.util.List;

import model.User;

import java.io.Serializable;
import java.util.ArrayList;

public class Streamer extends User implements Serializable{

    private boolean live;
    private int totalInscritos;
    private List<Viewer> inscritos;

    public Streamer(boolean live, String email, String senha, String nickname, int totalInscritos, List<Viewer> inscritos) {
        super(email, senha, nickname);
        this.live = live;
        this.totalInscritos = totalInscritos;
        this.inscritos = (inscritos == null) ? new ArrayList<>() : inscritos;
    }


    public void exibirInscritos(){
        for(Viewer inscrito : inscritos){
            System.out.println(inscrito.getNickname());
        }
    }

    public void removerUmInscrito(){
        this.totalInscritos--;
    }

    public void adicionarUmIscrito(){
        this.totalInscritos++;
    }

    //Getters e Setters
    public boolean getLive(){
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public int getTotalInscritos() {
        return totalInscritos;
    }


    public List<Viewer> getInscritos() {
        return inscritos;
    }


    public void setInscritos(int totalInscritos) {
        this.totalInscritos = totalInscritos;
    }

    //To String
    @Override
    public String toString() {
    
        return this.nickname + 
        "\n Número de inscritos: " + this.totalInscritos + "\n";
    }
    
}
