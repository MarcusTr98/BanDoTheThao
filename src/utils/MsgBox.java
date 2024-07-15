
package utils;

import java.awt.Component;
import javax.swing.JOptionPane;

public class MsgBox {

    /*
    Hiển thị thông báo cho người dùng
    @param parent là cửa sổ chứa thông báo
    @param message là thông báo
     */
    public static void showMessageDialog(Component parent, String content) {
        JOptionPane.showMessageDialog(parent, content, "Hệ thống quản lí bán đồ thể thao", JOptionPane.INFORMATION_MESSAGE);
    }

    /*
    Hiển thị thông báo và yêu cầu người dùng xác nhận
    @param parent là cửa sổ chứa thông báo
    @param message là thông báo
     */
    public static boolean showConfirmDialog(Component parent, String content) {
        int choose = JOptionPane.showConfirmDialog(parent, content, "Hệ thống quản lí bán đồ thể thao",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        return choose == JOptionPane.YES_OPTION;
    }

    /*
    Hiển thị thông báo và yêu cầu người dùng xác nhận
    @param parent là cửa sổ chứa thông báo
    @param message là thông báo
     */
    public static void showErrorDialog(Component parent, String content, String title) {
        JOptionPane.showMessageDialog(parent, content, title, JOptionPane.ERROR_MESSAGE);
    }

}
