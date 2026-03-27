import java.util.ArrayList;
import java.util.Random;

public class Vaso{
    private ArrayList<ZombieDado> dados;
    private Random random;
    
    public Vaso(){
        this.dados= new ArrayList<ZombieDado>();
        this.random = new Random();
        llenarVaso();
    }
    
    public void llenarVaso(){
        //Poner los dados necesarios 6 verdes, 4 amarillos y 3 rojos
        dados.clear();
        for(int i=0; i<6;i++) dados.add(new ZombieDado("green"));
        for(int i=0; i<4;i++) dados.add(new ZombieDado("yellow"));
        for(int i=0; i<3;i++) dados.add(new ZombieDado("red"));
        
        //Mezcla de los dados
        mezclarVaso();
        
    }
    
    private void mezclarVaso(){
        int n= dados.size();
        for(int i = n - 1; i > 0;i--){
            int j= random.nextInt(i+1);
            
        ZombieDado temporal= dados.get(i);
        dados.set(i,dados.get(j));
        dados.set(j,temporal);
            
        }
        
    }
    
    public ArrayList<ZombieDado> tomarDados(int cantidad) {
        ArrayList<ZombieDado> sacados = new ArrayList<ZombieDado>();

        for (int i = 0; i < cantidad && !dados.isEmpty(); i++) {
            int posicion = random.nextInt(dados.size());
            sacados.add(dados.remove(posicion));
        }

        return sacados;
    }
    
    public void devolverDado(ArrayList<ZombieDado> dadosUsados){
        for(ZombieDado d : dadosUsados) {
            d.ocultar();
            dados.add(d);
        }
        mezclarVaso(); //Se mezlcan nuevamente al regresar los dados
    }
    
    public int getCantidadRestante(){
        return dados.size();
    }
    

}