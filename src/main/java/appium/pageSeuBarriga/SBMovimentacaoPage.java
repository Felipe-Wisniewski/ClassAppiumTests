package appium.pageSeuBarriga;

import appium.core.BasePage;
import org.openqa.selenium.By;

public class SBMovimentacaoPage extends BasePage {

    public void salvar() {
        tapElementByText("SALVAR");
    }

    public boolean isMessageExist(String message) {
        return elementExistingByText(message);
    }

    public void setDescricao(String descricao) {
        writeText(By.xpath("//android.widget.EditText[@text='Descrição']"), descricao);
    }

    public void setInteressado(String interessado) {
        writeText(By.xpath("//android.widget.EditText[@text='Interessado']"), interessado);
    }

    public void setValor(String valor) {
        writeText(By.xpath("//android.widget.EditText[@text='Valor']"), valor);
    }

    public void setConta(String conta) {
        selectSpinner(By.xpath("//android.widget.Spinner[2]"), conta);
    }
}
