/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

/**
 *
 * @author jambo
 */
public interface UserInterface {

    public void setTextOnWindow(String text);

    public String getTextFromWindow();

    public void addTextOnWindow(String text);

    public void clearTextWindow();
}
