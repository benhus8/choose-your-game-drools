package com.sample;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.kie.api.KieServices;
import org.kie.api.runtime.ClassObjectFilter;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;


public class DroolsTest extends JFrame {

    private JButton fireRulesButton;
    private JLabel resultLabel;
    private KieSession kieSession;
    
    private WindowState windowState;


    public DroolsTest() {
        setTitle("Drools Swing Example");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        fireRulesButton = new JButton("Fire Rules");
        resultLabel = new JLabel("Result: ");

        JPanel panel = new JPanel();
        panel.add(fireRulesButton);
        panel.add(resultLabel);

        add(panel);

        initializeDrools();
        updateWindowState();
        
        fireRulesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickButton1();
            }
        });
    }

    private void initializeDrools() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        kieSession = kContainer.newKieSession("ksession-rules");
        kieSession.fireAllRules();
    }
    
    private void updateWindowState() {
    	windowState = (WindowState) kieSession.getObjects(new ClassObjectFilter(WindowState.class))
        	    .stream()
        	    .findFirst()
        	    .orElse(null);
        String result = "empty";
        if (windowState != null) {
        	result = windowState.getText();
        }
        resultLabel.setText("Result: " + result);
        String buttonDescription = (windowState != null) ? windowState.getButtonText1() : "Empty button text";
        fireRulesButton.setText(buttonDescription);
        if(windowState.getButtonText1().isBlank())
        	fireRulesButton.setVisible(false);
    }

    private void clickButton1() {
        kieSession.fireAllRules();
        updateWindowState();
        windowState.setAnswer(windowState.getButtonText1());
        kieSession.update(kieSession.getFactHandle(windowState), windowState);
        kieSession.fireAllRules();
        updateWindowState();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DroolsTest().setVisible(true);
            }
        });
    }
}
