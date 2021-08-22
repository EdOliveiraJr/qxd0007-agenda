import java.util.ArrayList;

public class Contato {
    private String name;
    private ArrayList <Fone> fones;
    private int qtdFones = 0;
    
    public Contato(String name){
        this.name = name;
        fones = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getQuantidadeFones(){
        return fones.size();
    }

    public ArrayList<Fone> getFones() {
        return fones;
    }

    public boolean adicionarFone(Fone fone){
        if(Fone.validarNumero(fone.getNumero())){
            fones.add(fone);
            qtdFones++;
            return true;
        }else{
            return false;
        }
    }

    public boolean removerFone(int index){
        if(fones.size() <= index || index < 0){
            return false;
        }else{
            fones.remove(index);
            qtdFones--;
            return true;
        }
        
    }

    public int getQtdFones(){
        return qtdFones;
    }
    
}
