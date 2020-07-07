package com.mygdx231.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.Timer;
import com.mygdx231.game.menu.Level0;
import com.mygdx231.game.menu.hit;
import com.mygdx231.game.sprites.Bird;
import com.mygdx231.game.states.GameStateManager;
import com.mygdx231.game.states.PlayState;
import java.util.Iterator;

public class MyGdxGame1 extends Game {
	// bucket is main hero
	// raindrops is enemy or zombies
	// gun is sword
	// cemetery is cemetery
	private static final int FRAME_COLS = 3, FRAME_ROWS = 1;
	private static final int FRAME_COLS1 = 6, FRAME_ROWS1 = 1;
	private static final int FRAME_COLS2 = 3, FRAME_ROWS2 = 1;
	private static final int FRAME_COLS3 = 3, FRAME_ROWS3 = 1;
	private static final int FRAME_COLS4 = 1, FRAME_ROWS4 = 5;
	private static final int FRAME_COLS5 = 1, FRAME_ROWS5 = 5;
	// Objects used
	Animation <TextureRegion> walkAnimation;
	Animation <TextureRegion> fireanim;
	Animation <TextureRegion> zombieWalk;
	Animation <TextureRegion> zombie3;
	Animation <TextureRegion> swordan;
	Animation <TextureRegion> knifel;
	// Must declare frame type (TextureRegion)
	// A variable for tracking elapsed time for the animation
	float stateTime;
    float stateTime1;
    float StateTime2;
	float StateTime3;
	float StateTime4;
	float StateTime5;
	inventory inv;
	nextlevel nxt;
	Menu mn;
	mainmenu mm;
	obstacles ob;
	obstacles3 ob3;
	level4 lvl4;
	level4main lvl4m;
	level5 lvl5;
	public OrthographicCamera camera;
	public SpriteBatch batch;
	Texture zombie;
	Texture walkSheet;
	Texture dropImage;
	Texture rightImage;
	Texture sword;
	public Texture bucketImage;
	public Texture backGround;
	Texture left;
	Texture fire;
	Texture heart;
	Texture knife;
	Texture bullet;
	Texture attack;
	Texture characterleft;
    public Texture door;
	Texture enter;
	Texture level2;
	Texture spawn;
	Texture coing;
	Texture npcleft;
	Texture npcright;
	Texture text;
	public Texture backGround1;
	public Texture backGround2;
	public Texture backGround3;
	Texture cemetery;
	Texture cemetery2;
	Texture cemetery3;
	Texture cemetery4;
	Texture cemetery5;
	Texture zombielvl3;
	Texture shieldhealth;
	Texture stairs;
	Texture up;
	Texture knifeleft;
	public Texture  down;
	Texture  bow;
	Texture bowleft;
	Texture nameplace;
	public Texture text2;
	public Texture level4;
	public Texture tree;
	public Texture option;
	public Rectangle bucket;
	public Texture l3;
	public Texture r3;
	public Texture village;
	Texture maintable;
	public Texture leftok;
	public Texture rightok;
	public Texture leftsmall;
	public Texture rightsmall;
	public Texture upmini;
	public Texture upoke;
	public Texture downmini;
	public Texture downoke;
	public Texture optionrus;
	Rectangle gun;
	Rectangle leftbut;
	Rectangle right;
	Rectangle bucketf;
	Rectangle cemetery1;
	Rectangle buckety;
	Rectangle door1;
	Rectangle door2;
	public Rectangle npc;
	public Rectangle stairs4;
	Rectangle bulletrec;
	Rectangle nameplace2;
	public Rectangle door3;
	public Rectangle left125;
	public Rectangle right125;
	public Rectangle upok;
	public Rectangle upsmall;
	public Rectangle upnormal;
	public Rectangle downrec;
	Vector3 touchPos;
	Vector3 touchPos1;
	Vector3 touchPos2;
    Vector3 touchPos10;
    Vector3 velosity;
	Vector3 position;
	public Vector3 touchPos6;
	Array<Rectangle> raindrops;
	Array<Rectangle> levels2;
	Array<Rectangle> levels3;
	long lastDropTime;
	long lastDropTime2;
	long lastDropTime3;
	public int health = 7;
	public int a = 7;
	public static int coins = 0;
	public static BitmapFont FontRed1;
	public String coin;
	float delay = 3;
	public int death = 1;
	int sps = 1;
	int sps2 = 1;
	int sps3 = 1;
	public int potionh = 0;
    public int potions = 0;
    public int v = 0;
    boolean f;
    int q = 3;
    int potionrandom;
    public int shield = 0;
    public int shieldh = 0;
    public int speed = 200;
    public boolean r = true;
    public boolean turn = true;
    public int pause = 0;
    public boolean pausep;
    public boolean returnp;
    public boolean begin = true;
    public boolean exit = false;
    public int rand = 1;
    public boolean chests = false;
    Sound buttons;
    Sound swordsound;
    Sound touch;
    Sound deaths;
	public boolean bulletb = false;
	public int amount = 0;
    Texture bullets[] = new Texture[amount+1234];
    public int i=0;
    public boolean kill;
    public boolean swordb = true;
    public boolean bowb = false;
	public boolean instr;
	public boolean gr = true;
	private GameStateManager gsm;
	public float x = 510;
	public float y = 170;
	public boolean pos = false;
	public  Bird br;
	public boolean b;
	public boolean chest = true;
	public boolean chest2 = true;
	int c = 0;
	boolean put;
	public boolean sps4;
	public boolean kill2;
	public boolean kill3;
	public armor ar;
	public int randomarmor = 0;
	public int randomarmor2 = 0;
	public int sps5 = 1;
	float yb = 0;
	public static int xup1;
	public static int xup2;
	public static int yup1;
	public static int yup2;

	@Override
	public void create () {
		/*
		Импортирование метода create всех нужных классов
		 */
		nxt = new nextlevel(this);
		nxt.create();
		mn = new Menu(this);
		mn.create();
		mm = new mainmenu(this);
		mm.create();
		inv = new inventory(this);
		inv.create();
		ob = new obstacles(this);
		ob.create();
		ob3 = new obstacles3(this);
		ob3.create();
		lvl4 = new level4(this);
		lvl4.create();
		lvl4m = new level4main(this);
		lvl4m.create();
		gsm = new GameStateManager();
		ar = new armor(this);
		ar.create();
		lvl5 = new level5(this);
        lvl5.create();

		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);
		batch = new SpriteBatch();

		touchPos = new Vector3();
		touchPos1 = new Vector3();
		touchPos2  = new Vector3();
		touchPos6 = new Vector3();
		touchPos10 = new Vector3();

		buttons = Gdx.audio.newSound(Gdx.files.internal("click.wav"));
		touch = Gdx.audio.newSound(Gdx.files.internal("touch.wav"));
		deaths = Gdx.audio.newSound(Gdx.files.internal("death.wav"));

		zombie = new Texture("zombie2.png");
		zombielvl3 = new Texture("zombie3.png");
		backGround = new Texture("background1.jpg");
		bucketImage = new Texture("knightright.png");
		backGround1 = new Texture("drt1.png");
		backGround2 = new Texture("grd1.png");
		fire = new Texture(Gdx.files.internal("fire.png"));
		rightImage = new Texture("right15x.png");
		left = new Texture("left15x.png");
		sword = new Texture("sword.png");
		heart = new Texture("heart.png");
		knife  = new Texture("knife1.png");
		attack = new Texture("attack.png");
		characterleft = new Texture("knightleft.png");
        door = new Texture("door.png");
		enter = new Texture("enter.png");
		level2 = new Texture("backround3.jpg");
		coing =  new Texture("coin.png");
		npcleft =  new Texture("npc.png");
		text =  new Texture("text.png");
		npcright = new Texture("npc2.png");
		backGround3  = new Texture("bacsre.png");
		cemetery = new Texture("cemetery.png");
		cemetery2 = new Texture("cemetery2.png");
		cemetery3 = new Texture("cemetery3.png");
		cemetery4 = new Texture("cemetery4.png");
		cemetery5 = new Texture("cemetery5.png");
		shieldhealth = new Texture("shieldhealth.png");
		stairs = new Texture("stairs.png");
		up = new Texture("up125x.png");
		down = new Texture("down125x.png");
		knifeleft = new Texture("knifeleft.png");
		bullet = new Texture("bullet.png");
		for(int i=0;i<=amount+1000;i++){
			bullets[i] = new Texture("bullet.png");
		}
		bow = new Texture("bow.png");
		bowleft = new Texture("bowleft.png");
		nameplace = new Texture("nameplace.png");
		text2 = new Texture("text.png");
		level4 = new Texture("level4.png");
		tree = new Texture("tree.png");
		option = new Texture("bth.jpeg");
        village = new Texture("village.png");
        maintable = new Texture("maintableingame.png");
        leftsmall = new Texture("left.png");
        rightsmall = new Texture("right.png");
        upmini = new Texture("up.png");
        downmini = new Texture("down.png");
        optionrus = new Texture("bthrus.png");
        rightok = rightImage;
        leftok = left;
		spawn = backGround;
		l3 = characterleft;
		r3 = bucketImage;
		upoke = up;
		downoke = down;

		gun = new Rectangle();
		gun.width = 49;
		gun.height = 10;
		buckety=new Rectangle();
		buckety.x=-10;
		buckety.y=10;
		buckety.width = 14;
		buckety.height = 14;
		bucketf= new Rectangle();
		bucketf.x = 500;
		bucketf.y=	175;
		right = new Rectangle();
		right.x=155;
		right.y=70;
		right125 = new Rectangle();
		right125.x = 165;
		right125.y = 60;
		leftbut = new Rectangle();
		leftbut.x=60;
		leftbut.y=70;
		left125 = new Rectangle();
		left125.x = 50;
		left125.y = 60;
		door1 = new Rectangle();
		door1.x=30;
		door1.y=170;
		door1.width=60;
		door1.height=110;
		door2 = new Rectangle();
		door2.x=0;
		door2.y=0;
		door2.width=0;
		door2.height=0;
		npc = new Rectangle();
		npc.x=400;
		npc.y=155;
		npc.width=50;
		npc.height=50;
		cemetery1 = new Rectangle();
		cemetery1.x=200;
		cemetery1.y=163;
		stairs4 = new Rectangle();
		stairs4.x = 0;
		stairs4.y = 0;
		stairs4.width = 0;
		stairs4.height = 0;
		bulletrec = new Rectangle();
        position = new Vector3();
        position.x = x;
        position.y = y;
		nameplace2 = new Rectangle();
		door3 = new Rectangle();
		door3.x = 700;
		door3.y = 170;
        door3.height = door.getHeight();
        door3.width = door.getWidth();
        upnormal = new Rectangle();
        upnormal.x = 557;
        upnormal.y = 104;
        upsmall = new Rectangle();
        upsmall.x = 560;
        upsmall.y = 106;
        upok = new Rectangle();
        upok.x = upnormal.x;
        upok.y = upnormal.y;
        downrec = new Rectangle();
        downrec.x = 557;
        downrec.y = 28;

		raindrops = new Array<Rectangle>();
		if(mm.loading == false) {
			spawnRaindrop();
		}
		levels2 = new Array<Rectangle>();
		spawn2();
		levels3 = new Array<Rectangle>();
		spawn3();

		FontRed1 = new BitmapFont(Gdx.files.internal("arial15.fnt"));
		FontRed1.setColor(Color.WHITE); // White

		gsm.set(new PlayState(gsm,this,ob));


	// Анимация

		walkSheet = new Texture(Gdx.files.internal("zombie.png"));
		TextureRegion[][] tmp = TextureRegion.split(walkSheet,
				walkSheet.getWidth() / FRAME_COLS,
				walkSheet.getHeight() / FRAME_ROWS);
		TextureRegion[] walkFrames = new TextureRegion[FRAME_COLS *
				FRAME_ROWS];
		int index = 0;
		for (int i = 0; i < FRAME_ROWS; i++) {
			for (int j = 0; j < FRAME_COLS; j++) {
				walkFrames[index++] = tmp[i][j];
			}
		}
		walkAnimation = new Animation<TextureRegion>(0.15f, walkFrames);
		stateTime = 0f;


        // анимация для костра
		int index1 = 0;
		TextureRegion[][] tm = TextureRegion.split(fire,
				fire.getWidth() / FRAME_COLS1,
				fire.getHeight() / FRAME_ROWS1);
		TextureRegion[] walkFrames1 = new TextureRegion[FRAME_COLS1 *
				FRAME_ROWS1];
		for (int i = 0; i < FRAME_ROWS1; i++) {
			for (int j = 0; j < FRAME_COLS1; j++) {
				walkFrames1[index1++] = tm[i][j];
			}
		}
		fireanim = new Animation<TextureRegion>(0.2f, walkFrames1);
		stateTime1 = 0f;


		// анимация для зомби level 2;
		int index2 = 0;
		TextureRegion[][] tm2 = TextureRegion.split(zombie,
				zombie.getWidth() / FRAME_COLS2,
				zombie.getHeight() / FRAME_ROWS2);
		TextureRegion[] walkframes2 = new TextureRegion[FRAME_COLS2 * FRAME_ROWS2];
		for(int i = 0; i < FRAME_ROWS2; i++) {
			for(int j = 0; j < FRAME_COLS2; j++)
			walkframes2[index2++] = tm2[i][j];
		}
		zombieWalk = new Animation<TextureRegion>(0.2f, walkframes2);
		StateTime2 = 0f;


		// анимация для npc level 2;
		int index3 = 0;
		TextureRegion[][] tm3 = TextureRegion.split(zombielvl3
				, zombielvl3.getWidth() / FRAME_COLS3,
				zombielvl3.getHeight() / FRAME_ROWS3);
		TextureRegion[] walkframes3 = new TextureRegion[FRAME_COLS3 * FRAME_ROWS3];
		for(int i = 0; i < FRAME_ROWS3; i++) {
			for(int j = 0; j < FRAME_COLS3; j++)
				walkframes3[index3++] = tm3[i][j];
		}
		zombie3 = new Animation<TextureRegion>(0.2f, walkframes3);
		StateTime3 = 0f;


		// анимация для меча в правую сторону;
		int index4 = 0;
		TextureRegion[][] tm4 = TextureRegion.split(knife
				, knife.getWidth() / FRAME_COLS4,
				knife.getHeight() / FRAME_ROWS4);
		TextureRegion[] walkframes4 = new TextureRegion[FRAME_COLS4 * FRAME_ROWS4];
		for(int i = 0; i < FRAME_ROWS4; i++) {
			for(int j = 0; j < FRAME_COLS4; j++)
				walkframes4[index4++] = tm4[i][j];
		}
		swordan = new Animation<TextureRegion>(0.11f, walkframes4);
		StateTime4 = 0f;

		// анимация для меча в левую сторону;
		int index5 = 0;
		TextureRegion[][] tm5 = TextureRegion.split(knifeleft
				, knifeleft.getWidth() / FRAME_COLS5,
				knifeleft.getHeight() / FRAME_ROWS5);
		TextureRegion[] walkframes5 = new TextureRegion[FRAME_COLS5 * FRAME_ROWS5];
		for(int i = 0; i < FRAME_ROWS5; i++) {
			for(int j = 0; j < FRAME_COLS5; j++)
				walkframes5[index5++] = tm5[i][j];
		}
		knifel = new Animation<TextureRegion>(0.11f, walkframes5);
		StateTime5 = 0f;

	}


	private void spawnRaindrop() {
		Rectangle raindrop = new Rectangle();
		raindrop.y = MathUtils.random(168, 168);
		raindrop.x = MathUtils.random(800, 800);
		raindrop.width = 25;
		raindrop.height = 64;
		raindrops.add(raindrop);
		lastDropTime = TimeUtils.millis();
	}
	private void spawn2() {
		Rectangle sp = new Rectangle();
		sp.y = MathUtils.random(165, 165);
		sp.x = MathUtils.random(800, 800);
		sp.width = 25;
		sp.height = 64;
		levels2.add(sp);
		lastDropTime2 = TimeUtils.millis();
	}
	private void spawn3() {
		Rectangle sp3 = new Rectangle();
		sp3.y = MathUtils.random(165, 165);
		sp3.x = MathUtils.random(190, 666);
		sp3.width = 25;
		sp3.height = 64;
		levels3.add(sp3);
		lastDropTime3 = TimeUtils.millis();
	}
/*
	final int max_level_jump = 300;//переменная обозначающай до какого уровня будет прыгать человечек, можно сделать супер прыжек
	final int mass_person = 90;//масса человечка
	double ay = 1;//ускорение
	boolean state = false;
	public  double force = 900;
	public void jump(float coordY,int mass,final double force) {
		if (gr == true) {
			if (((state == false) && (coordY > 169)) || (state == true) && (coordY > 170)) {
				state = true;
				Timer.schedule(new Timer.Task() { // задержка и код который должен выполняться после этого времени
					@Override
					public void run() {
						double a = force - mass_person;
						bucket.y = Math.round(bucket.y + a / 70);
						jump(bucket.y, mass_person, a);
						if (Gdx.input.isTouched()) {
							// обработка касаний для движения
							touchPos10.set(Gdx.input.getX(), Gdx.input.getY(), 0);
							camera.unproject(touchPos10);
							if ((touchPos10.x >= 60 && touchPos10.x <= 110) /*&& (touchPos10.y >= 70 && touchPos10.y <= 120) && (bucket.y <= 170)*/  /*) {
								//bucket.x -= speed * Gdx.graphics.getDeltaTime();
							}
							/*if ((touchPos10.x >= 155 && touchPos10.x <= 205)/* && (touchPos10.y >= 70 && touchPos10.y <= 120) && (bucket.y <= 170)) {
								bucket.x += speed * Gdx.graphics.getDeltaTime();
							}

						}
					}
				}, 0.05F);

			} else {
				state = false;
			}

		}

	}
	*/


	/*
	* this void is render image in main class
	*
	*
	* */

	@Override
	public void render () {

		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
		batch.setProjectionMatrix(camera.combined);
        lvl4.render();

if(begin==false && sps4 == true && mm.loading == false) {
	if(mainmenu.sizeofbuttons == true){
		leftbut.x = left125.x;
		leftbut.y = left125.y;
		right.x = right125.x;
		right.y = right125.y;
		rightImage = rightok;
		left = leftok;
		upnormal.x = upok.x;
		upnormal.y = upok.y;
		up = upoke;
		xup1 = 557;
		xup2 = 607;
		yup1 = 104;
		yup2 = 154;
		down = downoke;
		downrec.x = 557;
		downrec.y = 28;
	}else{
		right.x=155;
		right.y=70;
		leftbut.x=60;
		leftbut.y=70;
		upnormal.x = upsmall.x;
		upnormal.y = upsmall.y;
		rightImage = rightsmall;
		left = leftsmall;
		up = upmini;
		xup1 = 560;
		xup2 = 600;
		yup1 = 106;
		yup2 = 146;
		down = downmini;
		downrec.x = 560;
		downrec.y = 40;
	}

	bucket = new Rectangle(position.x,position.y,bucketImage.getWidth()-14,bucketImage.getHeight()-40);
	bucket.setPosition(x,y);
	nameplace2.set(200,170,nameplace.getHeight(),nameplace.getHeight());

	stateTime += Gdx.graphics.getDeltaTime();
	stateTime1 += Gdx.graphics.getDeltaTime();// Accumulate elapsed animation
	StateTime2 += Gdx.graphics.getDeltaTime();
	StateTime3 += Gdx.graphics.getDeltaTime();
	StateTime4 += Gdx.graphics.getDeltaTime();
	StateTime5 += Gdx.graphics.getDeltaTime();

	TextureRegion currentFrame = walkAnimation.getKeyFrame(stateTime, true);
	TextureRegion currentFramefire = fireanim.getKeyFrame(stateTime1, true);
	TextureRegion curentFramezombie = zombieWalk.getKeyFrame(StateTime2, true);
	TextureRegion curentFramezombielvl3 = zombie3.getKeyFrame(StateTime3, true);
	TextureRegion curentFramesword = swordan.getKeyFrame(StateTime4, true);
	TextureRegion curentFrameswordleft = knifel.getKeyFrame(StateTime5, true);


	batch.begin();
	batch.draw(backGround, 0, yb); // BackGround
	batch.draw(backGround1, 0, 0); // land
	batch.draw(currentFramefire, bucketf.x + 35, bucketf.y - 15);
	if(backGround != level4 && backGround!= village && backGround != lvl5.inside) {
		batch.draw(door, door1.x, door1.y);
	}// right door
	batch.draw(rightImage, right.x, right.y); // right button of manage
	batch.draw(left, leftbut.x, leftbut.y); // left button of manage
	batch.draw(attack, 650, 55); // attack button
	batch.draw(rightImage, right.x, right.y);
	batch.draw(left, leftbut.x, leftbut.y);
	batch.draw(attack, 650, 55);
  if(backGround != level4 && backGround != village && backGround != lvl5.inside) {
	  if (door1.overlaps(bucket)) {// if main hero come to door
		  if (backGround == level2) {
			  batch.draw(enter, 575, 30);
			  if (Gdx.input.justTouched()) { // if program caught touch on screen
				  touchPos1.set(Gdx.input.getX(), Gdx.input.getY(), 0); // data of location of touch
				  camera.unproject(touchPos1);
				  if (coins >= 5) {
					  if ((touchPos1.x >= 575 && touchPos1.x <= 626) && (touchPos1.y >= 30 && touchPos1.y <= 92)) {  // если касание зафиксировано в зоне кнопки входа в портал
						  if (backGround == level2) {
							  sps = 0;
							  Timer.schedule(new Timer.Task() { // задержка и код который должен выполняться после этого времени
								  @Override
								  public void run() {
									  sps = 1;
									  backGround = spawn;
								  }
							  }, delay);
							  //если касание зафиксировано в зоне кнопки входа в портал
						  }
						  coins = coins - 5;// колличество монет уменьшаем на 5
					  }
				  }
			  }
		  } else {
			  if (backGround != village ) {
				  batch.draw(enter, 575, 30);
				  if (Gdx.input.justTouched()) { // if program caught touch on screen
					  touchPos1.set(Gdx.input.getX(), Gdx.input.getY(), 0); // data of location of touch
					  camera.unproject(touchPos1);
					  if (coins >= 5) {
						  if ((touchPos1.x >= 575 && touchPos1.x <= 626) && (touchPos1.y >= 30 && touchPos1.y <= 92)) {
							  if (backGround == spawn || backGround == backGround3) {
								  sps2 = 0;
								  Timer.schedule(new Timer.Task() { // задержка и код который должен выполняться после этого времени
									  @Override
									  public void run() {
										  sps2 = 1;
										  backGround = level2;
									  }
								  }, delay);
							  }
							  coins = coins - 5;// колличество монет уменьшаем на 5
						  }
					  }
				  }
			  }
		  }
	  }
	  if (npc.width == 0) {
		  if (backGround == level2) {
			  if (door2.overlaps(bucket)) {
				  batch.draw(enter, 575, 30);// рисует кнопку входа
				  if (Gdx.input.justTouched()) { // регистрируем касание
					  touchPos1.set(Gdx.input.getX(), Gdx.input.getY(), 0);// считываем положение касания
					  camera.unproject(touchPos1);
					  if (coins >= 5) {
						  if ((touchPos1.x >= 575 && touchPos1.x <= 626) && (touchPos1.y >= 30 && touchPos1.y <= 92)) { // если оно зафиксирвано  зоне кнопки входа то меняем фон на фон 3 уровня
							  if (backGround == level2) {
								  sps3 = 0;
								  backGround = backGround3;
								  pos = true;
								  Timer.schedule(new Timer.Task() { // задержка и код который должен выполняться после этого времени
									  @Override
									  public void run() {
										  sps3 = 1;
									  }
								  }, delay);
							  }

							  coins = coins - 5;
						  }
					  }
				  }
			  }
		  }
	  }
  }
	batch.draw(up, upnormal.x, upnormal.y);

	// дальше  идет код про отнимание и отрисовку жизней
	if (a == 7) {
		batch.draw(heart, buckety.x + 30, buckety.y + 425);
		batch.draw(heart, buckety.x + 65, buckety.y + 425);
		batch.draw(heart, buckety.x + 100, buckety.y + 425);
		batch.draw(heart, buckety.x + 135, buckety.y + 425);
		batch.draw(heart, buckety.x + 170, buckety.y + 425);
		batch.draw(heart, buckety.x + 205, buckety.y + 425);
		batch.draw(heart, buckety.x + 240, buckety.y + 425);
	}
	if (a == 6) {
		batch.draw(heart, buckety.x + 30, buckety.y + 425);
		batch.draw(heart, buckety.x + 65, buckety.y + 425);
		batch.draw(heart, buckety.x + 100, buckety.y + 425);
		batch.draw(heart, buckety.x + 135, buckety.y + 425);
		batch.draw(heart, buckety.x + 170, buckety.y + 425);
		batch.draw(heart, buckety.x + 205, buckety.y + 425);
	}
	if (a == 5) {
		batch.draw(heart, buckety.x + 30, buckety.y + 425);
		batch.draw(heart, buckety.x + 65, buckety.y + 425);
		batch.draw(heart, buckety.x + 100, buckety.y + 425);
		batch.draw(heart, buckety.x + 135, buckety.y + 425);
		batch.draw(heart, buckety.x + 170, buckety.y + 425);
	}
	if (a == 4) {
		batch.draw(heart, buckety.x + 30, buckety.y + 425);
		batch.draw(heart, buckety.x + 65, buckety.y + 425);
		batch.draw(heart, buckety.x + 100, buckety.y + 425);
		batch.draw(heart, buckety.x + 135, buckety.y + 425);
	}
	if (a == 3) {
		batch.draw(heart, buckety.x + 30, buckety.y + 425);
		batch.draw(heart, buckety.x + 65, buckety.y + 425);
		batch.draw(heart, buckety.x + 100, buckety.y + 425);
	}
	if (a == 2) {
		batch.draw(heart, buckety.x + 30, buckety.y + 425);
		batch.draw(heart, buckety.x + 65, buckety.y + 425);
	}
	if (a == 1) {
		batch.draw(heart, buckety.x + 30, buckety.y + 425);
	}
	// отрисовка щитов
	if (shieldh == 1) {
		batch.draw(shieldhealth, buckety.x + 33, buckety.y + 386);
	}
	if (shieldh == 2) {
		batch.draw(shieldhealth, buckety.x + 33, buckety.y + 386);
		batch.draw(shieldhealth, buckety.x + 68, buckety.y + 386);
	}
	if (shieldh == 3) {
		batch.draw(shieldhealth, buckety.x + 33, buckety.y + 386);
		batch.draw(shieldhealth, buckety.x + 68, buckety.y + 386);
		batch.draw(shieldhealth, buckety.x + 103, buckety.y + 386);
	}
	if (shieldh == 4) {
		batch.draw(shieldhealth, buckety.x + 33, buckety.y + 386);
		batch.draw(shieldhealth, buckety.x + 68, buckety.y + 386);
		batch.draw(shieldhealth, buckety.x + 103, buckety.y + 386);
		batch.draw(shieldhealth, buckety.x + 138, buckety.y + 386);
	}
	if (shieldh == 5) {
		batch.draw(shieldhealth, buckety.x + 33, buckety.y + 386);
		batch.draw(shieldhealth, buckety.x + 68, buckety.y + 386);
		batch.draw(shieldhealth, buckety.x + 103, buckety.y + 386);
		batch.draw(shieldhealth, buckety.x + 138, buckety.y + 386);
		batch.draw(shieldhealth, buckety.x + 173, buckety.y + 386);
	}

	if (backGround == level2) {
		door2.x = 700;
		door2.y = 170;
		door2.height = 60;
		door2.width = 110;
		batch.draw(door, door2.x, door2.y);
		bucketf.x = 800;
		bucketf.y = 480;
		fire = level2;
		//NPC.............................................................................................
		// отрисовка и обработка npc на втором уровне
		batch.draw(npcleft, npc.x, npc.y);
		if (npc.overlaps(bucket)) {
			batch.draw(text, 310, 405);
			if(mainmenu.language == false){
				FontRed1.draw(batch, "If you want to get a chest you must kill some zombies", 322, 454);
				FontRed1.draw(batch, "Sorry but i have to go", 322, 434);
			}else{
            	FontRed1.draw(batch, "Если хочешь добраться до сундука,убивай зомби", 318, 455);
				FontRed1.draw(batch, "Извини,но мне надо в путь", 318, 433);
			}
			Timer.schedule(new Timer.Task() { // задержка и код который должен выполняться после этого времени
				@Override
				public void run() {
					if (Gdx.input.justTouched()) {
						touchPos1.set(Gdx.input.getX(), Gdx.input.getY(), 0);
						camera.unproject(touchPos1);
						npcleft = npcright;
						b = true;
					}
				}
			},delay);
		}
		if(b == true){
			npc.x += 150 * Gdx.graphics.getDeltaTime();
		if(npc.overlaps(door2) && npc.x >= 697){
			b = false;
			npcleft.dispose();
			npc.width = 0;
			npc.height = 0;
			npc.x = -50;
			npc.y = -50;
		}

	}
	}

	// отрисовка гробов на 3 уровне
	if (backGround == backGround3) {
		batch.draw(tree,483,162);
		stairs4.x = 690;
		stairs4.y = 210;
		stairs4.width = 32;
		stairs4.height = 457;
		batch.draw(obstacles3.warning,130,166);
		batch.draw(stairs, stairs4.x, stairs4.y);
		batch.draw(cemetery5, cemetery1.x, cemetery1.y);
		batch.draw(cemetery4, cemetery1.x + 45 + 46, cemetery1.y);
		batch.draw(cemetery2, cemetery1.x + 70 + 46 * 2, cemetery1.y);
		batch.draw(cemetery, cemetery1.x + 100 + 46 * 3, cemetery1.y);
		batch.draw(cemetery3, cemetery1.x + 110 + 46 * 4, cemetery1.y);
		batch.draw(cemetery2, cemetery1.x + 125 + 46 * 5, cemetery1.y);
		batch.draw(cemetery, cemetery1.x + 165 + 46 * 6, cemetery1.y);
	}
	if (backGround == spawn) {
		bucketf.x = 500;
		bucketf.y = 175;
		door2.x = 0;
		door2.y = 0;
		door2.height = 0;
		door2.width = 0;
	}

	//NPC...................................................................................................

    if(backGround == spawn) {
        batch.draw(nameplace,200,170);
    }
    if(nameplace2.overlaps(bucket) && backGround == spawn){
    	put = true;
		if (Gdx.input.justTouched()) {
			// if program caught touch on screen
			touchPos6.set(Gdx.input.getX(), Gdx.input.getY(), 0); // data of location of touch
			camera.unproject(touchPos6);

			if ((touchPos6.x >= 200 && touchPos6.x <= 260) && (touchPos6.y >= 170 && touchPos6.y <= 246) && pause == 0) {
				if (c == 1) {
					c = 0;
				} else {
					c = 1;
				}
			}
		}
    }else{
    	put = false;
	}

    if(c==1 && nameplace2.overlaps(bucket) && backGround == spawn ){
		batch.draw(text2, 365, 405);
		if(mainmenu.language == false){
			FontRed1.draw(batch, "Once here everything flourished", 372, 455);
			FontRed1.draw(batch, "You must back this place to bright time", 372, 433);
		}else{
			FontRed1.draw(batch, "Однажды здесь все процветало", 372, 455);
			FontRed1.draw(batch, "Ты должен вернуть это место в былые времена", 372, 433);
		}
	}
    if(backGround == level4) {
    	//Отрисовка элементов 4 уровня которые должны быть позади главного персонажа
		batch.draw(lvl4.curentFramesword, 418, 245);
		batch.draw(lvl4.curentFramesword,414,215);
		batch.draw(lvl4.curentFramesword,146,233);
		batch.draw(lvl4.curentFramesword,645,218);
        if(lvl4m.end1 == true){
            batch.draw(door,door3.x,door3.y,door.getWidth(),door.getHeight());
        }
        if(bucket.overlaps(door3)){
			batch.draw(enter, 575, 30);
			if (Gdx.input.justTouched()) { // регистрируем касание
				touchPos1.set(Gdx.input.getX(), Gdx.input.getY(), 0);// считываем положение касания
				camera.unproject(touchPos1);
			if((touchPos1.x >= 575 && touchPos1.x <= 626) && (touchPos1.y >= 30 && touchPos1.y <= 92)){
				Bird.position.x = 65;
				backGround = village;
				sps5 = 0;
                Timer.schedule(new Timer.Task() { // задержка и код который должен выполняться после этого времени
                    @Override
                    public void run() {
                        sps5 = 1;
                    }
                }, 3);
			}
		}
        }
	}
    if(backGround == village){
    	yb = 100;
	}else{
    	yb = 0;
	}
	if(backGround == village){
		batch.draw(lvl5.door,lvl5.doorr.x,lvl5.doorr.y);
	}
	if(backGround == lvl5.inside) {
		batch.draw(door, lvl5.doorinside.x, lvl5.doorinside.y);
	}
	if(backGround == spawn){
		batch.draw(maintable,39,291);
	}
	if(backGround == level2){
		batch.draw(maintable,40,291);
		batch.draw(maintable,709,291);
	}
	if(backGround == backGround3){
		batch.draw(maintable,39,291);
	}
	if (turn == true) {
		batch.draw(bucketImage,x,y);
	}
	if (turn == false) {
		batch.draw(characterleft, x, y);
	}
 //Отрисовка оружия
	if (turn == true) {
		if (Gdx.input.isTouched()) {
			// обработка касаний для движения
			touchPos1.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touchPos1);
			if ((touchPos1.x >= 650 && touchPos1.x <= 715) && (touchPos1.y >= 55 && touchPos1.y <= 134)) {
				if (bowb == true) {
					if (amount > 0 && bulletb == false) {
						bulletb = true;
						bulletrec.y = br.position.y + 35;
						bulletrec.x = br.position.x + 37;
						amount--;
					}
				}
				if (swordb == true) {
					batch.draw(curentFramesword, bucket.x + 33, bucket.y + 18);
						gun.x = bucket.x + 20;
						gun.y = bucket.y + 40;
				}
			}
		}
	}
		if (turn == false) {
		if (Gdx.input.isTouched()) {
			// обработка касаний для оружий
			touchPos1.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touchPos1);
			if ((touchPos1.x >= 650 && touchPos1.x <= 715) && (touchPos1.y >= 55 && touchPos1.y <= 134)) {
				if(bowb==true) {
					if(amount > 0 && bulletb == false) {
						bulletb = true;
						bulletrec.y = Bird.position.y+35;
						bulletrec.x = Bird.position.x+37;
						amount--;
					}
				}
				if (swordb == true) {
					batch.draw(curentFrameswordleft, bucket.x - 36, bucket.y + 18);
					gun.x = bucket.x - 20;
					gun.y = bucket.y + 40;
				}
			}
		}
	}
		if(bowb==true){
			if(turn==true) {
				batch.draw(bow, bucket.x + 53, bucket.y + 7);
			}
			if(turn==false){
				batch.draw(bowleft, bucket.x-6, bucket.y + 7);
			}
        }
		// конец отрисовки оружия
	// manage buttons
	if (r == true) {
		if (pause == 0) {
			if (Gdx.input.isTouched()) {
				// обработка касаний для движения
				touchPos10.set(Gdx.input.getX(), Gdx.input.getY(), 0);
				camera.unproject(touchPos10);
				if (mainmenu.sizeofbuttons == false) {
					if ((touchPos10.x >= 60 && touchPos10.x <= 110) && (touchPos10.y >= 70 && touchPos10.y <= 120)) {
						turn = false;
					}
					if ((touchPos10.x >= 155 && touchPos10.x <= 205) && (touchPos10.y >= 70 && touchPos10.y <= 120)) {
						turn = true;
					}
				}else{
					if ((touchPos10.x >= 50 && touchPos6.x <= 113) && (touchPos6.y >= 60 && touchPos6.y <= 123)) {
						turn = false;
					}
					if ((touchPos6.x >= 165 && touchPos6.x <= 228) && (touchPos6.y >= 60 && touchPos6.y <= 123)) {
						turn = true;
					}
				}
			}
		}
	}
	//конец обработки касаний для движения
	// обработка генерации противников
	for (Rectangle raindrop : raindrops) {
		batch.draw(currentFrame, raindrop.x, raindrop.y);  // Draw current frame at (50, 50)
	}
	if (npc.width == 0) {
		for (Rectangle sp : levels2) {
			batch.draw(curentFramezombie, sp.x, sp.y);
		}
	}
	for (Rectangle sp3 : levels3) {
		batch.draw(curentFramezombielvl3, sp3.x, sp3.y);
	}
	// конец обработки генерации противников
	// отрисовка кол-ва коинов
	batch.draw(backGround2, buckety.x, 160);
	coin = Integer.toString(coins);
	if (r == false) {
		FontRed1.draw(batch, coin, 680, 454);
		batch.draw(coing, 655, 441);
	}

	if(bulletb==true && bowb==true) {
         if(turn == true || bulletrec.x<=800) {
			 bulletrec.x += 300 * Gdx.graphics.getDeltaTime();
			 batch.draw(bullet, bulletrec.x, bulletrec.y, bullet.getWidth(), bullet.getHeight());
		 }
	}
    if(backGround == backGround3 && Bird.getPositiony()>480){
        backGround = level4;
        Bird.position.y = 170;
        Bird.position.x =  25;
        PlayState.stairs = false;
    }
	gsm.update(Gdx.graphics.getDeltaTime());
	batch.end();
	// Импортирование метода render() из нужных классов
	gsm.render(batch);
	if (backGround == level2) {
		ob.render();
	}
	if(backGround == backGround3){
		ob3.render();
	}
	if(backGround == level4){
       lvl4m.render();
	}
    if(backGround == village || backGround == lvl5.inside){
        lvl5.render();
    }
	// the end of draw
	inv.render();
    ar.render();
	mn.render();

	if (sps == 0 || sps2 == 0 || sps3 == 0 || sps5 == 0) {
		nxt.render();
	}

	// конец отрисовки кол-ва коинов
	if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) bucket.x -= 200 * Gdx.graphics.getDeltaTime();
	if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) bucket.x += 200 * Gdx.graphics.getDeltaTime();

	if (x < 0) {
		x = 0;
	}
	if (x > 800 - 64) {
		x = 800 - 64;
	}
 //отрисовка полета стрелы
	if((bulletrec.x>800 || kill==true || bulletrec.x<0) && amount>0 && bowb==true){
		if(kill==true) {
			kill = false;
		}
		bullet.dispose();
		bulletb = false;
		bulletrec.x = -2;
		bullet = bullets[i];
		i++;
	}
	// конец отрисовки полета стрелы
// Первый уровень...............................................................................................................................
	// отрисовка противников для первого уровня
	if((instr==false && pause == 0) &&  r==true && (c == 0 || put == false)) {
		if (backGround == spawn && mm.loading == false) {
            if(mainmenu.easy == true){
                if (TimeUtils.millis() - lastDropTime > (MathUtils.random(1,100000))) {
                    spawnRaindrop();
                }
            } else if(mainmenu.medium == true){
                if (TimeUtils.millis() - lastDropTime > (MathUtils.random(1,33333))) {
                    spawnRaindrop();
                }
            }
            else if(mainmenu.hard == true){
                if (TimeUtils.millis() - lastDropTime > (MathUtils.random(1, 10000))) {
                    spawnRaindrop();
                }
            }
		}
		Iterator<Rectangle> iter = raindrops.iterator();
		while (iter.hasNext()) {
			Rectangle raindrope = iter.next();
			if (pause == 0) {
				pausep = true;
			}
			if (r == true || c == 0) {
				if (pausep == true || c == 0) {
					raindrope.x -= (MathUtils.random(25, 200)) * Gdx.graphics.getDeltaTime();
				}
			}
			if (pause == 1) {
				pausep = false;
			}
			if (r == false) {
				if (pausep == false) {
					raindrope.x -= (MathUtils.random(0, 0)) * Gdx.graphics.getDeltaTime();
				}
			}
			if(c == 1){
				raindrope.x -= (MathUtils.random(0, 0)) * Gdx.graphics.getDeltaTime();
			}
			if (raindrope.overlaps(bucket)) {
				if (shieldh == 0) {
					if(mainmenu.options == true) {
						touch.play();
					}
					if(ar.armoronyou == 1 ||ar.armoronyou == 2 || ar.armoronyou == 3 ||ar.armoronyou == 4 || ar.armoronyou == 5) {
						ar.armoron();
					}else {
						health--;
						a--;
						setScreen(new hit(this));
						super.render();
					}


				} else {
					shieldh--;
				}
			}
			if (raindrope.overlaps(gun)) {
				int a = 1;
				int b = 1;
				if(mainmenu.easy == true){
					b = 2;
				}
				if(mainmenu.medium == true){
					b = 4;
				}
				if(mainmenu.hard == true){
					b = 6;
				}
				if(mainmenu.options == true) {
					deaths.play();
				}
				potionrandom = MathUtils.random(1, 5);
				if (potionrandom == 5) {
					if (potionh < 5 || v < 5) {
						if (v >= 4) {
							potionh++;
						}
						if (v < 5) {
							v++;
						}
					}
				}
				int coinget = MathUtils.random(a, b);
				if(coinget == 1) {
					coins += 1;
				}
			}
			if (raindrope.overlaps(bulletrec)) {
				if(mainmenu.options == true) {
					deaths.play();
				}
				kill = true;
				coins = coins + 1;
			}

			if (backGround != spawn || death == 0 || sps2 == 0 || raindrope.overlaps(gun) || raindrope.overlaps(bucket) || raindrope.x <= 0 || begin == true || raindrope.overlaps(bulletrec) || health <= 0 || returnp == true) {
				iter.remove();
			}
		}
	}

//....................................................................................................................................................
// Второй уровень.....................................................................................................................................
	// отрисовка противников для второго уровня
	if((instr==false && pause == 0) && r==true) {
		if (backGround == level2) {
            if(mainmenu.easy == true) {
                if (TimeUtils.millis() - lastDropTime2 > (MathUtils.random(1,100000))) {
                    spawn2();
                }
            }
            else if(mainmenu.medium == true){
                if (TimeUtils.millis() - lastDropTime2 > (MathUtils.random(1,33333))) {
                    spawn2();
                }
            }
            else if(mainmenu.hard == true){
                if (TimeUtils.millis() - lastDropTime2 > (MathUtils.random(1,10000))) {
                    spawn2();
                }
            }
		}
		Iterator<Rectangle> iter2 = levels2.iterator();
		while (iter2.hasNext()) {
			 Rectangle  raindrope = iter2.next();
			if (pause == 0) {
				pausep = true;
			}
			if (r == true) {
				if (pausep == true) {
					raindrope.x -= (MathUtils.random(25, 200)) * Gdx.graphics.getDeltaTime();
				}
			}
			if (pause == 1) {
				pausep = false;
			}
			if (r == false) {
				if (pausep == false) {
					raindrope.x -= (MathUtils.random(0, 0)) * Gdx.graphics.getDeltaTime();
				}
			}
			if (raindrope.overlaps(bucket)) {

				if (shieldh == 0) {
					if(mainmenu.options == true) {
						touch.play();
					}
					if(ar.armoronyou == 1 ||ar.armoronyou == 2 || ar.armoronyou == 3 ||ar.armoronyou == 4 || ar.armoronyou == 5) {
						ar.armoron();
					}else {
						health--;
						a--;
						setScreen(new hit(this));
						super.render();
					}

				} else {
					shieldh--;
				}
			}
			if (raindrope.overlaps(gun)) {
				int a = 1;
				int b = 1;
				if(mainmenu.easy == true){
					b = 2;
				}
				if(mainmenu.medium == true){
					b = 4;
				}
				if(mainmenu.hard == true){
					b = 6;
				}
				randomarmor = MathUtils.random(1, 100);
				if(mainmenu.options == true) {
					deaths.play();
				}
				int potion2 = MathUtils.random(1, 5);
				int key = MathUtils.random(1, 10);
				if (potion2 == 4) {
					if (potions < 5) {
						potions++;
					}
				}
				if(key == 2 && inventory.k2<5){
					inventory.k2++;
				}
				int coinget = MathUtils.random(a, b);
				if(coinget == 1) {
					coins += 1;
				}
			}
			if (raindrope.overlaps(bulletrec)) {
				if(mainmenu.options == true) {
					deaths.play();
				}
				kill = true;
				coins = coins + 1;
			}

			if (backGround != level2 || npc.width != 0 || sps == 0 || raindrope.overlaps(gun) || raindrope.overlaps(bucket) || raindrope.x <= 0 || begin == true || raindrope.overlaps(bulletrec)) {
				iter2.remove();
			}
		}
	}

//....................................................................................................................................................
// третий уровень
	// отрисовка противников на третьем уровне
	if((instr==false && pause == 0) && r==true) {
		if (backGround == backGround3) {
			if(mainmenu.easy == true) {
				if (TimeUtils.millis() - lastDropTime3 > (MathUtils.random(1, 100000))) {
					spawn3();
				}
			}
			if (mainmenu.medium == true) {
				if(TimeUtils.millis() - lastDropTime3 > (MathUtils.random(1, 33333))){
					spawn3();
				}
			}
			if(mainmenu.hard == true){
				if(TimeUtils.millis() - lastDropTime3 > (MathUtils.random(1, 10000))){
					spawn3();
				}
			}
		}
		Iterator<Rectangle> iter3 = levels3.iterator();
		while (iter3.hasNext()) {
			Rectangle raindrope = iter3.next();
			if (pause == 0) {
				pausep = true;
			}
			if (r == true) {
				if (pausep == true) {
					raindrope.x -= (MathUtils.random(25, 200)) * Gdx.graphics.getDeltaTime();
				}
			}
			if (pause == 1) {
				pausep = false;
			}
			if (r == false) {
				if (pausep == false) {
					raindrope.x -= (MathUtils.random(0, 0)) * Gdx.graphics.getDeltaTime();
				}
			}
			if (raindrope.overlaps(bucket)) {
				if (shieldh == 0) {
					if(mainmenu.options == true) {
						touch.play();
					}
					if(ar.armoronyou == 1 ||ar.armoronyou == 2 || ar.armoronyou == 3 ||ar.armoronyou == 4 || ar.armoronyou == 5) {
						ar.armoron();
					}else {
						health--;
						a--;
						setScreen(new hit(this));
						super.render();
					}

				} else {
					shieldh--;
				}
			}
			if (raindrope.overlaps(gun)) {
				int a = 1;
				int b = 1;
				if(mainmenu.easy == true){
					b = 2;
				}
				if(mainmenu.medium == true){
					b = 4;
				}
				if(mainmenu.hard == true){
					b = 6;
				}
				randomarmor2 = MathUtils.random(1, 100);
				if(mainmenu.options == true) {
					deaths.play();
				}
				int potion2 = MathUtils.random(1, 5);
				int key = MathUtils.random(1, 10);
				if (potion2 == 5) {
					if (shield < 5) {
						shield++;
					}
				}
				if(key == 3 && inventory.k1<5){
					inventory.k1++;
				}
				int coinget = MathUtils.random(a, b);
				if(coinget == 1) {
					coins += 1;
				}
			}
			if (bulletrec.overlaps(raindrope)) {
				if(mainmenu.options == true) {
					deaths.play();
				}
				kill = true;
				coins = coins + 1;
			}

			if (sps2 == 0 || sps3 == 0 || raindrope.overlaps(bucket) || (backGround != backGround3) || raindrope.x <= 0 || raindrope.overlaps(gun) || begin == true || raindrope.overlaps(bulletrec)) {
				iter3.remove();
			}
		}
	}

//........................................................................................................................................................................
	// отрисовка экрана "Game Over"
	if (health <= 0 || returnp == true) {
		death = 0;
		setScreen(new Level0(this));
		super.render();
		bucket.x = 5;
		bucket.y = 170;
		if(lvl4m.death.x>0) {
            lvl4m.death.x = 500;
        }
		if (Gdx.input.isTouched()) {
			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touchPos);
			if ((touchPos.x >= 400 && touchPos.x <= 450) && (touchPos.y >= 180 && touchPos.y <= 230)) {
				if(mainmenu.options == true) {
					buttons.play();
				}
				health = 7;
				a = 7;
				coins = 0;
				backGround = spawn;
				death = 1;
				returnp = false;
				pause = 0;
			}
		}
	}

	gun.x = 0;
	gun.y = 0;
	if (a == 8 || health == 8) {
		a--;
		health--;
	}
 }
 if(begin==true){
	 mm.render();
	 if(mainmenu.options2 == true) {
		 batch.begin();
		 if(mainmenu.language == false) {
			 batch.draw(option, 0, 0);
		 }else{
			 batch.draw(optionrus, 0, 0);
		 }
		 batch.draw(Menu.invexit,8,422);
		 if(mainmenu.language == false) {
		 	batch.draw(mainmenu.easyo,435,200);
		 	batch.draw(mainmenu.mediumo,552,200);
		 	batch.draw(mainmenu.hardo,669,200);
			 if (mainmenu.options == true) {
				 batch.draw(mainmenu.on, 246, 363);
			 }
			 if (mainmenu.options == false) {
				 batch.draw(mainmenu.off, 246, 363);
			 }
			 if (mainmenu.language == true) {
				 batch.draw(mainmenu.rus, 320, 263);
			 }
			 if (mainmenu.language == false) {
				 batch.draw(mainmenu.eng, 320, 263);
			 }
			 if (mainmenu.sizeofbuttons == true) {
				 batch.draw(mainmenu.x125, 700, 363);
			 }
			 if (mainmenu.sizeofbuttons == false) {
				 batch.draw(mainmenu.x100, 700, 363);
			 }
			 if(mainmenu.easy == true){
				 batch.draw(mainmenu.easyo,435,200);
			 }
			 if(mainmenu.medium == true){
				 batch.draw(mainmenu.mediumo,552,200);
			 }
			 if(mainmenu.hard == true){
				 batch.draw(mainmenu.hardo,669,200);
			 }
			 if(mainmenu.easy == true){
				 batch.draw(mainmenu.easyo,435,200);
			 }
			 if(mainmenu.medium == true){
				 batch.draw(mainmenu.mediumo,552,200);
			 }
			 if(mainmenu.hard == true){
				 batch.draw(mainmenu.hardo,669,200);
			 }
		 }else{
			 batch.draw(mainmenu.easyrus,345,200);
			 batch.draw(mainmenu.mediumrus,462,200);
			 batch.draw(mainmenu.hardrus,579,200);
			 if (mainmenu.options == true) {
				 batch.draw(mainmenu.on, 235, 366);
			 }
			 if (mainmenu.options == false) {
				 batch.draw(mainmenu.off, 235, 366);
			 }
			 if (mainmenu.language == true) {
				 batch.draw(mainmenu.rus, 240, 270);
			 }
			 if (mainmenu.language == false) {
				 batch.draw(mainmenu.eng, 240, 270);
			 }
			 if (mainmenu.sizeofbuttons == true) {
				 batch.draw(mainmenu.x125, 708, 366);
			 }
			 if (mainmenu.sizeofbuttons == false) {
				 batch.draw(mainmenu.x100, 708, 366);
			 }
			 if(mainmenu.easy == true){
				 batch.draw(mainmenu.easyrus,345,200);
			 }
			 if(mainmenu.medium == true){
				 batch.draw(mainmenu.mediumrus,462,200);
			 }
			 if(mainmenu.hard == true){
				 batch.draw(mainmenu.hardrus,579,200);
			 }
			 if(mainmenu.easy == true){
				 batch.draw(mainmenu.easyrus,345,200);
			 }
			 if(mainmenu.medium == true){
				 batch.draw(mainmenu.mediumrus,462,200);
			 }
			 if(mainmenu.hard == true){
				 batch.draw(mainmenu.hardrus,579,200);
			 }
		 }
		 batch.end();
	 }
 }
// выход из игры
 if(exit==true){
	 System.exit(0);
 }
	}

	@Override
	// destroy all textures on the screen
	public void dispose() {
		batch.dispose();
		dropImage.dispose();
		bucketImage.dispose();
		rightImage.dispose();
		sword.dispose();
		backGround.dispose();
		left.dispose();
		fire.dispose();
		heart.dispose();
		knife.dispose();
		bullet.dispose();
		attack.dispose();
		characterleft.dispose();
		door.dispose();
		enter.dispose();
		level2.dispose();
		spawn.dispose();
		coing.dispose();
		npcleft.dispose();
		npcright.dispose();
		text.dispose();
		backGround1.dispose();
		backGround2.dispose();
		cemetery.dispose();
		cemetery2.dispose();
		cemetery3.dispose();
		cemetery4.dispose();
		cemetery5.dispose();
		walkSheet.dispose();
		zombie.dispose();
		up.dispose();
		knifeleft.dispose();
		stairs.dispose();
		shieldhealth.dispose();
		zombielvl3.dispose();
		down.dispose();
		bow.dispose();
		bowleft.dispose();
	}
}