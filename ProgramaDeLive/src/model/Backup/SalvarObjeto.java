package model.Backup;

import model.Usuarios.Streamer;
import model.Usuarios.Viewer;
import model.Vod;

import java.io.*;

public class SalvarObjeto {

    public static void salvarStreamer(Streamer streamer, String caminho) {
        try {
            FileWriter fileWriter = new FileWriter(caminho, true); // true para modo append
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write("Streamer\n");
            bufferedWriter.write("Nickname: " + streamer.getNickname() + "\n");
            bufferedWriter.write("Email: " + streamer.getEmail() + "\n");
            bufferedWriter.write("Senha: " + streamer.getSenha() + "\n");
            bufferedWriter.write("Live: " + streamer.getLive() + "\n");
            bufferedWriter.write("Total de Inscritos: " + streamer.getTotalInscritos() + "\n");
            bufferedWriter.write("Inscritos:\n");
            for (Viewer inscrito : streamer.getInscritos()) {
                bufferedWriter.write("  - " + inscrito.getNickname() + "\n");
            }
            bufferedWriter.write("\n");

            bufferedWriter.close();
            System.out.println("\n# Streamer " + streamer.getNickname() + " salvo com sucesso! #\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void salvarViewer(Viewer viewer, String caminho) {
        try {
            FileWriter fileWriter = new FileWriter(caminho, true); // true para modo append
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write("Viewer\n");
            bufferedWriter.write("Nickname: " + viewer.getNickname() + "\n");
            bufferedWriter.write("Email: " + viewer.getEmail() + "\n");
            bufferedWriter.write("Senha: " + viewer.getSenha() + "\n");
            bufferedWriter.write("Canais Inscritos:\n");
            for (Streamer canal : viewer.getCanaisInscritos()) {
                bufferedWriter.write("  - " + canal.getNickname() + "\n");
            }
            bufferedWriter.write("\n");

            bufferedWriter.close();
            System.out.println("\n# Viewer " + viewer.getNickname() + " salvo com sucesso! #\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void salvarVod(Vod vod, String caminho) {
        try {
            FileWriter fileWriter = new FileWriter(caminho, true); // true para modo append
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write("Vod\n");
            bufferedWriter.write("Streamer: " + vod.getStreamer().getNickname() + "\n");
            bufferedWriter.write("Título: " + vod.getTitulo() + "\n");
            bufferedWriter.write("Categoria: " + vod.getCategoria() + "\n");
            bufferedWriter.write("\n");

            bufferedWriter.close();
            System.out.println("\n# Vod salvo com sucesso! #\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
