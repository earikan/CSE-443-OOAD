/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author eda
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {

    /*screen width*/
    private final int SCREEN_WIDTH = 450;
    /*screen height*/
    private final int SCREEN_HEIGHT = 300;
    /*all dots size*/
    private final int DOT_SIZE = 10;
    /*all dots number*/
    private final int ALL_DOTS = 150;
    /*start position for snake x*/
    private final int RANDOM_POS_X = 44;
    /*start position for snake y*/
    private final int RANDOM_POS_Y = 29;
	/*show stamina percentage*/
	private final int STAMINA_PER = 12;
	/*alert when stamina smaller than 30*/
	private final int STAMINA_MIN_ALERT = 30;
	/*in 5 offer, show dialog box for decorator*/
	private final int EACH_OFFER = 6;
	/*decrease delay*/
    private final int DECREASE_DELAY = 15;

    /*delay between each move*/
    private int DELAY = 140;

    /*board coorinates*/
    private final int x[] = new int[ALL_DOTS];
    private final int y[] = new int[ALL_DOTS];

    private int dots;
    
    /*offer job x y coordinates*/
    private int offer_x;
    private int offer_y;

    /*food job x y coordinates*/
    private int food_x;
    private int food_y;

    private int flag = 0;
    
    /*all directions*/
    private boolean leftDirection = false;
    private boolean rightDirection = true;
    private boolean upDirection = false;
    private boolean downDirection = false;
    private boolean inGame = true;

    /*timer for delay*/
    private Timer timer;
    
    /*Image variables*/
    private Image ball;
    private Image offer;
    private Image head;
    private Image food;

    /*round counter*/
    private int round;

    StaminaTimer staminaTimer;
    
    /*job offer time counter*/
    RandomJobOfferTimer jobOfferTimer;
    
    /*food time cunter*/
    RandomFoodTimer foodTimer;
    
    /*counter for eaten offers*/
    private int eatenOffer;
    
    /*total score*/
    private int score;

    /*snake reference*/
    Snake snake;
    
    /*print screen snakes stamina*/
    String healt = "";
    
    
    /*constructor*/
    public Board(Snake snake) {
        /*set snake*/
        this.snake = snake;
        
        /*set intial variables*/
        round = 1;
        eatenOffer = 1;
        score = 0;

        /*set listener*/
        addKeyListener(new TAdapter());
        /*set background*/
        setBackground(Color.DARK_GRAY);
        setFocusable(true);

        /*set screen size*/
        setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        /*set images*/
        loadImages();
        /*set initial game*/
        initGame();
    }

    
    /*load images*/
    private void loadImages() {
        ImageIcon snake_icon = new ImageIcon(getClass().getResource("snake.png"));
        ball = snake_icon.getImage();

        ImageIcon offer_icon = new ImageIcon(getClass().getResource("offer.png"));
        offer = offer_icon.getImage();

        ImageIcon snake_icon_2 = new ImageIcon(getClass().getResource("snake.png"));
        head = snake_icon_2.getImage();

        ImageIcon hamburger_icon = new ImageIcon(getClass().getResource("hamburger.png"));
        food = hamburger_icon.getImage();
    }

    
    private void initGame() {
        /*start stamina timer*/
        staminaTimer = new StaminaTimer(snake.getStamina());
        staminaTimer.start();

        /*job offer counter*/
        jobOfferTimer = new RandomJobOfferTimer();
        jobOfferTimer.start();

        /*food timer counter*/
        foodTimer = new RandomFoodTimer();
        foodTimer.start();

        /*print screen stamina counter*/
        for (int i = 0; i < staminaTimer.getValue() % STAMINA_PER; ++i) {
            healt += "I";
        }

        /*set snakes lenght*/
        dots = snake.getLength();
        for (int z = 0; z < dots; z++) {
            x[z] = 100 - z * 10;
            y[z] = 100;
        }

        /*random food and offer initilaze*/
        locateOffer();
        locateFood();
        
        /*timer for delay*/
        timer = new Timer(DELAY, this);
        timer.start();
    }

    /*print screen game*/
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }

    
    /*draw game to screen*/
    private void doDrawing(Graphics g) {
        
        /*print screen to multiplier, score, round number*/
        g.setColor(Color.LIGHT_GRAY);
        g.drawString("Combo: x" + snake.getMultiplier(), 10, 20);
        g.setColor(Color.LIGHT_GRAY);
        g.drawString("Score: " + snake.getScore(), 10, 40);
        g.setColor(Color.LIGHT_GRAY);
        g.drawString("Round: " + round, 10, 60);
        g.setColor(Color.LIGHT_GRAY);

        /*print screen stamina as stick*/
        healt = "";
        for (int i = 0; i < staminaTimer.getValue() / STAMINA_PER; ++i) {
            healt += "I";
        }
        g.drawString("Stamina: " + healt, 350, 20);

        /*if stamine is lover print screen alert*/
        if (staminaTimer.getValue() < STAMINA_MIN_ALERT) {
            g.drawString("Eat Food!", 350, 40);
        } else {
            g.setColor(Color.DARK_GRAY);
        }

        /*draw foods and o in random time*/
        if (inGame && staminaTimer.getValue() > 0) {
            if (jobOfferTimer.getValue()) {
                g.drawImage(offer, offer_x, offer_y, this);
            }

            if (foodTimer.getValue()) {
                g.drawImage(food, food_x, food_y, this);
            }

            for (int z = 0; z < dots; z++) {
                if (z == 0) {
                    g.drawImage(head, x[z], y[z], this);
                } else {
                    g.drawImage(ball, x[z], y[z], this);
                }
            }

            Toolkit.getDefaultToolkit().sync();
        } else {
            gameOver(g);
        }
    }

    /*print message when game over*/
    private void gameOver(Graphics g) {
        String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = getFontMetrics(small);

        staminaTimer.stop();
        g.setColor(Color.WHITE);
        g.setFont(small);
        g.drawString(msg, (SCREEN_WIDTH - metr.stringWidth(msg)) / 2, SCREEN_HEIGHT / 2);
    }

    
    /*check offers and increase score and length*/
    private void checkOffer() {
        if (jobOfferTimer.getValue()) {
            if ((x[0] == offer_x) && (y[0] == offer_y)) {
                /*increase lenght*/
                dots++;
                /*increase eaten offer job counter*/
                eatenOffer++;
                /*set offer*/
                locateOffer();
                /*set score*/
                score += (int) (snake.getMultiplier() * 10);
                snake.setScore(score);
                /*set next timer again*/
                jobOfferTimer.stop();
                jobOfferTimer = new RandomJobOfferTimer();
                jobOfferTimer.start();
            }
        }
    }

    
    /*check food and increase stamina*/
    private void checkFood() {
        if (foodTimer.getValue()) {
            if ((x[0] == food_x) && (y[0] == food_y)) {
                /*increase eaten offer job counter*/
                staminaTimer.stop();
                staminaTimer = new StaminaTimer(snake.getStamina());
                staminaTimer.start();
                /*set apple*/
                locateFood();
                /*set score*/
                foodTimer.stop();
                foodTimer = new RandomFoodTimer();
                foodTimer.start();
            }
        }
    }

    
    /*move and relocate dots*/
    private void move() {
        for (int z = dots; z > 0; z--) {
            x[z] = x[z - 1];
            y[z] = y[z - 1];
        }

        if (leftDirection) {
            x[0] -= DOT_SIZE;
        }
        if (rightDirection) {
            x[0] += DOT_SIZE;
        }
        if (upDirection) {
            y[0] -= DOT_SIZE;
        }
        if (downDirection) {
            y[0] += DOT_SIZE;
        }
    }

    
    /*when snake crash walls or own tail, game over*/
    private void checkCollision() {
        for (int z = dots; z > 0; z--) {
            if ((z > 4) && (x[0] == x[z]) && (y[0] == y[z])) {
                inGame = false;
            }
        }

        if ((y[0] >= SCREEN_HEIGHT) || (y[0] < 0) || (x[0] > SCREEN_WIDTH) || (x[0] < 0)) {
            inGame = false;
        }

        if (!inGame) {
            timer.stop();
        }
    }

    
    /*random locate and random timefor offer*/
    private void locateOffer() {
        int r = (int) (Math.random() * RANDOM_POS_X);
        offer_x = r * DOT_SIZE;

        r = (int) (Math.random() * RANDOM_POS_Y);
        offer_y = r * DOT_SIZE;
    }

    
    /*random locate and random timefor food*/
    private void locateFood() {
        int r = (int) (Math.random() * RANDOM_POS_X);
        food_x = r * DOT_SIZE;

        r = (int) (Math.random() * RANDOM_POS_Y);
        food_y = r * DOT_SIZE;
    }

    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (inGame && flag != 1) {

            if (eatenOffer % EACH_OFFER == 0 && eatenOffer != 0) {
                flag = 1;

                Integer choice = null;
                do {
                    String enteredString;
                    int isChoiceLegal = 0;

                    /*ask until choice is legal*/
                    do {
                        enteredString = JOptionPane.showInputDialog(round + ".Round Passed!\n"
                                + "+Foreign Language = 1\n"
                                + "+For Training Certificates = 2\n"
                                + "+For Internship = 3\n"
                                + "For Exit Game = 0:");

                        /*is choice is a number*/
                        try {
                            choice = Integer.valueOf(enteredString);
                            isChoiceLegal = 0;
                        } catch (NumberFormatException n) {
                            isChoiceLegal = 1;
                        }

                    } while (isChoiceLegal == 1);

                    /*decorate snake*/
                    if (choice == 1) {
                        /*decorate with ForeignLanguages*/
                        snake = new ForeignLanguages(snake);

                    } else if (choice == 2) {
                        /*decorate with TraininCertificates*/
                        snake = new TraininCertificates(snake);

                    } else if (choice == 3) {
                        /*decorate with Internship*/
                        snake = new Internship(snake);

                    } else if (choice == 0) {
                        System.exit(0);
                    }

                    if (choice == 1 || choice == 2 || choice == 3) {
                        /*decrease delay, more faster snake*/
                        if (DELAY > 0) {
                            DELAY -= DECREASE_DELAY;
                        }

                        /*start timer again with new delay*/
                        timer.stop();
                        timer = new Timer(DELAY, this);
                        timer.start();
                    }
                } while (choice != 1 && choice != 2 && choice != 3 && choice != 0);

                /*round passed*/
                round += 1;
                /*increase eaten offer jobs counter*/
                eatenOffer++;
                /*set score*/
                snake.setScore(score);
                /*set flag*/
                flag = 0;
            }

            checkOffer();
            checkFood();
            checkCollision();
            move();
        }

        repaint();
    }

    
    /*set adapter*/
    private class TAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            if ((key == KeyEvent.VK_LEFT) && (!rightDirection)) {
                leftDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if ((key == KeyEvent.VK_RIGHT) && (!leftDirection)) {
                rightDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if ((key == KeyEvent.VK_UP) && (!downDirection)) {
                upDirection = true;
                rightDirection = false;
                leftDirection = false;
            }

            if ((key == KeyEvent.VK_DOWN) && (!upDirection)) {
                downDirection = true;
                leftDirection = false;
                rightDirection = false;
            }
        }
    }
}
