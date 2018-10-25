import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static int turno = 0;
    static int[] rodada = new int[4];
    static ArrayList<Cartas> baralho = new ArrayList<Cartas>();
    static boolean teste = true;

    public static void main(String[] args){

        //Incializar jogador
        Jogador player1 = new Jogador("Lucas", escolheClasse(), 1 );
        Jogador player2 = new Jogador("Nathan", escolheClasse(), 2);
        Jogador player3 = new Jogador("Jorge", escolheClasse(), 3 );
        Jogador player4 = new Jogador("Marcos", escolheClasse(), 4 );

        ordenarJogadores();
        while(teste) {
            embaralhar();

            //Checar turno
            if (rodada[turno] == 1) {
                //Turno
                player1.comprarCarta(baralho);
                player1.usarCarta(player1.mao.get(0), player2);
                passarTurno();
            } else if (rodada[turno] == 2) {
                //Turno
                player2.comprarCarta(baralho);
                player2.usarCarta(player2.mao.get(0), player3);
                passarTurno();
            } else if (rodada[turno] == 3) {
                //Turno
                player3.comprarCarta(baralho);
                player3.usarCarta(player3.mao.get(0), player4);
                passarTurno();
            } else if (rodada[turno] == 4) {
                //Turno
                player4.comprarCarta(baralho);
                player4.usarCarta(player4.mao.get(0), player1);
                passarTurno();
            }
            if(player1.vida == 0 || player2.vida == 0 || player3.vida == 0 || player4.vida == 0){
                teste = false;
            }
        }
    }

     private static Classe escolheClasse(){
        Scanner in = new Scanner(System.in);
        System.out.println("Escolha sua classe: 1 - Mago, 2 - Guerreiro, 3 - Paladino, 4 - Clerigo");
        int classe =  in.nextInt();
        switch (classe){
            case 1:
                Mago mago = new Mago();
                return mago;
            case 2:
                Guerreiro guerreiro = new Guerreiro();
                return guerreiro;
            case 3:
                Paladino paladino = new Paladino();
                return paladino;
            case 4:
                Clerigo clerigo = new Clerigo();
                return clerigo;
            default:
                return null;
        }

    }

    public static void ordenarJogadores(){
        Random random = new Random();
        rodada[0] = random.nextInt(4) + 1;
        switch (rodada[0]){
            case 1:
                rodada[1] = 2;
                rodada[2] = 3;
                rodada[3] = 4;
                break;
            case 2:
                rodada[1] = 3;
                rodada[2] = 4;
                rodada[3] = 1;
                break;
            case 3:
                rodada[1] = 4;
                rodada[2] = 1;
                rodada[3] = 2;
                break;
            case 4:
                rodada[1] = 1;
                rodada[2] = 2;
                rodada[3] = 3;
                break;
            default:
                System.out.println("Erro");

        }
    }

     public static void embaralhar(){
        for(Cartas carta : Cartas.values()){
            int i = 0;
            while(i < 5){
                baralho.add(carta);
                i ++;
            }
        }
        Collections.shuffle(baralho);
    }

    public static void passarTurno(){
        turno++;
        if (turno > rodada.length - 1){
            turno = 0;
        }
    }
}
