public enum Cartas {
    FOGO(2, "Mago"), GELO(2, "Mago"), CURA(3, "Clerigo"), PORRETE(2, "Guerreiro"),
    BATATA(3, "Guerreiro"), TESTE(3, "Paladino"), COISA(2, "Paladino"), BORA(3, "Clerigo"), EITA(1, "Mago");

    int dano;
    String tipo;

     Cartas(int dano, String tipo){
        this.dano = dano;
        this.tipo = tipo;

    }
}
