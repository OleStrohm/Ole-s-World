package no.Strohm.game2D.state;

import no.Strohm.game2D.Game;
import no.Strohm.game2D.InputHandler;
import no.Strohm.game2D.Multiplayer.Client;
import no.Strohm.game2D.Multiplayer.Server;
import no.Strohm.game2D.graphics.Screen;

import java.net.Inet4Address;

/**
 * Created by Ole on 15/12/13.
 */
public class StateMenuMain extends StateMenu {

	private static String[] options = new String[]{
			"Play Game",
			"Multiplayer (WIP)",
			"Instructions",
			"About",
			"Exit"
	};

	public StateMenuMain(InputHandler input) {
		super(options.length, startId, input);
	}

	protected void press() {
		switch (selected) {
			case 0:
                setState(gameId);
				break;
			case 1:
				//options[1] = "Multiplayer doesn't work";
				setState(multiplayerId);
				break;
			case 2:
				setState(instructionsId);
				break;
			case 3:
				setState(aboutId);
				break;
			case 4:
				setState(exitId);
				break;
		}
	}

	public void render(Screen screen) {
		screen.renderArea(0x00A9FF, 0, screen.w, 0, screen.h, false);
		screen.renderText(Game.TITLE, (screen.w - Game.TITLE.length() * 8) / 2, 50, 0xFF0000, false);
		for (int i = 0; i < options.length; i++) {
			screen.renderText(options[i], (screen.w - options[i].length() * 8) / 2, screen.h / 2 - 15 + (i * 10), getColor(i), false);
		}
	}
}
