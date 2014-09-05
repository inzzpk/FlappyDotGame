package flappydot;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

	public class FlappyDotGame extends BasicGame {
		  public static final int GAME_WIDTH = 640;
		  public static final int GAME_HEIGHT = 480;
		  public static final float DOT_JUMP_VY = 10;
		  public static final float G = (float) -0.5;
		  private boolean isStarted = false;
		  private Dot dot;
		  private PillarPair pillar;
		  public static final float PILLAR_VX = -4;
		  private PillarPair[] pillars;
		  public static final int PILLAR_COUNT = 3;

		public FlappyDotGame(String title) {
		    super(title);
		  }

		@Override
		public void render(GameContainer container, Graphics g) throws SlickException {
			for (PillarPair pillar : pillars) {
			      pillar.render();
			    }
			    dot.render();
			
		}

		@Override
		public void init(GameContainer container) throws SlickException {
		    Color background = new Color(128, 128, 128);
		    container.getGraphics().setBackground(background); 
		    dot = new Dot(GAME_WIDTH/2, GAME_HEIGHT/2, -(DOT_JUMP_VY));
		    pillar = new PillarPair(GAME_WIDTH/2, GAME_HEIGHT/2, PILLAR_VX);
		    initPillars();
			
		}

		private void initPillars() throws SlickException {
			pillars = new PillarPair[PILLAR_COUNT];
		    for (int i = 0; i < PILLAR_COUNT; i++) {
		      pillars[i] = new PillarPair(GAME_WIDTH + 100 + 250*i, GAME_HEIGHT/2, PILLAR_VX);
		    }
		}

		@Override
		public void update(GameContainer container, int delta) throws SlickException {
			if(isStarted == true){
				dot.update();
				for (int i = 0; i < PILLAR_COUNT; i++){
						pillars[i].update();
						}
			}
		}
		
		@Override
		  public void keyPressed(int key, char c) {
			if (key == Input.KEY_SPACE) {
				  	isStarted = true;
					dot.jump(DOT_JUMP_VY);
			    }
		  }
		 
		 public static void main(String[] args) {
			    try {
			    	FlappyDotGame game = new FlappyDotGame("Super Ship Game");
			      AppGameContainer container = new AppGameContainer(game);
			      container.setDisplayMode(GAME_WIDTH, GAME_HEIGHT, false);
			      container.setMinimumLogicUpdateInterval(1000 / 60);
			      container.start();
			    } catch (SlickException e) {
			      e.printStackTrace();
			    }
			  }
		}
