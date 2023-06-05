package com.example.futfem.HomeActivityDrawer;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.example.futfem.ClasificacionPantalla.ClasificacionFragment;
import com.example.futfem.EquiposPantalla.EquiposFragment;
import com.example.futfem.InicioPantalla.InicioActivity;
import com.example.futfem.R;
import com.google.android.material.navigation.NavigationView;


public class MainActivityDrawer extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private NavigationView navigationView;
    public DrawerLayout drawerLayout;

    public ActionBarDrawerToggle actionBarDrawerToggle;
    private Button buttonLogout;
    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_drawer);

        Toolbar toolbar = findViewById(R.id.toolbar);

        setupDrawer(toolbar);
        setupNavigationView();

        buttonLogout = navigationView.getHeaderView(0).findViewById(R.id.cerrar);
        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(context, InicioActivity.class);
                context.startActivity(myIntent);
                Toast.makeText(MainActivityDrawer.this, "Has clicado logout", Toast.LENGTH_SHORT).show();
            }
        });

        Fragment home = new HomeFragment();
        showFragment(home);

    }

    private void setupDrawer(Toolbar toolbar) {
        drawerLayout = findViewById(R.id.drawerLayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.nav_open,
                R.string.nav_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

    }


    //Configuración de la vista de navegación
    private void setupNavigationView() {
        navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
        MenuItem menuItem = navigationView.getMenu().getItem(0);
        onNavigationItemSelected(menuItem);
        menuItem.setChecked(true);
    }


    //Controlar el comportamiento del botón de retroceso
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    //Cuando seleccionamos un elemento de Drawer se ejecuta para mostrar el fragment correspondiente
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        String title = "";
        Fragment fragment = null;
        switch (menuItem.getItemId()) {
            case R.id.home:
                title = "Home";
                fragment= new HomeFragment();
                break;
            case R.id.equipos:
                title = "Equipos";
                fragment = new EquiposFragment();
                break;
            case R.id.clasificacion:
                title = "Clasificación";
                fragment = new ClasificacionFragment();
                break;

        }
        setTitle(title);
        showFragment(fragment);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void showFragment(Fragment fragment) {
        if (fragment == null){
            return;
        }
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.home_content, fragment)
                .commit();

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        return true;
    }
}
