/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestorTareas;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author nicol
 */
public class Main {
    private JFrame frame;
    private JTextArea tareaTextArea;
    private JTextField nombreField;
    private JTextField descripcionField;
    private JButton agregarButton;
    private JButton eliminarButton;
    private JButton mostrarPilaButton;
    private JButton mostrarColaButton;
    private JButton mostrarListaButton;
    
    private GestorTareas gestor;
    
    public Main() {
        gestor = new GestorTareas();
        initialize();
    }
    
    private void initialize() {
        frame = new JFrame("Gestor de Tareas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        
        tareaTextArea = new JTextArea();
        tareaTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(tareaTextArea);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));
        
        JLabel nombreLabel = new JLabel("Nombre:");
        nombreField = new JTextField();
        
        JLabel descripcionLabel = new JLabel("Descripción:");
        descripcionField = new JTextField();
        
        panel.add(nombreLabel);
        panel.add(nombreField);
        panel.add(descripcionLabel);
        panel.add(descripcionField);
        
        agregarButton = new JButton("Agregar Tarea");
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                String descripcion = descripcionField.getText();
                gestor.agregarTarea(nombre, descripcion);
                actualizarTexto(tareaTextArea, gestor);
            }
        });
        
        eliminarButton = new JButton("Eliminar Tarea");
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = JOptionPane.showInputDialog(frame, "Ingrese el nombre de la tarea a eliminar:");
                gestor.eliminarTarea(nombre);
                actualizarTexto(tareaTextArea, gestor);
            }
        });
        
        mostrarPilaButton = new JButton("Mostrar Pila");
        mostrarPilaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, gestor.obtenerTareasPila(), "Tareas Pendientes - Pila", JOptionPane.PLAIN_MESSAGE);
            }
        });
        
        mostrarColaButton = new JButton("Mostrar Cola");
        mostrarColaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, gestor.obtenerTareasCola(), "Tareas Pendientes - Cola", JOptionPane.PLAIN_MESSAGE);
            }
        });
        
        mostrarListaButton = new JButton("Mostrar Lista");
        mostrarListaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, gestor.obtenerTareasLista(), "Tareas Pendientes - Lista", JOptionPane.PLAIN_MESSAGE);
            }
        });
        
        panel.add(agregarButton);
        panel.add(eliminarButton);
        panel.add(mostrarPilaButton);
        panel.add(mostrarColaButton);
        panel.add(mostrarListaButton);
        
        frame.getContentPane().add(panel, BorderLayout.NORTH);
        
        frame.setVisible(true);
        
        actualizarTexto(tareaTextArea, gestor);
    }
    
    private void actualizarTexto(JTextArea tareaTextArea, GestorTareas gestor) {
        String texto = gestor.obtenerTareasPila() + "\n" + gestor.obtenerTareasCola() + "\n" + gestor.obtenerTareasLista();
        tareaTextArea.setText(texto);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Main();
            }
        });
    }
}


