package com.sample;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class DroolsTest extends JFrame {

    private JButton fireRulesButton;
    private JLabel resultLabel;

    private KieSession kieSession;

    public DroolsTest() {
        setTitle("Drools Swing Example");
        setSize(300, 150);
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
        // Wstaw dane do sesji Drools (w tym przypadku, możesz wstawić fakty lub dane wejściowe)
        // Możesz również przekazać do sesji dane z interfejsu użytkownika
        // kieSession.insert(...);

        // Wywołaj reguły
        kieSession.fireAllRules();


        String result = "Result: " ;
        resultLabel.setText(result);
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
