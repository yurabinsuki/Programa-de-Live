package controller;

import model.Live;
import model.Usuarios.Streamer;

public class LiveController {
    

    public static void abrirLiveControl(Streamer streamer){
        String titulo = Utilitario.getInputString("# Titulo da Live: ");
        String categoria = VodController.definirCategoriaControl();

        Live.abrirLive(streamer, categoria, titulo);
    }

    public static void LiveRodandoControl(Streamer streamer, String categoria, String titulo){
        String resp = Utilitario.getInputStringChat();

        switch (resp) {
            case "!parar":
                Live.encerrarLive(streamer, categoria, titulo);
                break;
        
            default:
            System.out.println("# Opção inválida #");
            LiveRodandoControl(streamer, categoria, titulo);
                break;
        }
    }
}
