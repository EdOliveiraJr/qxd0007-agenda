import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Comparator;

public class Agenda {
    private List <Contato> listaContatos;

    public Agenda(){
        listaContatos = new ArrayList<>();
    }

    public List<Contato> getContatos() {
        listaContatos.sort(Comparator.comparing(Contato::getName));
        return listaContatos;  
    }

    public int getQuantidadeDeContatos() { 
        return listaContatos.size(); 
    }

    public Contato getContato(String name){
        for (Contato contato : listaContatos) {
            if(contato.getName().equals(name)){
                return contato;
            }
        }
        return null;
    }

    public boolean adicionarContato(Contato contato){
        for (Contato e : listaContatos) {
            if(contato.getName().equals(e.getName())){
                for (Fone fone : contato.getFones()) {
                    e.adicionarFone(fone);
                }
                return false;
            }
        }

        if(contato.getQtdFones() == 0){
            return false;
        }else{

            listaContatos.add(contato);
            return true;
        }
    
    }

    public boolean removerContato(String name){
        int index = 0;
        for (Contato contato : listaContatos) {
            if(contato.getName().equals(name)){
                index = listaContatos.indexOf(contato);
                listaContatos.remove(index);
                return true;
            }
        }
        return false;
    }

    public boolean removerFone(String name, int index){
        for (Contato contato : listaContatos) {
            if(contato.getName().equals(name) && index <= contato.getQtdFones()){
                contato.removerFone(index);
                return true;
            }
        }
        return false;
    }

    public int getQuantidadeDeFones(Identificador identificador){
        int contador = 0;
        for (Contato contato : listaContatos) {
            for (Fone fone : contato.getFones()) {
                if(fone.getIdentificador().equals(identificador)){
                    contador++;
                }
            }
        }   
        return contador;
    }

    public int getQuantidadeDeFones(){
        int totalFones = 0;
        for (Contato contato : listaContatos) {
            totalFones += contato.getQuantidadeFones();
        }
        return totalFones;
    }

    public ArrayList <Contato> pesquisar(String expressao){
        ArrayList <Contato> resultado = new ArrayList<>();

        for (Contato contato : listaContatos) {
            if(contato.getName().contains(expressao)){
                resultado.add(contato);
            }

            for (Fone fone: contato.getFones()) {
                if(fone.getNumero().contains(expressao)){
                    resultado.add(contato);
                }
            }
        }
        resultado.sort(Comparator.comparing(Contato::getName));
        return resultado;
        

    }

}