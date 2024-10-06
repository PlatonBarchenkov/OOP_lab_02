import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * @author Барченков Платон 3312
 * @version 1.0
 */

public class Main {
    // Объявление графических компонентов
    private JFrame frame;
    private JTable teacherTable;
    private DefaultTableModel teacherTableModel;
    private JPanel filterPanel, actionPanel;
    private JButton addTeacherButton, addStudentButton, deleteTeacherButton, deleteStudentButton, generateReportButton;
    private JButton searchButton;
    private JComboBox<String> searchCriteria;
    private JTextField searchField;
    private JScrollPane teacherScrollPane;

    public void SchoolManagementSystem() {
        // Создание главного окна
        frame = new JFrame("School Management System");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Создание панели с кнопками действий
        JToolBar actionPanel = new JToolBar("Toolbar");
        addTeacherButton = new JButton("Добавить учителя");
        addStudentButton = new JButton("Добавить ученика");
        deleteTeacherButton = new JButton("Уволить учителя");
        deleteStudentButton = new JButton("Удалить ученика");
        generateReportButton = new JButton("Создать отчет");

        actionPanel.add(addTeacherButton);
        actionPanel.add(addStudentButton);
        actionPanel.add(deleteTeacherButton);
        actionPanel.add(deleteStudentButton);
        actionPanel.add(generateReportButton);
        frame.add(actionPanel, BorderLayout.NORTH);

        // Создание таблицы с данными учителей
        String[] teacherColumns = {"ФИО учителя", "Предмет", "Классы"};
        Object[][] teacherData = {
                {"Иванов Иван Иванович", "Математика", "5А, 6Б"},
                {"Петрова Анна Сергеевна", "Русский язык", "7В, 8Г"},
                {"Сидоров Петр Петрович", "История", "9А, 10Б"}
        };
        teacherTableModel = new DefaultTableModel(teacherData, teacherColumns);
        teacherTable = new JTable(teacherTableModel);
        teacherScrollPane = new JScrollPane(teacherTable);

        frame.add(teacherScrollPane, BorderLayout.CENTER);

        // Компоненты поиска
        searchCriteria = new JComboBox<>(new String[]{"ФИО учителя", "Предмет", "Класс"});
        searchField = new JTextField(20);
        searchButton = new JButton("Поиск");

        filterPanel = new JPanel();
        filterPanel.add(new JLabel("Критерий поиска: "));
        filterPanel.add(searchCriteria);
        filterPanel.add(new JLabel("Значение: "));
        filterPanel.add(searchField);
        filterPanel.add(searchButton);
        frame.add(filterPanel, BorderLayout.SOUTH);

        // Делаем окно видимым
        frame.setVisible(true);
    }

    /**
     * @param args (Входных аргументов нет)
     */
    public static void main(String[] args) {
        new Main().SchoolManagementSystem();
    }
}