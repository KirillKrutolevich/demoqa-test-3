import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {
    @Test
    void dragAndDropTest(){
//       открываем  https://the-internet.herokuapp.com/drag_and_drop
        open( "https://the-internet.herokuapp.com/drag_and_drop");
//      меняем местами кубы А и B
        $("#column-a").dragAndDropTo("#column-b");
//       проверяем что кубы поменялись
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));


    }
}
