package sistemadetestes.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProdutoPO extends BasePO{
    @FindBy(className = "nav-link")
    public WebElement linkVoltar;
    @FindBy(id = "btn-adicionar")
    public WebElement botaoCriar;
    @FindBy(tagName = "title")
    public WebElement tituloPagina;
    @FindBy(tagName = "body")
    public WebElement body;
    @FindBy(id = "btn-sair")
    public WebElement botaoSair;

    public ProdutoPO(WebDriver driver) {
        super(driver);
    }
    public String obterTituloDaPagina() {
        return driver.getTitle();
    }
    public boolean menuDeCadastroVisivel() {
        return body.getAttribute("class").contains("modal-open");
    }
}
