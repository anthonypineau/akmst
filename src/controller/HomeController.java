package controller;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.dao.CustomerDAO;
import model.dao.InvoiceDAO;
import model.dao.QuotationDAO;
import model.work.Customer;
import model.work.Invoice;
import model.work.Quotation;
import utils.ModelToTable;
import utils.comparators.customer.NameDescSorter;
import utils.comparators.customer.NameSorter;
import view.HomeView;
import view.components.Graphs;
import view.dialogs.AddNewCustomerDialog;
import view.dialogs.AddNewInvoiceDialog;
import view.dialogs.AddNewQuotationDialog;

/**
 *
 * @author Anthony
 */
public class HomeController implements ActionListener, MouseListener {

    private MainController mainController = null;
    private HomeView homeView = null;
    
    private final JButton jButtonHome;
    private final JButton jButtonCustomers;
    private final JButton jButtonQuotations;
    private final JButton jButtonInvoices;
    private final JButton jButtonAdd;
    
    private AddNewCustomerDialog addNewCustomerDialog = null;
    private AddNewInvoiceDialog addNewInvoiceDialog = null;
    private AddNewQuotationDialog addNewQuotationDialog = null;
    
    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Invoice> invoices = new ArrayList<>();
    private ArrayList<Quotation> quotations = new ArrayList<>();
    
    private String[] customersTableColumnTitles = {"Customer number", "Name", "E-mail", "Phone number", "First order date", "Tag"};
    private String[] invoicesTableColumnsTitles = {"Invoice number", "Ordre date", "Total price"};
    private String[] quotationsTableColumnsTitles = {"Quotation number", "Ordre date", "Price"};
    
    private Customer selectedCustomer = null;
            
    private JComboBox jComboBoxSortCustomersTable = new JComboBox();
    private DefaultComboBoxModel modelComboBoxSortCustomersTable = new DefaultComboBoxModel();
        
    private JTable jTable = new JTable();
    private DefaultTableModel modelTable = new DefaultTableModel();
    
    private JTable jTableCustomers = new JTable();
    private DefaultTableModel modelTableCustomers = new DefaultTableModel();
    
    private int statusAddButton=0;
    
    public HomeController(MainController mainController) throws SQLException{
        this.mainController = mainController;
        this.homeView = new HomeView();
        
        jButtonHome = new JButton("Home");
        jButtonCustomers = new JButton("Customers");
        jButtonQuotations = new JButton("Quotations");
        jButtonInvoices = new JButton("Invoices");
        jButtonAdd = new JButton("Add");
        
        this.jButtonHome.addActionListener(this);
        this.jButtonCustomers.addActionListener(this);
        this.jButtonQuotations.addActionListener(this);
        this.jButtonInvoices.addActionListener(this);
        this.jButtonAdd.addActionListener(this);
        
        this.homeView.getjPanelMenu().setLayout(new GridLayout(1,5));
        
        this.homeView.getjPanelMenu().add(jButtonHome);
        this.homeView.getjPanelMenu().add(jButtonCustomers);
        this.homeView.getjPanelMenu().add(jButtonQuotations);
        this.homeView.getjPanelMenu().add(jButtonInvoices);
        this.homeView.getjPanelMenu().add(jButtonAdd);        
        
        this.addNewCustomerDialog = new AddNewCustomerDialog(this.homeView,true);
        this.addNewInvoiceDialog = new AddNewInvoiceDialog(this.homeView,true);
        this.addNewQuotationDialog = new AddNewQuotationDialog(this.homeView,true);       
        
        this.addNewCustomerDialog.getjButtonAddNewCustomer().addActionListener(this);
        this.addNewInvoiceDialog.getjButtonAddNewInvoice().addActionListener(this);
        this.addNewQuotationDialog.getjButtonAddNewQuotation().addActionListener(this);
        
        this.addNewInvoiceDialog.getjComboBoxCustomer().addActionListener(this);
        this.addNewQuotationDialog.getjComboBoxCustomer().addActionListener(this);
        
        jComboBoxSortCustomersTable.setModel(modelComboBoxSortCustomersTable);
                
        String[] items = { "name", "name desc" };
        
        for(String item : items){
            modelComboBoxSortCustomersTable.addElement(item);
        }
        
        jComboBoxSortCustomersTable.addActionListener(this);
        
        jTable.setModel(modelTable);
        jTableCustomers.setModel(modelTableCustomers);
        
        jTableCustomers.addMouseListener(this);
        
        try {
            this.customers = CustomerDAO.getAll();
            this.invoices = InvoiceDAO.getAll();
            this.quotations = QuotationDAO.getAll();
        } catch (SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    public void displayHomeView(){
        this.homeView.setVisible(true);
        this.jButtonAdd.setVisible(false);
        this.displayHome();
    }    

    public void displayHome(){
        JPanel panel = new JPanel();
        panel.removeAll();
        panel.setLayout(new GridLayout(2,2));          
        panel.add(Graphs.displayLaGraph());
        panel.add(Graphs.displayPieGraph());
        panel.add(Graphs.displayLineGraph());
        panel.add(Graphs.displayLaGraph());
        //this.homeView.getjPanelContent().removeAll();
        //this.homeView.getjPanelContent().add(panel);
        //this.homeView.getjPanelContent().validate();
        this.displayJContentPanel(panel);
    }
    
    private void updateCustomers() throws SQLException{
        this.customers = CustomerDAO.getAll();
    }
    
    private void updateInvoices() throws SQLException{
        this.invoices = InvoiceDAO.getAll();
    }
    
    private void updateQuotations() throws SQLException{
        this.quotations = QuotationDAO.getAll();
    }
    
    private void displayCustomersTable(boolean status){
        selectedCustomer=null;
        
        modelTableCustomers.setColumnIdentifiers(customersTableColumnTitles);    
        
        for(int i=this.modelTableCustomers.getRowCount()-1;i>=0;i--){
            this.modelTableCustomers.removeRow(i);
        }
        
        customers.forEach(c -> {
            modelTableCustomers.addRow(ModelToTable.customerToTableRow(c));
        });
        JPanel customerPanel = new JPanel();
        if(!status){
            customerPanel.removeAll();
            customerPanel.setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridx = 0;
            c.gridy = 0;            
            customerPanel.add(new JLabel("Sort by :"), c);
            c.gridx = 1;
            c.gridy = 0;
            customerPanel.add(jComboBoxSortCustomersTable,c);
            c.gridx = 0;
            c.gridy = 1;
            c.gridwidth = 2;
            customerPanel.add(new JScrollPane(jTableCustomers),c);
        }
        this.displayJContentPanel(customerPanel);
    }
    
    private void displayInvoicesTable(){       
        modelTable.setColumnIdentifiers(invoicesTableColumnsTitles);
        
        ArrayList<Invoice> invoicesDisplay;
        
        if(selectedCustomer != null){
            invoicesDisplay = selectedCustomer.getInvoices();
        }else{
            invoicesDisplay = invoices;
        }
        
        for(int i=this.modelTable.getRowCount()-1;i>=0;i--){
            this.modelTable.removeRow(i);
        }
        
        invoicesDisplay.forEach(i -> {
            modelTable.addRow(ModelToTable.invoiceToTableRow(i));
        });
        
        this.displayJContentPanel(new JScrollPane(jTable));
    }
    
    private void displayQuotationsTable(){
        modelTable.setColumnIdentifiers(quotationsTableColumnsTitles);
        
        ArrayList<Quotation> quotationsDisplay;
        
        if(selectedCustomer != null){
            quotationsDisplay = selectedCustomer.getQuotations();
        }else{
            quotationsDisplay = quotations;
        }
        
        for(int i=this.modelTable.getRowCount()-1;i>=0;i--){
            this.modelTable.removeRow(i);
        }
        
        quotationsDisplay.forEach(q -> {
            modelTable.addRow(ModelToTable.quotationToTableRow(q));
        });
        
        this.displayJContentPanel(new JScrollPane(jTable));
    }
    
    private void displayJContentPanel(Component component){
        this.homeView.getjPanelContent().removeAll();
        this.homeView.getjPanelContent().add(component);
        this.homeView.getjPanelContent().validate();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(this.jButtonCustomers)){
            displayCustomersTable(false);
            this.jButtonAdd.setText("Add new customer");
            statusAddButton=1;
            this.jButtonAdd.setVisible(true);
        }else if(e.getSource().equals(this.jButtonQuotations)){
            displayQuotationsTable();
            this.jButtonAdd.setText("Add new quotation");
            statusAddButton=2;
            this.jButtonAdd.setVisible(true);
        }else if(e.getSource().equals(this.jButtonInvoices)){
            displayInvoicesTable();
            this.jButtonAdd.setText("Add new invoice");
            statusAddButton=3;
            this.jButtonAdd.setVisible(true);
        }else if(e.getSource().equals(this.jButtonHome)){
            displayHome();
            this.jButtonAdd.setVisible(false);
        }else if(e.getSource().equals(this.jButtonAdd)){
            switch(statusAddButton){
                case 1:
                    this.addNewCustomerDialog.setVisible(true);
                    try {
                        updateCustomers();
                        displayCustomersTable(false);
                    } catch (SQLException ex) {
                        Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case 2:
                    this.addNewQuotationDialog.setVisible(true);
                    try {
                        updateQuotations();
                        displayQuotationsTable();
                    } catch (SQLException ex) {
                        Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case 3:
                    this.addNewInvoiceDialog.setVisible(true);
                    try {
                        updateInvoices();
                        displayInvoicesTable();
                    } catch (SQLException ex) {
                        Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
            }
        }else if(e.getSource().equals(this.addNewCustomerDialog.getjButtonAddNewCustomer())){
            String name = this.addNewCustomerDialog.getjTextFieldName().getText();
            String email = this.addNewCustomerDialog.getjTextFieldEmail().getText();
            String phoneNumber = this.addNewCustomerDialog.getjTextFieldPhone().getText();
            String firstOrderDate = this.addNewCustomerDialog.getjTextFieldDate().getText();
            String tag = this.addNewCustomerDialog.getjTextFieldTag().getText();
            Customer c = new Customer(0,name, email, phoneNumber, firstOrderDate, tag);
            try {
                CustomerDAO.insert(c);
            } catch (SQLException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(e.getSource().equals(this.addNewQuotationDialog.getjButtonAddNewQuotation())){
            String date = this.addNewQuotationDialog.getjTextFieldDate().getText();
            int price = parseInt(this.addNewQuotationDialog.getjTextFieldDate().getText());
            int customer = this.addNewQuotationDialog.getNumberSelectedCustomer();
            Quotation q = new Quotation(0,date,price);
            try {
                QuotationDAO.insert(q, customer);
            } catch (SQLException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(e.getSource().equals(this.addNewInvoiceDialog.getjButtonAddNewInvoice())){
            String date = this.addNewInvoiceDialog.getjTextFieldDate().getText();
            int price = parseInt(this.addNewInvoiceDialog.getjTextFieldDate().getText());
            int customer = this.addNewInvoiceDialog.getNumberSelectedCustomer();
            Invoice q = new Invoice(0,date,price);
            try {
                InvoiceDAO.insert(q, customer);
            } catch (SQLException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(e.getSource().equals(this.jComboBoxSortCustomersTable)){
            switch(modelComboBoxSortCustomersTable.getSelectedItem().toString()){
                case "name" :
                    customers.sort(new NameSorter());
                    break;
                case "name desc" :
                    customers.sort(new NameDescSorter());
                    break;
            }
            displayCustomersTable(false);
        } else if(e.getSource().equals(this.addNewInvoiceDialog.getjComboBoxCustomer())){
            Customer customer = (Customer) this.addNewInvoiceDialog.getModelComboBoxCustomers().getSelectedItem();
            this.addNewInvoiceDialog.setNumberSelectedCustomer(customer.getNumber());
        } else if(e.getSource().equals(this.addNewQuotationDialog.getjComboBoxCustomer())){
            Customer customer = (Customer) this.addNewQuotationDialog.getModelComboBoxCustomers().getSelectedItem();
            this.addNewQuotationDialog.setNumberSelectedCustomer(customer.getNumber());
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(jTableCustomers)) {
            selectedCustomer = customers.get(jTableCustomers.rowAtPoint(e.getPoint()));
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
     
}
