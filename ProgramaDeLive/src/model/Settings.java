package model;

import model.Usuarios.Streamer;
import model.Usuarios.Viewer;
import view.PlataformaView;

public class Settings {

    public static void mudarNickViewer(Viewer viewer, String novoNick){
        Plataforma.verificarNick(novoNick);
        viewer.setNickname(novoNick);

        PlataformaView.homeViewer(viewer);
    }
    public static void mudarNickStreamer(Streamer streamer, String novoNick){
        Plataforma.verificarNick(novoNick);
        streamer.setNickname(novoNick);

        PlataformaView.homeStreamerView(streamer);
    }

    public static void alterarSenhaViewer(Viewer viewer, String novaSenha){
        viewer.setSenha(novaSenha);

        PlataformaView.homeViewer(viewer);
    }

    public static void alterarSenhaStreamer(Streamer streamer, String novaSenha){
        streamer.setSenha(novaSenha);

        PlataformaView.homeStreamerView(streamer);
    }

    public static void deletarContaViewer(Viewer viewer){
        Plataforma.removerViewer(viewer);

        PlataformaView.homeViewer(viewer);
    }

}
