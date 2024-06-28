package controller;

import model.Plataforma;
import model.Settings;
import model.Usuarios.Streamer;
import model.Usuarios.Viewer;
import view.PlataformaView;
import view.SettingsView;

public class SettingsController {

    public static void configControlViewer(Viewer viewer){
        int resp = -1;
        resp = Utilitario.getInputInt("# Digite: ");

        switch (resp) {
            case 1:
                mudarNickViewerControl(viewer);
                break;

            case 2: 
                mudarSenhaViewerControl(viewer);
                break;

            case 3: 
                Plataforma.removerViewer(viewer);
                break;

            case 0:
                System.out.println("# Voltando... #");
                PlataformaView.homeViewer(viewer);
                break;

            default:
                System.out.println("# Opção inválida #");
                break;
        }
    }

    public static void mudarNickViewerControl(Viewer viewer){
        String novoNick = Utilitario.getInputString("# Digite o novo nick: ");
        Settings.mudarNickViewer(viewer, novoNick);
        PlataformaView.homeViewer(viewer);
    }

    public static void mudarSenhaViewerControl(Viewer viewer){
        String novaSenha = Utilitario.getInputString("# Digite o novo nick: ");
        Settings.alterarSenhaViewer(viewer, novaSenha);
        PlataformaView.homeViewer(viewer);
    }


    public static void configControlStreamer(Streamer streamer){
        int resp = -1;
        resp = Utilitario.getInputInt("# Digite: ");

        switch (resp) {
            case 1:
                mudarNickStreamerControl(streamer);
                break;

            case 2: 
                mudarSenhaStreamerControl(streamer);
                break;

            case 3: 
                Plataforma.removerStreamer(streamer);
                break;

            case 0:
                System.out.println("# Voltando... #");
                PlataformaView.homeStreamerView(streamer);
                break;

            default:
                System.out.println("# Opção inválida #");
                SettingsView.configStreamer(streamer);
                break;
        }
    }

    public static void mudarNickStreamerControl(Streamer streamer){
        String novoNick = Utilitario.getInputString("# Digite o novo nick: ");
        Settings.mudarNickStreamer(streamer, novoNick);
    }

    public static void mudarSenhaStreamerControl(Streamer streamer){
        String novaSenha = Utilitario.getInputString("# Digite o novo nick: ");
        Settings.alterarSenhaStreamer(streamer, novaSenha);
    }



}
