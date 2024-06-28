package model.Usuarios;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import model.User;

public class Streamer extends User implements Serializable {

    private boolean live;
    private int totalInscritos;
    private List<Viewer> inscritos;

    // Construtor
    public Streamer(boolean live, String email, String senha, String nickname, int totalInscritos, List<Viewer> inscritos) {
        super(email, senha, nickname);
        this.live = live;
        this.totalInscritos = totalInscritos;
        this.inscritos = (inscritos == null) ? new ArrayList<>() : inscritos;
    }

    // Método para exibir inscritos
    public void exibirInscritos() {
        for (Viewer inscrito : inscritos) {
            System.out.println(inscrito.getNickname());
        }
    }

    // Métodos para manipular inscritos
    public void removerUmInscrito() {
        if (this.totalInscritos > 0) {
            this.totalInscritos--;
        }
    }

    public void adicionarUmIscrito() {
        this.totalInscritos++;
    }

    // Getters e Setters
    public boolean getLive() {
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

    public void setInscritos(List<Viewer> inscritos) {
        this.inscritos = inscritos;
    }

    // Método toString
    @Override
    public String toString() {
        return "\n# Nickname: " + this.nickname + "\n# Número de inscritos: "  + this.totalInscritos + "\n";
    }
}
