import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ATM extends JFrame {
    private JTextField accountField;
    private JPasswordField pinField;
    private JTextArea outputArea;
    private JComboBox<String> transactionDropdown;

    // Initialize sample accounts
    private double checkingBalance = 1000.0;
    private double savingsBalance = 500.0;

    public ATM() {
        setTitle("ATM Machine");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create account number label and text field
        JLabel accountLabel = new JLabel("Account Number:");
        accountField = new JTextField(15);

        // Create PIN label and password field
        JLabel pinLabel = new JLabel("PIN:");
        pinField = new JPasswordField(4);

        // Create transaction dropdown
        String[] transactions = {"Select Transaction", "Check Balance", "Deposit", "Withdraw", "Transfer"};
        transactionDropdown = new JComboBox<>(transactions);

        // Create output area
        outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false);

        // Create buttons for actions
        JButton submitButton = new JButton("Submit");
        JButton clearButton = new JButton("Clear");

        // Add components to the layout
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);

        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(accountLabel, constraints);

        constraints.gridx = 1;
        panel.add(accountField, constraints);

        constraints.gridy = 1;
        panel.add(pinLabel, constraints);

        constraints.gridx = 1;
        panel.add(pinField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(transactionDropdown, constraints);

        constraints.gridx = 1;
        panel.add(submitButton, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(clearButton, constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 2;
        panel.add(new JScrollPane(outputArea), constraints);

        // ActionListener for the Submit button
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleTransaction();
            }
        });

        // ActionListener for the Clear button
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });

        add(panel);
        setVisible(true);
    }

    // Handle user-selected transaction
    private void handleTransaction() {
        String accountNumber = accountField.getText();
        String pin = String.valueOf(pinField.getPassword());
        String selectedTransaction = (String) transactionDropdown.getSelectedItem();

        if (accountNumber.isEmpty() || pin.isEmpty()) {
            showMessage("Please enter your account number and PIN.");
            return;
        }

        // Perform account validation (simplified for demonstration)
        boolean validAccount = accountNumber.equals("12345") && pin.equals("1234");
        if (!validAccount) {
            showMessage("Invalid account number or PIN.");
            return;
        }

        // Handle selected transaction
        switch (selectedTransaction) {
            case "Check Balance":
                showMessage("Checking Balance: $" + checkingBalance + "\nSavings Balance: $" + savingsBalance);
                break;
            case "Deposit":
                performDeposit();
                break;
            case "Withdraw":
                performWithdrawal();
                break;
            case "Transfer":
                performTransfer();
                break;
            default:
                showMessage("Please select a valid transaction.");
        }
    }

    // Perform a deposit transaction
    private void performDeposit() {
        String depositAmountStr = JOptionPane.showInputDialog("Enter the deposit amount:");
        if (depositAmountStr == null || depositAmountStr.isEmpty()) {
            showMessage("Invalid deposit amount.");
            return;
        }

        double depositAmount = Double.parseDouble(depositAmountStr);
        checkingBalance += depositAmount;
        showMessage("Deposit successful. New Checking Balance: $" + checkingBalance);
    }

    // Perform a withdrawal transaction
    private void performWithdrawal() {
        String withdrawalAmountStr = JOptionPane.showInputDialog("Enter the withdrawal amount:");
        if (withdrawalAmountStr == null || withdrawalAmountStr.isEmpty()) {
            showMessage("Invalid withdrawal amount.");
            return;
        }

        double withdrawalAmount = Double.parseDouble(withdrawalAmountStr);
        if (checkingBalance >= withdrawalAmount) {
            checkingBalance -= withdrawalAmount;
            showMessage("Withdrawal successful. New Checking Balance: $" + checkingBalance);
        } else {
            showMessage("Insufficient balance.");
        }
    }

    // Perform a fund transfer transaction
    private void performTransfer() {
        String transferAmountStr = JOptionPane.showInputDialog("Enter the transfer amount:");
        if (transferAmountStr == null || transferAmountStr.isEmpty()) {
            showMessage("Invalid transfer amount.");
            return;
        }

        double transferAmount = Double.parseDouble(transferAmountStr);
        if (checkingBalance >= transferAmount) {
            savingsBalance += transferAmount;
            checkingBalance -= transferAmount;
            showMessage("Transfer successful.\nNew Checking Balance: $" + checkingBalance + "\nNew Savings Balance: $" + savingsBalance);
        } else {
            showMessage("Insufficient balance.");
        }
    }

    // Display a message in the output area
    private void showMessage(String message) {
        outputArea.setText(message);
    }

    // Clear input fields
    private void clearFields() {
        accountField.setText("");
        pinField.setText("");
        transactionDropdown.setSelectedIndex(0);
        outputArea.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ATM();
            }
        });
    }
}
