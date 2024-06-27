package model.Interativo;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import model.Usuarios.Streamer;
import model.Usuarios.Viewer;

public class Chat {
 
        public static void chat(Streamer streamer, Viewer viewer){
            Scanner leitor = new Scanner(System.in);
            boolean rodarChat = true;
            while (rodarChat) {
            
        if(streamer.getLive() == true){

            String[] randomUser = {
                "\u001B[31mdarkpriest: \u001B[0m",       // Red
                "\u001B[32mbananagamer: \u001B[0m",      // Green
                "\u001B[33mshadowhunter: \u001B[0m",     // Yellow
                "\u001B[34mstormbringer: \u001B[0m",     // Blue
                "\u001B[35mnightslayer: \u001B[0m",      // Purple
                "\u001B[36mphantomwarrior: \u001B[0m",   // Cyan
                "\u001B[37mghostsniper: \u001B[0m",      // White
                "\u001B[90mdragonmaster: \u001B[0m",     // Bright Black (Gray)
                "\u001B[91mfiremage: \u001B[0m",         // Bright Red
                "\u001B[92mironknight: \u001B[0m",       // Bright Green
                "\u001B[93mcelestialfox: \u001B[0m",     // Bright Yellow
                "\u001B[94mmoonrider: \u001B[0m",        // Bright Blue
                "\u001B[95msilverarrow: \u001B[0m",      // Bright Purple
                "\u001B[96mwindranger: \u001B[0m",       // Bright Cyan
                "\u001B[97mstonetitan: \u001B[0m",       // Bright White
                "\u001B[31mdesertking: \u001B[0m",       // Red
                "\u001B[32mforestqueen: \u001B[0m",      // Green
                "\u001B[33micewarrior: \u001B[0m",       // Yellow
                "\u001B[34mthunderlord: \u001B[0m",      // Blue
                "\u001B[35mpoisonarrow: \u001B[0m",      // Purple
                "\u001B[36msandwizard: \u001B[0m",       // Cyan
                "\u001B[37mseasorcerer: \u001B[0m",      // White
                "\u001B[90mstarhunter: \u001B[0m",       // Bright Black (Gray)
                "\u001B[91mvolcanomancer: \u001B[0m",    // Bright Red
                "\u001B[92mwildtracker: \u001B[0m"       // Bright Green
            };
            String[] comentarios = {
                "Inacreditável",
                "GG",
                "Olha o nível desse jogo!",
                "POGGERS",
                "Sem palavras!",
                "TÁ LOUCO",
                "que cara meme",
                "Só vai",
                "JOGOU MUITO!",
                "Tá voando!",
                "faltava um teco mlk",
                "QUASE!",
                "Deu ruim...",
                "Só observando aqui",
                "Que partida, hein!",
                "Nem fodendo",
                "Confia",
                "Que azar...",
                "cagao",
                "Manda salve",
                "Muito bom!",
                "Aí sim",
                "Clipado",
                "Pro player demais!",
                "Respeita!",
                "Tenso demais!",
                "Tô tremendo aqui!",
                "OMEGALUL vey",
                "Eita *flushed*",
                "JOGA MUITO!",
                "Esse é o cara!",
                "QUE CHAPAÇÃO!",
                "Vai dar bom",
                "o cara não mandou essa",
                "Deus Gamer",
                "feelsgoodman",
                "Qual o nome do jogo?",
                "Meu mano simplesmente ESMIRILHOU nessa",
                "Perfeito",
                "O cara não erra",
                "Destruiu!",
                "Joga DbD",
                "hmmm",
                "apaga agora pelo amor de deus tá todo mundo pedindo pra apagar tem criança chorando aqui já tá todo mundo engatilhado por favor essa informação eh muito pesada traz traumas horriveis pra muita gente te gente que fica com gatilho que passa mal desmaia apaga isso pelo amor de deus",
                "noooooooooooooo"
            };

            ScheduledExecutorService cronometro = Executors.newScheduledThreadPool(1);

             // Thread para capturar a entrada do usuário sem bloquear o cronômetro
        Thread inputThread = new Thread(() -> {
            while (true) {
                String userInput = leitor.nextLine();
                System.out.println(viewer.getNickname() + ": " + userInput);
                if (userInput.equals("!sub")) {
                    Plataforma.sub(viewer, streamer);
                }
                if(userInput.equals("!sair")) {
                    Plataforma.sair(viewer);
                    
                }

            }
        });

        // Iniciar a thread de captura de entrada do usuário
        inputThread.setDaemon(true);
        inputThread.start();

        // Tarefa que será executada a cada 5 segundos
        Runnable task = () -> {
            Random random = new Random();
            int userIndex = random.nextInt(randomUser.length);
            int commentIndex = random.nextInt(comentarios.length);
            String user = randomUser[userIndex];
            String comment = comentarios[commentIndex];

            System.out.println(user + comment);
        };

        // Agendando a tarefa para ser executada periodicamente
        cronometro.scheduleAtFixedRate(task, 1, 5, TimeUnit.SECONDS);
            
        }
        }
    }
}
