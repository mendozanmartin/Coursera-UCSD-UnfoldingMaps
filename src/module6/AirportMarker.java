package module6;

import java.util.List;

import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.marker.SimpleLinesMarker;
import processing.core.PConstants;
import processing.core.PGraphics;

/** 
 * A class to represent AirportMarkers on a world map.
 *   
 * @author Adam Setters and the UC San Diego Intermediate Software Development
 * MOOC team
 *
 */
public class AirportMarker extends CommonMarker {
	public static List<SimpleLinesMarker> routes;
	public static int CIRCLE_SIZE = 5;  // The size of the triangle marker

	
	public AirportMarker(Feature city) {
		super(((PointFeature)city).getLocation(), city.getProperties());
	
	}
	
	@Override
	public void drawMarker(PGraphics pg, float x, float y) {
		pg.fill(255,0,0);
		pg.ellipse(x, y, 5, 5);
		
		
	}

	@Override
	public void showTitle(PGraphics pg, float x, float y) {
		String city = "City: " + getCity();
		String country =  "Country: " + getCountry();
		
		pg.pushStyle();
		
		pg.fill(255, 255, 255);
		pg.rect(x, y-CIRCLE_SIZE-39, Math.max(pg.textWidth(city), pg.textWidth(country)) + 6, 39);

		pg.textSize(12);
		pg.rectMode(PConstants.CORNER);
		pg.fill(0, 0, 0);
		pg.textAlign(PConstants.LEFT, PConstants.TOP);
		pg.text(city, x+3, y-CIRCLE_SIZE-33);
		pg.text(country, x+3, y-CIRCLE_SIZE-20);

		
		pg.popStyle();
	}
	
	private String getCity()
	{
		return getStringProperty("name");
	}
	
	private String getCountry()
	{
		return getStringProperty("country");
	}
	

	
}
