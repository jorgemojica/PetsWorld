package co.edu.ufps.petsworld.Administrator;
import android.os.Bundle;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.NonNull;

import co.edu.ufps.petsworld.R;

public class DisplayedMenuActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, DrawerLayout.DrawerListener{

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.displayedmenu);

        Toolbar toolbar = findViewById(R.id.toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.common_open_on_phone,
                R.string.common_signin_button_text_long);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
        //cambio en la posición del drawer
    }

    @Override
    public void onDrawerOpened(@NonNull View drawerView) {
        //el drawer se ha abierto completamente
        Toast.makeText(this, getString(R.string.common_open_on_phone),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDrawerClosed(@NonNull View drawerView) {
        //el drawer se ha cerrado completamente
    }

    @Override
    public void onDrawerStateChanged(int newState) {
        //cambio de estado, puede ser STATE_IDLE, STATE_DRAGGING or STATE_SETTLING
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}
