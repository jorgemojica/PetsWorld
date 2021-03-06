package co.edu.ufps.petsworld.Customer;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;
import co.edu.ufps.petsworld.Administrator.ChatActivity;
import co.edu.ufps.petsworld.Administrator.CitasActivity;
import co.edu.ufps.petsworld.Administrator.MascotasActivity;
import co.edu.ufps.petsworld.Administrator.NovedadesActivity;
import co.edu.ufps.petsworld.Administrator.PerfilAdministratorActivity;

import co.edu.ufps.petsworld.R;

public class DisplayedMenuCustActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, DrawerLayout.DrawerListener{

    private DrawerLayout drawerLayout;
    ImageButton btnCitas, btnNotificaciones, btnMascotas, btnNovedades, btnChat, btnPerfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.displayedmenucustomer);

        btnCitas = findViewById(R.id.btnCitas);
        btnCitas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goCitas();
            }
        });

        btnNotificaciones = findViewById(R.id.btnNotificaciones);
        btnNotificaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goNotificaciones();
            }
        });

        btnMascotas = findViewById(R.id.btnMascotas);
        btnMascotas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goPets();
            }
        });

        btnNovedades = findViewById(R.id.btnNovedades);
        btnNovedades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goNovedades();
            }
        });

        btnChat = findViewById(R.id.btnChat);
        btnChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goChat();
            }
        });

        btnPerfil = findViewById(R.id.btnPerfil);
        btnPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goPerfil();
            }
        });

        Toolbar toolbar = findViewById(R.id.toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        MenuItem menuItem = navigationView.getMenu().getItem(0);
        onNavigationItemSelected(menuItem);
        menuItem.setChecked(true);

        drawerLayout.addDrawerListener(this);

        View header = navigationView.getHeaderView(0);
        header.findViewById(R.id.header_title).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DisplayedMenuCustActivity.this, getString(R.string.title_click),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void goCitas(){
        Intent intent = new Intent(this, CitasActivity.class);
        startActivity(intent);
    }

    private void goNotificaciones(){
        Intent intent = new Intent(this, AlertasActivity.class);
        startActivity(intent);
    }

    private void goPets(){
        Intent intent = new Intent(this, MascotasActivity.class);
        startActivity(intent);
    }

    private void goNovedades(){
        Intent intent = new Intent(this, NovedadesActivity.class);
        startActivity(intent);
    }

    private void goChat(){
        Intent intent = new Intent(this, ChatActivity.class);
        startActivity(intent);
    }

    private void goPerfil(){
        Intent intent = new Intent(this, PerfilAdministratorActivity.class);
        startActivity(intent);
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
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int option;
        switch (menuItem.getItemId()) {
            case R.id.citas:
                option = R.layout.citas;
                break;
            case R.id.notificaciones:
                option = R.layout.activity_alertas;
                break;
            case R.id.mascotas:
                option = R.layout.mascotas;
                break;
            case R.id.novedades:
                option = R.layout.novedades;
                break;
            case R.id.chat:
                option = R.layout.activity_chat;
                break;
            case R.id.miperfil:
                option = R.layout.perfil;
                break;
            default:
                throw new IllegalArgumentException("menu option not implemented!!");
        }

        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
        
    }

    @Override
    public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
        //cambio en la posición del drawer
    }

    @Override
    public void onDrawerOpened(@NonNull View view) {
        //el drawer se ha abierto completamente
        Toast.makeText(this, getString(R.string.navigation_drawer_open),
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

}
