package flappydot;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

	public class FlappyDotGame extends BasicGame {
		 
		  private Dot dot;

		public FlappyDotGame(String title) {
		    super(title);
		  }

		@Override
		public void render(GameContainer container, Graphics g)
				throws SlickException {
					dot.render();
			
		}

		@Override
		public void init(GameContainer container) throws SlickException {
		    Color background = new Color(128, 128, 128);
		    container.getGraphics().setBackground(background); 
		    dot = new Dot(320, 240);
			
		}

		@Override
		public void update(GameContainer container, int delta) throws SlickException {
			// TODO Auto-generated method stub
			
		}
		 
		 public static void main(String[] args) {
			    try {
			    	FlappyDotGame game = new FlappyDotGame("Super Ship Game");
			      AppGameContainer appgc = new AppGameContainer(game);
			      appgc.setDisplayMode(640, 480, false);
			      appgc.start();
			    } catch (SlickException e) {
			      e.printStackTrace();
			    }
			  }
		}
