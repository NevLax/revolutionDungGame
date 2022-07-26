package ru.nlx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.ScreenUtils;
import ru.nlx.game.Dino.Dino;

public class MyMainClass extends ApplicationAdapter {
	SpriteBatch batch;
	Dino dinozavr;
	Texture dino;
	World world;
	Box2DDebugRenderer debugRenderer;
	OrthographicCamera camera;
	private final MoveInput moveInput;
	boolean debugRenderBox2D = false;

	public MyMainClass(MoveInput moveInput){
		this.moveInput = moveInput;
	}
	@Override
	public void create () {

		dino = new Texture(Gdx.files.internal("dinoCharacters/sheets/DinoSprites-doux.png"));
		world = new World(new Vector2(0, 0), true);
		dinozavr = new Dino(dino, world, moveInput);
		debugRenderer = new Box2DDebugRenderer();
		camera = new OrthographicCamera(600,400);
		batch = new SpriteBatch();
		batch.setProjectionMatrix(camera.combined);
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		world.step(1/40f, 4, 4);
		batch.begin();
		dinozavr.draw(batch);
		batch.end();
		if (debugRenderBox2D) debugRenderer.render(world, camera.combined);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		dinozavr.dispose();
		dino.dispose();
		world.dispose();
	}
}
