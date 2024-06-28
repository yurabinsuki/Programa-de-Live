package view;

import controller.PlataformaController;
import model.Usuarios.Streamer;
import model.Usuarios.Viewer;

public class PlataformaView {

        public static void inicioView(){
        System.out.println("");
        System.out.println("\n########################################\n");
        System.out.println("# Twi- Sistema de Live não patrocinado #");
        System.out.println("# 1. Entrar com conta                  #");
        System.out.println("# 2. Criar nova conta                  #");
        System.out.println("# 3. Reviver Contas                    #");
        System.out.println("# 0. Encerrar programa                 #");
        System.out.println("\n########################################\n");  
        System.out.println("");

        PlataformaController.inicioControll();
    }

    //Menu de nova conta seleção de tipo
    public static void novaContaView(){
        System.out.println("");
        System.out.println("\n########################################\n");
        System.out.println("#       Selecione o tipo de conta      #");
        System.out.println("# 1. Viewer                            #");
        System.out.println("# 2. Streamer                          #");
        System.out.println("# 0. Voltar                            #");
        System.out.println("\n########################################\n");
        System.out.println("");

        PlataformaController.novaContaControll();

    }

    //Menu Home de Viewer
    public static void homeViewer(Viewer viewer){
        System.out.println("");
        System.out.println("\n########################################\n");
        System.out.println("# Home do Viewer " + viewer.getNickname());
        System.out.println("# 1. Ver canais Ao vivo #");
        System.out.println("# 2. Canais inscritos   #");
        System.out.println("# 3. Mostrar canais     #");
        System.out.println("# 4. Configurações      #");
        System.out.println("# 0. Sair               #");
        System.out.println("\n########################################\n");  
        System.out.println("");

        PlataformaController.homeViewerControll(viewer);
    }

    public static void dentroDoCanalInscrito(Viewer viewer, Streamer streamer){
        System.out.println("\n# Canal " + streamer);
        System.out.println("# Já inscrito #");
        System.out.println("\n# ~~~~~~~~~~~~~~~ #");
        System.out.println("# 1. Se desinscrever ");
        System.out.println("# 0. Voltar ");
        System.out.println("# ~~~~~~~~~~~~~~~ #\n");

        PlataformaController.dentroDoCanalInscritoControl(viewer, streamer);

    }

    public static void dentroDoCanalNaoInscrito(Viewer viewer, Streamer streamer){
        System.out.println("# Canal " + streamer);
        System.out.println("# Não inscrito #");
        System.out.println("\n# ~~~~~~~~~~~~~~~ #");
        System.out.println("# 1. Se inscrever ");
        System.out.println("# 0. Voltar ");
        System.out.println("# ~~~~~~~~~~~~~~~ #\n");

        PlataformaController.dentroDoCanalNaoInscritoControl(viewer, streamer);
        

    }

    //Menu Home de Streamer
    public static void homeStreamerView(Streamer streamer){
        System.out.println("");
        System.out.println("\n########################################\n");
        System.out.println("# Home do Streamer " + streamer.getNickname());
        System.out.println("# 1. Iniciar Live       #");
        System.out.println("# 2. Analytics          #");
        System.out.println("# 3. Configurações      #");
        System.out.println("# 0. Sair               #");
        System.out.println("\n########################################\n");  
        System.out.println("");

        PlataformaController.homeStreamerControll(streamer);

    }

    public static void liveAberta(){
        System.out.println("\n# Live está ON!!#\n");
    }




}
