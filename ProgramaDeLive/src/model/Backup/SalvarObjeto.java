package model.Backup;

import model.Vod;
import model.Usuarios.Streamer;
import model.Usuarios.Viewer;

import java.io.*;

public class SalvarObjeto {
    
    public static void salvarStreamer(Streamer streamer, String caminho){

        try {
            FileOutputStream fileOut = new FileOutputStream(caminho);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(streamer);
            objectOut.close();
            System.out.println("\n# Streamer " + streamer.getNickname() + " salvo com sucesso! #\n");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void salvarViewer(Viewer viewer, String caminho){

        try {
            FileOutputStream fileOut = new FileOutputStream(caminho);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(viewer);
            objectOut.close();
            System.out.println("\n# Viewer " + viewer.getNickname() + " salvo com sucesso! #\n");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void salvarVod(Vod vod, String caminho){

        try {
            FileOutputStream fileOut = new FileOutputStream(caminho);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(vod);
            objectOut.close();
            System.out.println("\n# Vod salvo com sucesso! #\n");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    
}
