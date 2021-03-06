package robot.sim.hud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.utils.Align;
import robot.sim.field.Field;

public class HUD {

    BitmapFont font;
    float verticalMargin,leftx,rightx,centerx,row1Y,row2Y,sectionWidth;

    public HUD(){
        //creates a bitmapFont from our file
        FreeTypeFontGenerator fontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("NugoSansLight-9YzoK.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter fontParameter = new FreeTypeFontGenerator.FreeTypeFontParameter();

        //sets font attributes
        fontParameter.size = 70;
        fontParameter.borderWidth = 3.6f;
        fontParameter.color = new Color(1,1,1,1);
        fontParameter.borderColor = new Color(1,1,1,1);

        font = fontGenerator.generateFont(fontParameter);

        //sets scale of font
        font.getData().setScale(.3f);

        //calculates hud margins,etc
        verticalMargin = font.getCapHeight()/2;
        leftx = verticalMargin;
        rightx = Field.WIDTH * 2 / 3 - leftx;
        centerx = Field.WIDTH/3;
        row1Y = Field.HEIGHT - verticalMargin;
        row2Y = row1Y - verticalMargin - font.getCapHeight();
        sectionWidth = Field.WIDTH/3;
    }

    public HUD(int size){
        //creates a bitmapFont from our file
        FreeTypeFontGenerator fontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("NugoSansLight-9YzoK.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter fontParameter = new FreeTypeFontGenerator.FreeTypeFontParameter();

        //sets font attributes
        fontParameter.size = size;
        fontParameter.borderWidth = 3.6f;
        fontParameter.color = new Color(1,1,1,1);
        fontParameter.borderColor = new Color(1,1,1,1);

        font = fontGenerator.generateFont(fontParameter);

        //sets scale of font
        font.getData().setScale(.3f);

        //calculates hud margins,etc
        verticalMargin = font.getCapHeight()/2;
        leftx = verticalMargin;
        rightx = Field.WIDTH * 2 / 3 - leftx;
        centerx = Field.WIDTH/3;
        row1Y = Field.HEIGHT - verticalMargin;
        row2Y = row1Y - verticalMargin - font.getCapHeight();
        sectionWidth = Field.WIDTH/3;
    }

    public void draw(Batch batch, String text, float x, float y, float sectionW, boolean wrap){
        font.draw(batch,text,x,y,sectionW, Align.left,wrap);
    }
}
