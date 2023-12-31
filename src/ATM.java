import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class ATM extends JFrame {
    //these variables represent the user interface components for the ATM application.
    private final JTextField accountField;        //input field for account number
    private final JPasswordField pinField;        //input field for PIN
    private final JTextArea outputArea;            //area for displaying output messages
    private final JComboBox<String> transactionDropdown;    //dropdown for selecting transaction type

    //initializing sample account balances for demonstration purposes
    private double currentBalance = 1500.0;    //starting balance for current account
    private double savingsBalance = 500.0;      //starting balance for savings account


    public ATM() {
        //setting the title of the ATM application window
        setTitle("ATM Machine");

        //setting the size (dimensions) of the application window
        setSize(400, 300);

        //specifying the default close operation when the user closes the application window
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //centering the application window on the screen
        setLocationRelativeTo(null);

        //creating account number label and text field
        JLabel accountLabel = new JLabel("Account Number:");
        accountField = new JTextField(15);

        //creating pin label and password field
        JLabel pinLabel = new JLabel("PIN:");
        pinField = new JPasswordField(4);

        //creating transaction dropdown
        String[] transactions = {"Select Transaction", "Check Balance", "Deposit", "Withdraw", "Transfer"};
        transactionDropdown = new JComboBox<>(transactions);

        //creating output area
        outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false);

        //creating buttons for actions
        JButton submitButton = new JButton("Submit");
        JButton clearButton = new JButton("Clear");

        //adding components to the layout
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

        //ActionListener for the submit button
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleTransaction();
            }
        });

        //ActionListener for the clear button
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });

        //adding the 'panel' component to the ATM application window
        add(panel);

        //making the ATM application window visible to the user
        setVisible(true);

    }

    //handling user-selected transaction
    private void handleTransaction() {
        //retrieve the user-entered account number from the 'accountField' input field
        String accountNumber = accountField.getText();

        //retrieve the user-entered pin from the 'pinField' input field and convert it to a String
        String pin = String.valueOf(pinField.getPassword());

        //retrieve the selected transaction type from the 'transactionDropdown' dropdown
        String selectedTransaction = (String) transactionDropdown.getSelectedItem();

        //check if either the account number or pin is empty; if so, show an error message and exit
        if (accountNumber.isEmpty() || pin.isEmpty()) {
            showMessage("Please enter your account number and pin.");
            return;
        }

        //perform account validation
        //check if the entered account number and pin match the predefined values
        boolean validAccount = accountNumber.equals("12345") && pin.equals("1234");
        //if the account is not valid, show an error message and exit the transaction handling
        if (!validAccount) {
            showMessage("Invalid account number or PIN.");
            return;
        }

        //handling the selected transaction
        switch (Objects.requireNonNull(selectedTransaction)) {
            case "Check Balance" ->
                //display the current and savings balances
                    showMessage("Current Balance: $" + currentBalance + "\nSavings Balance: $" + savingsBalance);
            case "Deposit" ->
                //proceed to handle a deposit transaction
                    performDeposit();
            case "Withdraw" ->
                //proceed to handle a withdrawal transaction
                    performWithdrawal();
            case "Transfer" ->
                //proceed to handle a transfer transaction
                    performTransfer();
            default ->
                //in case the invalid transaction is selected, print out error message
                    showMessage("Please select a valid transaction.");
        }
    }

    // Perform a deposit transaction
    private void performDeposit() {
        //request the user to input the deposit amount using a dialog box
        String depositAmountStr = JOptionPane.showInputDialog("Enter the deposit amount:");

        //checking if the user canceled the input dialog or left it empty
        if (depositAmountStr == null || depositAmountStr.isEmpty()) {
            //show an error message and exit the deposit operation
            showMessage("Invalid deposit amount.");
            return;
        }

        //parse the deposit amount from the user's input (as a string) to a double
        double depositAmount = Double.parseDouble(depositAmountStr);

        //update the current balance by adding the deposit amount
        currentBalance += depositAmount;

        //display a success message with the new checking balance
        showMessage("Deposit successful. New Current Balance: $" + currentBalance);
    }

    // Perform a withdrawal transaction
    private void performWithdrawal() {
        //requesting the user to input the withdrawal amount using a dialog box
        String withdrawalAmountStr = JOptionPane.showInputDialog("Enter the withdrawal amount:");
        //checking if the user canceled the input dialog or left it empty
        if (withdrawalAmountStr == null || withdrawalAmountStr.isEmpty()) {
            //show an error message and exit the withdrawal operation
            showMessage("Invalid withdrawal amount.");
            return;
        }

        //parse the withdrawal amount from the user's input (as a string) to a double
        double withdrawalAmount = Double.parseDouble(withdrawalAmountStr);

        //checking if the current balance is sufficient for the withdrawal
        if (currentBalance >= withdrawalAmount) {
            //if sufficient, update the current balance by subtracting the withdrawal amount
            currentBalance -= withdrawalAmount;
            showMessage("Withdrawal successful. New Current Balance: $" + currentBalance);
        } else {
            //if the balance is insufficient, show an error message
            showMessage("Insufficient balance.");
        }
    }

    // Perform a fund transfer transaction
    private void performTransfer() {
        //request the user to input the transfer amount using a dialog box
        String transferAmountStr = JOptionPane.showInputDialog("Enter the transfer amount:");
        //checking if the user canceled the input dialog or left it empty
        if (transferAmountStr == null || transferAmountStr.isEmpty()) {
            //show an error message and exit the transfer operation
            showMessage("Invalid transfer amount.");
            return;
        }

        //parse the transfer amount from the user's input (as a string) to a double
        double transferAmount = Double.parseDouble(transferAmountStr);

        //checking if the current balance is sufficient for the transfer
        if (currentBalance >= transferAmount) {
            //if sufficient, update the savings and current balances accordingly
            savingsBalance += transferAmount;
            currentBalance -= transferAmount;
            showMessage("Transfer successful.\nNew Current Balance: $" + currentBalance + "\nNew Savings Balance: $" + savingsBalance);
        } else {
            //if the balance is insufficient, show an error message
            showMessage("Insufficient balance.");
        }
    }

    //display a message in the output area
    private void showMessage(String message) {
        //setting the provided 'message' text to the 'outputArea' for user display
        outputArea.setText(message);
    }

    //clear input fields
    private void clearFields() {
        //reset the input fields and dropdown to their initial state
        accountField.setText("");
        pinField.setText("");
        transactionDropdown.setSelectedIndex(0);
        outputArea.setText("");
    }

    public static void main(String[] args) {
        //launch the ATM application within the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ATM(); //creates an instance of the ATM application
            }
        });
    }
}
