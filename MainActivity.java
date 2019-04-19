package estrada.leon.rafael.ahorcadoandroid;


import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ahorcado juego;
    Button btninicio;
    Button btnbuscar;
    EditText caja;
    TextView palabrasecreta;
    ImageView monito;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toast.makeText(getApplicationContext(),"Presiona inicio para comenzar",Toast.LENGTH_LONG).show();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btninicio=findViewById(R.id.btninicio);
        btninicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                juego= new ahorcado();
                juego.Actualizar();
                palabrasecreta.setText(juego.getActualizar());
                btnbuscar.setEnabled(true);
                int id=getResources().getIdentifier("estrada.leon.rafael.ahorcadoandroid:"+"drawable/inicio",null,null);
                monito.setImageResource(id);
            }
        });
        btnbuscar=findViewById(R.id.btnbuscar);
        btnbuscar.setEnabled(false);
        btnbuscar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(caja.getText().equals("") | caja.getText().length()>1 | palabrasecreta.getText().equals("")){
                Toast.makeText(getApplicationContext(),"Inserta un caracter",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    juego.BuscarLetra(caja.getText().toString());
                    juego.Actualizar();
                    palabrasecreta.setText(juego.getActualizar());
                    int id=getResources().getIdentifier("estrada.leon.rafael.ahorcadoandroid:"+juego.getUrl(),null,null);
                    monito.setImageResource(id);
                    // ImageIcon url=new ImageIcon(juego.getUrl());
                    //monito.setIcon(new ImageIcon(url.getImage()));
                }
                if(palabrasecreta.getText().equals(juego.getPalabra())){
                    int id=getResources().getIdentifier("estrada.leon.rafael.ahorcadoandroid:"+"drawable/felicidades",null,null);
                    monito.setImageResource(id);
                    btnbuscar.setEnabled(false);
                    Toast.makeText(getApplicationContext(),"Presiona inicio para comenzar de nuevo",Toast.LENGTH_LONG).show();
                    caja.setText("");
                }
                if(juego.getUrl().substring(juego.getUrl().length()-1,juego.getUrl().length()).equals("8")){
                  btnbuscar.setEnabled(false);
                    Toast.makeText(getApplicationContext(),"Presiona inicio para comenzar de nuevo",Toast.LENGTH_LONG).show();
                    caja.setText("");
                    palabrasecreta.setText(juego.getPalabra());
                }
            }
        });
        caja=findViewById(R.id.caja);
        palabrasecreta=findViewById(R.id.palabrasecreta);
        monito=findViewById(R.id.monito);
        Toast.makeText(getApplicationContext(),"Presiona inicio para comenzar",Toast.LENGTH_LONG).show();
        int id=getResources().getIdentifier("estrada.leon.rafael.ahorcadoandroid:"+"drawable/comienzo",null,null);
        monito.setImageResource(id);
    }
}
