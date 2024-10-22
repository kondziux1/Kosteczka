package pl.kondziux1.kostka;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    //global variable
    private int suma = 0;
    private int globalsuma = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //inicjalizacja nic ważnego
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Przycisk rzuć kośćmi logika
        Button runRand = (Button) findViewById(R.id.runbutton);
        runRand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                runonclick();
            }
        });

        //Przycisk Resetuj wynik logika
        Button runReset = (Button) findViewById(R.id.reset);
        runReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView loswyn = findViewById(R.id.wyniklos);
                TextView wynikgry = findViewById(R.id.wynikgry);
                globalsuma = 0;
                loswyn.setText("Wynik tego losowania: " + suma);
                wynikgry.setText("Wynik gry: " + globalsuma);
            }
        });

    }
    //logika rzutu kośćmi
    private void runonclick(){
        //inicjalizuj potrzebne rzeczy i wykonaj losowanie (getRandomNumbers)
        ArrayList<Integer> wynikikostki = getRandomNumbers(5);
        TextView loswyn = findViewById(R.id.wyniklos);
        TextView wynikgry = findViewById(R.id.wynikgry);
        //ustaw sume na 0
        suma = 0;
        //przeleć przez wylosowane liczby które zapisane są w tablicy
        for (int i = 0; i < wynikikostki.size(); i++) {
            //zamień obrazek w zaleznosci od liczby wylosowanej
            switch (wynikikostki.get(i)){
                case 0:
                    setDrawableon(i,R.drawable._1);
                    break;
                case 1:
                    setDrawableon(i,R.drawable._2);
                    break;
                case 2:
                    setDrawableon(i,R.drawable._3);
                    break;
                case 3:
                    setDrawableon(i,R.drawable._4);
                    break;
                case 4:
                    setDrawableon(i,R.drawable._5);
                    break;
                case 5:
                    setDrawableon(i,R.drawable._6);
                    break;

            }
            //dodaj do sumy wszystkie liczby wylosowane
            suma += wynikikostki.get(i);
        }
        //dodaj sume
        globalsuma += suma;
        //wypisz wyniki
        loswyn.setText("Wynik tego losowania: " + suma);
        wynikgry.setText("Wynik gry: " + globalsuma);


    }

    //ustawia dany obrazek do wybranego obiektu obrazka (ImageView)
    private void setDrawableon(int imgview, int img){
        //inicjalizacja obiektow z obrazkami
        ImageView one,two,three,four,five;
        two = (ImageView) findViewById(R.id.kosc1);
        three = (ImageView) findViewById(R.id.kosc2);
        four = (ImageView) findViewById(R.id.kosc3);
        five = (ImageView) findViewById(R.id.kosc4);
        one = (ImageView) findViewById(R.id.kosc0);
        //switch który dla ImageView ustawia obrazek
        switch (imgview){
            case 0:
            one.setImageDrawable(getDrawable(img));
            break;
            case 1:
            two.setImageDrawable(getDrawable(img));
            break;
            case 2:
            three.setImageDrawable(getDrawable(img));
            break;
            case 3:
            four.setImageDrawable(getDrawable(img));
            break;
            case 4:
            five.setImageDrawable(getDrawable(img));
            break;

        }
    }
    //zwraca n losowych liczby od 1 do 6
    private ArrayList<Integer> getRandomNumbers(Integer numbers){
        ArrayList<Integer> randoms = new ArrayList<Integer>();

        Random rnd = new Random();

        for (int i = 0; i < numbers; i++) {
            randoms.add(rnd.nextInt(6));
        }

        return randoms;
    }
}