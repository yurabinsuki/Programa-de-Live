package Classes.Interativo;
import java.util.Scanner;
import Classes.Usuarios.Streamer;

public class Plataforma {

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
        System.out.println("########################################");  
        System.out.println("");

        int resp = getInputInt("Digite: ");

        switch (resp) {
            case 1:
                
                break;
            case 2:
                
                break;
            case 3:
                
                break;
        
            default:
            System.out.println(""); 
            System.out.println("#            Opção inválida            #");
            System.out.println(""); 
                break;
        }
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


    }
    

}
