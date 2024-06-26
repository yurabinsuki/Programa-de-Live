package Classes.Usuarios;
import Classes.User;
import java.util.List;
import java.util.ArrayList;

public class Streamer extends User{

    private boolean live;
    private int horasStreamadas;
    private int totalInscritos;
    private List<Viewer> inscritos;

    public Streamer(boolean live, String email, String senha, String nickname, int totalInscritos, int horasStreamadas, List<Viewer> inscritos) {
        super(email, senha, nickname);
        this.live = live;
        this.horasStreamadas = horasStreamadas;
        this.totalInscritos = totalInscritos;
        this.inscritos = (inscritos == null) ? new ArrayList<>() : inscritos;
    }


    //Adição e Remoção e Exibição de Inscritos
    public void addInscrito(Viewer novoInscrito){
        this.inscritos.add(novoInscrito);
        this.totalInscritos++;
    }

    public void rmvInscrito(String nickname){
        for(Viewer inscrito : inscritos){
            if(inscrito.getNickname().equals(nickname)){
                inscritos.remove(inscrito);
                return;
            }
        }
        this.totalInscritos--;
    }

    public void exibirInscritos(){
        for(Viewer inscrito : inscritos){
            System.out.println(inscrito.getNickname());
        }
    }

    //Controle de Live
    public void abrirLive(){
        System.out.println("## Live ON!! ##");
        this.live = true;
    };

    public void encerrarLive(){
        System.out.println("## OffStream... ##");
        this.live = false;
    };





    //Getters e Setters
    public boolean getLive(){
        return live;
    }

    public int getHorasStreamadas() {
        return horasStreamadas;
    }

    public void setHorasStreamadas(int horasStreamadas) {
        this.horasStreamadas = horasStreamadas;
    }

    public int getInscritos() {
        return totalInscritos;
    }

    public void setInscritos(int totalInscritos) {
        this.totalInscritos = totalInscritos;
    }

    //To String
    @Override
    public String toString() {
    
        return "Streamer: " + this.nickname + 
        "\n Número de inscritos: " + this.totalInscritos + 
        "\n Total de horas Stremadas: " + this.horasStreamadas;
    }
    
}
