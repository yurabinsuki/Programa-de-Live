package Classes.Usuarios;
import Classes.User;
import java.util.List;
import java.util.ArrayList;

//Gerador de comentários
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class Streamer extends User{

    private boolean live;
    private int horasStreamadas;
    private int totalInscritos;
    private List<Viewer> inscritos;

    public Streamer(boolean live, String email, String senha, String nickname, int totalInscritos, int horasStreamadas, List<Viewer> inscritos) {
        super(email, senha, nickname);
        this.live = live;
        this.horasStreamadas = horasStreamadas;
        this.totalInscritos = totalInscritos;
        this.inscritos = (inscritos == null) ? new ArrayList<>() : inscritos;
    }


    //Adição e Remoção e Exibição de Inscritos
    public void addInscrito(Viewer novoInscrito){
        this.inscritos.add(novoInscrito);
        this.totalInscritos++;
    }

    public void rmvInscrito(String nickname){
        for(Viewer inscrito : inscritos){
            if(inscrito.getNickname().equals(nickname)){
                inscritos.remove(inscrito);
                return;
            }
        }
        this.totalInscritos--;
    }

    public void exibirInscritos(){
        for(Viewer inscrito : inscritos){
            System.out.println(inscrito.getNickname());
        }
    }

    //Controle de Live
    public void abrirLive(){
        System.out.println("## Live ON!! ##");
        this.live = true;
    };

    public void encerrarLive(){
        System.out.println("## OffStream... ##");
        this.live = false;
    };


    public void chat(){
        if(this.live == true){

            String[] randomUser = {
                "\u001B[31mdarkpriest:\u001B[0m",       // Red
                "\u001B[32mbananagamer:\u001B[0m",      // Green
                "\u001B[33mshadowhunter:\u001B[0m",     // Yellow
                "\u001B[34mstormbringer:\u001B[0m",     // Blue
                "\u001B[35mnightslayer:\u001B[0m",      // Purple
                "\u001B[36mphantomwarrior:\u001B[0m",   // Cyan
                "\u001B[37mghostsniper:\u001B[0m",      // White
                "\u001B[90mdragonmaster:\u001B[0m",     // Bright Black (Gray)
                "\u001B[91mfiremage:\u001B[0m",         // Bright Red
                "\u001B[92mironknight:\u001B[0m",       // Bright Green
                "\u001B[93mcelestialfox:\u001B[0m",     // Bright Yellow
                "\u001B[94mmoonrider:\u001B[0m",        // Bright Blue
                "\u001B[95msilverarrow:\u001B[0m",      // Bright Purple
                "\u001B[96mwindranger:\u001B[0m",       // Bright Cyan
                "\u001B[97mstonetitan:\u001B[0m",       // Bright White
                "\u001B[31mdesertking:\u001B[0m",       // Red
                "\u001B[32mforestqueen:\u001B[0m",      // Green
                "\u001B[33micewarrior:\u001B[0m",       // Yellow
                "\u001B[34mthunderlord:\u001B[0m",      // Blue
                "\u001B[35mpoisonarrow:\u001B[0m",      // Purple
                "\u001B[36msandwizard:\u001B[0m",       // Cyan
                "\u001B[37mseasorcerer:\u001B[0m",      // White
                "\u001B[90mstarhunter:\u001B[0m",       // Bright Black (Gray)
                "\u001B[91mvolcanomancer:\u001B[0m",    // Bright Red
                "\u001B[92mwildtracker:\u001B[0m"       // Bright Green
            };
            
            String[] comentarios = {
                "BORA!",
                "Inacreditável!",
                "GG EZ!",
                "Olha o nível desse jogo!",
                "POGGERS",
                "Mandou bem demais!",
                "Sem palavras!",
                "TÁ LOUCO!",
                "Isso foi insano!",
                "Cê é louco, bicho!",
                "É disso que eu tô falando!",
                "Só vai!",
                "JOGOU MUITO!",
                "Tá voando!",
                "Meus parabéns!",
                "QUASE!",
                "Deu ruim...",
                "Só observando aqui",
                "Que partida, hein!",
                "Nem fodendo",
                "Clutch master!",
                "Que azar...",
                "Bateu na trave!",
                "Tamo junto!",
                "Manda salve!",
                "Que emoção!",
                "Muito bom!",
                "Coração a mil!",
                "É o mito!",
                "Aí sim",
                "Clipado",
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣤⣤⣤⣤⣤⣶⣦⣤⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⢀⣴⣿⡿⠛⠉⠙⠛⠛⠛⠛⠻⢿⣿⣷⣤⡀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⣼⣿⠋⠀⠀⠀⠀⠀⠀⠀⢀⣀⣀⠈⢻⣿⣿⡄⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⣸⣿⡏⠀⠀⠀⣠⣶⣾⣿⣿⣿⠿⠿⠿⢿⣿⣿⣿⣄⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⣿⣿⠁⠀⠀⢰⣿⣿⣯⠁⠀⠀⠀⠀⠀⠀⠀⠈⠙⢿⣷⡄⠀\n" +
                "⠀⠀⣀⣤⣴⣶⣶⣿⡟⠀⠀⠀⢸⣿⣿⣿⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣷⠀\n" +
                "⠀⢰⣿⡟⠋⠉⣹⣿⡇⠀⠀⠀⠘⣿⣿⣿⣿⣷⣦⣤⣤⣤⣶⣶⣶⣶⣿⣿⣿⠀\n" +
                "⠀⢸⣿⡇⠀⠀⣿⣿⡇⠀⠀⠀⠀⠹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠃⠀\n" +
                "⠀⣸⣿⡇⠀⠀⣿⣿⡇⠀⠀⠀⠀⠀⠉⠻⠿⣿⣿⣿⣿⡿⠿⠿⠛⢻⣿⡇⠀⠀\n" +
                "⠀⣿⣿⠁⠀⠀⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣧⠀⠀⠀\n" +
                "⠀⣿⣿⠀⠀⠀⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⠀⠀⠀\n" +
                "⠀⣿⣿⠀⠀⠀⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⠀⠀⠀\n" +
                "⠀⢿⣿⡆⠀⠀⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⡇⠀⠀⠀\n" +
                "⠀⠸⣿⣧⡀⠀⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⠃⠀⠀⠀\n" +
                "⠀⠀⠛⢿⣿⣿⣿⣿⣇⠀⠀⠀⠀⠀⣰⣿⣿⣷⣶⣶⣶⣶⠶⠀⢠⣿⣿⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⣿⣿⠀⠀⠀⠀⠀⣿⣿⡇⠀⣽⣿⡏⠁⠀⠀⢸⣿⡇⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⣿⣿⠀⠀⠀⠀⠀⣿⣿⡇⠀⢹⣿⡆⠀⠀⠀⣸⣿⠇⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⢿⣿⣦⣄⣀⣠⣴⣿⣿⠁⠀⠈⠻⣿⣿⣿⣿⡿⠏⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠈⠛⠻⠿⠿⠿⠿⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
                "Pro player demais!",
                "Respeita!",
                "Tenso demais!",
                "Tô tremendo aqui!",
                "OMEGALUL vey",
                "Eita!",
                "JOGA MUITO!",
                "Esse é o cara!",
                "QUE CHAPAÇÃO!",
                "Vai dar bom!",
                "Ufa, que alívio!",
                "Mão suando aqui",
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⣾⣿⠟⢻⡀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠹⣿⣳⠖⠳⣄⡀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⡤⠒⠀⠂⡾⠉⠀⠀⠀⠀⠉⢳⡄⣄⡀⠀⠀\n" +
                "⠀⠀⠀⢸⡥⠀⣀⡼⢁⠀⢰⡄⠀⡄⠀⠀⣧⠀⠙⡆⠀\n" +
                "⠀⢀⣠⠼⠗⠚⠉⠠⠋⠀⠀⢷⣠⣧⠀⠀⠈⠳⢤⣇⠀\n" +
                "⠀⣾⣟⠒⠦⣄⠀⠀⠀⣠⡴⠋⠁⢈⠛⢦⣄⣠⣴⣾⣷\n" +
                "⢀⡟⠙⢶⣤⠬⠷⣼⡏⠉⠉⢩⡍⠹⠦⢤⣿⣤⣨⣿⠈\n" +
                "⡾⣡⠆⠁⠀⠀⠀⢠⡀⠀⠀⠀⢱⡀⠀⠂⠙⠎⠻⡅⠀\n" +
                "⢿⠁⠒⣤⠤⣤⣀⠀⢧⠀⠀⠀⣸⠃⠀⠀⠀⡶⣤⣽⠀\n" +
                "⠈⠳⣴⡇⠀⠀⠈⠛⢦⣄⣠⠾⢿⣄⣀⣠⠾⣡⠞⠁⠀\n" +
                "⠀⠀⠈⠉⠉⠉⠁⢧⢠⠟⣽⠀⢿⠀⢧⢰⡈⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠐⢫⠏⢸⠁⠀⠈⢳⠘⢧⣙⢦⠀⠀⠀",
                "O mestre!",
                "Mito demais!",
                "Boa demais!",
            "⢀⡴⠑⡄⠀⠀⠀⠀⠀⠀⠀⣀⣀⣤⣤⣤⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ \n" +
            "⠸⡇⠀⠿⡀⠀⠀⠀⣀⡴⢿⣿⣿⣿⣿⣿⣿⣿⣷⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀ \n" +
            "⠀⠀⠀⠀⠑⢄⣠⠾⠁⣀⣄⡈⠙⣿⣿⣿⣿⣿⣿⣿⣿⣆⠀⠀⠀⠀⠀⠀⠀⠀ \n" +
            "⠀⠀⠀⠀⢀⡀⠁⠀⠀⠈⠙⠛⠂⠈⣿⣿⣿⣿⣿⠿⡿⢿⣆⠀⠀⠀⠀⠀⠀⠀ \n" +
            "⠀⠀⠀⢀⡾⣁⣀⠀⠴⠂⠙⣗⡀⠀⢻⣿⣿⠭⢤⣴⣦⣤⣹⠀⠀⠀⢀⢴⣶⣆ \n" +
            "⠀⠀⢀⣾⣿⣿⣿⣷⣮⣽⣾⣿⣥⣴⣿⣿⡿⢂⠔⢚⡿⢿⣿⣦⣴⣾⠁⠸⣼⡿ \n" +
            "⠀⢀⡞⠁⠙⠻⠿⠟⠉⠀⠛⢹⣿⣿⣿⣿⣿⣌⢤⣼⣿⣾⣿⡟⠉⠀⠀⠀⠀⠀ \n" +
            "⠀⣾⣷⣶⠇⠀⠀⣤⣄⣀⡀⠈⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀ \n" +
            "⠀⠉⠈⠉⠀⠀⢦⡈⢻⣿⣿⣿⣶⣶⣶⣶⣤⣽⡹⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀ \n" +
            "⠀⠀⠀⠀⠀⠀⠀⠉⠲⣽⡻⢿⣿⣿⣿⣿⣿⣿⣷⣜⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀ \n" +
            "⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣷⣶⣮⣭⣽⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀ \n" +
            "⠀⠀⠀⠀⠀⠀⣀⣀⣈⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠇⠀⠀⠀⠀⠀⠀⠀ \n" +
            "⠀⠀⠀⠀⠀⠀⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠃⠀⠀⠀⠀⠀⠀⠀⠀ \n" +
            "⠀⠀⠀⠀⠀⠀⠀⠹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀ \n" +
            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠛⠻⠿⠿⠿⠿⠛⠉",
                "o cara não mandou essa",
                "Mandou bem!",
                "É GG!",
                "feelsgoodman",
                "TOPOU!",
                "Meu mano simplesmente ESMIRILHOU nessa",
                "Perfeito",
                "O cara não erra",
                "Destruiu!",
                "Sempre na frente!",
                "hmmm",
                "Só sucesso!",
                "Que aula!",
                "Que fase!",
                "noooooooooooooo"
            };

            ScheduledExecutorService cronometro = Executors.newScheduledThreadPool(1);

            cronometro.scheduleAtFixedRate(() -> {
                Random r = new Random();
                String comentario = randomUser[r.nextInt(comentarios.length)] + comentarios[r.nextInt(comentarios.length)];
                System.out.println(comentario);
            }, 5, 5, TimeUnit.SECONDS);
            
        }
    }


    //Getters e Setters
    public int getHorasStreamadas() {
        return horasStreamadas;
    }

    public void setHorasStreamadas(int horasStreamadas) {
        this.horasStreamadas = horasStreamadas;
    }

    public int getInscritos() {
        return totalInscritos;
    }

    public void setInscritos(int totalInscritos) {
        this.totalInscritos = totalInscritos;
    }

    //To String
    @Override
    public String toString() {
    
        return "Streamer: " + this.nickname + 
        "\n Número de inscritos: " + this.totalInscritos + 
        "\n Total de horas Stremadas: " + this.horasStreamadas;
    }
    
}
