package br.com.alura.leilao.api.retrofit;

import br.com.alura.leilao.api.retrofit.service.TesteService;

public class TesteRetrofitInicializador extends RetrofitInicializador {
    public TesteService getTestService() {
        return retrofit.create(TesteService.class);
    }
}
