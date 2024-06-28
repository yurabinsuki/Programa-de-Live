package view;

import controller.SettingsController;
import model.Usuarios.Streamer;
import model.Usuarios.Viewer;

public class SettingsView {

    public static void configViewer(Viewer viewer){

        System.out.println("");
        System.out.println("\n########################################\n");
        System.out.println(viewer);
        System.out.println("");
        System.out.println("# 1. Alterar nickname    #");
        System.out.println("# 2. Alterar senha       #");
        System.out.println("# 3. Deletar conta       #");
        System.out.println("# 0. Voltar              #");
        System.out.println("\n########################################\n");  
        System.out.println("");

        SettingsController.configControlViewer(viewer);

    }

    public static void configStreamer(Streamer streamer){

        System.out.println("");
        System.out.println("# 1. Alterar nickname    #");
        System.out.println("# 2. Alterar senha       #");
        System.out.println("# 3. Deletar conta       #");
        System.out.println("# 0. Voltar              #");
        System.out.println("\n########################################\n");  
        System.out.println("");

        SettingsController.configControlStreamer(streamer);

    }
    
}
