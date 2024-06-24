package Classes.Interativo;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

import Classes.Usuarios.Streamer;
import Classes.Usuarios.Viewer;



public class Plataforma {

    public List<Viewer> viewers = new ArrayList<>();
    public List<Streamer> streamers = new ArrayList<>();

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

    public void inicio(){
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
                
                break;

            case 0:
            System.out.println("\n# Encerrando programa...");
                break;
        
            default:
            System.out.println("\n#            Opção inválida            #\n");
                break;
        }
    }

    public void login(){
        System.out.println("");
        System.out.println("########################################");
        System.out.println("#       Selecione o tipo de conta      #");
        System.out.println("# 1. Viewer                            #");
        System.out.println("# 2. Streamer                          #");
        System.out.println("# 0. Voltar                            #");
        System.out.println("########################################");
        System.out.println("");
    }

    public void criarConta(){
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
                String senha = getInputString("# Digite uma senha: ");
                String nick = getInputString("# Digite um nome de usuário: ");
                System.out.println("");

                Viewer novoViewer = new Viewer(email, senha, nick, null);
                viewers.add(novoViewer);
                break;

            case 2:
                System.out.println("");
                String email2 = getInputString("# Digite um e-mail: ");
                String senha2 = getInputString("# Digite uma senha: ");
                String nick2 = getInputString("# Digite um nome de usuário: ");
                System.out.println("");

                Streamer novoStreamer = new Streamer(false, email2, senha2, nick2, 0, 0, null);
                streamers.add(novoStreamer);
                break;

            case 0: 
                System.out.println("# Voltando...");
                break;

            default:
                System.out.println("\n#            Opção inválida            #\n");
                break;
        }

    }
    

}
