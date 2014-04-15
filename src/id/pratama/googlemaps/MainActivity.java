package id.pratama.googlemaps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;

public class MainActivity extends FragmentActivity implements
		OnMapClickListener {

	private GoogleMap map;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setupMapIfNeeded();
	}

	/**
	 * initialize map
	 */
	private void setupMapIfNeeded() {
		if (map == null) {
			FragmentManager fragmentManager = getSupportFragmentManager();
			SupportMapFragment supportMapFragment = (SupportMapFragment) fragmentManager
					.findFragmentById(R.id.maps);
			map = supportMapFragment.getMap();

			if (map != null) {
				setupMap();
			}
		}
	}

	/**
	 * Setup Map
	 */
	private void setupMap() {
		map.setMyLocationEnabled(true);
		map.setOnMapClickListener(this);
	}

	/**
	 * Add marker when map clicked
	 */
	@Override
	public void onMapClick(LatLng point) {
		map.clear();
		map.addMarker(new MarkerOptions().position(point));
	}

}
