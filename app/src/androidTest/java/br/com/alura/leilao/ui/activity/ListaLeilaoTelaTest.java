package br.com.alura.leilao.ui.activity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;

import br.com.alura.leilao.api.retrofit.client.LeilaoWebClient;
import br.com.alura.leilao.api.retrofit.client.TesteWebClient;
import br.com.alura.leilao.model.Leilao;

public class ListaLeilaoTelaTest {

    @Rule
    public ActivityTestRule<ListaLeilaoActivity> activity =
            new ActivityTestRule<>(ListaLeilaoActivity.class, true, true);

    @Test
    public void deve_AparecerUmLeilao_QuandoCarregarUmLeilaoDApi() throws IOException {
        TesteWebClient webClient = new TesteWebClient();

        boolean bancoDeDadosNaoFoiLimpo = !webClient.limpaBancoDeDados();
        if (bancoDeDadosNaoFoiLimpo){
            Assert.fail("Banco de dados nao foi limpo");
        }

        Leilao consoleSalvo = webClient.salva(new Leilao("Console"));

        if(consoleSalvo == null) {
            Assert.fail("Leilão não foi salvo");
        }

        activity.launchActivity(new Intent());

        onView(withText("Console")).check(matches(isDisplayed()));
    }

}