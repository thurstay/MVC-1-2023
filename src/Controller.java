import java.util.ArrayList;
import java.util.List;

public class Controller {
    private View view;

    public Controller(View view) {
        this.view = view;
    }

    //Tokenize โมเดลปกติ
    public List<Model1> tokenizeModel1(String sourceCode) {
        String[] lines = sourceCode.split("\n");
        List<Model1> models1 = new ArrayList<>();

        for (String line : lines) {
            // เช็คว่าเริ่มด้วย // ไหม ถ้าใช่ให้ข้าม
            if (line.trim().startsWith("//")) {
                continue;
            }

            String[] words = line.split(" ");
            for (String word : words) {
                TokenType1 type = TokenType1.SYMBOL; // Set a default value

                if (word.equals("declare")) {
                    type = TokenType1.KEYWORD;
                } else if (word.matches("[a-zA-Z]+")) {
                    type = TokenType1.IDENTIFIER;
                } else if (word.matches("\\d+")) {
                    type = TokenType1.LITERAL;
                } else if (word.equals("+") || word.equals("=")) {
                    type = TokenType1.SYMBOL;
                }

                models1.add(new Model1(word, type));
            }
        }

        return models1;
    }

    // tokenize Model เพิ่มเติมที่อจต้องการ
    public List<Model2> tokenizeModel2(String sourceCode) {
        String[] lines = sourceCode.split("\n");
        List<Model2> models2 = new ArrayList<>();

        for (String line : lines) {
            // เช็คว่าขึ้นด้นด้วย // ไหม หากใช่ให้ข้าม
            if (line.trim().startsWith("//")) {
                continue;
            }

            String[] words = line.split(" ");
            for (String word : words) {
                TokenType2 type = TokenType2.ASSIGNMENT; // Set a default value

                if (word.equals("declare")) {
                    type = TokenType2.KEYWORD_AND_SIGN;
                } else if (word.matches("[a-zA-Z]+")) {
                    type = TokenType2.VARIABLE;
                } else if (word.matches("\\d+")) {
                    type = TokenType2.INTEGER;
                } else if (word.equals("+") || word.equals("=")) {
                    type = TokenType2.ASSIGNMENT;
                }

                models2.add(new Model2(word, type));
            }
        }

        return models2;
    }
    // display ผล Tokens
    public void displayTokensModel1(List<Model1> models1) {
        for (Model1 model : models1) {
            view.printModel1(model);
        }
    }

    public void displayTokensModel2(List<Model2> models2) {
        for (Model2 model : models2) {
            view.printModel2(model);
        }
    }
}
