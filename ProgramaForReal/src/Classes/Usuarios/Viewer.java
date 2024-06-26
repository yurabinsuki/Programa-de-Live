package Classes.Usuarios;
import Classes.User;

import java.util.ArrayList;
import java.util.List;

public class Viewer extends User{

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
        
        String exibir = "# Usuário: " + this.nickname + "\n Canais inscritos: [";

        if(this.canaisInscritos.size() == 0) {
            return exibir = "# Usuário: " + this.nickname + "\n Inscrito em nenhum canal :( #";

        }

        for(int i = 0; i < canaisInscritos.size(); i++){
            Streamer streamer = canaisInscritos.get(i);
            exibir += streamer.getNickname();

            if(i < canaisInscritos.size() - 1) {
                exibir += ", ";
            }
        }
        exibir += "]";
        return exibir;
    }

}
