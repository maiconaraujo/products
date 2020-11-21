/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.maicon.techstartpro.utils;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author MAICON
 */
public class FileChosserFilter extends FileFilter {

    @Override
    public boolean accept(File file) {
        if (file.isDirectory()) {
            return true;
        }else{
            return file.getName().endsWith(".csv");
        }
    }

    @Override
    public String getDescription() {
        return "*.csv";
    }
}
