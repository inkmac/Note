package CommonClass;


public class Register {
    public static void main(String[] args) {
        String name = "jack";
        String pwd = "882861";

        userRegister(name, pwd);
    }

    public static void userRegister(String name, String pwd) {

        if (!(name.length() >= 2 && name.length() <= 4)) {
            System.out.println("NameWrong");
            return;
        }

        if (!(pwd.length() == 6 && isNumeric(pwd))) {
            System.out.println("PasswordWrong");
            return;
        }

        System.out.println("注册成功");
    }


    public static boolean isNumeric(String str) {
        for (char c : str.toCharArray()) {
            if (!(Character.isDigit(c))) {
                return false; // 如果发现非数字字符，返回false
            }
        }
        return true; // 如果所有字符都是数字，返回true
    }
}

