package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.excecao.ConversaoDeAnoException;
import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo> {
    //@SerializedName("Title") // Renomeia a variável abaixo para a biblioteca gson entender
    private String nome;
    //@SerializedName("Year")
    private int anoDeLancamento;
    private boolean incluidoNoPlano;
    private double somaDasAvaliacoes;
    private int totalDeAvaliacoes;
    private int duracaoEmMinutos;

    public Titulo(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }

    //Constructor para receber um Titulo que venha da API OMDB
    public Titulo(TituloOMDB meuTituloOMDB) {
        this.nome = meuTituloOMDB.title();  //Recebe o nome do Titulo e passa para o title do record
        if (meuTituloOMDB.year().length() > 4){ // IF para verificar a exception criada para o erro do atributo year
            throw new ConversaoDeAnoException("A conversão não foi realizada pois o ano tem mais que 04 caracteres!");
        }
        this.anoDeLancamento = Integer.valueOf(meuTituloOMDB.year()); // Transforma o String year para um int, para receber o anoDeLancamento
        this.duracaoEmMinutos = Integer.valueOf(meuTituloOMDB.runtime().substring(0, 2));
        // Transforma o String runtime para int, e pega somente os 3 primeiros caracteres da String utilizando o .substirng(0,2)
    }

    public String getNome() {
        return nome;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public boolean isIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public int getTotalDeAvaliacoes() {
        return totalDeAvaliacoes;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public void exibeFichaTecnica(){
        System.out.println("Nome do filme: " + nome);
        System.out.println("Ano de lançamento: " + anoDeLancamento);
    }

    public void avalia(double nota){
        somaDasAvaliacoes += nota;
        totalDeAvaliacoes++;
    }

    public double pegaMedia(){
        return somaDasAvaliacoes / totalDeAvaliacoes;
    }

    @Override
    public int compareTo(Titulo outroTitulo) {
        return this.getNome().compareTo(outroTitulo.getNome());
    }

    @Override
    public String toString() {
        return "[Nome: " + nome + " | Ano de Lançamento: " + anoDeLancamento + " | Duração: " + duracaoEmMinutos + " min]";
    }
}
