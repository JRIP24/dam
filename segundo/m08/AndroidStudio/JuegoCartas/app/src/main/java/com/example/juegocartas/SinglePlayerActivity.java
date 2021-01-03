package com.example.juegocartas;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class SinglePlayerActivity extends AppCompatActivity {

    ImageView deck;
    ImageView backCard;
    Button playBtn;
    Button oneMoreBtn;
    Button stopBtn;

    ImageView playerCard1;
    ImageView playerCard2;
    ImageView playerCard3;
    ImageView playerCard4;
    ImageView playerCard5;
    ImageView playerCard6;
    ImageView playerCard7;
    ImageView playerCard8;
    ImageView playerCard9;
    ImageView playerCard10;
    ImageView playerCard11;
    ImageView playerCard12;
    ImageView playerCard13;
    ImageView playerCard14;
    ImageView playerCard15;
    ImageView playerCard16;

    TextView playerScore;
    TextView gameMessage;
    double playerPoints = 0.0;
    double bankPoints = 0.0;

    ObjectAnimator animatorOneMoreBtn;
    ObjectAnimator animatorStopBtn;
    ObjectAnimator cardAnimator1;
    ObjectAnimator cardAnimator2;
    ObjectAnimator cardAnimator3;
    ObjectAnimator cardAnimator4;

    boolean terminarTurnoForced = false;
    ArrayList<String> baraja = new ArrayList<String>();
    ArrayList<ImageView> cartasJugador = new ArrayList<ImageView>();
    int numCartasJugador = 0;//Número de cartas que el jugador ha sacado

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_player);

        //hook
        deck = findViewById(R.id.deck);
        backCard = findViewById(R.id.backCard);
        playBtn = findViewById(R.id.playBtn);
        playerScore = findViewById(R.id.playerScore);
        oneMoreBtn = findViewById(R.id.oneMoreBtn);
        stopBtn = findViewById(R.id.stopBtn);
        gameMessage = findViewById(R.id.gameMessage);

        playerCard1 = findViewById(R.id.playerCard1);
        playerCard2 = findViewById(R.id.playerCard2);
        playerCard3 = findViewById(R.id.playerCard3);
        playerCard4 = findViewById(R.id.playerCard4);
        playerCard5 = findViewById(R.id.playerCard5);
        playerCard6 = findViewById(R.id.playerCard6);
        playerCard7 = findViewById(R.id.playerCard7);
        playerCard8 = findViewById(R.id.playerCard8);
        playerCard9 = findViewById(R.id.playerCard9);
        playerCard10 = findViewById(R.id.playerCard10);
        playerCard11 = findViewById(R.id.playerCard11);
        playerCard12 = findViewById(R.id.playerCard12);
        playerCard13 = findViewById(R.id.playerCard13);
        playerCard14 = findViewById(R.id.playerCard14);
        playerCard15 = findViewById(R.id.playerCard15);
        playerCard16 = findViewById(R.id.playerCard16);

        cartasJugador.add(playerCard1);
        cartasJugador.add(playerCard2);
        cartasJugador.add(playerCard3);
        cartasJugador.add(playerCard4);
        cartasJugador.add(playerCard5);
        cartasJugador.add(playerCard6);
        cartasJugador.add(playerCard7);
        cartasJugador.add(playerCard8);
        cartasJugador.add(playerCard9);
        cartasJugador.add(playerCard10);
        cartasJugador.add(playerCard11);
        cartasJugador.add(playerCard12);
        cartasJugador.add(playerCard13);
        cartasJugador.add(playerCard14);
        cartasJugador.add(playerCard15);
        cartasJugador.add(playerCard16);



        //Bastos
        baraja.add("1.0b");
        baraja.add("2.0b");
        baraja.add("3.0b");
        baraja.add("4.0b");
        baraja.add("5.0b");
        baraja.add("6.0b");
        baraja.add("7.0b");
        baraja.add("8.0b");
        baraja.add("9.0b");
        baraja.add("10.0b");
        baraja.add("11.0b");
        baraja.add("12.0b");

        //Copas
        baraja.add("1.0c");
        baraja.add("2.0c");
        baraja.add("3.0c");
        baraja.add("4.0c");
        baraja.add("5.0c");
        baraja.add("6.0c");
        baraja.add("7.0c");
        baraja.add("8.0c");
        baraja.add("9.0c");
        baraja.add("10.0c");
        baraja.add("11.0c");
        baraja.add("12.0c");

        //Oros
        baraja.add("1.0o");
        baraja.add("2.0o");
        baraja.add("3.0o");
        baraja.add("4.0o");
        baraja.add("5.0o");
        baraja.add("6.0o");
        baraja.add("7.0o");
        baraja.add("8.0o");
        baraja.add("9.0o");
        baraja.add("10.0o");
        baraja.add("11.0o");
        baraja.add("12.0o");

        //Espadas
        baraja.add("1.0e");
        baraja.add("2.0e");
        baraja.add("3.0e");
        baraja.add("4.0e");
        baraja.add("5.0e");
        baraja.add("6.0e");
        baraja.add("7.0e");
        baraja.add("8.0e");
        baraja.add("9.0e");
        baraja.add("10.0e");
        baraja.add("11.0e");
        baraja.add("12.0e");



        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Se desordena la baraja
                Collections.shuffle(baraja);

                cardForPlayer();
                stopBtn.setVisibility(View.VISIBLE);
                oneMoreBtn.setVisibility(View.VISIBLE);
                animStop_OneMoreButtons(false);
                playBtn.setVisibility(View.INVISIBLE);


            }
        });

        oneMoreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animStop_OneMoreButtons(true);
                cardForPlayer();


            }
        });

        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                terminarTurnoForced = true;
                animStop_OneMoreButtons(true);
            }
        });




    }

    private void animStop_OneMoreButtons(boolean out){

        if (out){
            animatorOneMoreBtn = ObjectAnimator.ofFloat(oneMoreBtn, "translationX", 0f, -1000f);
            animatorStopBtn = ObjectAnimator.ofFloat(stopBtn, "translationX", 0f, 1000f);
        } else {
            animatorOneMoreBtn = ObjectAnimator.ofFloat(oneMoreBtn, "translationX", -1000f, 0f);
            animatorStopBtn = ObjectAnimator.ofFloat(stopBtn, "translationX", 1000f, 0f);
        }

        animatorOneMoreBtn.setDuration(1000);
        animatorStopBtn.setDuration(1000);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animatorOneMoreBtn, animatorStopBtn);
        animatorSet.start();

    }

    private void cardForPlayer() {

        terminarTurnoForced = false;

        ImageView carta = cartasJugador.get(numCartasJugador);
        numCartasJugador++;


        //Nueva carta
        //extraeremos siempre el indice 0, ya que al eliminar la carta del array el indice 0 pasa a ser otro
        asingnarImagenes(baraja.get(0), carta);

        backCard.setAlpha(1f);
        cardAnimator1 = ObjectAnimator.ofFloat(backCard, "x", deck.getX(), carta.getX());
        cardAnimator2 = ObjectAnimator.ofFloat(backCard, "y", deck.getY(), carta.getY());
        cardAnimator3 = ObjectAnimator.ofFloat(backCard, "rotationY", 0f, 180f);
        cardAnimator4 = ObjectAnimator.ofFloat(backCard, "alpha", 1f, 0f);

        cardAnimator1.setDuration(500);
        cardAnimator2.setDuration(500);
        cardAnimator3.setDuration(500);
        cardAnimator3.setStartDelay(500);
        cardAnimator4.setDuration(100);
        cardAnimator4.setStartDelay(750);


        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(cardAnimator1, cardAnimator2, cardAnimator3, cardAnimator4);
        animatorSet.start();

        ObjectAnimator card1Animation = ObjectAnimator.ofFloat(carta, "alpha", 0f, 1f);
        ObjectAnimator card2Animation = ObjectAnimator.ofFloat(carta, "rotationY", -180f, 0f);

        card1Animation.setDuration(0);
        card1Animation.setStartDelay(750);
        card2Animation.setDuration(500);
        card2Animation.setStartDelay(500);

        AnimatorSet animatorSetCard = new AnimatorSet();
        animatorSetCard.playTogether(card1Animation, card2Animation);
        animatorSetCard.start();





        String cartaStr = deleteLast(baraja.get(0));
        double valor = Double.parseDouble(cartaStr);
        baraja.remove(0);

        //Suma de valores
        if(valor > 7.5){
            playerPoints = playerPoints + 0.5;
        } else {
            playerPoints = playerPoints + valor;
        }

        playerScore.setText(playerPoints + "");

        //Condicionales para acabar turno
        if (playerPoints > 7.5){
            terminarTurnoForced = true;
            gameMessage.setText(R.string.loseMsg);
            gameMessage.setVisibility(View.VISIBLE);

        } else {
            animStop_OneMoreButtons(false);
        }


    }

    private String deleteLast(String str) {
        //Toast.makeText(this, "index 1: " + str.substring(str.length() - 1), Toast.LENGTH_SHORT).show();
        String result = null;
        if ((str != null) && (str.length() > 0)) {
            result = str.substring(0, str.length() - 1);
        }
        return result;
    }

    private void asingnarImagenes(String s, ImageView image) {

        switch (s){
            case "1.0b":
                image.setImageResource(R.drawable.clubs01);
                break;

            case "2.0b":
                image.setImageResource(R.drawable.clubs02);
                break;

            case "3.0b":
                image.setImageResource(R.drawable.clubs03);
                break;

            case "4.0b":
                image.setImageResource(R.drawable.clubs04);
                break;


            case "5.0b":
                image.setImageResource(R.drawable.clubs05);
                break;


            case "6.0b":
                image.setImageResource(R.drawable.clubs06);
                break;


            case "7.0b":
                image.setImageResource(R.drawable.clubs07);
                break;


            case "8.0b":
                image.setImageResource(R.drawable.clubs08);
                break;

            case "9.0b":
                image.setImageResource(R.drawable.clubs09);
                break;

            case "10.0b":
                image.setImageResource(R.drawable.clubs10);
                break;

            case "11.0b":
                image.setImageResource(R.drawable.clubs11);
                break;

            case "12.0b":
                image.setImageResource(R.drawable.clubs12);
                break;


            case "1.0c":
                image.setImageResource(R.drawable.cups01);
                break;

            case "2.0c":
                image.setImageResource(R.drawable.cups02);
                break;

            case "3.0c":
                image.setImageResource(R.drawable.cups03);
                break;

            case "4.0c":
                image.setImageResource(R.drawable.cups04);
                break;


            case "5.0c":
                image.setImageResource(R.drawable.cups05);
                break;


            case "6.0c":
                image.setImageResource(R.drawable.cups06);
                break;


            case "7.0c":
                image.setImageResource(R.drawable.cups07);
                break;


            case "8.0c":
                image.setImageResource(R.drawable.cups08);
                break;

            case "9.0c":
                image.setImageResource(R.drawable.cups09);
                break;

            case "10.0c":
                image.setImageResource(R.drawable.cups10);
                break;

            case "11.0c":
                image.setImageResource(R.drawable.cups11);
                break;

            case "12.0c":
                image.setImageResource(R.drawable.cups12);
                break;


            case "1.0o":
                image.setImageResource(R.drawable.golds01);
                break;

            case "2.0o":
                image.setImageResource(R.drawable.golds02);
                break;

            case "3.0o":
                image.setImageResource(R.drawable.golds03);
                break;

            case "4.0o":
                image.setImageResource(R.drawable.golds04);
                break;


            case "5.0o":
                image.setImageResource(R.drawable.golds05);
                break;


            case "6.0o":
                image.setImageResource(R.drawable.golds06);
                break;


            case "7.0o":
                image.setImageResource(R.drawable.golds07);
                break;


            case "8.0o":
                image.setImageResource(R.drawable.golds08);
                break;

            case "9.0o":
                image.setImageResource(R.drawable.golds09);
                break;

            case "10.0o":
                image.setImageResource(R.drawable.golds10);
                break;

            case "11.0o":
                image.setImageResource(R.drawable.golds11);
                break;

            case "12.0o":
                image.setImageResource(R.drawable.golds12);
                break;


            case "1.0e":
                image.setImageResource(R.drawable.swords01);
                break;

            case "2.0e":
                image.setImageResource(R.drawable.swords02);
                break;

            case "3.0e":
                image.setImageResource(R.drawable.swords03);
                break;

            case "4.0e":
                image.setImageResource(R.drawable.swords04);
                break;


            case "5.0e":
                image.setImageResource(R.drawable.swords05);
                break;


            case "6.0e":
                image.setImageResource(R.drawable.swords06);
                break;


            case "7.0e":
                image.setImageResource(R.drawable.swords07);
                break;


            case "8.0e":
                image.setImageResource(R.drawable.swords08);
                break;

            case "9.0e":
                image.setImageResource(R.drawable.swords09);
                break;

            case "10.0e":
                image.setImageResource(R.drawable.swords10);
                break;

            case "11.0e":
                image.setImageResource(R.drawable.swords11);
                break;

            case "12.0e":
                image.setImageResource(R.drawable.swords12);
                break;


            default:
                image.setImageResource(R.drawable.back);
                break;
        }

    }
}