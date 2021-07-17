package views;
import banco.BDSingleton;
import banco.BancoDeDados;
import banco.Pessoa;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class JanelaAddPessoa extends JFrame implements ActionListener {
    private JTextField edtNome;
    private JSlider sliderIdade;
    private JTextField edtCidade;
    private JLabel lbIdade;

    public JanelaAddPessoa() {
        super("Adicionar Pessoa.");
        iniciaComponentes();
    }

    public void iniciaComponentes(){
        JLabel label = new JLabel("Janela para Adicionar pessoas");

        JPanel panelNome = new JPanel(new GridLayout(1,2));
        panelNome.add(new JLabel("Digite o Nome:"));
        edtNome = new JTextField();
        panelNome.add(edtNome);

        JPanel panelIdade = new JPanel(new GridLayout(1,2));
        panelIdade.add(lbIdade = new JLabel("Idade"));

        sliderIdade = new JSlider(1, 150);
        panelIdade.add(sliderIdade);
        sliderIdade.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lbIdade.setText(sliderIdade.getValue()+"");
            }
        });

        JButton button1 = new JButton("ADD");
        button1.setBackground(Color.BLUE);
        button1.addActionListener(this);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        add(label);
        add(panelNome);
        add(panelIdade);
        add(button1);
        pack();
    }

    public void actionPerformed(ActionEvent botaox){
        //add no banco de dados aqui
        Pessoa p = new Pessoa();
        p.nome = edtNome.getText();
        p.idade = sliderIdade.getValue();
        BDSingleton.getInstance().getBancoDeDados().addPessoa(p);
    }
}
