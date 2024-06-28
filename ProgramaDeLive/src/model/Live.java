package model;

import model.Backup.SalvarObjeto;
import model.Usuarios.Streamer;
import view.LiveView;

public class Live {

    public static void abrirLive(Streamer streamer, String categoria, String titulo){
        LiveView.abrirLiveView(streamer, categoria, titulo);

    }
    
    public static void encerrarLive(Streamer streamer, String categoria, String titulo){
        Vod novoVod = new Vod(streamer, titulo, categoria);
        switch (novoVod.getCategoria()) {
            case "JOGOS":
                Plataforma.adicionarVodJogos(novoVod);
                break;
            case "CONVERSA":
                Plataforma.adicionarVodJogos(novoVod);
                break;
            case "ESTUDO":
                Plataforma.adicionarVodJogos(novoVod);
                break;
        }
        try {
            String caminhoVod = "src/model/Backup/vodSalvo.txt";
        SalvarObjeto.salvarVod(novoVod, caminhoVod);
            
        } catch (Exception e) {
            System.out.println("Deu BO no salvamento do VOD");
        }
        

        LiveView.encerrarLiveView(streamer, categoria, titulo);
    }




    
}
