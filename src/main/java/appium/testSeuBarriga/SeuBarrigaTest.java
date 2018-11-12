package appium.testSeuBarriga;

import appium.core.BaseTest;
import appium.page.MenuPage;
import appium.pageSeuBarriga.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SeuBarrigaTest extends BaseTest {

    private MenuPage menu = new MenuPage();
    private SBLoginPage login = new SBLoginPage();
    private SBMenuPage menuSb = new SBMenuPage();
    private SBContasPage contas = new SBContasPage();
    private SBMovimentacaoPage mov = new SBMovimentacaoPage();
    private SBHomePage home = new SBHomePage();
    private SBResumoPage resumo = new SBResumoPage();

    @Before
    public void setUp() {
        menu.accessSeuBarrigaNativoo();

        //realizar login
        login.enterName("felipe@wisniewski");
        login.enterPassword("1234");
        login.clickEntrarButton();
    }

    @Test
    public void deveInserirContaComSucesso() {
        menuSb.contasPage();

        contas.setNewConta("Conta de teste");
        contas.salvarConta();

        Assert.assertTrue(contas.isMessageExist("Conta adicionada com sucesso"));
    }

    @Test
    public void deveExcluirContaComSucesso() {
        menuSb.contasPage();

        contas.selectConta("Conta mesmo nome");
        contas.excluirConta();

        Assert.assertTrue(contas.isMessageExist("Conta excluída com sucesso"));
    }

    @Test
    public void deveValidarInclusaoDaMovimentacao() {
        menuSb.movimentacoesPage();

        //validar descricao
        mov.salvar();
        Assert.assertTrue(mov.isMessageExist("Descrição é um campo obrigatório"));

        //validar interessado
        mov.setDescricao("Setando descrição");
        mov.salvar();
        Assert.assertTrue(mov.isMessageExist("Interessado é um campo obrigatório"));

        //validar valor
        mov.setInteressado("Felipe");
        mov.salvar();
        Assert.assertTrue(mov.isMessageExist("Valor é um campo obrigatório"));

        //validar conta
        mov.setValor("111");
        mov.salvar();
        Assert.assertTrue(mov.isMessageExist("Conta é um campo obrigatório"));

        //inserir com sucesso
        mov.setConta("Conta para alterar");
        mov.salvar();
        Assert.assertTrue(mov.isMessageExist("Movimentação cadastrada com sucesso"));
    }

    @Test
    public void deveExcluirMovimentacaoChecarSaldo() {
        menuSb.homePage();

        //verificar salda conta para saldo 534
        Assert.assertEquals("534.00", home.obterSaldoConta("Conta para saldo"));

        //ir para resumo
        menuSb.resumoPage();

        //excluir movimentacao 3
        resumo.excluirMovimentacao("Movimentacao 3, calculo saldo");

        //validar mensagem "movimentacao removida com sucesso"
        Assert.assertTrue(resumo.isMessageExist("Movimentação removida com sucesso!"));

        //voltar para home
        menuSb.homePage();

        //atualiza o saldos
        waitToLoad(1500);
        home.atualizarHome();

        //verifica o saldo -1000
        Assert.assertEquals("-1000.00", home.obterSaldoConta("Conta para saldo"));
    }
}
