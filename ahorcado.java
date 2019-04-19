package estrada.leon.rafael.ahorcadoandroid;

import java.util.Random;

public class ahorcado {
    private String [] images = {"drawable/a0","drawable/a1","drawable/a2","drawable/a3","drawable/a4","drawable/a5","drawable/a6","drawable/a7","drawable/a8"};
    private String [] biblioteca={"casa","libro","programacion","perro","gato","escuela","reina"};
    private String [] aux={"-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-"};
    private Boolean flag  = false;
    private int error;
    private Random r;
    private String palabra;
    private  String cad;
    private String url;

    public ahorcado(){
        r=new Random();
        int x = r.nextInt(7);
        this.palabra=this.biblioteca[x];
        this.error=0;
        this.url="drawable/a0";
        this.cad="";
    }

    public void Actualizar (){
        this.cad="";
        for (int i=0;i<this.palabra.length();i++){
            this.cad=this.cad+this.aux[i];
        }

    }
    public String getActualizar(){
        return this.cad;
    }

    public void Dibujar(){
        url="";
        if(this.error>=1){
            url=images[this.error];
        }

    }
    public String getUrl(){
        return this.url;
    }
    public void BuscarLetra(String letra){
        int x=0;
        this.flag=false;
        while (x<this.palabra.length()){
            if(this.palabra.substring(x,x+1).equals(letra)){
                this.aux[x]=letra;
                this.flag=true;
            }
            x++;
        }
        if(flag==false){
            this.error ++;
            Dibujar();
        }
    }
    public String getPalabra(){
        return this.palabra;
    }

}

