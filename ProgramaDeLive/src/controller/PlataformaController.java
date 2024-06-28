package controller;

import model.Plataforma;
import model.Usuarios.Streamer;
import model.Usuarios.Viewer;
import view.PlataformaView;
import view.SettingsView;

public class PlataformaController {

    public static void inicioControll(){

        int resp = Utilitario.getInputInt("Digite: ");


            switch (resp) {
                case 1:
                    login();
                    break;
                case 2:
                    PlataformaView.novaContaView();
                    break;
                case 3:
                    Plataforma.reviverContas();
                    break;

                case 0:
                System.out.println("\n# Encerrando programa...");
                    break;
            
                default:
                System.out.println("\n# Opção inválida #\n");
                inicioControll();
                    break;
            }
        
    }

    public static void login(){
        System.out.println("");
        String nick = Utilitario.getInputString("# Insira o nome de Usuário: ");
        String senha = Utilitario.getInputString("# Digite a senha:  ");

        Plataforma.verificarConta(nick, senha);
        
    }

    public static void novaContaControll(){
        
        int resp = Utilitario.getInputInt("Digite: ");

  
       
        switch (resp) {
            case 1:
                criarContaViewerControll();
                break;

            case 2:
                criarContaStreamerControll();
                break;

            case 0: 
                System.out.println("# Voltando...");
                PlataformaView.inicioView();
                break;

            default:
                System.out.println("\n# Opção inválida #\n");
                novaContaControll();
                break;
        }
    
    }
    
    public static void criarContaViewerControll(){
        System.out.println("");
        String email = Utilitario.getInputString("# Digite um e-mail: ");
        Plataforma.verificarEmail(email);

        String senha = Utilitario.getInputString("# Digite uma senha: ");

        String nick = Utilitario.getInputString("# Digite um nome de usuário: ");
        Plataforma.verificarNick(nick);

        Plataforma.criarContaViewer(email, senha, nick);
        System.out.println("");

    }

    public static void criarContaStreamerControll(){
        System.out.println("");

        String email = Utilitario.getInputString("# Digite um e-mail: ");
        Plataforma.verificarEmail(email);

        String senha = Utilitario.getInputString("# Digite uma senha: ");

        String nick = Utilitario.getInputString("# Digite um nome de usuário: ");
        Plataforma.verificarNick(nick);
        System.out.println("");

        Plataforma.criarContaStreamer(email, senha, nick);
    }

    public static void homeViewerControll(Viewer viewer){
        
        int resp = Utilitario.getInputInt("Digite: ");

        switch (resp) {
            case 1:
                Plataforma.mostrarCanaisAoVivo();
                String nick = Utilitario.getInputString("Digite o canal que deseja assistir: ");
                Plataforma.assistirLive(viewer, nick);
                break;

            case 2: 
                Plataforma.mostrarCanaisInscritos(viewer);
                break;

            case 3: 
                Plataforma.buscarCanais(viewer);
                break;

            case 4:
                SettingsView.configViewer(viewer);
                break;

            case 0:
                System.out.println("# Saindo... ");
                PlataformaView.inicioView();
                break;

            default:
                System.out.println("# Opção inválida #");
                homeViewerControll(viewer);
                break;
        }
    
    }

    public static void entrarNoCanalControl(Viewer viewer){
        String resp = Utilitario.getInputString("# Digite o nome do canal desejado: ");
        Plataforma.verificarStreamerPorNick(viewer, resp);

    }

    public static void dentroDoCanalInscritoControl(Viewer viewer, Streamer streamer){
        int resp = Utilitario.getInputInt("# Digite a opção desejada: ");

        switch (resp) {
            case 1:
                Plataforma.desinscreverDoCanal(viewer, streamer);
                break;

            case 0: 
            System.out.println("# Voltando #");
            PlataformaView.homeViewer(viewer);
                break;
        
            default:
            System.out.println("# Opção inválida");
            dentroDoCanalInscritoControl(viewer, streamer);
                break;
        }
    }

    public static void dentroDoCanalNaoInscritoControl(Viewer viewer, Streamer streamer){
        int resp = Utilitario.getInputInt("# Digite a opção desejada: ");

        switch (resp) {
            case 1:
                Plataforma.inscreverNoCanal(viewer, streamer);
                break;

            case 0: 
            System.out.println("# Voltando #");
            PlataformaView.homeViewer(viewer);
                break;
        
            default:
            System.out.println("# Opção inválida");
            dentroDoCanalInscritoControl(viewer, streamer);
                break;
        }
    }

    public static void homeStreamerControll(Streamer streamer){
      
        int resp = Utilitario.getInputInt("Digite: ");

        switch (resp) {
            case 1:
                LiveController.abrirLiveControl(streamer);
                break;

            case 2: 
                Plataforma.mostrarAnalytics(streamer);
                break;

            case 3: 
                SettingsView.configStreamer(streamer);
                break;

            case 0:
                System.out.println("# Saindo...");
                PlataformaView.inicioView();
                break;

            default:
                System.out.println("# Opção inválida #");
                homeStreamerControll(streamer);
                break;
        }
    
    }


}
