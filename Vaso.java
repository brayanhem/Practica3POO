import java.util.ArrayList;
import java.util.Collections;

public class Vaso{
    private ArrayList<ZombieDado> dados;
    
    public Vaso(){
        dados= new ArrayList<ZombieDado>();
        llenarVaso();
    }
    
    private void llenarVaso(){
        //Poner los dados necesarios 6 verdes, 4 amarillos y 3 rojos
        dados.clear();
        for(int i=0; i<6;i++) dados.add(new ZombieDado("green"));
        for(int i=0; i<4;i++) dados.add(new ZombieDado("yellow"));
        for(int i=0; i<3;i++) dados.add(new ZombieDado("red"));
        
        //Mezcla de los dados
        Collections.shuffle(dados);
    }
    
    public ArrayList<ZombieDado>tomarDador(int cantidad){
        return null;
    }
    
    public void devolverDado(ArrayList<ZombieDado> dadosUsados){
        
    }
    
    public int getCantidadRestante(){
        return 0;
    }

}