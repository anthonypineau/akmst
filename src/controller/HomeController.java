/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.work.Customer;
import model.work.Invoice;
import model.work.Quotation;
import model.work.User;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import utils.comparators.customer.NameDescSorter;
import utils.comparators.customer.NameSorter;
import view.HomeView;
import view.dialogs.AddNewCustomerDialog;
import view.dialogs.AddNewInvoiceDialog;
import view.dialogs.AddNewQuotationDialog;

/**
 *
 * @author anthony
 */
public class HomeController implements ActionListener {

    private MainController mainController = null;
    private HomeView homeView = null;
    
    private AddNewCustomerDialog addNewCustomerDialog = null;
    private AddNewInvoiceDialog addNewInvoiceDialog = null;
    private AddNewQuotationDialog addNewQuotationDialog = null;
    
    private final ArrayList<Customer> customers = new ArrayList<>();
    private final ArrayList<Invoice> invoices = new ArrayList<>();
    private final ArrayList<Quotation> quotations = new ArrayList<>();
    
    JPanel customerPanel = new JPanel();
        
    JComboBox jComboBoxSortCustomersTable = new JComboBox();
    DefaultComboBoxModel modelComboBoxSortCustomersTable = new DefaultComboBoxModel();
        
    JTable jTableCustomers = new JTable();
    DefaultTableModel modelCustomersTable = new DefaultTableModel();
        
    private int statusAddButton=0;
    
    public HomeController(MainController mainController){
        this.mainController = mainController;
        this.homeView = new HomeView();
        this.homeView.getjButtonCustomers().addActionListener(this);
        this.homeView.getjButtonQuotations().addActionListener(this);
        this.homeView.getjButtonInvoices().addActionListener(this);
        this.homeView.getjButtonHome().addActionListener(this);
        this.homeView.getjButtonAdd().addActionListener(this);
        
        this.addNewCustomerDialog = new AddNewCustomerDialog(this.homeView,true);
        this.addNewInvoiceDialog = new AddNewInvoiceDialog(this.homeView,true);
        this.addNewQuotationDialog = new AddNewQuotationDialog(this.homeView,true);       
        
        this.addNewCustomerDialog.getjButtonAddNewCustomer().addActionListener(this);
                
        jComboBoxSortCustomersTable.setModel(modelComboBoxSortCustomersTable);
                
        String[] items = { "name", "name desc" };
        
        for(String item : items){
            modelComboBoxSortCustomersTable.addElement(item);
        }
                
        jComboBoxSortCustomersTable.addActionListener(this);
        
        jTableCustomers.setModel(modelCustomersTable);
        
        String[] columnsTitles = {"Customer number", "Name", "E-mail", "Phone number", "First order date", "Shopping cart", "Tag"};
        
        modelCustomersTable.setColumnIdentifiers(columnsTitles);        
        
        addData();
    }
    
    private void addData(){
        Customer c1 = new Customer(1, "c1", "c1@c1.com", "0123456789", new Date(2021,04,10), "cart", "tag");
        Customer c2 = new Customer(2, "c2", "c2@c2.com", "0123456789", new Date(2021,04,10), "cart", "tag");
        Customer c3 = new Customer(3, "c3", "c3@c3.com", "0123456789", new Date(2021,04,10), "cart", "tag");
        Customer c4 = new Customer(4, "c4", "c4@c4.com", "0123456789", new Date(2021,04,10), "cart", "tag");
        Customer c5 = new Customer(5, "c5", "c5@c5.com", "0123456789", new Date(2021,04,10), "cart", "tag");
        Customer c6 = new Customer(6, "c6", "c6@c6.com", "0123456789", new Date(2021,04,10), "cart", "tag");
        Customer c7 = new Customer(7, "c7", "c7@c7.com", "0123456789", new Date(2021,04,10), "cart", "tag");
        Customer c8 = new Customer(8, "c8", "c8@c8.com", "0123456789", new Date(2021,04,10), "cart", "tag");
        Customer c9 = new Customer(9, "c9", "c9@c9.com", "0123456789", new Date(2021,04,10), "cart", "tag");
        Customer c10 = new Customer(10, "c10", "c10@c10.com", "0123456789", new Date(2021,04,10), "cart", "tag");
        
        customers.add(c1);
        customers.add(c2);
        customers.add(c3);
        customers.add(c4);
        customers.add(c5);
        customers.add(c6);
        customers.add(c7);
        customers.add(c8);
        customers.add(c9);
        customers.add(c10);
        
        Invoice i1 = new Invoice(1, new Date(2021,04,10), 100);
        Invoice i2 = new Invoice(2, new Date(2021,04,10), 100);
        Invoice i3 = new Invoice(3, new Date(2021,04,10), 100);
        Invoice i4 = new Invoice(4, new Date(2021,04,10), 100);
        Invoice i5 = new Invoice(5, new Date(2021,04,10), 100);
        invoices.add(i1);
        invoices.add(i2);
        invoices.add(i3);
        invoices.add(i4);
        invoices.add(i5);
        
        Quotation q1 = new Quotation(1, new Date(2021,04,10));
        Quotation q2 = new Quotation(2, new Date(2021,04,10));
        Quotation q3 = new Quotation(3, new Date(2021,04,10));
        Quotation q4 = new Quotation(4, new Date(2021,04,10));
        Quotation q5 = new Quotation(5, new Date(2021,04,10));
        quotations.add(q1);
        quotations.add(q2);
        quotations.add(q3);
        quotations.add(q4);
        quotations.add(q5);
    }
    
    public void displayHomeView(User user){
        this.homeView.setVisible(true);
        this.homeView.getjButtonAdd().setVisible(false);
        this.homeView.getjLabelUser().setText(user.toString());
        this.displayPieGraph();
    }    
    
    public void displayLaGraph(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(1,"","premier");
        dataset.setValue(7,"","deuxième");
        dataset.setValue(5,"","troisième");
        dataset.setValue(2,"","quatrième");
        
        JFreeChart chart = ChartFactory.createBarChart("","", "", dataset, PlotOrientation.HORIZONTAL, false, false, false);
        CategoryPlot catPlot =chart.getCategoryPlot();
        catPlot.setRangeGridlinePaint(Color.BLACK);
        
        ChartPanel chartPanel = new ChartPanel(chart);
        this.homeView.getjPanelContent().removeAll();
        this.homeView.getjPanelContent().add(chartPanel, BorderLayout.CENTER);
        this.homeView.getjPanelContent().validate();
    }
    
    public void displayPieGraph(){
            
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("premier", 1);
        dataset.setValue("deuxième", 2);
        dataset.setValue("troisième", 7);
        dataset.setValue("quatrième", 3);
        
        JFreeChart chart = ChartFactory.createPieChart("pie chart", dataset, true, true, false);
        
        ChartPanel chartPanel = new ChartPanel(chart);
        this.homeView.getjPanelContent().removeAll();
        this.homeView.getjPanelContent().add(chartPanel, BorderLayout.CENTER);
        this.homeView.getjPanelContent().validate();
    }
    
    public void displayLineGraph(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(1,"","premier");
        dataset.setValue(7,"","deuxième");
        dataset.setValue(5,"","troisième");
        dataset.setValue(2,"","quatrième");
        
        JFreeChart chart = ChartFactory.createLineChart("","", "", dataset, PlotOrientation.VERTICAL, false, false, false);
        CategoryPlot catPlot =chart.getCategoryPlot();
        catPlot.setRangeGridlinePaint(Color.BLACK);
        
        ChartPanel chartPanel = new ChartPanel(chart);
        this.homeView.getjPanelContent().removeAll();
        this.homeView.getjPanelContent().add(chartPanel, BorderLayout.CENTER);
        this.homeView.getjPanelContent().validate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(this.homeView.getjButtonCustomers())){
            displayCustomersTable();
            this.homeView.getjButtonAdd().setText("Add new customer");
            statusAddButton=1;
            this.homeView.getjButtonAdd().setVisible(true);
        }else if(e.getSource().equals(this.homeView.getjButtonHome())){
            displayPieGraph();
            this.homeView.getjButtonAdd().setVisible(false);
        }else if(e.getSource().equals(this.homeView.getjButtonAdd())){
            switch(statusAddButton){
                case 1:
                    this.addNewCustomerDialog.setVisible(true);
                    System.out.println("add new customer");
                    break;
                case 2:
                    this.addNewQuotationDialog.setVisible(true);
                    System.out.println("add new quotation");
                    break;
                case 3:
                    this.addNewInvoiceDialog.setVisible(true);
                    System.out.println("add new invoice");
                    break;
            }
        }else if(e.getSource().equals(this.homeView.getjButtonQuotations())){
            displayQuotationsTable();
            this.homeView.getjButtonAdd().setText("Add new quotation");
            statusAddButton=2;
            this.homeView.getjButtonAdd().setVisible(true);
        }else if(e.getSource().equals(this.homeView.getjButtonInvoices())){
            displayInvoicesTable();
            this.homeView.getjButtonAdd().setText("Add new invoice");
            statusAddButton=3;
            this.homeView.getjButtonAdd().setVisible(true);
        }else if(e.getSource().equals(this.addNewCustomerDialog.getjButtonAddNewCustomer())){
            
        }else if(e.getSource().equals(this.jComboBoxSortCustomersTable)){
            switch(modelComboBoxSortCustomersTable.getSelectedItem().toString()){
                case "name" :
                    customers.sort(new NameSorter());
                    break;
                case "name desc" :
                    customers.sort(new NameDescSorter());
                    break;
            }
            displayCustomersTable();
        }
    }

    private void displayCustomersTable(){
        for(int i=this.modelCustomersTable.getRowCount()-1;i>=0;i--){
            this.modelCustomersTable.removeRow(i);
        }
        
        for(Customer c : customers){
            modelCustomersTable.addRow(customerToTableRow(c));
        }
        
        customerPanel.removeAll();
        customerPanel.add(new JLabel("Sort by :"));
        customerPanel.add(jComboBoxSortCustomersTable);
        customerPanel.add(new JScrollPane(jTableCustomers));
        
        this.homeView.getjPanelContent().removeAll();
        this.homeView.getjPanelContent().add(customerPanel);
        this.homeView.getjPanelContent().validate();
    }
    
    private void displayInvoicesTable(){
        JTable jTableInvoices = new JTable();
        DefaultTableModel modelInvoicesTable = new DefaultTableModel();
        jTableInvoices.setModel(modelInvoicesTable);
        
        String[] columnsTitles = {"Invoice number", "Ordre date", "Total price"};
        
        modelInvoicesTable.setColumnIdentifiers(columnsTitles);
        
        for(Invoice i : invoices){
            modelInvoicesTable.addRow(invoiceToTableRow(i));
        }
        
        this.homeView.getjPanelContent().removeAll();
        this.homeView.getjPanelContent().add(new JScrollPane(jTableInvoices));
        this.homeView.getjPanelContent().validate();
    }
    
    private void displayQuotationsTable(){
        JTable jTableQuotations = new JTable();
        DefaultTableModel modelQuotationsTable = new DefaultTableModel();
        jTableQuotations.setModel(modelQuotationsTable);
        
        String[] columnsTitles = {"Invoice number", "Ordre date"};
        
        modelQuotationsTable.setColumnIdentifiers(columnsTitles);
        
        for(Quotation q : quotations){
            modelQuotationsTable.addRow(quotationToTableRow(q));
        }
        
        this.homeView.getjPanelContent().removeAll();
        this.homeView.getjPanelContent().add(new JScrollPane(jTableQuotations));
        this.homeView.getjPanelContent().validate();
    }
    
    private String[] customerToTableRow(Customer c){
        String[] tableRow = new String[7];
        
        tableRow[0]=String.valueOf(c.getNumber());
        tableRow[1]=c.getName();
        tableRow[2]=c.getEmail();
        tableRow[3]=c.getPhoneNumber();
        tableRow[4]=c.getFirstOrderDate().toString();
        tableRow[5]=c.getShoppingCart();
        tableRow[6]=c.getTag();
        
        return tableRow;
    }
    
    private String[] invoiceToTableRow(Invoice i){
        String[] tableRow = new String[3];
        
        tableRow[0]=String.valueOf(i.getNumber());
        tableRow[1]= i.getOrderDate().toString();
        tableRow[2]= String.valueOf(i.getTotalPrice());
        
        return tableRow;
    }
    
    private String[] quotationToTableRow(Quotation q){
        String[] tableRow = new String[2];
        
        tableRow[0]=String.valueOf(q.getNumber());
        tableRow[1]= q.getOrderDate().toString();
        
        return tableRow;
    }
     
}
