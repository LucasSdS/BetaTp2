import java.util.ArrayList;

public class Jogador {
    String nome;
    int vida = 20;
    Classe classe;
    ArrayList<Cartas> mao = new ArrayList<>();
    int id;
    int armadura;

    Jogador(String nome, Classe classe, int id){
        this.nome = nome;
        this.classe = classe;
        this.id = id;
    }

    public void comprarCarta(ArrayList<Cartas> baralho){
        Cartas carta = baralho.get(0);
        System.out.println(carta.tipo);
        this.mao.add(carta);

        if(mao.size() > 3){
            mao.remove(0);
        }
    }

    public void usarCarta(Cartas carta, Jogador alvo){
        if (carta.tipo.equals(this.classe.nomeClasse)){
            carta.dano += this.classe.modificador;
        }

        switch (carta.tipo){
            case "Mago":
                alvo.vida -= carta.dano;
                System.out.println(this.nome + " usou um feitiço contra " + alvo.nome + " e deu " + carta.dano + " de dano.");
                break;
            case "Paladino":
                alvo.armadura += carta.dano;
                System.out.println(this.nome + " protegeu " + alvo.nome + " e aumentou sua armadura em " + carta.dano );
                break;
            case "Clerigo":
                alvo.vida += carta.dano;
                System.out.println(this.nome + " curou " + alvo.nome + " e aumentou em " + carta.dano + " seus pontos de vida.");
                break;
            case "Guerreiro":
                alvo.vida -= carta.dano;
                System.out.println(this.nome + " deu um socão em " + alvo.nome + " e deu " + carta.dano + " de dano.");
                break;
            default:
                System.out.println("Foda-se");
        }

        mao.remove(carta);
    }

    
}
