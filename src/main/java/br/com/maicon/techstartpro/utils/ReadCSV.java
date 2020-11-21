/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.maicon.techstartpro.utils;

import br.com.maicon.techstartpro.model.Category;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author MAICON
 */
public class ReadCSV {
    public static List<Category> readCategoriesCSV(File file) throws IOException{
        Reader reader = null;
        List<Category> lista = new ArrayList<>();
        
        try {                                   
            reader = new FileReader(file, Charset.forName("UTF-8"));
            CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
            List<String[]> linhas = csvReader.readAll();
            linhas.forEach(linha -> {                
                for (String coluna : linha){
                    lista.add(new Category(coluna));                    
                }
            });                                            
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }   
        
        return lista;
    }
}
