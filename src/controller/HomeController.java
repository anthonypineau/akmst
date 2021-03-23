/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.BorderLayout;
import java.awt.Color;
import model.work.User;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import view.HomeView;

/**
 *
 * @author anthony
 */
public class HomeController {

    private MainController mainController = null;
    private HomeView homeView = null;
    
    public HomeController(MainController mainController){
        this.mainController = mainController;
        this.homeView = new HomeView();
    }
    
    public void displayHomeView(User user){
        this.homeView.setVisible(true);
        this.homeView.getJLabelUser().setText(user.toString());
        this.faitUnGraphPie();
    }    
    
     public void faitUnGraphLa(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(1,"","premier");
        dataset.setValue(7,"","deuxième");
        dataset.setValue(5,"","troisième");
        dataset.setValue(2,"","quatrième");
        
        JFreeChart chart = ChartFactory.createBarChart("","", "", dataset, PlotOrientation.HORIZONTAL, false, false, false);
        CategoryPlot catPlot =chart.getCategoryPlot();
        catPlot.setRangeGridlinePaint(Color.BLACK);
        
        ChartPanel chartPanel = new ChartPanel(chart);
        this.homeView.getJPanel1().removeAll();
        this.homeView.getJPanel1().add(chartPanel, BorderLayout.CENTER);
        this.homeView.getJPanel1().validate();
    }
    
        public void faitUnGraphPie(){
            
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("premier", 1);
        dataset.setValue("deuxième", 2);
        dataset.setValue("troisième", 7);
        dataset.setValue("quatrième", 3);
        
        JFreeChart chart = ChartFactory.createPieChart("pie chart", dataset, true, true, false);
        
        ChartPanel chartPanel = new ChartPanel(chart);
        this.homeView.getJPanel1().removeAll();
        this.homeView.getJPanel1().add(chartPanel, BorderLayout.CENTER);
        this.homeView.getJPanel1().validate();
    }
        
    public void faitUnGraphLine(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(1,"","premier");
        dataset.setValue(7,"","deuxième");
        dataset.setValue(5,"","troisième");
        dataset.setValue(2,"","quatrième");
        
        JFreeChart chart = ChartFactory.createLineChart("","", "", dataset, PlotOrientation.VERTICAL, false, false, false);
        CategoryPlot catPlot =chart.getCategoryPlot();
        catPlot.setRangeGridlinePaint(Color.BLACK);
        
        ChartPanel chartPanel = new ChartPanel(chart);
        this.homeView.getJPanel1().removeAll();
        this.homeView.getJPanel1().add(chartPanel, BorderLayout.CENTER);
        this.homeView.getJPanel1().validate();
    }
}
