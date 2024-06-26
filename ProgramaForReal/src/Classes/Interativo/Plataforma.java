package Classes.Interativo;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

import Classes.Usuarios.Streamer;
import Classes.Usuarios.Viewer;



public class Plataforma {

    public static List<Viewer> viewers = new ArrayList<>();
    public static List<Streamer> streamers = new ArrayList<>();

    public static String getInputString(String texto) {
        Scanner leitor = new Scanner(System.in);
        System.out.print(texto);
        return leitor.nextLine();
    }

    public static int getInputInt(String texto){
        Scanner leitor = new Scanner(System.in);

        System.out.print(texto);
        String valorDigitado = leitor.nextLine();

        return Integer.parseInt(valorDigitado);
        
    }

    public static void inicio(){
        System.out.println("");
        System.out.println("########################################");
        System.out.println("# Twi- Sistema de Live não patrocinado #");
        System.out.println("# 1. Entrar com conta                  #");
        System.out.println("# 2. Criar nova conta                  #");
        System.out.println("# 3. Continuar desconectado            #");
        System.out.println("# 0. Encerrar programa                 #");
        System.out.println("########################################");  
        System.out.println("");

        int resp = getInputInt("Digite: ");

        switch (resp) {
            case 1:
                login();
                break;
            case 2:
                criarConta();
                break;
            case 3:
                homeViewer(null);
                break;

            case 0:
            System.out.println("\n# Encerrando programa...");
                break;
        
            default:
            System.out.println("\n# Opção inválida #\n");
                break;
        }
    }

    public static void login(){
        System.out.println("");
        String nick = getInputString("# Insira o nome de Usuário: ");
        String senha = getInputString("# Digite a senha:  ");

        boolean usuarioEncontrado = false;

        // Verifica se o usuário é um Streamer
        for (Streamer streamer : streamers) {
            if (streamer.getNickname().equals(nick) && streamer.getSenha().equals(senha)) {
                usuarioEncontrado = true;
                System.out.println("# Conectado com sucesso #");
                homeStreamer(streamer);
                break;
            }
        }

        // Verifica se o usuário é um Viewer
        if (!usuarioEncontrado) {
            for (Viewer viewer : viewers) {
                if (viewer.getNickname().equals(nick) && viewer.getSenha().equals(senha)) {
                    usuarioEncontrado = true;
                    System.out.println("# Conectado com sucesso #");
                    homeViewer(viewer);
                    break;
                }
            }
        }

        if (!usuarioEncontrado) {
            System.out.println("# Nome de usuário ou senha incorretos. #");
        }
    }

    public static void criarConta(){

        System.out.println("");
        System.out.println("########################################");
        System.out.println("#       Selecione o tipo de conta      #");
        System.out.println("# 1. Viewer                            #");
        System.out.println("# 2. Streamer                          #");
        System.out.println("# 0. Voltar                            #");
        System.out.println("########################################");
        System.out.println("");

        int resp = getInputInt("Digite: ");
       
            switch (resp) {
                case 1:
                    System.out.println("");
                    String email = getInputString("# Digite um e-mail: ");
                    for(Viewer viewer : viewers){
                        if(viewer.getEmail().equals(email)){
                            System.out.println("# Esse e-mail já está em uso! #");
                            email = getInputString("Digite outro e-mail ou realize o login: ");
                        }
                    }

                    String senha = getInputString("# Digite uma senha: ");

                    String nick = getInputString("# Digite um nome de usuário: ");
                    for(Viewer viewer : viewers){
                        if(viewer.getNickname().equals(nick)){
                            System.out.println("# Esse nome já está em uso! #");
                            nick = getInputString("Insira outro nome de usuário: ");
                        }
                    }
                    System.out.println("");

                    Viewer novoViewer = new Viewer(email, senha, nick, null);
                        viewers.add(novoViewer);

                    System.out.println("# Usuário criado com sucesso! #");
                    homeViewer(novoViewer);
                    break;

                case 2:
                    System.out.println("");

                    email = getInputString("# Digite um e-mail: ");
                    for(Streamer streamer : streamers){
                        if(streamer.getEmail().equals(email)){
                            System.out.println("# Esse e-mail já está em uso! #");
                            email = getInputString("Digite outro e-mail ou realize o login: ");
                        }
                    }

                    senha = getInputString("# Digite uma senha: ");

                    nick = getInputString("# Digite um nome de usuário: ");
                    for(Streamer streamer : streamers){
                        if(streamer.getNickname().equals(nick)){
                            System.out.println("# Esse nome já está em uso! #");
                            email = getInputString("Digite outro nome de usuário: ");
                        }
                    }
                    System.out.println("");

                    Streamer novoStreamer = new Streamer(false, email, senha, nick, 0, 0, null);
                        streamers.add(novoStreamer);

                    System.out.println("# Usuário criado com sucesso! #");
                    homeStreamer(novoStreamer);
                    break;

                case 0: 
                    System.out.println("# Voltando...");
                    inicio();
                    break;

                default:
                    System.out.println("\n# Opção inválida #\n");
                    break;
            }

    }

    public static void homeViewer(Viewer viewer){
        System.out.println("");
        System.out.println("########################################");
        System.out.println("# Home do Viewer " + viewer.getNickname());
        System.out.println("# 1. Ver canais Ao vivo #");
        System.out.println("# 2. Canais inscritos #");
        System.out.println("# 3. Buscar canais #");
        System.out.println("# 4. Configurações #");
        System.out.println("# 0. Sair #");
        System.out.println("########################################");  
        System.out.println("");

    }

    public static void homeStreamer(Streamer streamer){
        System.out.println("Home do Streamaer");
        System.out.println(streamer);

    }

    

}
