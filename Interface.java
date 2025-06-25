import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Interface extends JFrame {
    public JTable table;
    public DefaultTableModel tableModel;
    public JTextField outputField;
    public JButton addCellButton;
    public JButton task3;
    public JButton task33;

    public Interface() {

        setTitle("Task 3");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 300);
        setLayout(new BorderLayout());

        tableModel = new DefaultTableModel();
        tableModel.addColumn(1);
        tableModel.addRow(new Object[]{""});
        table = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(table);
        add(tableScrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());

        JButton addCellButton = new JButton("Добавить ячейку");
        addCellButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int columnCount = tableModel.getColumnCount();
                tableModel.addColumn(columnCount + 1);
                tableModel.setValueAt("", 0, columnCount);
            }
        });

        buttonPanel.add(addCellButton);

        JButton tsk32 = new JButton("Task3 Node");
        tsk32.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Integer> numbers = getNumbersFromTable();
                if (numbers.isEmpty()) {
                    outputField.setText("Введите числа");
                    return;
                }

                ArrayList<Integer> result = Task32.process(numbers);
                outputField.setText(result.toString());
            }
        });

        JButton task3 = new JButton("task 3");
        task3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Integer> numbers = getNumbersFromTable();
                if (numbers.isEmpty()) {
                    outputField.setText("Введите числа");
                    return;
                }

                ArrayList<Integer> result = Task3.Swap(new ArrayList<>(numbers));

                String output = String.format(result.toString());
                outputField.setText(output);
            }
        });
        buttonPanel.add(task3);
        buttonPanel.add(tsk32);

        add(buttonPanel, BorderLayout.SOUTH);

        outputField = new JTextField();
        outputField.setEditable(false);
        outputField.setPreferredSize(new Dimension(150, 0));
        add(outputField, BorderLayout.EAST);

        setVisible(true);
    }
    public ArrayList<Integer> getNumbersFromTable() {
        ArrayList<Integer> numbers = new ArrayList<>();

        int row = 0;
        int columnCount = tableModel.getColumnCount();

        for (int col = 0; col < columnCount; col++) {
            Object val = tableModel.getValueAt(row, col);
            if (val != null && !val.toString().trim().isEmpty()) {
                try {
                    numbers.add(Integer.parseInt(val.toString().trim()));
                } catch (NumberFormatException e) {
                    // пропускаем нечисловые значния
                }
            }
        }

        return numbers;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Interface();
            }
        });
    }
}
