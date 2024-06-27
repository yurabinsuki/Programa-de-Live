package model.Interativo;

import java.util.Scanner;

import model.Usuarios.Streamer;
import model.Usuarios.Viewer;

import java.util.List;
import java.util.ArrayList;



public class Plataforma {

    public static List<Viewer> viewers = new ArrayList<>();
    public static List<Streamer> streamers = new ArrayList<>();


    public static void addContas(){
        Streamer pelfs = new Streamer(true, "eoselfs@tmail.com", "segredo", "Pelfs", 1500000, 10000, viewers);
        Streamer bitcel = new Streamer(false, "bitcel@tmail.com", "segredo", "Bitcel", 2000000, 16000, viewers);
        Streamer aaronzuka = new Streamer(true, "aaronzuka69@tmail.com", "segredo", "Aaronzuka", 3000000, 12000, viewers);
        Streamer notathingshow = new Streamer(false, "notalive@tmail.com", "segredo", "NotaThingShow", 29, 130, viewers);
        Streamer molhodevinho = new Streamer(true, "vinesauce@tmail.com", "segredo", "Molho", 606000, 25000, viewers);
    
        streamers.add(pelfs);
        streamers.add(bitcel);
        streamers.add(aaronzuka);
        streamers.add(notathingshow);
        streamers.add(molhodevinho);
    
        Viewer teste = new Viewer("teste@tmail.com", "a", "a", streamers);
        viewers.add(teste);

    }


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
            inicio();
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
        System.out.println("# 2. Canais inscritos   #");
        System.out.println("# 3. Buscar canais      #");
        System.out.println("# 4. Configurações      #");
        System.out.println("# 0. Sair               #");
        System.out.println("########################################");  
        System.out.println("");

        int resp = getInputInt("Digite: ");

        switch (resp) {
            case 1:
                mostrarCanaisAoVivo();
                String nick = getInputString("Digite o canal que deseja assistir: ");
                assistirLive(viewer, nick);
                break;

            case 2: 
                mostrarCanaisIscritos();
                break;

                case 3: 
                buscarCanais();
            default:
                break;
        }
    }

    public static void mostrarCanaisAoVivo(){
        for(Streamer streamer : streamers){
            if (streamer.getLive() == true) {
                System.out.println(streamer.getNickname());
            }
        }
    }

    public static void assistirLive(Viewer viewer, String nick){
        for(Streamer streamer : streamers){
            if (streamer.getNickname().equals(nick)) {
                System.out.println("# Você está assistindo ao canal: " + streamer.getNickname());
                System.out.println("### Digite '!sub' para se inscrever, '!sair' para sair da live ###");
                Chat.chat(streamer, viewer);
            }
        }
    }

    public static void sub(Viewer viewer, Streamer streamer){
        viewer.getCanaisInscritos().add(streamer);
    }

    public static void sair(Viewer viewer){
        homeViewer(viewer);
    }

    public static void mostrarCanaisIscritos(){
        for(Streamer streamer : streamers){
            System.out.println("# Canais inscritos: [" + streamer.getNickname() + ", ");
        }
        System.out.println("]");
    }

    public static void buscarCanais(){
        for(Streamer streamer : streamers){
            if (streamer.getLive() == true) {
                System.out.println("# Canais em live: " + streamer.getNickname());
            }
            System.out.println("# Canais OffStream: " + streamer.getNickname());
        }
    }



    public static void homeStreamer(Streamer streamer){
        System.out.println("Home do Streamaer");
        System.out.println(streamer);

    }


    

}
