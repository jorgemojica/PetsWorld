package co.edu.ufps.petsworld.Administrator;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import co.edu.ufps.petsworld.R;

public class DisplayedMenuAdminActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, DrawerLayout.DrawerListener{

    private DrawerLayout drawerLayout;
    ImageButton btnCitas, btnVeterinary, btnCustomers, btnMascotas, btnNovedades, btnChat, btnReminders, btnInfo, btnPerfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.displayedmenuadministrator);

        btnCitas = findViewById(R.id.btnCitas);
        btnCitas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goCitas();
            }
        });

        btnVeterinary = findViewById(R.id.btnVeterinary);
        btnVeterinary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goVeterinary();
            }
        });

        btnCustomers = findViewById(R.id.btnCustomers);
        btnCustomers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goCustomers();
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

        btnReminders = findViewById(R.id.btnReminders);
        btnReminders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goReminders();
            }
        });

        btnInfo = findViewById(R.id.btnInfo);
        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goInfo();
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
                Toast.makeText(DisplayedMenuAdminActivity.this, getString(R.string.title_click),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void goCitas(){
        Intent intent = new Intent(this, CitasActivity.class);
        startActivity(intent);
    }

    private void goVeterinary(){
        Intent intent = new Intent(this, VeterinariosActivity.class);
        startActivity(intent);
    }

    private void goCustomers(){
        Intent intent = new Intent(this, ClientesActivity.class);
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

    private void goReminders(){
        Intent intent = new Intent(this, RecordatoriosActivity.class);
        startActivity(intent);
    }

    private void goInfo(){
        Intent intent = new Intent(this, InfoActivity.class);
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
        int title;
        switch (menuItem.getItemId()) {
            case R.id.citas:
                title = R.string.citasString;
                break;
            case R.id.veterinarios:
                title = R.string.veterinariosString;
                break;
            case R.id.clientes:
                title = R.string.clientesString;
                break;
            case R.id.mascotas:
                title = R.string.mascotasString;
                break;
            case R.id.novedades:
                title = R.string.novedadesString;
                break;
            case R.id.chat:
                title = R.string.chatString;
                break;
            case R.id.recordatorios:
                title = R.string.recordatoriosString;
                break;
            case R.id.info:
                title = R.string.infoString;
                break;
            case R.id.miperfil:
                title = R.string.miperfilString;
                break;
            default:
                throw new IllegalArgumentException("menu option not implemented!!");
        }
        Fragment fragment = DisplayedMenuAdminFragment.newInstance(getString(title));
        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.anim.bottom_nav_enter, R.anim.bottom_nav_exit)
                .replace(R.id.home_content, fragment)
                .commit();

        setTitle(getString(title));

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
