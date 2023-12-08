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

        fireRulesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireRules();
            }
        });
    }

    private void initializeDrools() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        kieSession = kContainer.newKieSession("ksession-rules");
    }

    private void fireRules() {
        kieSession.fireAllRules();
        WindowState windowState = (WindowState) kieSession.getObjects(new ClassObjectFilter(WindowState.class))
        	    .stream()
        	    .findFirst()
        	    .orElse(null);
        String result = "empty";
        if (windowState != null) {
        	System.out.println("We are here");
        	result = windowState.getText();
        }
        resultLabel.setText("Result: " + result);
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
