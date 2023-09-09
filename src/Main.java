import java.util.List;
import java.util.Scanner;

public class Main {
    // 64050210 วณัชญา เธียรเงิน
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // สร้าง instance ในการเรียกใช้ view และ controller
        View view = new View();
        Controller controller = new Controller(view);

        System.out.print("Enter CSGO source code: ");
        String sourceCode = sc.nextLine();
        
        // Tokenize using Model1 จาก Controller
        List<Model1> models1 = controller.tokenizeModel1(sourceCode);
        controller.displayTokensModel1(models1); //แสดงค่า model1

        // Tokenize using Model2 จาก Controller
        List<Model2> models2 = controller.tokenizeModel2(sourceCode);
        controller.displayTokensModel2(models2); //แสดงค่า model2
    }
}
