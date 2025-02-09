package model.Usuarios;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class Viewer extends User implements Serializable{

    private List<Streamer> canaisInscritos;
    
    public Viewer(String email, String senha, String nickname, List<Streamer> canaisInscritos) {
        super(email, senha, nickname);
        this.canaisInscritos = (canaisInscritos == null) ? new ArrayList<>() : canaisInscritos;
    }



    //GETTERs e SETTERs
    public List<Streamer> getCanaisInscritos() {
        return canaisInscritos;
    }

    public void setCanaisInscritos(List<Streamer> canaisInscritos) {
        this.canaisInscritos = canaisInscritos;
    }


    //ToString
    @Override
    public String toString() {
        
        String exibir = "\n# Usuário: " + this.nickname + "\n#E-mail: " + this.email + "\n#~~~~~~~~~~~~~~~#\n" + "Canais inscritos: \n";

        if(this.canaisInscritos.size() == 0) {
            return exibir = "# Usuário: " + this.nickname + "\n Inscrito em nenhum canal :( #";

        }

        for(int i = 0; i < canaisInscritos.size(); i++){
            Streamer streamer = canaisInscritos.get(i);
            exibir += " # " + streamer.getNickname() + " ";

            if(i < canaisInscritos.size() - 1) {
                exibir += "\n";
            }
        }
        exibir += "\n#~~~~~~~~~~~~~~~#\n";
        return exibir;
    }

}
