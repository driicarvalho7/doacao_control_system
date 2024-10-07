import javax.swing.*;
import java.awt.event.*;

public class BarcodeReaderApp {

    public static void main(String[] args) {
        // Cria uma nova janela
        JFrame frame = new JFrame("Leitor de Código de Barras");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Campo de texto onde o código de barras será inserido
        JTextField barcodeField = new JTextField();
        barcodeField.setColumns(20);

        // Botão para processar o código de barras
        JButton processButton = new JButton("Processar Código");

        // Área de texto para exibir o resultado
        JTextArea resultArea = new JTextArea(3, 30);
        resultArea.setEditable(false);

        // Adiciona um listener ao campo de texto para capturar a entrada
        barcodeField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // Se a tecla ENTER for pressionada, consideramos que o código foi inserido
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String barcode = barcodeField.getText();
                    resultArea.setText("Código de Barras Lido: " + barcode);
                    barcodeField.setText(""); // Limpa o campo para o próximo código
                }
            }
        });

        // Adiciona ação ao botão de processar
        processButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String barcode = barcodeField.getText();
                resultArea.setText("Código de Barras Processado: " + barcode);
                barcodeField.setText(""); // Limpa o campo de texto
            }
        });

        // Painel para organizar os componentes
        JPanel panel = new JPanel();
        panel.add(new JLabel("Insira o Código de Barras:"));
        panel.add(barcodeField);
        panel.add(processButton);

        // Envolver a área de texto em um JScrollPane e adicionar ao painel
        JScrollPane scrollPane = new JScrollPane(resultArea);
        panel.add(scrollPane);

        // Adiciona o painel à janela
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
}
