/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.maicon.techstartpro.controller;

import br.com.maicon.techstartpro.dao.ConnectionFactory;


/**
 *
 * @author MAICON
 */
public class VerifyConnectionController {
    public boolean verifyConnection(){
        return ConnectionFactory.verifyConnection();
    }
        
}
