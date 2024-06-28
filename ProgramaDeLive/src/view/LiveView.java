package view;

import controller.LiveController;
import model.Usuarios.Streamer;

public class LiveView {

    public static void abrirLiveView(Streamer streamer, String categoria, String titulo){
        System.out.println("# " + titulo + " - " + streamer.getNickname() + " | " + categoria);

        System.out.println("# Digite '!parar' para encerrar a Live #");
        LiveController.LiveRodandoControl(streamer, categoria, titulo);
    }

    public static void encerrarLiveView(Streamer streamer, String categoria, String titulo){
        System.out.println("# Live encerrada #");
        PlataformaView.homeStreamerView(streamer);
    }






    
}
