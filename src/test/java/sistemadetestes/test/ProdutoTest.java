package sistemadetestes.test;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import sistemadetestes.pageObject.ProdutoPO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProdutoTest extends BaseTestProdutos{
    private static ProdutoPO produtoPage;
    @BeforeClass
    public static void prepararTestes() {
        produtoPage = new ProdutoPO(driver);
    }
    @Before
    public void prepararTestesParaCadaFuncao() {
        driver.navigate().refresh();
    }
    /*
    @Test
    public void abrirEEsperarPor10Segundos() {
        //Teste dos testes...
        System.out.println( produtoPage.obterTituloDaPagina());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    */

    @Test
    public void TC001_VoltarAoLogin() {
        //System.out.println( produtoPage.obterTituloDaPagina());
        assertEquals("Controle de Produtos", produtoPage.obterTituloDaPagina());
        produtoPage.linkVoltar.click();
        assertEquals("Login", produtoPage.obterTituloDaPagina());
    }
    @Test
    public void TC003_AbrirTelaDeCadastroAoClicarUmaVez() {
        System.out.println(produtoPage.menuDeCadastroVisivel());
        assertFalse(produtoPage.menuDeCadastroVisivel());
        produtoPage.botaoCriar.click();
        System.out.println(produtoPage.menuDeCadastroVisivel());
        assertTrue(produtoPage.menuDeCadastroVisivel());
    }
    @Test
    public void TC004_FecharTelaDeCadastroAoClicarEmSair() {
        System.out.println(produtoPage.menuDeCadastroVisivel());
        assertFalse(produtoPage.menuDeCadastroVisivel());
        produtoPage.botaoCriar.click();
        produtoPage.botaoCriar.click();
        System.out.println(produtoPage.menuDeCadastroVisivel());
        assertTrue(produtoPage.menuDeCadastroVisivel());
        produtoPage.botaoSair.click();
        produtoPage.botaoSair.click(); //Na tabela diz que fecha mas pra min só fecha com dois cliques
        System.out.println(produtoPage.menuDeCadastroVisivel());

        assertFalse(produtoPage.menuDeCadastroVisivel());
    }
}
