package com.example.juegocartas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.transition.AutoTransition;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MultiplayerActivity extends AppCompatActivity {

    static final String FILE_SHARED_NAME = "Scores_multiPlayer";

    ImageView deck;
    ImageView backCard;
    Button playBtn;
    Button playAgain;
    Button oneMoreBtn;
    Button oneMore2Btn;
    Button stopBtn;
    Button stop2Btn;

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

    ImageView player2Card1;
    ImageView player2Card2;
    ImageView player2Card3;
    ImageView player2Card4;
    ImageView player2Card5;
    ImageView player2Card6;
    ImageView player2Card7;
    ImageView player2Card8;
    ImageView player2Card9;
    ImageView player2Card10;
    ImageView player2Card11;
    ImageView player2Card12;
    ImageView player2Card13;
    ImageView player2Card14;
    ImageView player2Card15;
    ImageView player2Card16;

    TextView globalPlayerScore;
    TextView globalBankScore;
    TextView whoBank;
    //int globalPlayerScoreInt = 0;
    //int globalPlayer2ScoreInt = 0;

    TextView playerScore;
    TextView player2Score;
    TextView gameMessage;
    //double playerPoints = 0.0;
    //double bankPoints = 0.0;

    ObjectAnimator animatorOneMoreBtn;
    ObjectAnimator animatorStopBtn;
    ObjectAnimator cardAnimator1;
    ObjectAnimator cardAnimator2;
    ObjectAnimator cardAnimator3;
    ObjectAnimator cardAnimator4;

    ArrayList<String> baraja = new ArrayList<String>();
    ArrayList<ImageView> cartasJugador = new ArrayList<ImageView>();
    ArrayList<ImageView> cartasPlayer2 = new ArrayList<ImageView>();
    //int numCartasJugador = 0;
    //int numCartasPlayer2 = 0;

    //Definimos los jugadores
    User player1 = new User(0, 0.0, 0, false);
    User player2 = new User(0, 0.0, 0 ,false);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplayer);

        //hook
        deck = findViewById(R.id.deck);
        backCard = findViewById(R.id.backCard);
        playBtn = findViewById(R.id.playBtn);
        playAgain = findViewById(R.id.playAgain);

        playerScore = findViewById(R.id.playerScore);
        globalPlayerScore = findViewById(R.id.globalPlayerScore);
        player2Score = findViewById(R.id.bankScore);
        globalBankScore = findViewById(R.id.globalBankScore);
        whoBank = findViewById(R.id.whoBank);

        oneMoreBtn = findViewById(R.id.oneMoreBtn);
        oneMore2Btn = findViewById(R.id.oneMore2Btn);
        stopBtn = findViewById(R.id.stopBtn);
        stop2Btn = findViewById(R.id.stop2Btn);
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

        player2Card1 = findViewById(R.id.bankCard1);
        player2Card2 = findViewById(R.id.bankCard2);
        player2Card3 = findViewById(R.id.bankCard3);
        player2Card4 = findViewById(R.id.bankCard4);
        player2Card5 = findViewById(R.id.bankCard5);
        player2Card6 = findViewById(R.id.bankCard6);
        player2Card7 = findViewById(R.id.bankCard7);
        player2Card8 = findViewById(R.id.bankCard8);
        player2Card9 = findViewById(R.id.bankCard9);
        player2Card10 = findViewById(R.id.bankCard10);
        player2Card11 = findViewById(R.id.bankCard11);
        player2Card12 = findViewById(R.id.bankCard12);
        player2Card13 = findViewById(R.id.bankCard13);
        player2Card14 = findViewById(R.id.bankCard14);
        player2Card15 = findViewById(R.id.bankCard15);
        player2Card16 = findViewById(R.id.bankCard16);


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

        cartasPlayer2.add(player2Card1);
        cartasPlayer2.add(player2Card2);
        cartasPlayer2.add(player2Card3);
        cartasPlayer2.add(player2Card4);
        cartasPlayer2.add(player2Card5);
        cartasPlayer2.add(player2Card6);
        cartasPlayer2.add(player2Card7);
        cartasPlayer2.add(player2Card8);
        cartasPlayer2.add(player2Card9);
        cartasPlayer2.add(player2Card10);
        cartasPlayer2.add(player2Card11);
        cartasPlayer2.add(player2Card12);
        cartasPlayer2.add(player2Card13);
        cartasPlayer2.add(player2Card14);
        cartasPlayer2.add(player2Card15);
        cartasPlayer2.add(player2Card16);


        stop2Btn.setTranslationX(1000f);
        oneMore2Btn.setTranslationX(-1000f);
        stopBtn.setTranslationX(1000f);
        oneMoreBtn.setTranslationX(-1000f);

        //Recogemos los puntos de la última partida guardada si la hay
        Intent intent = getIntent();
        boolean gameResumed = intent.getBooleanExtra(MainActivity.GAME_RESUMED, false);
        if (gameResumed){

            SharedPreferences sharedPreferences = getSharedPreferences(FILE_SHARED_NAME, Context.MODE_PRIVATE);
            player1.globalScore = sharedPreferences.getInt("scorePlayer" , 0);
            player2.globalScore = sharedPreferences.getInt("scoreBank" , 0);

            globalPlayerScore.setText(player1.globalScore + "");
            globalBankScore.setText(player2.globalScore + "");

        } else { //Se dejará guardado un 0-0 (no contará como juego guardado)
            SharedPreferences sharedPreferences = getSharedPreferences(FILE_SHARED_NAME, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("scoreBank", 0);
            editor.putInt("scorePlayer", 0);

            editor.commit();

        }



        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RelativeLayout parent = findViewById(R.id.relativeLayout);
                baraja = crearNuevaBaraja(baraja);

                //Asignamos rol de banco
                player1.isBank = false;
                player2.isBank = false;
                int direccion = RelativeLayout.ALIGN_PARENT_TOP;

                if(Math.random() < 0.5) {

                    player1.isBank = true;//Juega player 2 primero
                    direccion = RelativeLayout.ALIGN_PARENT_BOTTOM;
                    cardForPlayer(cartasPlayer2, player2, player2Score, player1, oneMore2Btn, stop2Btn);
                } else {

                    player2.isBank = true; //Juega player 1 primero
                    cardForPlayer(cartasJugador, player1, playerScore, player2, oneMoreBtn, stopBtn);
                    direccion = RelativeLayout.ALIGN_PARENT_TOP;

                }

                //ObjectAnimator animator1 = ObjectAnimator.ofFloat(whoBank, "translationY",0f, labelScore.getY());
                /*ObjectAnimator animator1 = ObjectAnimator.ofFloat(whoBank, "translationY",0f,500f);
                animator1.setDuration(1000);
                animator1.start();*/
                /*
                RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) whoBank.getLayoutParams();
                lp.addRule(direccion, RelativeLayout.TRUE);
                //lp.removeRule(RelativeLayout.CENTER_VERTICAL);

                AutoTransition transition = new AutoTransition();
                transition.setDuration(500);
                TransitionManager.beginDelayedTransition(parent, transition);
                whoBank.setLayoutParams(lp);

                transition.addListener(new Transition.TransitionListener() {
                    @Override
                    public void onTransitionStart(@NonNull Transition transition) {

                    }

                    @Override
                    public void onTransitionEnd(@NonNull Transition transition) {
                        if (player1.isBank){
                            cardForPlayer(cartasPlayer2, player2, player2Score, player1, oneMore2Btn, stop2Btn);
                        } else {
                            cardForPlayer(cartasJugador, player1, playerScore, player2, oneMoreBtn, stopBtn);
                        }
                    }

                    @Override
                    public void onTransitionCancel(@NonNull Transition transition) {

                    }

                    @Override
                    public void onTransitionPause(@NonNull Transition transition) {

                    }

                    @Override
                    public void onTransitionResume(@NonNull Transition transition) {

                    }
                });*/

                playBtn.setVisibility(View.INVISIBLE);

            }
        });

        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baraja = crearNuevaBaraja(baraja);

                playAgain.setVisibility(View.INVISIBLE);
                gameMessage.setVisibility(View.INVISIBLE);
                whoBank.setVisibility(View.INVISIBLE);
                playBtn.setVisibility(View.VISIBLE);


            }
        });

        oneMoreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animStop_OneMoreButtons(true, oneMoreBtn, stopBtn);
                cardForPlayer(cartasJugador, player1, playerScore, player2, oneMoreBtn, stopBtn);


            }
        });

        oneMore2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animStop_OneMoreButtons(true, oneMore2Btn, stop2Btn);
                cardForPlayer(cartasPlayer2, player2, player2Score, player1, oneMore2Btn, stop2Btn);


            }
        });

        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animStop_OneMoreButtons(true, oneMoreBtn, stopBtn);


                if (player1.isBank){
                    whoWins();
                } else {
                    cardForPlayer(cartasPlayer2, player2, player2Score, player1, oneMore2Btn, stop2Btn);

                }



            }
        });

        stop2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                animStop_OneMoreButtons(true, oneMore2Btn, stop2Btn);

                //El banco es el último en jugar,
                //por lo que se comprobará quien gana y se acabará la ronda

                if (player2.isBank){
                    whoWins();
                } else {
                    cardForPlayer(cartasJugador, player1, playerScore, player2, oneMoreBtn, stopBtn);
                }


            }
        });

    }

    private void whoWins() {

        User winner = new User();

        if (player1.points > player2.points){
            winner = player1;
        } else if(player2.points > player1.points){
            winner = player2;

        } else { //Empate, gana el que tiene el rol de banco
            if (player1.isBank){
                winner = player1;
                gameMessage.setText(R.string.player1WonMsg);
            } else {
                winner = player2;
                gameMessage.setText(R.string.player2WonMsg);
            }
        }

        gameMessage.setVisibility(View.VISIBLE);

        //oponentGlobalScore++;
        winner.globalScore++;
        endRound();

    }


    private void animStop_OneMoreButtons(boolean out, Button oneMore, Button stop){

        if (out){
            animatorOneMoreBtn = ObjectAnimator.ofFloat(oneMore, "translationX", 0f, -1000f);
            animatorStopBtn = ObjectAnimator.ofFloat(stop, "translationX", 0f, 1000f);
        } else {
            animatorOneMoreBtn = ObjectAnimator.ofFloat(oneMore, "translationX", -1000f, 0f);
            animatorStopBtn = ObjectAnimator.ofFloat(stop, "translationX", 1000f, 0f);
        }

        animatorOneMoreBtn.setDuration(1000);
        animatorStopBtn.setDuration(1000);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animatorOneMoreBtn, animatorStopBtn);
        animatorSet.start();

    }


    private void cardForPlayer(ArrayList<ImageView> cartasUser, User player, TextView userScore, User oponent, Button oneMore, Button stop) {

        ImageView carta = cartasUser.get(player.numCartas);
        player.numCartas++;

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

        ObjectAnimator card1Animation = ObjectAnimator.ofFloat(carta, "alpha", 0f, 1f);
        ObjectAnimator card2Animation = ObjectAnimator.ofFloat(carta, "rotationY", -180f, 0f);

        card1Animation.setDuration(0);
        card1Animation.setStartDelay(750);
        card2Animation.setDuration(500);
        card2Animation.setStartDelay(500);

        AnimatorSet animatorSetCard = new AnimatorSet();
        animatorSetCard.playTogether(cardAnimator1, cardAnimator2, cardAnimator3, cardAnimator4, card1Animation, card2Animation);
        animatorSetCard.start();


        String cartaStr = deleteLast(baraja.get(0));
        double valor = Double.parseDouble(cartaStr);
        baraja.remove(0);

        //Suma de valores
        if(valor > 7.5){
            player.points = player.points + 0.5;
        } else {
            player.points = player.points + valor;
        }

        userScore.setText(player.points + "");

        //Condicionales para acabar turno
        if (player.points > 7.5){
            if (oponent == player1){
                gameMessage.setText(R.string.player1WonMsg);
                gameMessage.setVisibility(View.VISIBLE);

            } else {
                gameMessage.setText(R.string.player2WonMsg);
                gameMessage.setVisibility(View.VISIBLE);
            }


            oponent.globalScore++;
            endRound();

        } else {
            animStop_OneMoreButtons(false, oneMore, stop);
        }


    }

    private void endRound() {

        globalBankScore.setText(player2.globalScore + "");

        globalPlayerScore.setText(player1.globalScore + "");

        //Al poner el marcador primero se cambia el número y despues de hace la animación
        playAgain.setVisibility(View.VISIBLE);
        /*
        ObjectAnimator animatorPlayAgainBtn = ObjectAnimator.ofFloat(playAgain, "alpha", 0f, 1f);
        animatorPlayAgainBtn.setDuration(0);
        animatorPlayAgainBtn.start();*/


        //Guardamos datos en el teléfono
        SharedPreferences sharedPreferences = getSharedPreferences(FILE_SHARED_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("scoreBank", player2.globalScore);
        editor.putInt("scorePlayer", player1.globalScore);

        editor.commit();

    }

    private String deleteLast(String str) {
        //Toast.makeText(this, "index 1: " + str.substring(str.length() - 1), Toast.LENGTH_SHORT).show();
        String result = null;
        if ((str != null) && (str.length() > 0)) {
            result = str.substring(0, str.length() - 1);
        }
        return result;
    }

    private ArrayList<String> crearNuevaBaraja(ArrayList<String> baraja) {

        baraja.clear();

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

        //Se desordena la baraja
        Collections.shuffle(baraja);

        //playerPoints = 0.0;
        //bankPoints = 0.0;
        player1.points = 0.0;
        player2.points = 0.0;

        player1.numCartas = 0;
        player2.numCartas = 0;
        //numCartasJugador = 0;
        //numCartasPlayer2 = 0;


        //Quitamos las cartas de la pantalla;
        for (int i = 0; i < cartasJugador.size(); i++){
            cartasJugador.get(i).setImageResource(R.drawable.back);
            cartasJugador.get(i).setAlpha(0f);
        }

        for (int i = 0; i < cartasPlayer2.size(); i++){
            cartasPlayer2.get(i).setImageResource(R.drawable.back);
            cartasPlayer2.get(i).setAlpha(0f);
        }


        playerScore.setText(R.string.initialScore);
        player2Score.setText(R.string.initialScore);

        return baraja;

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