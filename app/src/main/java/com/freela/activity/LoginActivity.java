package com.freela.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.freela.R;
import com.freela.SessionManager.SessionManager;
import com.freela.handler.FreelaDBHandler;
import com.freela.model.Credenciais;
import com.freela.model.Usuario;

//import com.freela.manager.SessionManager;


/**
 * Created by Mateus - PC on 2016-10-25.
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etEmail;
    private EditText etSenha;
    private Button btEntrar;
    private Button btVoltar;
    private Usuario usuario;
    private SessionManager sessionManager;
    private FreelaDBHandler db;

    private LoginTask loginTask;
    //private SessionManager sessao;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

      //  sessao =  new SessionManager(getApplicationContext());

        etEmail = (EditText) findViewById(R.id.login_et_email);
        etSenha = (EditText) findViewById(R.id.login_et_senha);

        btEntrar = (Button) findViewById(R.id.login_bt_entrar);
        btEntrar.setOnClickListener(this);

        btVoltar = (Button) findViewById(R.id.login_bt_voltar);
        btVoltar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.login_bt_entrar:
                autenticar();
                break;

            case R.id.login_bt_voltar:
                voltar();
                break;

        }
    }

    private void autenticar() {
        try {
            String login = etEmail.getText().toString();
            String pass = etSenha.getText().toString();

            if (login.trim().length() > 0 && pass.trim().length() > 0) {

//                Credenciais credenciais = new Credenciais(login, pass);

//                if (loginTask == null) {
//
//                  //  if (LoginHttp.temConexao(this)) {
//
//                        loginTask = new LoginTask();
//                        loginTask.execute(credenciais);
//
//                  //  } else {
//                  //      throw new Exception(getString(R.string.erro_conexao));
//                  //  }
//
//                } else if (loginTask.getStatus() == AsyncTask.Status.RUNNING) {
//                    //TODO: mostrar progress
//                }

                db = new FreelaDBHandler(this, null, null, 1);
                usuario = db.findUsuario(login, pass);

                if(usuario != null) {
                    sessionManager =  new SessionManager(this);
                    sessionManager.setUsuario(usuario);

                    redirecionarDashboard();
                } else {
                    exibirMensagem(getString(R.string.erro_autenticacao));
                }


            } else {
                throw new Exception(getString(R.string.erro_campos_obringatorios));
            }
        } catch (Exception e) {
            exibirMensagem(e.getMessage());
        }
    }

    private void voltar() {

        startActivity(new Intent(this, MainActivity.class));

    }


    public void redirecionarDashboard() {

        //TODO: passar parametros usuário

        //startActivity(new Intent(this, DashboardActivity.class));

        Intent intent = new Intent(this, BottomNavActivity.class);
        startActivity(intent);

    }


    public void exibirMensagem(String texto) {

        Toast toast = Toast.makeText(this, texto, Toast.LENGTH_SHORT);

        toast.show();

    }

    class LoginTask extends AsyncTask<Credenciais, Void, Usuario> {
        @Override
        protected void onPreExecute() {

            //TODO: exibir o progress

        }

        @Override
        protected Usuario doInBackground(Credenciais... credenciais) {

            //return LoginHttp.carregarUsuarioJson(credenciais[0]);

            return new Usuario();
        }

        @Override
        protected void onPostExecute(Usuario usr) {

            //TODO: esconder progress

            if (usr == null) {

                exibirMensagem(getString(R.string.erro_autenticacao));

            } else {

            //    sessao.criarLoginSession(usuario)

                usuario = usr;

                redirecionarDashboard();

            }

        }
    }
}
