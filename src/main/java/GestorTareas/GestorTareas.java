/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestorTareas;

import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
/**
 *
 * @author nicol
 */

public class GestorTareas {
    private Stack<Tarea> pilaTareas;
    private Queue<Tarea> colaTareas;
    private LinkedList<Tarea> listaTareas;
    
    public GestorTareas() {
        pilaTareas = new Stack<>();
        colaTareas = new LinkedList<>();
        listaTareas = new LinkedList<>();
    }
    
    public void agregarTarea(String nombre, String descripcion) {
        Tarea nuevaTarea = new Tarea(nombre, descripcion);
        pilaTareas.push(nuevaTarea);
        colaTareas.add(nuevaTarea);
        listaTareas.add(nuevaTarea);
    }
    
    public void eliminarTarea(String nombre) {
        pilaTareas.removeIf(tarea -> tarea.getNombre().equals(nombre));
        colaTareas.removeIf(tarea -> tarea.getNombre().equals(nombre));
        listaTareas.removeIf(tarea -> tarea.getNombre().equals(nombre));
    }
    
    public String obtenerTareasPila() {
        StringBuilder builder = new StringBuilder();
        builder.append("Tareas pendientes en la pila:\n");
        Stack<Tarea> pilaAuxiliar = new Stack<>();
        while (!pilaTareas.isEmpty()) {
            Tarea tarea = pilaTareas.pop();
            builder.append("Nombre: ").append(tarea.getNombre()).append(", Descripción: ").append(tarea.getDescripcion()).append("\n");
            pilaAuxiliar.push(tarea);
        }
        while (!pilaAuxiliar.isEmpty()) {
            pilaTareas.push(pilaAuxiliar.pop());
        }
        return builder.toString();
    }
    
    public String obtenerTareasCola() {
        StringBuilder builder = new StringBuilder();
        builder.append("Tareas pendientes en la cola:\n");
        for (Tarea tarea : colaTareas) {
            builder.append("Nombre: ").append(tarea.getNombre()).append(", Descripción: ").append(tarea.getDescripcion()).append("\n");
        }
        return builder.toString();
    }
    
    public String obtenerTareasLista() {
        StringBuilder builder = new StringBuilder();
        builder.append("Tareas pendientes en la lista:\n");
        for (Tarea tarea : listaTareas) {
            builder.append("Nombre: ").append(tarea.getNombre()).append(", Descripción: ").append(tarea.getDescripcion()).append("\n");
        }
        return builder.toString();
    }
}


