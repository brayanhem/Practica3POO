/*

*/

public class ZombieDadoView {
    private Square fondo1, fondo2, fondo3;
    
    // Partes del Cerebro
    private Circle cer1, cer2, cer3, cerBrillo;
    // Partes de los Pasos
    private Circle paso1_base, paso1_dedo, paso2_base, paso2_dedo;
    // Partes del Disparo
    private Circle dispHumo, dispFuego, dispNucleo, dispCentro;
    
    private int x, y; 
    private String color;

    public ZombieDadoView(String colorDado) {
        this.color = colorDado;
        this.x = -160;
        this.y = 30;
        
        // Creamos los tres fondos alineados
        fondo1 = crearFondo(x);
        //fondo2 = crearFondo(x); 
        //fondo3 = crearFondo(x + 190);
    }

    private Square crearFondo(int posX) {
        Square s = new Square();
        s.changeSize(85);
        s.changeColor(color);
        s.moveHorizontal(posX - 60);
        s.moveVertical(y - 50);
        return s;
    }
    
    public void cambiarColor(String color){      
        this.color= color;
        
        fondo1.changeColor(color);
        
        actualizarCaras();
        
    }
    
    //Este metodo me ayuda a que los iconos queden por encima del fondo cuando realizo el cambio
    //de color del  dado
    private void actualizarCaras(){
        if (cer1 != null) {
          cer1.makeVisible(); cer2.makeVisible(); 
          cer3.makeVisible(); cerBrillo.makeVisible();
        }
        
        if (paso1_base != null) {
            paso1_base.makeVisible(); paso1_dedo.makeVisible();
            paso2_base.makeVisible(); paso2_dedo.makeVisible();
        }
        
        if (dispHumo != null) {
            dispHumo.makeVisible(); dispFuego.makeVisible();
            dispNucleo.makeVisible(); dispCentro.makeVisible();
        }
    }
    
    //Utilice este metodo para asegurarme de que los iconos se esten borrando correctamente ya que
    //se sobreponian sobre las otras figuras y me causaba errores en las otras funciones como moverDados
    private void borrarIconos(){
        hacerInvisible();
        
        cer1 = null; cer2 = null; cer3 = null; cerBrillo = null;
        paso1_base = null; paso1_dedo = null; paso2_base = null; paso2_dedo = null;
        dispHumo = null; dispFuego = null; dispNucleo = null; dispCentro = null;
    }
    
    public void mostrarCerebro(){

        borrarIconos();  
        fondo1.makeVisible();
        dibujarCerebro(x);
        
    }
    
    public void mostrarPasos(){
        
        borrarIconos();
        fondo1.makeVisible();
        dibujarPasos(x);
        
    }
    
    public void mostrarDisparo(){
        
        borrarIconos();
        fondo1.makeVisible();
        dibujarDisparo(x);
    }

    private void dibujarCerebro(int baseX) {
        // Un cerebro con 3 lóbulos y un punto de brillo para realismo
        cer1 = prepararIcono("magenta", 35, baseX + 15, y + 20); 
        cer2 = prepararIcono("magenta", 35, baseX + 35, y + 20); 
        cer3 = prepararIcono("magenta", 30, baseX + 25, y + 35); 
        cerBrillo = prepararIcono("white", 8, baseX + 28, y + 22);      
    }

    private void dibujarPasos(int baseX) {
        // Huella izquierda (planta y dedo)
        paso1_base = prepararIcono("black", 22, baseX + 15, y + 15);
        paso1_dedo = prepararIcono("black", 10, baseX + 20, y + 5);
        // Huella derecha (planta y dedo)
        paso2_base = prepararIcono("black", 22, baseX + 45, y + 45);
        paso2_dedo = prepararIcono("black", 10, baseX + 50, y + 35);
    }

    private void dibujarDisparo(int baseX) {
        // Capas de color para simular una explosión
        dispHumo = prepararIcono("black", 55, baseX + 12, y + 12); 
        dispFuego = prepararIcono("red", 35, baseX + 22, y + 22);   
        dispNucleo = prepararIcono("orange", 20, baseX + 30, y + 30); 
        dispCentro = prepararIcono("yellow", 10, baseX + 35, y + 35); 
    }

    private Circle prepararIcono(String colorIcono, int tam, int posX, int posY) {
        Circle c = new Circle();
        c.changeSize(tam);
        c.changeColor(colorIcono);
        // Ajuste para centrar respecto al Square
        c.moveHorizontal(posX + 22);
        c.moveVertical(posY - 20);
        c.makeVisible();
        return c;
    }

    public void hacerInvisible() {
        fondo1.makeInvisible();
        
        // Ocultar partes del cerebro
        if (cer1 != null) {
           cer1.makeInvisible(); cer2.makeInvisible(); 
           cer3.makeInvisible(); cerBrillo.makeInvisible();
        }
        // Ocultar pasos
        if (paso1_base != null) {
            paso1_base.makeInvisible(); paso1_dedo.makeInvisible();
            paso2_base.makeInvisible(); paso2_dedo.makeInvisible();
        }
        // Ocultar disparo
        if (dispHumo != null) {
            dispHumo.makeInvisible(); dispFuego.makeInvisible();
            dispNucleo.makeInvisible(); dispCentro.makeInvisible();
        }
        
    }
    
    public void moverDados(int nx, int ny) {
        // Calculamos cuánto debemos movernos desde la posición actual
        //int moverX = nx - x;
        //int moverY = ny - y;
        
        this.x += nx;
        this.y += ny;

        // Mover Fondo
        fondo1.moveHorizontal(nx);
        fondo1.moveVertical(ny);

        moverIconos(nx,ny);
        // Guardar la posición posición actual
        //this.x = nx;
        //this.y = ny;
        
    }
    
    private void moverIconos(int moverX,int moverY){
                // Mover partes del Cerebro
        if (cer1 != null) {
            cer1.moveHorizontal(moverX); cer1.moveVertical(moverY);
            cer2.moveHorizontal(moverX); cer2.moveVertical(moverY);
            cer3.moveHorizontal(moverX); cer3.moveVertical(moverY);
            cerBrillo.moveHorizontal(moverX); cerBrillo.moveVertical(moverY);
            
        }

        // Mover partes de los Pasos
        if (paso1_base != null) {
            paso1_base.moveHorizontal(moverX); paso1_base.moveVertical(moverY);
            paso1_dedo.moveHorizontal(moverX); paso1_dedo.moveVertical(moverY);
            paso2_base.moveHorizontal(moverX); paso2_base.moveVertical(moverY);
            paso2_dedo.moveHorizontal(moverX); paso2_dedo.moveVertical(moverY);
        }

        // Mover partes del Disparo
        if (dispHumo != null) {
            dispHumo.moveHorizontal(moverX); dispHumo.moveVertical(moverY);
            dispFuego.moveHorizontal(moverX); dispFuego.moveVertical(moverY);
            dispNucleo.moveHorizontal(moverX); dispNucleo.moveVertical(moverY);
            dispCentro.moveHorizontal(moverX); dispCentro.moveVertical(moverY);
            
        }
    }
    

}