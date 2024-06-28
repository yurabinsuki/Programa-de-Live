package controller;

import java.util.concurrent.ScheduledExecutorService;

import model.Chat;
import model.Usuarios.Streamer;
import model.Usuarios.Viewer;

public class ChatController {

    public static void comentarioNoChat(Streamer streamer, Viewer viewer, ScheduledExecutorService cronometro, boolean[] rodando) {
        Thread inputThread = new Thread(() -> {
            while (rodando[0]) {
                String userInput = Utilitario.getInputStringChat();
                System.out.println(viewer.getNickname() + ": " + userInput);

                if (userInput.equals("!sub")) {
                    Chat.sub(viewer, streamer);
                }
                if (userInput.equals("!sair")) {
                    rodando[0] = false;
                }
            }
        });

        // Iniciar a thread de captura de entrada do usuário
        inputThread.setDaemon(true);
        inputThread.start();
    }
}
